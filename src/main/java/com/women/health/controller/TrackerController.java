package com.women.health.controller;

import com.women.health.entity.Cycles;
import com.women.health.entity.Tracker;
import com.women.health.entity.Women;
import com.women.health.service.CyclesService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TrackerController {

    @Autowired
    private CyclesService cyclesService;

    @GetMapping("/tracker")
    public String trackerForm(Model model, HttpSession session) {

        Women women = (Women) session.getAttribute("women");

        Tracker tracker = new Tracker();

        tracker.setEmail(women.getEmail());

        model.addAttribute("tracker", tracker);
        return "women-dashboard/women-tracker";
    }

    @PostMapping("/tracker")
    public String submitTrackerForm(@ModelAttribute("tracker") Tracker tracker,HttpSession session,Model model) {

        Women women = (Women) session.getAttribute("women");

        System.out.println("tracker duration : "+tracker.getPeriodDuration());
        System.out.println("tracker start date : "+tracker.getPeriodStartDate());

        List<Cycles> cycles = generateCyclePredictions(tracker,women.getEmail(),tracker.getAvgCycleLength());

        cyclesService.saveCycles(cycles);



        model.addAttribute("women", women);
       // trackerService.updateLastSelectedDate(tracker.getEmail(), LocalDate.now());


//        if (tracker.getAvgCycleLength() < 35 ){
//           return "women-dashboard/doctor-advice";
//
//       }else if(tracker.getAvgCycleLength() > 15){
//            return "women-dashboard/doctor-advice";
//
//        }else {
//           return "women-dashboard/women-dashboard";
//       }

        return "women-dashboard/women-dashboard";

    }

    private List<Cycles> generateCyclePredictions(Tracker tracker,String email,int avgCycleLength) {

        List<Cycles> cycles = new ArrayList<>();

        LocalDate startDate = tracker.getPeriodStartDate();

        int periodCycleLength = tracker.getPeriodDuration();

        LocalDate endDate = startDate.plusDays(periodCycleLength - 1);

        for (int i = 1; i <= 6; i++) {

            Cycles cycle = new Cycles();


            cycle.setEmail(email);
            cycle.setPeriodDuration(periodCycleLength);
            cycle.setPeriodStartDate(startDate);
            cycle.setPeriodEndDate(endDate);
            cycle.setFertilityStartDate(endDate.plusDays(10));
            cycle.setOvulationDate(endDate.plusDays(15));
            cycle.setNextPeriodPredictionDate(endDate.plusDays(avgCycleLength));


            startDate = cycle.getNextPeriodPredictionDate().plusDays(1);
            endDate = startDate.plusDays(periodCycleLength - 1);


            cycles.add(cycle);

        }
        return cycles;
    }

    @GetMapping("/getTrackersByWomen")
    public String getTrackersByWomen(HttpSession session,Model model) {
        // Fetch email from session
        Women women = (Women) session.getAttribute("women");

        System.out.println("Women Tracker Record : "+women);
        System.out.println("Women Email : "+women.getEmail());

        // Fetch tracker data for the email from service
        List<Cycles> cyclesList = cyclesService.getAllCyclesByEmail(women.getEmail());

        System.out.println("cycle Record List: "+cyclesList);
       // System.out.println("tracker Last Selected Date : "+trackerRecord.get(0).getLastSelectedDate());

        // Add tracker data to the model
        model.addAttribute("cyclesRecord", cyclesList);

        // Return the dashboard view
        return "women-dashboard/women-tracker-record";
    }


}

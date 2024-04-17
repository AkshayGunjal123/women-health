

function toggleTracker() {
    // Make an AJAX request to fetch the tracker page content
    $.get("/tracker", function(data) {

        // Display the tracker content in the dashboard
        $('.tracker-temp').html(data).show(); // Show the tracker content


        // Optionally, you can hide other dashboard content here
        $('.doctor-appointment').hide();
         $(".temp").hide();
         $('.women-symptoms').hide();
         $('.tracker-record').hide();
         $('.view-symptoms').hide();
         $('.appointment-record').hide();
         $('.health-info').hide();
    });
}

function toggleTrackerRecord(){

     $.get("/getTrackersByWomen", function(data) {

            console.log("toggleTrackerRecord data : "+data);

            $('.tracker-record').html(data).show(); // Show the tracker content

            // Optionally, you can hide other dashboard content here
            $('.doctor-appointment').hide();
             $(".temp").hide();
             $('.tracker-temp').hide();
             $('.women-symptoms').hide();
             $('.view-symptoms').hide();
             $('.appointment-record').hide();
             $('.health-info').hide();
        });

}

function womenSymptoms() {
    // Make an AJAX request to fetch the tracker page content

      $.get("/symptoms", function(data) {

            $('.women-symptoms').show();

            $('.doctor-appointment').hide();
            $('.tracker-record').hide();
            $('.tracker-temp').hide();
            $(".temp").hide();
            $('.view-symptoms').hide();
            $('.appointment-record').hide();
            $('.health-info').hide();
        });
}

function doctorAppointment() {
    // Make an AJAX request to fetch the tracker page content

      $.get("/appointment", function(data) {

            $('.doctor-appointment').show();

            $('.women-symptoms').hide();
            $('.tracker-record').hide();
            $('.tracker-temp').hide();
            $(".temp").hide();
            $('.view-symptoms').hide();
            $('.appointment-record').hide();
            $('.health-info').hide();
        });
}


function viewSymptoms() {
    // Make an AJAX request to fetch the tracker page content

      $.get("/viewSymptoms", function(data) {

            console.log("Symptoms: "+data);

            $('.view-symptoms').html(data).show();

            $('.doctor-appointment').hide();
            $('.women-symptoms').hide();
            $('.tracker-record').hide();
            $('.tracker-temp').hide();
            $(".temp").hide();
            $('.appointment-record').hide();
            $('.health-info').hide();
        });
}


function appointmentRecord() {
    // Make an AJAX request to fetch the tracker page content

      $.get("/appointments", function(data) {

            console.log("Symptoms: "+data);

            $('.appointment-record').html(data).show();

            $('view-symptoms').hide();
            $('.doctor-appointment').hide();
            $('.women-symptoms').hide();
            $('.tracker-record').hide();
            $('.tracker-temp').hide();
            $(".temp").hide();
            $('.health-info').hide();
        });
}

function healthInfo(){

            $('.health-info').show();
            $('.tracker-record').hide(); // Show the tracker content
            // Optionally, you can hide other dashboard content here
            $('.doctor-appointment').hide();
             $(".temp").hide();
             $('.tracker-temp').hide();
             $('.women-symptoms').hide();
             $('.view-symptoms').hide();
             $('.appointment-record').hide();


}


 function confirmSubmission(event) {
         event.preventDefault(); // Prevent default form submission

         var avgCycleLength = document.getElementById("avgCycleLength").value;
         if (avgCycleLength > 30) {
             Swal.fire({
                 title: "Warning!",
                 text: "Your average cycle length exceeds 30 days. Do you still want to proceed?",
                 icon: "warning",
                 showCancelButton: true,
                 confirmButtonColor: "#3085d6",
                 cancelButtonColor: "#d33",
                 confirmButtonText: "Yes, proceed",
                 cancelButtonText: "Cancel"
             }).then((result) => {
                 if (result.isConfirmed) {
                     // If user clicks Yes, submit the form
                     document.getElementById("period-tracker-form").submit();
                 }
             });
         } else {
             // If average cycle length is within limit, submit the form
             document.getElementById("period-tracker-form").submit();
         }
     }
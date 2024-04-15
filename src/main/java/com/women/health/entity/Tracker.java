package com.women.health.entity;

// Tracker.java

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;


public class Tracker {

    private String email;

    private LocalDate periodStartDate;
    private int periodDuration;

    private int avgCycleLength;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getPeriodStartDate() {
        return periodStartDate;
    }

    public void setPeriodStartDate(LocalDate periodStartDate) {
        this.periodStartDate = periodStartDate;
    }

    public int getPeriodDuration() {
        return periodDuration;
    }

    public void setPeriodDuration(int periodDuration) {
        this.periodDuration = periodDuration;
    }

    public int getAvgCycleLength() {
        return avgCycleLength;
    }

    public void setAvgCycleLength(int avgCycleLength) {
        this.avgCycleLength = avgCycleLength;
    }
}

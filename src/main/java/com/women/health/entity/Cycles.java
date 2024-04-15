package com.women.health.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Cycles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email; // Email ID of the women
    private LocalDate periodStartDate;
    private int periodDuration;
    private LocalDate periodEndDate;
    private LocalDate fertilityStartDate;
    private LocalDate ovulationDate;
    private LocalDate nextPeriodPredictionDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDate getPeriodEndDate() {
        return periodEndDate;
    }

    public void setPeriodEndDate(LocalDate periodEndDate) {
        this.periodEndDate = periodEndDate;
    }

    public LocalDate getFertilityStartDate() {
        return fertilityStartDate;
    }

    public void setFertilityStartDate(LocalDate fertilityStartDate) {
        this.fertilityStartDate = fertilityStartDate;
    }

    public LocalDate getOvulationDate() {
        return ovulationDate;
    }

    public void setOvulationDate(LocalDate ovulationDate) {
        this.ovulationDate = ovulationDate;
    }

    public LocalDate getNextPeriodPredictionDate() {
        return nextPeriodPredictionDate;
    }

    public void setNextPeriodPredictionDate(LocalDate nextPeriodPredictionDate) {
        this.nextPeriodPredictionDate = nextPeriodPredictionDate;
    }
}

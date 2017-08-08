package com.apptopus.scoupter.model;

import java.util.List;

public class ScooterData {

    private List<Scooter> scooters;

    public ScooterData(List<Scooter> scooters) {
        this.scooters = scooters;
    }

    public List<Scooter> getScooters() {
        return scooters;
    }

    public void setScooters(List<Scooter> scooters) {
        this.scooters = scooters;
    }
}

package com.apptopus.scoupter.model;

import com.google.gson.annotations.SerializedName;


public class Scooter {

    @SerializedName("id")
    private String id;
    @SerializedName("vin")
    private String vin;
    @SerializedName("model")
    private String model;
    @SerializedName("market_id")
    private String marketId;
    @SerializedName("license_plate")
    private String licensePlate;
    @SerializedName("energy_level")
    private int energyLevel;
    @SerializedName("distance_to_travel")
    private float distanceToTravel;
    @SerializedName("location")
    private Location location;

    public Scooter(String id, String vin, String model, String marketId, String licensePlate, int energyLevel, float distanceToTravel, Location location) {
        this.id = id;
        this.vin = vin;
        this.model = model;
        this.marketId = marketId;
        this.licensePlate = licensePlate;
        this.energyLevel = energyLevel;
        this.distanceToTravel = distanceToTravel;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public float getDistanceToTravel() {
        return distanceToTravel;
    }

    public void setDistanceToTravel(float distanceToTravel) {
        this.distanceToTravel = distanceToTravel;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

package com.apptopus.scoupter.util;

import android.util.Log;

import com.apptopus.scoupter.model.Location;
import com.apptopus.scoupter.model.Scooter;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LocationUtils {

    public static String DEBUG_TAG = "LocationUtils";

    public static LatLng getLatLng(Location location) {

        return new LatLng(location.getLatitude(), location.getLongitude());
    }


    public static float getDistance(Location location1, Location location2) {
        android.location.Location from = new android.location.Location("");
        android.location.Location to = new android.location.Location("");
        from.setLatitude(location1.getLatitude());
        from.setLongitude(location1.getLongitude());
        to.setLatitude(location2.getLatitude());
        to.setLongitude(location2.getLongitude());
        return from.distanceTo(to);
    }


    public static Scooter getClosestScooter(LatLng from, List<Scooter> scooters) {
        final Location location = new Location(from.latitude, from.longitude);
        Collections.sort(scooters, new Comparator<Scooter>() {
            @Override
            public int compare(Scooter o1, Scooter o2) {
                float distance1 = LocationUtils.getDistance(location, o1.getLocation());
                float distance2 = LocationUtils.getDistance(location, o2.getLocation());
                if (distance1 > distance2) {
                    return 1;
                } else if (distance1 == distance2) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        return null;
    }


}

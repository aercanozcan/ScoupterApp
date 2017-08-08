package com.apptopus.scoupter.util;

import android.util.Log;

import com.apptopus.scoupter.model.Location;
import com.apptopus.scoupter.model.Scooter;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class LocationUtils {

    public static String DEBUG_TAG = "LocationUtils";
    public static LatLng getLatLng(Location location) {
        return new LatLng(location.getLatitude(), location.getLongitude());
    }
}

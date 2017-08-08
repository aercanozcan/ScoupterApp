package com.apptopus.scoupter.util;

import android.graphics.Color;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class ColorUtils {
    static float[] hsv = new float[3];
    private static final BitmapDescriptor RED = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED);
    private static final BitmapDescriptor YELLOW = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW);
    private static final BitmapDescriptor GREEN = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN);


    public static float[] getColorFromPercent(int percent) {// visually more smooth but expensive operation
        int r = (255 * percent) / 100;
        int g = (255 * (100 - percent)) / 100;
        Color.colorToHSV(Color.rgb(r, g, 0), hsv);
        return hsv;
    }

    public static BitmapDescriptor getBitmapDescriptorFromPercent(int percent) {
        if(percent > 50){
            return GREEN;
        } else if (percent > 30){
            return YELLOW;
        } else {
            return RED;
        }
    }

}

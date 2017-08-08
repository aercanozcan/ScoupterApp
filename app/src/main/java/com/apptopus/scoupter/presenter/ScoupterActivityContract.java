package com.apptopus.scoupter.presenter;

import com.apptopus.scoupter.model.Scooter;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by ercanozcan on 03/08/17.
 */

public interface ScoupterActivityContract {

    interface View {
        void updateMapMarkers(List<Scooter> scooters);
        void hideProgressSpinner();
    }

    interface ActionListener {
        void onMapCameraChanged();
    }

    interface Operations {
        void getScoters();
    }

}

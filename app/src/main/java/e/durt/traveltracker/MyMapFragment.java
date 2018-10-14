package e.durt.traveltracker;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.joanzapata.iconify.IconDrawable;

import java.util.List;

import models.pointsOfInterest.IPlottable;
import models.pointsOfInterest.PlottableType;
import presenters.IMapDisplay;
import presenters.MockPresenter;


public class MyMapFragment extends SupportMapFragment implements IMapDisplay {
    private GoogleMap map;
    private IMapPresenter mapPresenter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mapPresenter = new MockPresenter(this);

        getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                mapPresenter.notifyMapReady();
            }
        });
    }

    @Override
    public void placePOIs(final List<IPlottable> thingsToPlace) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                placePlottablesOnMap(thingsToPlace);
            }
        });
    }

    private void placePlottablesOnMap(List<IPlottable> plottableList){

    }
    private IconDrawable getIcon(PlottableType type){
        switch(type){
            case TEMPLE:
            case WONDER:
            case NATIONAL_PARK:
            case OTHER:
        }
    }
}

package e.durt.traveltracker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;

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
                map.addMarker(new MarkerOptions().position(new LatLng(10, 10)).title("test in placePOIs"));
            }
        });
    }

    private void placePlottablesOnMap(List<IPlottable> plottableList){
        for(IPlottable poi : plottableList){
            LatLng loc = new LatLng(poi.getLatDouble(), poi.getLongDouble());
            BitmapDescriptor icon = getCustomMarker(poi.getType(), getActivity());
            MarkerOptions marker = new MarkerOptions().position(loc).title(poi.getLabel());
            map.addMarker(marker);
        }

    }
    private BitmapDescriptor getCustomMarker(PlottableType type, Activity activity){
        IconDrawable icon = getIcon(type, activity);
        Bitmap bm = Bitmap.createBitmap(icon.getIntrinsicWidth(), icon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        icon.draw(c);

        return BitmapDescriptorFactory.fromBitmap(bm);
    }
    private IconDrawable getIcon(PlottableType type, Activity activity){
        FontAwesomeIcons iconType;
        switch(type){
            case TEMPLE:
                iconType = FontAwesomeIcons.fa_fort_awesome;
                break;
            case WONDER:
                iconType = FontAwesomeIcons.fa_institution;
                break;
            case NATIONAL_PARK:
                iconType = FontAwesomeIcons.fa_tree;
                break;
            case OTHER:
                iconType = FontAwesomeIcons.fa_map_marker;
                break;
            default:
                iconType = FontAwesomeIcons.fa_map_marker;
        }
        IconDrawable icon = new IconDrawable(activity, iconType);
        icon.sizeDp(40);
        icon.setAlpha(1);
        return icon;
    }
}

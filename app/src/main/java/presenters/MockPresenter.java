package presenters;

import java.io.InputStreamReader;
import java.util.List;

import e.durt.traveltracker.IMapPresenter;
import e.durt.traveltracker.MyMapFragment;
import exceptions.TravelTrackerException;
import modelStorage.IStorageRetrieval;
import modelStorage.MockRetriever;
import modelStorage.TempleFileRetriever;
import models.pointsOfInterest.IPlottable;
import models.provider.ProviderFactory;

public class MockPresenter implements IMapPresenter {

    IMapDisplay mapView;
    IStorageRetrieval retriever;

    public MockPresenter(IMapDisplay mapDisplay){
        mapView = mapDisplay;
        retriever = ProviderFactory.getProvider().getRetriever();
        ((TempleFileRetriever)retriever).setPresenter(this);
    }

    @Override
    public void setMapDisplay(IMapDisplay relatedView){
        this.mapView = relatedView;
    }

    @Override
    public void notifyMapReady(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                fetchItemsToPlot();
            }
        }).start();
    }

    private void fetchItemsToPlot(){
        try {
            List<IPlottable> poiList = retriever.getPois();
            if (poiList == null) {
                return;
            }
            mapView.placePOIs(poiList);
        }
        catch (TravelTrackerException e){
            e.printStackTrace();
            //TODO: implement toasting error messages
        }
    }

    public InputStreamReader getISRFromAssets(String fileName){
        return ((MyMapFragment)mapView).getISRFromAssets(fileName);
    }
}

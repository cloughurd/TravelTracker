package presenters;

import java.util.List;

import e.durt.traveltracker.IMapPresenter;
import modelStorage.IStorageRetrieval;
import models.pointsOfInterest.IPlottable;
import models.provider.ProviderFactory;

public class MockPresenter implements IMapPresenter {

    IMapDisplay mapView;
    IStorageRetrieval retriever;

    public MockPresenter(IMapDisplay mapDisplay){
        mapView = mapDisplay;
        retriever = ProviderFactory.getProvider().getRetriever();
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
        List<IPlottable> poiList = retriever.getPois();
    }
}

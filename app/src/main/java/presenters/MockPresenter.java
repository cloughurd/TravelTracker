package presenters;

import e.durt.traveltracker.IMapPresenter;

public class MockPresenter implements IMapPresenter {

    IMapDisplay relatedView;

    @Override
    public void setMapDisplay(IMapDisplay relatedView){
        this.relatedView = relatedView;
    }

    @Override
    public void notifyMapReady(){

    }

}

package e.durt.traveltracker;

import presenters.IMapDisplay;

public interface IMapPresenter {

    void setMapDisplay(IMapDisplay relatedView);

    void notifyMapReady();

}

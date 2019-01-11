package modelStorage;

import java.util.ArrayList;
import java.util.List;

import exceptions.TravelTrackerException;
import models.pointsOfInterest.IPlottable;

public class TempleParkRetriever implements IStorageRetrieval {
    @Override
    public List<IPlottable> getPois() throws TravelTrackerException {
        List<IPlottable> temples = new TempleFileRetriever().getPois();
        List<IPlottable> natParks = new NationalParkRetriever().getPois();
        List<IPlottable> all = new ArrayList<>(temples.size() + natParks.size());
        all.addAll(temples);
        all.addAll(natParks);
        return all;
    }
}

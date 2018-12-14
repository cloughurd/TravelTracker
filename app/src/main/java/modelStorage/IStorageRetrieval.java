package modelStorage;

import java.util.List;

import exceptions.TravelTrackerException;
import models.pointsOfInterest.IPlottable;

public interface IStorageRetrieval {
    List<IPlottable> getPois() throws TravelTrackerException;
}

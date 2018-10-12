package modelStorage;

import java.util.List;

import models.pointsOfInterest.IPlottable;

public interface IStorageRetrieval {
    List<IPlottable> getPois();
}

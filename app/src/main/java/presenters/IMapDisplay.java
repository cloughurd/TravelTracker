package presenters;

import java.util.List;

import models.pointsOfInterest.IPlottable;

public interface IMapDisplay {

    void placePOIs(List<IPlottable> thingsToPlace);

}

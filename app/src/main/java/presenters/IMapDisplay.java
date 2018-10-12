package presenters;

import java.util.List;

import models.pointsOfInterest.IPlottable;

public interface IMapDisplay {

    int placePOIs(List<IPlottable> thingsToPlace);

}

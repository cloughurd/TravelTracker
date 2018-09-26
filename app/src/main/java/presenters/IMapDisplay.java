package presenters;

import java.util.List;

import models.Plottable;

public interface IMapDisplay {

    int placePOIs(List<Plottable> thingsToPlace);

}

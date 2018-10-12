package modelStorage;

import java.util.ArrayList;
import java.util.List;

import models.pointsOfInterest.IPlottable;
import models.pointsOfInterest.TemplePlottable;
import models.pointsOfInterest.WonderPlottable;

public class MockRetriever implements IStorageRetrieval {
    private List<IPlottable> mockPoiList;

    public MockRetriever(){
        mockPoiList = new ArrayList<>();
        mockSetup();
    }

    @Override
    public List<IPlottable> getPois() {
        return mockPoiList;
    }

    private void mockSetup(){
        mockPoiList.add(new TemplePlottable("Provo City Center", "40.2327° N", "111.6593° W", true));
        mockPoiList.add(new TemplePlottable("Logan Utah", "41.7342° N", "111.8279° W", false));

        mockPoiList.add(new WonderPlottable("Colosseum", "41.8902° N", "12.4922° E", true));
    }
}

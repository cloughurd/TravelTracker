package modelStorage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import exceptions.NoAssetRetrieverException;
import exceptions.TravelTrackerException;
import models.pointsOfInterest.IPlottable;
import models.pointsOfInterest.NatParkPlottable;
import models.provider.ProviderFactory;

public class NationalParkRetriever implements IStorageRetrieval {
    private InputStreamReader templeFile;
    private final String NAT_PARK_FILENAME = "NationalParks.json";

    @Override
    public List<IPlottable> getPois() throws TravelTrackerException {
        Gson gson = new Gson();
//            InputStreamReader file = new InputStreamReader(getAssets().open("templeCoordinates.txt"));
        Type listType = new TypeToken<ArrayList<NatParkPlottable>>(){}.getType();
        return gson.fromJson(getFileInputeStream(), listType);

    }


    public InputStreamReader getFileInputeStream() throws TravelTrackerException {
        IAssetRetriever assetRetriever = ProviderFactory.getProvider().getAssetRetriever();
        if(assetRetriever == null){
            throw new NoAssetRetrieverException();
        }
        return new InputStreamReader(ProviderFactory.getProvider().getAssetRetriever().getAssetInputStream(NAT_PARK_FILENAME));
    }

}

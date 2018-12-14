package modelStorage;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.List;

import e.durt.traveltracker.IMapPresenter;
import exceptions.NoAssetRetrieverException;
import exceptions.TravelTrackerException;
import models.pointsOfInterest.IPlottable;
import models.provider.ProviderFactory;
import presenters.MockPresenter;

public class TempleFileRetriever implements IStorageRetrieval {
    private MockPresenter presenter;
    private InputStreamReader templeFile;
    private final String TEMPLE_FILE_NAME = "templeCoordinates.txt";

    @Override
    public List<IPlottable> getPois() throws TravelTrackerException{
        Gson gson = new Gson();
//            InputStreamReader file = new InputStreamReader(getAssets().open("templeCoordinates.txt"));
        TempleHolder temp = gson.fromJson(getFileInputeStream(), TempleHolder.class);
        return temp.getIPlottableList();

    }

    public void setPresenter(MockPresenter presenter){
        this.presenter = presenter;
    }

    public InputStreamReader getFileInputeStream() throws TravelTrackerException {
        IAssetRetriever assetRetriever = ProviderFactory.getProvider().getAssetRetriever();
        if(assetRetriever == null){
            throw new NoAssetRetrieverException();
        }
        return new InputStreamReader(ProviderFactory.getProvider().getAssetRetriever().getAssetInputStream(TEMPLE_FILE_NAME));
    }
}

package modelStorage;

import java.io.InputStream;

import exceptions.AssetNotFoundException;

public interface IAssetRetriever {
    InputStream getAssetInputStream(String filename) throws AssetNotFoundException;
}

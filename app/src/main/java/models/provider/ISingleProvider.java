package models.provider;

import modelStorage.IAssetRetriever;
import modelStorage.IStorageRetrieval;

public interface ISingleProvider {
    IStorageRetrieval getRetriever();
    IAssetRetriever getAssetRetriever();
    void setAssetRetriever(IAssetRetriever assetRetriever);
}

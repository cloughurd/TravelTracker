package models.provider;

import modelStorage.IAssetRetriever;
import modelStorage.IStorageRetrieval;
import modelStorage.MockRetriever;
import modelStorage.TempleFileRetriever;

public class SingleProvider implements ISingleProvider {
    private static SingleProvider singleProvider;
    private IStorageRetrieval mockRetriever;
    private IAssetRetriever assetRetriever;

    private SingleProvider(){
        mockRetriever = new TempleFileRetriever();
    }

    public static SingleProvider getInstance(){
        if(singleProvider == null){
            singleProvider = new SingleProvider();
        }
        return singleProvider;
    }

    @Override
    public IStorageRetrieval getRetriever() {
        return mockRetriever;
    }

    @Override
    public IAssetRetriever getAssetRetriever() {
        return assetRetriever;
    }

    @Override
    public void setAssetRetriever(IAssetRetriever assetRetriever) {
        this.assetRetriever = assetRetriever;
    }
}

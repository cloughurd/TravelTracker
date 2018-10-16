package models.provider;

import modelStorage.IStorageRetrieval;
import modelStorage.MockRetriever;

public class SingleProvider implements ISingleProvider {
    private static SingleProvider singleProvider;
    private IStorageRetrieval mockRetriever;

    private SingleProvider(){
        mockRetriever = new MockRetriever();
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
}

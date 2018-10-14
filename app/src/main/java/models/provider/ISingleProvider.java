package models.provider;

import modelStorage.IStorageRetrieval;

public interface ISingleProvider {
    IStorageRetrieval getRetriever();
}

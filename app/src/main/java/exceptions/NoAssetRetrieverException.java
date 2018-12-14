package exceptions;

public class NoAssetRetrieverException extends TravelTrackerException {
    public NoAssetRetrieverException(String message){
        super(message);
    }
    public NoAssetRetrieverException(){
        super("No asset retriever was found");
    }
}

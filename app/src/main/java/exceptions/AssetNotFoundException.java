package exceptions;

public class AssetNotFoundException extends TravelTrackerException {
    public AssetNotFoundException(String message){
        super(message);
    }
    public AssetNotFoundException(){
        super("Asset not found");
    }
}

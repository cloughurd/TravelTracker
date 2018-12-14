package exceptions;

public abstract class TravelTrackerException extends Exception {
    public TravelTrackerException(){
        super("Error in TravelTracker");
    }
    public  TravelTrackerException(String message){
        super(message);
    }
}

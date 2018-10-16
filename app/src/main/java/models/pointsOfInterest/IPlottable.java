package models.pointsOfInterest;

public interface IPlottable {

    String getLabel();

    boolean isVisited();

    PlottableType getType();

    String getLatitude();
    String getLongitude();

    double getLatDouble();
    double getLongDouble();

}

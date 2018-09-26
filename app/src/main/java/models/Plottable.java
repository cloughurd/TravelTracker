package models;

public interface Plottable {

    String getLabel();

    boolean isVisited();

    PlottableType getType();

    String getLatitude();
    String getLongitude();

}

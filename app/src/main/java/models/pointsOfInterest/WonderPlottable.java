package models.pointsOfInterest;

public class WonderPlottable implements IPlottable {
    private String latitude, longitude, label;
    private PlottableType type;
    private boolean visited;

    public WonderPlottable(String label, String latitude, String longitude, boolean visited){
        this.label = label;
        this.latitude = latitude;
        this.longitude = longitude;
        this.visited = visited;
        this.type = PlottableType.WONDER;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public boolean isVisited() {
        return visited;
    }

    @Override
    public PlottableType getType() {
        return type;
    }

    @Override
    public String getLatitude() {
        return latitude;
    }

    @Override
    public String getLongitude() {
        return longitude;
    }
}

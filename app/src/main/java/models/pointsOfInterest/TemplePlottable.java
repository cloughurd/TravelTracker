package models.pointsOfInterest;

public class TemplePlottable implements IPlottable {

    private String label, latitude, longitude;
    private PlottableType type;
    private boolean visited;

    public TemplePlottable(String label, String latitude, String longitude, boolean visited){
        this.label = label;
        this.latitude = latitude;
        this.longitude = longitude;
        this.visited = visited;
        type = PlottableType.TEMPLE;
    }

    @Override
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public PlottableType getType() {
        return type;
    }

    public void setType(PlottableType type) {
        this.type = type;
    }

    @Override
    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public double getLatDouble() {
        return Double.parseDouble(latitude);
    }

    @Override
    public double getLongDouble() {
        return Double.parseDouble(longitude);
    }
}

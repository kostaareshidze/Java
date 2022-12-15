package pgdp.streams;

import java.util.Comparator;
import java.util.List;

public class Penguin {
    private List<Geo> locations;
    private String trackID;

    public Penguin(List<Geo> locations, String trackID) {
        this.locations = locations;
        this.trackID = trackID;
    }

    @Override
    public String toString() {
        return "Penguin{" +
                "locations=" + locations +
                ", trackID='" + trackID + '\'' +
                '}';
    }

    public List<Geo> getLocations() {
        return locations;
    }

    public String getTrackID() {
        return trackID;
    }

    public String toStringUsingStreams() {
        return "Penguin{" +
                "locations=" + locations.stream().sorted((a, b) -> {
            if (a.latitude == b.latitude) {
                return Double.compare(b.longitude, a.longitude);
            } else return Double.compare(b.latitude, a.latitude);
        }).toList()
                +
                ", trackID='" + trackID + '\'' +
                '}';
    }
}

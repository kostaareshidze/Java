package pgdp.streams;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataScience {
    public static Stream<Penguin> getDataByTrackId(Stream<PenguinData> stream) {
        var mapped = stream.collect(
                Collectors.groupingBy(a -> a.trackID));
        List<Penguin> penguins = new ArrayList<>();

        for (var i : mapped.entrySet()) {
            var temp = i.getValue().stream().map(PenguinData::getGeom).toList();
            penguins.add(new Penguin(temp, i.getKey()));
        }
        return penguins.stream();
    }

    public static void outputPenguinStream() {
        System.out.println(Objects.requireNonNull(CSVReading.processInputFile())
                .map(n -> n.trackID).distinct().count());
        DataScience.getDataByTrackId(Objects.requireNonNull(CSVReading.processInputFile()))
                .map(Penguin::toStringUsingStreams).forEach(System.out::println);

    }

    public static void outputLocationRangePerTrackid(Stream<PenguinData> stream) {
        
        Objects.requireNonNull(getDataByTrackId(stream))
                .map(a -> a.getLocations().stream().map(n -> n.longitude)).map(n -> n.mapToDouble(a -> a))
                .map(n -> n.min().getAsDouble()).forEach(System.out::println);
        Objects.requireNonNull(getDataByTrackId(stream))
                .map(a -> a.getLocations().stream().map(n -> n.longitude)).map(n -> n.mapToDouble(a -> a))
                .map(n -> n.max().getAsDouble()).forEach(System.out::println);
        Objects.requireNonNull(getDataByTrackId(stream))
                .map(a -> a.getLocations().stream().map(n -> n.latitude)).map(n -> n.mapToDouble(a -> a))
                .map(n -> n.min().getAsDouble()).forEach(System.out::println);

        Objects.requireNonNull(getDataByTrackId(stream))
                .map(a -> a.getLocations().stream().map(n -> n.latitude)).map(n -> n.mapToDouble(a -> a))
                .map(n -> n.max().getAsDouble()).forEach(System.out::println);
        Objects.requireNonNull(getDataByTrackId(stream))
                .map(a -> a.getLocations().stream().map(n -> n.latitude)).map(n -> n.mapToDouble(a -> a))
                .map(n -> n.average().getAsDouble()).forEach(System.out::println);
        Objects.requireNonNull(getDataByTrackId(stream))
                .map(a -> a.getLocations().stream().map(n -> n.longitude)).map(n -> n.mapToDouble(a -> a))
                .map(n -> n.average().getAsDouble()).forEach(System.out::println);

    }

    public static void main(String[] args) {
        var geo = new Geo(4.2, 1.9);
        var geo2 = new Geo(7.4, 0.2);
        List<Geo> list = new LinkedList<>();
        list.add(geo);
        list.add(geo2);
        Penguin penguin = new Penguin(list, "kosta");
        DataScience.outputLocationRangePerTrackid(Objects.requireNonNull(CSVReading.processInputFile()));
//        DataScience.outputLocationRangePerTrackid(CSVReading.processInputFile());
//        DataScience.outputPenguinStream();


    }
}
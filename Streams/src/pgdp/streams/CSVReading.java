package pgdp.streams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVReading {

    private static List<PenguinData> instance = null;
    private static final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static Stream<PenguinData> processInputFile() {
            String fileName = "data/OC_LPhillips_LittlePenguin_GPS_tracks_DATA.csv";
            try{
                var stream  = Files.lines(Paths.get(fileName));
                return stream.skip(1).map(n -> mapToPenguinData.apply(n));
            } catch (IOException e) {
                System.out.println("Data Path seems to be wrong");
                e.printStackTrace();
            }
            return null;
    }

    private static Function<String, PenguinData> mapToPenguinData = (line) -> {
        String[] p = line.split(","); // a CSV has comma separated lines
        LocalDateTime dateTime = LocalDateTime.parse(p[2], formatter);
        return new PenguinData(p[0], Integer.parseInt(p[1]), dateTime, Double.parseDouble(p[3]),
                Double.parseDouble(p[4]), p[5], p[6], p[7], new Geo(p[8]));
    };
}

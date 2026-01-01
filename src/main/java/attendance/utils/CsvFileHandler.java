package attendance.utils;

import attendance.domain.crew.Crew;
import attendance.domain.crew.Crews;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CsvFileHandler {

    public static Crews convertCsvFileToCrewList() {
        Crews crews = new Crews();
        Path path = Paths.get("src/main/resources/attendances.csv");
        try {
            List<String> strings = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (int i = 1; i < strings.size(); i++) {
                String[] split = strings.get(i).split(",");
                String name = split[0];
                String date = split[1];
                LocalDateTime dateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                Crew crew = crews.getExistedCrewOrMakeNewCrew(name);
                crew.registerAttendance(dateTime);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return crews;
    }
}

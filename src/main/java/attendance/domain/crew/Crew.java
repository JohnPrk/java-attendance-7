package attendance.domain.crew;

import attendance.domain.attendance.Attendance;
import attendance.domain.attendance.Attendances;

import java.time.LocalDateTime;

public class Crew {

    private String name;
    private Attendances attendances;

    public Crew(String name) {
        this.name = name;
        this.attendances = new Attendances();
    }

    public Attendance registerAttendance(LocalDateTime dateTime) {
        return attendances.addAttendance(dateTime);
    }

    public boolean findByName(String name) {
        return name.equals(this.name);
    }
}

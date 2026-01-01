package attendance.domain.crew;

import attendance.domain.attendance.Attendances;

import java.time.LocalDateTime;

public class Crew {

    private String name;
    private Attendances attendances;

    public Crew(String name) {
        this.name = name;
        this.attendances = new Attendances();
    }

    public Attendances getAttendances() {
        return attendances;
    }

    public void registerAttendance(LocalDateTime dateTime) {
        attendances.addAttendance(dateTime);
    }

    public boolean findByName(String name) {
        return name.equals(this.name);
    }
}

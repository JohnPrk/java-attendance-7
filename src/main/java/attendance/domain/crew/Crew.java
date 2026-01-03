package attendance.domain.crew;

import attendance.domain.attendance.Attendance;
import attendance.domain.attendance.AttendanceHistory;
import attendance.domain.attendance.Attendances;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Crew {

    private String name;
    private Attendances attendances;

    public Crew(String name) {
        this.name = name;
        this.attendances = new Attendances();
    }

    public String getName() {
        return name;
    }

    public Attendance registerAttendance(LocalDateTime dateTime) {
        return attendances.addAttendance(dateTime);
    }

    public boolean findByName(String name) {
        return name.equals(this.name);
    }

    public Attendance getAttendanceByDate(LocalDate date) {
        return attendances.getAttendanceByDate(date);
    }

    public void updateAttendance(LocalDate date, LocalTime time) {
        attendances.updateAttendance(date, time);
    }

    public AttendanceHistory getAttendanceHistory(LocalDate date) {
        return attendances.getAttendanceHistory(date);
    }
}

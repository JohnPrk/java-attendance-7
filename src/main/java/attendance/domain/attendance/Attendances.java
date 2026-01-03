package attendance.domain.attendance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Attendances {

    private static final String NOT_EXISTS_ATTENDANCE_LIST = "출석된 기록이 존재하지 않습니다.";

    private final List<Attendance> attendances;

    public Attendances() {
        this.attendances = new ArrayList<>();
    }

    public Attendance addAttendance(LocalDateTime dateTime) {
        Attendance attendance = new Attendance(dateTime);
        attendances.add(attendance);
        return attendance;
    }

    public Attendance getAttendanceByDate(LocalDate date) {
        return attendances.stream()
                .filter(attendance -> attendance.isSameDate(date))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTS_ATTENDANCE_LIST));
    }

    public void updateAttendance(LocalDate date, LocalTime time) {
        getAttendanceByDate(date).updateTime(time);
    }

    public AttendanceHistory getAttendanceHistory(LocalDate date) {
        return new AttendanceHistory(date, attendances);
    }
}

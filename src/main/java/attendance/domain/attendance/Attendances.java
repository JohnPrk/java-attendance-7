package attendance.domain.attendance;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Attendances {

    private final List<Attendance> attendances;

    public Attendances() {
        this.attendances = new ArrayList<>();
    }

    public Attendance addAttendance(LocalDateTime dateTime) {
        Attendance attendance = new Attendance(dateTime);
        attendances.add(attendance);
        return attendance;
    }
}

package attendance.domain.attendance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Attendance {

    private LocalDate date;
    private LocalTime time;

    public Attendance(LocalDateTime dateTime) {
        this.date = dateTime.toLocalDate();
        this.time = dateTime.toLocalTime();
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
}

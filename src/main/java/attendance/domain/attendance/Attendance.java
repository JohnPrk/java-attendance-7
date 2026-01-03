package attendance.domain.attendance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Attendance {

    private LocalDate date;
    private LocalTime time;
    private DailyAttendanceStatus dailyAttendanceStatus;

    public Attendance(LocalDateTime dateTime) {
        this.date = dateTime.toLocalDate();
        this.time = dateTime.toLocalTime();
        this.dailyAttendanceStatus = DailyAttendanceStatus.of(date, time);
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDailyAttendanceStatus() {
        return dailyAttendanceStatus.getName();
    }

    public boolean isSameDate(LocalDate date) {
        return this.date.equals(date);
    }

    public void updateTime(LocalTime time) {
        this.time = time;
        this.dailyAttendanceStatus = DailyAttendanceStatus.of(date, time);
    }
}

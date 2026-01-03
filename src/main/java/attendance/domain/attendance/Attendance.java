package attendance.domain.attendance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Attendance implements Comparable<Attendance> {

    private LocalDate date;
    private LocalTime time;
    private DailyAttendanceStatus dailyAttendanceStatus;

    public Attendance(LocalDateTime dateTime) {
        this.date = dateTime.toLocalDate();
        this.time = dateTime.toLocalTime();
        this.dailyAttendanceStatus = DailyAttendanceStatus.of(date, time);
    }

    public Attendance(LocalDate date) {
        this.date = date;
        this.dailyAttendanceStatus = DailyAttendanceStatus.ABSENCE;
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

    public boolean isAttendance() {
        return dailyAttendanceStatus.isAttendance();
    }

    public boolean isLate() {
        return dailyAttendanceStatus.isLate();
    }

    public boolean isAbsence() {
        return dailyAttendanceStatus.isAbsence();
    }

    public boolean isSameYearAndMonth(LocalDate date) {
        return date.getMonthValue() == this.date.getMonthValue() && date.getYear() == this.date.getYear();
    }

    public void updateTime(LocalTime time) {
        this.time = time;
        this.dailyAttendanceStatus = DailyAttendanceStatus.of(date, time);
    }

    @Override
    public int compareTo(Attendance attendance) {
        if (this.date.isAfter(attendance.getDate())) {
            return 1;
        }
        return -1;
    }
}

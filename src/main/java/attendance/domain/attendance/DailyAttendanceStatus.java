package attendance.domain.attendance;

import java.time.LocalDate;
import java.time.LocalTime;

public enum DailyAttendanceStatus {

    ATTENDANCE("출석"),

    LATE("지각"),

    ABSENCE("결석");

    private final String name;

    DailyAttendanceStatus(String name) {
        this.name = name;
    }

    public static DailyAttendanceStatus of(LocalDate date, LocalTime time) {
        CriteriaOfAttendance criteriaOfAttendance = CriteriaOfAttendance.of(date.getDayOfWeek());
        if (criteriaOfAttendance.isLate(date.getDayOfWeek(), time)) {
            return LATE;
        }
        if (criteriaOfAttendance.isAbsence(date.getDayOfWeek(), time)) {
            return ABSENCE;
        }

        return ATTENDANCE;
    }

    public String getName() {
        return name;
    }

    public boolean isAttendance() {
        return this.equals(ATTENDANCE);
    }

    public boolean isLate() {
        return this.equals(LATE);
    }

    public boolean isAbsence() {
        return this.equals(ABSENCE);
    }
}

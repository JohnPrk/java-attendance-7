package attendance.domain.attendance;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;

public enum CriteriaOfAttendance {

    MONDAY_CRITERIA(DayOfWeek.MONDAY, LocalTime.of(13, 6), LocalTime.of(13, 30)),
    TUESDAY_CRITERIA(DayOfWeek.TUESDAY, LocalTime.of(10, 6), LocalTime.of(10, 30)),
    WEDNESDAY_CRITERIA(DayOfWeek.WEDNESDAY, LocalTime.of(10, 6), LocalTime.of(10, 30)),
    THURSDAY_CRITERIA(DayOfWeek.THURSDAY, LocalTime.of(10, 6), LocalTime.of(10, 30)),
    FRIDAY_CRITERIA(DayOfWeek.FRIDAY, LocalTime.of(10, 6), LocalTime.of(10, 30));

    private static final String NOT_EXISTS_CRITERIA_OF_ATTENDANCE = "요일의 출석 규칙이 존재하지 않습니다.";

    private final DayOfWeek dayOfWeek;
    private final LocalTime lateTime;
    private final LocalTime absenceTime;

    CriteriaOfAttendance(DayOfWeek dayOfWeek, LocalTime lateTime, LocalTime absenceTime) {
        this.dayOfWeek = dayOfWeek;
        this.lateTime = lateTime;
        this.absenceTime = absenceTime;
    }

    public static CriteriaOfAttendance of(DayOfWeek dayOfWeek) {
        return Arrays.stream(values())
                .filter(criteria -> dayOfWeek.equals(criteria.dayOfWeek))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTS_CRITERIA_OF_ATTENDANCE));
    }

    public boolean isLate(DayOfWeek dayOfWeek, LocalTime time) {
        CriteriaOfAttendance criteriaOfAttendance = of(dayOfWeek);
        return time.isAfter(criteriaOfAttendance.lateTime) && time.isBefore(criteriaOfAttendance.absenceTime);
    }

    public boolean isAbsence(DayOfWeek dayOfWeek, LocalTime time) {
        CriteriaOfAttendance criteriaOfAttendance = of(dayOfWeek);
        return time.isAfter(criteriaOfAttendance.absenceTime);
    }
}

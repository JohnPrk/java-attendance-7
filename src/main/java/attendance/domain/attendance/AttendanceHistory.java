package attendance.domain.attendance;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Collections;
import java.util.List;

import static attendance.domain.attendance.DayOfTheWeek.isWeekend;
import static attendance.domain.attendance.Holiday.isHoliday;

public class AttendanceHistory {

    private final List<Attendance> attendances;
    private final long attendanceCount;
    private final long lateCount;
    private final long absenceCount;
    private final CriteriaOfAcademicWarning academicWarningStatus;

    public AttendanceHistory(LocalDate referenceDate, List<Attendance> attendances) {
        this.attendances = addNotExistsAttendanceDateToAbsenceAttendance(referenceDate, attendances);
        this.attendanceCount = countAttendance(referenceDate, attendances);
        this.lateCount = countLate(referenceDate, attendances);
        this.absenceCount = countAbsence(referenceDate, attendances);
        this.academicWarningStatus = CriteriaOfAcademicWarning.decide(lateCount, absenceCount);
        Collections.sort(attendances);
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public long getAttendanceCount() {
        return attendanceCount;
    }

    public long getLateCount() {
        return lateCount;
    }

    public long getAbsenceCount() {
        return absenceCount;
    }

    public String getAcademicWarningStatus() {
        return academicWarningStatus.getDescription();
    }

    public boolean hasNoWarning() {
        return academicWarningStatus.isSafe();
    }

    private List<Attendance> addNotExistsAttendanceDateToAbsenceAttendance(LocalDate referenceDate, List<Attendance> attendances) {
        LocalDate startDate = referenceDate.with(TemporalAdjusters.firstDayOfMonth());
        for (LocalDate date = startDate; date.isBefore(referenceDate); date = date.plusDays(1)) {
            if (isWeekend(date)) {
                continue;
            }
            if (isHoliday(date)) {
                continue;
            }
            if (isNotExists(attendances, date)) {
                attendances.add(new Attendance(date));
            }
        }
        return attendances;
    }

    private long countAbsence(LocalDate referenceDate, List<Attendance> attendances) {
        return attendances.stream()
                .filter(attendance -> attendance.isSameYearAndMonth(referenceDate))
                .filter(Attendance::isAbsence)
                .count();
    }

    private long countLate(LocalDate referenceDate, List<Attendance> attendances) {
        return attendances.stream()
                .filter(attendance -> attendance.isSameYearAndMonth(referenceDate))
                .filter(Attendance::isLate)
                .count();
    }

    private long countAttendance(LocalDate referenceDate, List<Attendance> attendances) {
        return attendances.stream()
                .filter(attendance -> attendance.isSameYearAndMonth(referenceDate))
                .filter(Attendance::isAttendance)
                .count();
    }

    private boolean isNotExists(List<Attendance> attendances, LocalDate date) {
        return attendances.stream()
                .noneMatch(attendance -> attendance.isSameDate(date));
    }
}

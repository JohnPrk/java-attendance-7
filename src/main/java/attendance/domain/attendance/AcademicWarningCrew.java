package attendance.domain.attendance;

public class AcademicWarningCrew {

    private final String crewName;
    private final long lateCount;
    private final long absenceCount;
    private final String academicWarningStatus;

    public AcademicWarningCrew(String crewName, long lateCount, long absenceCount, String academicWarningStatus) {
        this.crewName = crewName;
        this.lateCount = lateCount;
        this.absenceCount = absenceCount;
        this.academicWarningStatus = academicWarningStatus;
    }

    public String getCrewName() {
        return crewName;
    }

    public long getLateCount() {
        return lateCount;
    }

    public long getAbsenceCount() {
        return absenceCount;
    }

    public String getAcademicWarningStatus() {
        return academicWarningStatus;
    }
}

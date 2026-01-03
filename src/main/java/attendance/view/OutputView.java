package attendance.view;

import attendance.domain.attendance.Attendance;
import attendance.domain.attendance.DayOfTheWeek;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class OutputView {

    private static final String WELCOME_MESSAGE = "오늘은 %02d월 %02d일 %s입니다. 기능을 선택해 주세요.%n";
    private static final String REGISTER_ATTENDANCE_MESSAGE = "%02d월 %02d일 %s %02d:%02d (%s)%n";
    private static final String UPDATE_ATTENDANCE_MESSAGE = "%02d월 %02d일 %s %02d:%02d (%s) -> %02d:%02d (%s) 수정 완료!%n";

    public static void printWelcomeMessage(LocalDateTime date) {
        System.out.printf(WELCOME_MESSAGE + "%n", date.getMonthValue(), date.getDayOfMonth(), DayOfTheWeek.getKoreanName(date.getDayOfWeek()));
    }

    public static void printQuitMessage() {
        System.out.println("시스템을 종료합니다.");
    }

    public static void printRegisterAttendance(Attendance attendance) {
        System.out.printf(
                REGISTER_ATTENDANCE_MESSAGE,
                attendance.getDate().getMonthValue(),
                attendance.getDate().getDayOfMonth(),
                DayOfTheWeek.getKoreanName(attendance.getDate().getDayOfWeek()),
                attendance.getTime().getHour(),
                attendance.getTime().getMinute(),
                attendance.getDailyAttendanceStatus());
    }

    public static void printUpdateAttendanceMessage(LocalDate previousDate, LocalTime previousTime, String previousDailyAttendanceStatus, Attendance updatedAttendance) {
        System.out.printf(
                UPDATE_ATTENDANCE_MESSAGE,
                previousDate.getMonthValue(),
                previousDate.getDayOfMonth(),
                DayOfTheWeek.getKoreanName(previousDate.getDayOfWeek()),
                previousTime.getHour(),
                previousTime.getMinute(),
                previousDailyAttendanceStatus,
                updatedAttendance.getTime().getHour(),
                updatedAttendance.getTime().getMinute(),
                updatedAttendance.getDailyAttendanceStatus());
    }
}

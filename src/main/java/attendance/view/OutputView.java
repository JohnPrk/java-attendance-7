package attendance.view;

import attendance.domain.attendance.Attendance;
import attendance.domain.attendance.DayOfTheWeek;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OutputView {

    private static final String WELCOME_MESSAGE = "오늘은 %02d월 %02d일 %s입니다. 기능을 선택해 주세요.%n";
    private static final String REGISTER_ATTENDANCE_MESSAGE = "%02d월 %02d일 %s %02d:%02d (%s)%n";

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
}

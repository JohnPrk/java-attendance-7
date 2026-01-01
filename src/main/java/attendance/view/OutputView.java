package attendance.view;

import attendance.utils.DayConverterUtil;

import java.time.LocalDateTime;

public class OutputView {

    private static final String WELCOME_MESSAGE = "오늘은 %02d월 %02d일 %s입니다. 기능을 선택해 주세요.%n";

    public static void printWelcomeMessage(LocalDateTime date) {
        System.out.printf(WELCOME_MESSAGE + "%n", date.getMonthValue(), date.getDayOfMonth(), DayConverterUtil.getKoreanDayOfWeek(date.getDayOfWeek()));
    }

    public static void printQuitMessage() {
        System.out.println("시스템을 종료합니다.");
    }
}

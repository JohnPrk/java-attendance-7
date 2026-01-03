package attendance.view;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class InputValidator {

    private static final String IS_NOT_BLANK_AND_NULL = "입력값은 공백이 될 수 없습니다.";
    private static final String WRONG_REGEX_TYPE = "[ERROR] 잘못된 형식을 입력하였습니다.";
    private static final String WRONG_TIME_TYPE = "[ERROR] 잘못된 범위의 시간을 입력하였습니다.";
    private static final String WRONG_DATE_TYPE = "[ERROR] 잘못된 범위의 날짜를 입력하였습니다.";
    private static final String WRONG_DAY_TYPE = "잘못된 날짜(일) 형식입니다.";
    private static final String WRONG_DAY_RANGE = "잘못된 날짜(일)의 범위입니다.";
    private static final String TIME_REGEX = "^\\d{1,2}:\\d{1,2}$";
    private static final String DAY_REGEX = "^\\d{1,2}$";

    public static void menuValid(String menu) {
        checkNotNull(menu);
        checkNotBlank(menu);
    }

    public static void nameValid(String name) {
        checkNotNull(name);
        checkNotBlank(name);
    }

    public static void timeValid(String time) {
        checkNotNull(time);
        checkNotBlank(time);
        checkTimeRegex(time);
    }

    public static void dayValid(String day) {
        checkNotBlank(day);
        checkNotNull(day);
        checkDayRegex(day);
    }

    private static void checkDayRegex(String day) {
        if (!day.matches(DAY_REGEX)) {
            throw new IllegalArgumentException(WRONG_DAY_TYPE);
        }
        int dayOfMonth = Integer.parseInt(day);
        LocalDate today = LocalDate.now();
        int lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
        if (dayOfMonth < 0 || dayOfMonth > lastDayOfMonth) {
            throw new IllegalArgumentException(WRONG_DAY_RANGE);
        }
    }

    private static void checkTimeRegex(String time) {
        if (!time.matches(TIME_REGEX)) {
            throw new IllegalArgumentException(WRONG_REGEX_TYPE);
        }
        String[] hourAndMinute = time.split(":");
        int hour = Integer.parseInt(hourAndMinute[0]);
        int minute = Integer.parseInt(hourAndMinute[1]);
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException(WRONG_DATE_TYPE);
        }
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException(WRONG_TIME_TYPE);
        }
    }

    private static void checkNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(IS_NOT_BLANK_AND_NULL);
        }
    }

    private static void checkNotBlank(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(IS_NOT_BLANK_AND_NULL);
        }
    }
}

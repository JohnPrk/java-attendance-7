package attendance.view;

public class InputValidator {

    private static final String IS_NOT_BLANK_AND_NULL = "입력값은 공백이 될 수 없습니다.";
    private static final String WRONG_REGEX_TYPE = "[ERROR] 잘못된 형식을 입력하였습니다.";
    private static final String WRONG_TIME_TYPE = "[ERROR] 잘못된 범위의 시간을 입력하였습니다.";
    private static final String WRONG_DATE_TYPE = "[ERROR] 잘못된 범위의 날짜를 입력하였습니다.";

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

    private static void checkTimeRegex(String time) {
        String regex = "^\\d{1,2}:\\d{1,2}$";
        if (!time.matches(regex)) {
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

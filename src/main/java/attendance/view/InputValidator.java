package attendance.view;

public class InputValidator {

    private static final String IS_NOT_BLANK_AND_NULL = "입력값은 공백이 될 수 없습니다.";

    public static void menuValid(String menu) {
        checkNotNull(menu);
        checkNotBlank(menu);
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

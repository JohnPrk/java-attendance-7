package attendance.utils;

import java.util.function.Supplier;

public class Retry {

    public static <T> T repeatUntilSuccess(Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

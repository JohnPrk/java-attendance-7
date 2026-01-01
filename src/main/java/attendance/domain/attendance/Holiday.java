package attendance.domain.attendance;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import static attendance.domain.attendance.DayOfTheWeek.getKoreanName;

public enum Holiday {

    CHRISTMAS(LocalDate.of(2024, 12, 25));

    private static final String NOT_ATTENDANCE_DAY = "%02d월 %02d일 %s은 등교일이 아닙니다.";

    private final LocalDate date;

    Holiday(LocalDate date) {
        this.date = date;
    }

    public static void validHoliday(LocalDateTime dateTime) {
        LocalDate date = dateTime.toLocalDate();
        if (isHoliday(date)) {
            throw new IllegalArgumentException(String.format(NOT_ATTENDANCE_DAY, date.getMonthValue(), date.getDayOfMonth(), getKoreanName(date.getDayOfWeek())));
        }
    }

    private static boolean isHoliday(LocalDate date) {
        return Arrays.stream(Holiday.values())
                .anyMatch(h -> h.date.equals(date));
    }
}

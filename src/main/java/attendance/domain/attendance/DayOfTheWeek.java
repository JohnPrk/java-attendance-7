package attendance.domain.attendance;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public enum DayOfTheWeek {

    MONDAY(DayOfWeek.MONDAY, "월요일"),
    TUESDAY(DayOfWeek.TUESDAY, "화요일"),
    WEDNESDAY(DayOfWeek.WEDNESDAY, "수요일"),
    THURSDAY(DayOfWeek.THURSDAY, "목요일"),
    FRIDAY(DayOfWeek.FRIDAY, "금요일"),
    SATURDAY(DayOfWeek.SATURDAY, "토요일"),
    SUNDAY(DayOfWeek.SUNDAY, "일요일");

    private static final String NOT_ATTENDANCE_DAY = "[ERROR] %02d월 %02d일 %s은 등교일이 아닙니다.";
    private static final String NOT_EXISTS_DAY_OF_WEEK = "[ERROR] 존재하지 않는 요일입니다.";

    private final DayOfWeek dayOfWeek;
    private final String koreanName;

    DayOfTheWeek(DayOfWeek dayOfWeek, String koreanName) {
        this.dayOfWeek = dayOfWeek;
        this.koreanName = koreanName;
    }

    public static DayOfTheWeek of(DayOfWeek dayOfWeek) {
        return Arrays.stream(values())
                .filter(day -> dayOfWeek.equals(day.dayOfWeek))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTS_DAY_OF_WEEK));
    }

    public static void validWeekend(LocalDateTime date) {
        if (isWeekend(date.toLocalDate())) {
            throw new IllegalArgumentException(String.format(NOT_ATTENDANCE_DAY, date.getMonthValue(), date.getDayOfMonth(), getKoreanName(date.getDayOfWeek())));
        }
    }

    public static boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return of(dayOfWeek).equals(SATURDAY) || of(dayOfWeek).equals(SUNDAY);
    }

    public static String getKoreanName(DayOfWeek dayOfWeek) {
        return of(dayOfWeek).koreanName;
    }
}

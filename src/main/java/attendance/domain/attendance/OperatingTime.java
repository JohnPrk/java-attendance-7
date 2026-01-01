package attendance.domain.attendance;

import java.time.LocalTime;

public enum OperatingTime {

    START(LocalTime.of(8, 0)),
    END(LocalTime.of(23, 0));

    private static final String NO_OPERATION_TIME = "출석 가능한 시간이 아닙니다.";

    private final LocalTime time;

    OperatingTime(LocalTime time) {
        this.time = time;
    }

    public static void checkAvailableTime(LocalTime time) {
        if (!(!(time.isBefore(START.time)) && !(time.isAfter(END.time)))) {
            throw new IllegalArgumentException(NO_OPERATION_TIME);
        }
    }

    public LocalTime getTime() {
        return time;
    }
}

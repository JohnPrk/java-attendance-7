package attendance.view;


import attendance.domain.attendance.OperatingTime;
import camp.nextstep.edu.missionutils.Console;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.function.Consumer;

public class InputView {

    private static final String INPUT_MENU = "1. 출석 확인\n"
            + "2. 출석 수정\n"
            + "3. 크루별 출석 기록 확인\n"
            + "4. 제적 위험자 확인\n"
            + "Q. 종료";
    private static final String INPUT_CREW_NAME = "닉네임을 입력해 주세요.";
    private static final String INPUT_ATTENDANCE_TIME = "등교 시간을 입력해 주세요.";
    private static final String INPUT_UPDATE_DAY = "수정할 날짜(일)를 입력하세요.";

    public static String inputMenu() {
        System.out.println(INPUT_MENU);
        String menu = Console.readLine();
        InputValidator.menuValid(menu);
        return menu;
    }

    public static String inputName(Consumer<String> existsValidator) {
        System.out.println(INPUT_CREW_NAME);
        String name = Console.readLine();
        InputValidator.nameValid(name);
        existsValidator.accept(name);
        return name;
    }

    public static LocalTime inputTime() {
        System.out.println(INPUT_ATTENDANCE_TIME);
        String time = Console.readLine();
        InputValidator.timeValid(time);
        String[] hoursAndMinutes = time.split(":");
        OperatingTime.checkAvailableTime(LocalTime.of(Integer.parseInt(hoursAndMinutes[0]), Integer.parseInt(hoursAndMinutes[1])));
        return LocalTime.of(Integer.parseInt(hoursAndMinutes[0]), Integer.parseInt(hoursAndMinutes[1]));
    }

    public static LocalDate inputDate(LocalDateTime dateTime, Consumer<LocalDate> existsValidator) {
        System.out.println(INPUT_UPDATE_DAY);
        String day = Console.readLine();
        InputValidator.dayValid(day);
        LocalDate updateDay = dateTime.toLocalDate().withDayOfMonth(Integer.parseInt(day));
        existsValidator.accept(updateDay);
        return updateDay;
    }
}

package attendance.controller;

import attendance.domain.attendance.Attendance;
import attendance.domain.attendance.DayOfTheWeek;
import attendance.domain.attendance.Holiday;
import attendance.domain.crew.Crew;
import attendance.domain.crew.Crews;
import attendance.domain.menu.Menu;
import attendance.utils.Retry;
import attendance.view.InputView;
import attendance.view.OutputView;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class AttendanceController {

    private Crews crews;
    private LocalDateTime dateTime;

    public AttendanceController(Crews crews, LocalDateTime dateTime) {
        this.crews = crews;
        this.dateTime = dateTime;
    }

    public void run() {
        while (true) {
            try {
                OutputView.printWelcomeMessage(dateTime);
                Menu menu = getMenu();
                if (isQuit(menu)) {
                    break;
                }
                processMenu(menu);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void processMenu(Menu menu) {
        switch (menu) {
            case REGISTER_ATTENDANCE -> registerAttendance();
            case UPDATE_ATTENDANCE -> updateAttendance();
            case GET_ATTENDANCE_HISTORY -> getAttendanceHistory();
            case GET_DROPOUT_RISK_MEMBERS -> getDropoutRiskMembers();
        }
    }

    private void getDropoutRiskMembers() {
        System.out.println("<제적 위험자 조회>");
    }

    private void getAttendanceHistory() {
        System.out.println("<출석 기록 조회>");

    }

    private void updateAttendance() {
        System.out.println("<출석 수정>");

    }

    private void registerAttendance() {
        DayOfTheWeek.validWeekend(dateTime);
        Holiday.validHoliday(dateTime);
        System.out.println("<출석 등록>");
        Attendance attendance = registerAndGetAttendance();
        OutputView.printRegisterAttendance(attendance);
    }

    private boolean isQuit(Menu menu) {
        if (menu.isQuit()) {
            OutputView.printQuitMessage();
            return true;
        }
        return false;
    }

    private Attendance registerAndGetAttendance() {
        return Retry.repeatUntilSuccess(() -> {
            String crewName = InputView.inputName(crews::getCrewByName);
            Crew crew = crews.getCrewByName(crewName);
            LocalTime localTime = InputView.inputTime();
            return crew.registerAttendance(LocalDateTime.of(dateTime.toLocalDate(), localTime));
        });
    }

    private Menu getMenu() {
        return Retry.repeatUntilSuccess(() -> {
            String input = InputView.inputMenu();
            return Menu.of(input);
        });
    }
}

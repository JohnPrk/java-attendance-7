package attendance;

import attendance.controller.AttendanceController;
import attendance.domain.crew.Crews;
import attendance.utils.CsvFileHandler;
import camp.nextstep.edu.missionutils.DateTimes;

public class Application {

    public static void main(String[] args) {
        Crews crews = CsvFileHandler.convertCsvFileToCrewList();
        AttendanceController controller = new AttendanceController(crews, DateTimes.now());
        controller.run();
    }
}

package attendance.controller;

import attendance.domain.crew.Crews;

import java.time.LocalDateTime;

public class AttendanceController {

    private Crews crews;
    private LocalDateTime dateTime;

    public AttendanceController(Crews crews, LocalDateTime dateTime) {
        this.crews = crews;
        this.dateTime = dateTime;
    }

    public void run() {
    }
}
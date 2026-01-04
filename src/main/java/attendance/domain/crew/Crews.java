package attendance.domain.crew;

import attendance.domain.attendance.AcademicWarningCrew;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Crews {

    private List<Crew> crews;

    public Crews() {
        this.crews = new ArrayList<>();
    }

    public Crew getExistedCrewOrMakeNewCrew(String name) {
        Optional<Crew> optionalCrew = crews.stream()
                .filter(crew -> crew.findByName(name))
                .findFirst();
        if (optionalCrew.isEmpty()) {
            Crew crew = new Crew(name);
            crews.add(crew);
            return crew;
        }
        return optionalCrew.get();
    }

    public Crew getCrewByName(String name) {
        return findByName(name);
    }

    private Crew findByName(String name) {
        return crews.stream()
                .filter(crew -> crew.findByName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 등록되지 않은 닉네임입니다."));
    }

    public List<AcademicWarningCrew> getAcademicWarningCrews(LocalDate dateTime) {
        return crews.stream()
                .map(crew -> crew.getAcademicWarningCrew(dateTime))
                .toList();
    }
}

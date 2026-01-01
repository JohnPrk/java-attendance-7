package attendance.domain.crew;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Crews {

    private List<Crew> crews;

    public Crews() {
        this.crews = new ArrayList<>();
    }

    public Crew findCrew(String name) {
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
}

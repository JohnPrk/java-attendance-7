package attendance.domain.attendance;

import java.util.Arrays;
import java.util.function.Predicate;

public enum CriteriaOfAcademicWarning {

    EXPULSION("제적", count -> count >= 5),
    INTERVIEW("면담", count -> count >= 3),
    WARNING("경고", count -> count >= 2),
    NONE("정상", count -> count < 2);

    private final String description;
    private final Predicate<Long> condition;

    CriteriaOfAcademicWarning(String description, Predicate<Long> condition) {
        this.description = description;
        this.condition = condition;
    }

    public static CriteriaOfAcademicWarning decide(long late, long absence) {
        return Arrays.stream(values())
                .filter(criteria -> criteria.condition.test(rule(late, absence)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 기준이 존재하지 않습니다."));
    }

    private static long rule(long late, long absence) {
        return (late / 3) + absence;
    }

    public boolean isSafe() {
        return this == NONE;
    }

    public String getDescription() {
        return description;
    }
}

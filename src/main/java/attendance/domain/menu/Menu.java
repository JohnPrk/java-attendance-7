package attendance.domain.menu;

import java.util.Arrays;
import java.util.Objects;

public enum Menu {

    REGISTER_ATTENDANCE("1"),
    UPDATE_ATTENDANCE("2"),
    GET_ATTENDANCE_HISTORY("3"),
    GET_ACADEMIC_WARNING_CREWS("4"),
    QUIT("Q");

    private final String symbol;

    Menu(String symbol) {
        this.symbol = symbol;
    }

    public static Menu of(String symbol) {
        return Arrays.stream(Menu.values())
                .filter(menu -> symbol.equals(menu.symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않는 메뉴입니다."));
    }

    public boolean isQuit() {
        return Objects.equals(QUIT.symbol, this.symbol);
    }
}

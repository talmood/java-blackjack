import java.util.List;

public enum Denomination {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    J(10),
    Q(10),
    K(10);

    int value;

    public int getValue() {
        return value;
    }

    Denomination(int value) {
        this.value = value;
    }

    static boolean isNumber(Denomination denomination) {
        List<Denomination> persons = List.of(ACE, J, Q, K);

        if (persons.contains(denomination)) {
            return false;
        }
        return true;
    }
}

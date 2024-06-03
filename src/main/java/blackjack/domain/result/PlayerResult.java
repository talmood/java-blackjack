package blackjack.domain.result;

public class PlayerResult {
    private final String name;
    private final Result result;

    private PlayerResult(final String name, final Result result) {
        this.name = name;
        this.result = result;
    }

    public static PlayerResult of(final String name, final Result result) {
        return new PlayerResult(name, result);
    }

    public String getName() {
        return name;
    }

    public Result getResult() {
        return result;
    }
}

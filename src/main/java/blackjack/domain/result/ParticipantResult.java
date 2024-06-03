package blackjack.domain.result;

public class ParticipantResult {

    private final String name;
    private final Result result;

    public ParticipantResult(final String name, final Result result) {
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public Result getResult() {
        return result;
    }
    
}

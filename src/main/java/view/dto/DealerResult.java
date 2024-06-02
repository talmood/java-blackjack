package view.dto;

public class DealerResult {

    private final GameResult value;

    public DealerResult(GameResult value) {
        this.value = value;
    }

    public String toResultFormat() {
        return "딜러: "
                + formatCount(value.wonCount(), "승")
                + formatCount(value.tieCount(), "무")
                + formatCount(value.loseCount(), "패");
    }

    private String formatCount(final long count, final String suffix) {
        if (count == 0) {
            return "";
        }
        return count + suffix;
    }

}

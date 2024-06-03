package blackjack.domain.result;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class DealerResult {
    private final Map<Result, Integer> result;

    public DealerResult(final List<PlayerResult> playerResults) {
        this.result = new EnumMap<>(Result.class);
        calculateResultCount(playerResults);
    }

    private void calculateResultCount(final List<PlayerResult> playerResults) {
        for (final PlayerResult playerResult : playerResults) {
            addCount(Result.reverse(playerResult.getResult()));
        }
    }

    private void addCount(final Result result) {
        this.result.put(result, this.result.getOrDefault(result, 0) + 1);
    }

    public Map<Result, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

}

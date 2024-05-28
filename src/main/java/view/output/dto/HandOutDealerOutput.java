package view.output.dto;

public class HandOutDealerOutput {

    private final int handOutThreshold;

    public HandOutDealerOutput(int handOutThreshold) {
        this.handOutThreshold = handOutThreshold;
    }

    public int getHandOutThreshold() {
        return handOutThreshold;
    }
}

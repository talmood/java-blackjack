package domain.trumpcard;

public enum WinOrLose {
    WIN("승"),
    LOSE("패"),
    TIE("무승부");

    private final String koreanName;

    WinOrLose(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }
}

import java.util.Random;

public enum Suit {
    heart("하트"),
    spade("스페이드"),
    club("클로브"),
    diamond("다이아몬드");

    String title;

    public String getTitle() {
        return title;
    }

    Suit(String title) {
        this.title = title;
    }

    public static Suit getRandomSuits() {
        int randomIndex = new Random().nextInt(3);
        Suit[] values = Suit.values();
        return values[randomIndex];
    }
}

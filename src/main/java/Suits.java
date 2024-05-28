import java.util.Random;

public enum Suits {
    heart("하트"),
    spade("스페이드"),
    club("클로브"),
    diamond("다이아몬드");

    String title;

    public String getTitle() {
        return title;
    }

    Suits(String title) {
        this.title = title;
    }

    public static Suits getRandomSuits() {
        int randomIndex = new Random().nextInt(3);
        Suits[] values = Suits.values();
        return values[randomIndex];
    }
}

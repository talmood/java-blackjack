package view.input.dto;

public class HandOutPlayerInput {

    private final boolean handOut;

    public HandOutPlayerInput(boolean handOut) {
        this.handOut = handOut;
    }

    public static HandOutPlayerInput from(String input) {
        if (input.equals("y")) {
            return new HandOutPlayerInput(true);
        }

        if (input.equals("n")) {
            return new HandOutPlayerInput(false);
        }

        throw new IllegalArgumentException("카드를 더 받을 건지에 대한 응답은 y아니면 n이어야 합니다.");
    }

    public boolean isHandOut() {
        return handOut;
    }
}

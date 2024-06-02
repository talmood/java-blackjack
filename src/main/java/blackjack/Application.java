package blackjack;


import blackjack.controller.BlackJackGameController;

public class Application {

	public static void main(String[] args) {
		final BlackJackGameController blackJackGameController = new BlackJackGameController();
		blackJackGameController.run();
	}
}

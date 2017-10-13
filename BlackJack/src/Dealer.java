import java.util.InputMismatchException;
import java.util.Scanner;

public class Dealer {

	private int playerSum;
	private int dealerSum;
	private int dealerSecondCard;
	private String hitOrStay = "'h' for hit, 's' for stay";
	CardDeck cardDeck; // = new CardDeck();

	public Dealer() {
		super();
		cardDeck = new CardDeck();
	}

	void initiateGame() {
		int firstCard = giveCard(); // Dealern ger fï¿½rsta kortet
		int secondCard = giveCard(); // Dealern ger andra kortet
		// playerSum = firstCard + secondCard;
		playerSum = 21;
		System.out.println("You get a " + firstCard + " and a " + secondCard + "\nYour total is " + playerSum + "\n");
		// Ger tvï¿½ kort till spelaren och skriver ut totala

		int dealerFirstCard = giveCard();
		dealerSecondCard = giveCard();
		dealerSum = dealerFirstCard + dealerSecondCard;

		if (playerSum < 21) {
			System.out.println("The dealer has " + dealerFirstCard
					+ " showing and a hidden card\nHis total is hidden too\n\n" + hitOrStay);
			// Ger tvï¿½ kort till dealern men skriver bara ut det fï¿½rsta kortet
		}
	}

	int giveCard() { // Metoden fï¿½r att ge kort
		int card = cardDeck.getCards().get(0); // Ger kort vï¿½rdet av kortet pï¿½ index 0
		cardDeck.getCards().remove(0);
		return card;
	}

	void proceedGame() {
		int newCard;
		newCard = giveCard();
		playerSum += newCard;
		System.out.println("You drew a " + newCard + "\nYour total is " + playerSum);
	}

	boolean playerStay(String proceed, Scanner scan) { // Metoden fï¿½r att loopa spelet tills man vinner, vï¿½ljer att
														// stanna eller fï¿½rlorar

		boolean ifNotSOrH = false;

		while (proceed.equals("h") || proceed.equals("H")) {

			if (playerSum < 21) { // Om man fï¿½r under 21 och vï¿½ljer att 'hit' sï¿½ fortsï¿½tter spelet
				proceedGame();
				if (playerSum < 21) {
					System.out.println("\n" + hitOrStay + " i första while loop");
					proceed = scan.next();
				}
			}

			if (playerSum > 21) { // Om man fï¿½r ï¿½ver 21
				System.out.println("You lost");
				break;
			}

			if (playerSum == 21) { // Om man fï¿½r 21
				System.out.println("Blackjack!");
				break;
			}
		}

		if (proceed.equals("s") || proceed.equals("S"))
			return true;

		if (proceed.equals("h") || proceed.equals("H"))
			return false;

		else {
			ifNotSOrH = true;
		}
		while (ifNotSOrH) {
			System.out.println(hitOrStay + " i andra while loop");
			proceed = scan.next();
			if (proceed.equals("s") || proceed.equals("S"))
				break;
			else if (proceed.equals("h") || proceed.equals("H")) {
				while (proceed.equals("h") || proceed.equals("H")) {
					if (playerSum < 21) { // Om man fï¿½r under 21 och vï¿½ljer att 'hit' sï¿½ fortsï¿½tter spelet
						proceedGame();
					}

					if (playerSum > 21) { // Om man fï¿½r ï¿½ver 21
						System.out.println("You lost");
						break;
					}

					if (playerSum == 21) { // Om man fï¿½r 21
						System.out.println("Blackjack!");
						break;
					}
					System.out.println("\n" + hitOrStay + " andra i andra while loop");
					proceed = scan.next();
				}
				return false;
			}
		}
		return false;
	}

	int getPlayerSum() {
		return playerSum;
	}

	boolean dealerWon() {
		if (playerSum > 21)
			return true;

		if (!(playerSum > 21)) {
			System.out.println(
					"\nDealer's turn\nHis hidden card was a " + dealerSecondCard + "\nHis total was " + dealerSum);

			while (dealerSum < 17) { // Dealern mï¿½ste ta "hit" nï¿½r den har mindre ï¿½n 17
				int newCard = giveCard();
				dealerSum = dealerSum + newCard;
				System.out.println("\nDealer chooses to hit\nHe draws a " + newCard + "\nHis total is " + dealerSum
						+ "\nYour total was " + playerSum);
			}

			if (playerSum > dealerSum && playerSum <= 21 || dealerSum > 21) { // Spelaren vinner om playerSum ï¿½r
																				// ï¿½ver
																				// dealerSum eller dealer fï¿½r ï¿½ver
																				// 21
				System.out.println("\nYou win");
				return false;
			} else {
				System.out.println("\nDealer win");
				return true;
			}
		}
		return true;
	}

	int numCheck(int num, Scanner scan) {

		boolean keyCheck = true;

		do {

			try {

				num = scan.nextInt();
				break;

			} catch (InputMismatchException e) {

				keyCheck = false;
				System.out.println("We don't take letters...");
				scan.next();
			}

		} while (!keyCheck);
		return num;
	}
}
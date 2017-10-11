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
		int firstCard = giveCard(); // Dealern ger första kortet
		int secondCard = giveCard(); // Dealern ger andra kortet
		playerSum = firstCard + secondCard;
		System.out.println("You get a " + firstCard + " and a " + secondCard +"\nYour total is " + playerSum + "\n");
		// Ger två kort till spelaren och skriver ut totala
		
		int dealerFirstCard = giveCard();
		dealerSecondCard = giveCard();
		dealerSum = dealerFirstCard + dealerSecondCard;
		System.out.println("The dealer has " + dealerFirstCard + " showing and a hidden card\nHis total is hidden too\n\n" + hitOrStay);
		// Ger två kort till dealern men skriver bara ut det första kortet
	}

	int giveCard() { // Metoden för att ge kort
		int card = cardDeck.getCards().get(0); // Ger kort värdet av kortet på index 0
		cardDeck.getCards().remove(0);
		return card;
	}

	void proceedGame () {
		int newCard;
		newCard = giveCard();
		playerSum += newCard;
		System.out.println("You drew a " + newCard + "\nYour total is " + playerSum);
	}

	boolean playerStay(String proceed, Scanner scan) { //Metoden för att loopa spelet tills man vinner, väljer att stanna eller förlorar
		
		boolean ifNotSOrH = false;
		
		if (proceed.equals("s")) {
			return true;
		}
		
		else if (proceed.equals("h")) {
			while (proceed.equals("h")) {

				if (playerSum < 21) { //Om man får under 21 och väljer att 'hit' så fortsätter spelet
					proceedGame();
				}
				
				if (playerSum > 21) { // Om man får över 21
					System.out.println("You lost");
					break;
				}

				if (playerSum == 21) { // Om man får 21
					System.out.println("Blackjack!");
					break;
				}
				System.out.println("\n" + hitOrStay);
				proceed = scan.next();
			}
			return false;
		}
		else {
			ifNotSOrH = true;

			while (ifNotSOrH) {
				System.out.println(hitOrStay);
				proceed = scan.next();
				if (proceed.equals("s"))
					break;
				else if (proceed.equals("h")) {
					while (proceed.equals("h")) {
						if (playerSum < 21) { //Om man får under 21 och väljer att 'hit' så fortsätter spelet
							proceedGame();
						}
						
						if (playerSum > 21) { // Om man får över 21
							System.out.println("You lost");
							break;
						}
	
						if (playerSum == 21) { // Om man får 21
							System.out.println("Blackjack!");
							break;
						}
						System.out.println("\n" + hitOrStay);
						proceed = scan.next();
					}
					return false;
				}
			}
		}
		return false;
	}
		
	int getPlayerSum() {
		return playerSum;
	}

	boolean dealerWon () {
		if (playerSum > 21) 
			return true;
		
		if(!(playerSum > 21)) {
			System.out.println("\nDealer's turn\nHis hidden card was a " + dealerSecondCard + "\nHis total was " + dealerSum);
			
			while (dealerSum < 17) { // Dealern måste ta "hit" när den har mindre än 17
				int newCard = giveCard();
				dealerSum = dealerSum + newCard;
				System.out.println("\nDealer chooses to hit\nHe draws a " + newCard + "\nHis total is " + dealerSum+ "\nYour total was " + playerSum);	
			}
			
			if (playerSum > dealerSum && playerSum <= 21|| dealerSum > 21) { // Spelaren vinner om playerSum är över dealerSum eller dealer får över 21
				System.out.println("\nYou win");
				return false;
			}
			else {
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
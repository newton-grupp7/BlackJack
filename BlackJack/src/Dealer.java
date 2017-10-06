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
		int firstCard = giveCard(); // Dealern ger f�rsta kortet
		int secondCard = giveCard(); // Dealern ger andra kortet
		playerSum = firstCard + secondCard;
		System.out.println("You get a " + firstCard + " and a " + secondCard +"\nYour total is " + playerSum + "\n");
		// Ger tv� kort till spelaren och skriver ut totala
		
		int dealerFirstCard = giveCard();
		dealerSecondCard = giveCard();
		dealerSum = dealerFirstCard + dealerSecondCard;
		System.out.println("The dealer has " + dealerFirstCard + " showing and a hidden card\nHis total is hidden too\n\n" + hitOrStay);
		// Ger tv� kort till dealern men skriver bara ut det f�rsta kortet
	}

	int giveCard() { // Metoden f�r att ge kort
		int kort = cardDeck.getCards().get(0); //cardDeck.get(0); // Ger kort v�rdet av kortet p� index 0
		cardDeck.getCards().remove(0);
		return kort;
	}

	void proceedGame () {
		int newCard;
		newCard = giveCard();
		playerSum += newCard;
		System.out.println("You drew a " + newCard + "\nYour total is " + playerSum);
	}

	boolean playerStay(String proceed, Scanner scan) { //Metoden f�r att loopa spelet tills man vinner, v�ljer att stanna eller f�rlorar
		
//		if (!(proceed.equals("s")) || !(proceed.equals("h"))) { // "Felmeddelande" om man inte skriver in 's' eller 'h'
//			
//			while (!(proceed.equals("s")) || !(proceed.equals("h"))) {
//				System.out.println(hitOrStay + " i else if");
//				proceed = scan.next();
//				if (proceed.equals("s") || proceed.equals("h"))
//					break;
//			}
//		}
		
		if (proceed.equals("s")) {
			return true;
		}
		
		if (proceed.equals("h")) {
			while (proceed.equals("h")) {

				if (playerSum < 21) { //Om man f�r under 21 och v�ljer att 'hit' s� forts�tter spelet
					proceedGame();
				}
				
				if (playerSum > 21) { // Om man f�r �ver 21
					System.out.println("You lost");
					break;
				}

				if (playerSum == 21) { // Om man f�r 21
					System.out.println("Blackjack!");
					break;
				}
				System.out.println("\n'h' for hit, 's' for stay");
				proceed = scan.next();
			}
			return false;
		}
		return false;

	}
		
	boolean dealerWon () {
		if (playerSum > 21) 
			return true;
		
		if(!(playerSum > 21)) {
			System.out.println("\nDealer's turn\nHis hidden card was a " + dealerSecondCard + "\nHis total was " + dealerSum);
			
			while (dealerSum < 17) { // Dealern m�ste ta "hit" n�r den har mindre �n 17
				int newCard = giveCard();
				dealerSum = dealerSum + newCard;
				System.out.println("\nDealer chooses to hit\nHe draws a " + newCard + "\nHis total is " + dealerSum+ "\nYour total was " + playerSum);	
			}
			
			if (playerSum > dealerSum && playerSum <= 21|| dealerSum > 21) { // Spelaren vinner om playerSum �r �ver dealerSum eller dealer f�r �ver 21
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
}
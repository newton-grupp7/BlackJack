import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Dealer extends CardDeck {

	public int playerSum;
	public int dealerSum;
	public int dealerSecondCard;
	public String hitOrStay = "'h' for hit, 's' for stay";

	public ArrayList<Integer> createCardDeck() {

		for (int i = 0; i < 4; i++)
			cardDeck.add(11);
		for (int j = 0; j < 16; j++)
			cardDeck.add(10);
		for (int k = 2; k <= 9; k++)
			for (int i = 0; i < 4; i++)
				cardDeck.add(k);

		Collections.shuffle(cardDeck);
		return cardDeck;

	}

	public void initiateGame() {
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

	public int giveCard() { // Metoden f�r att ge kort
		int kort = cardDeck.get(0); // Ger kort v�rdet av kortet p� index 0
		cardDeck.remove(0); // Tar bort det kortet ifr�n kortleken
		return kort;
	}

	public void proceedGame () {
		int newCard;
		newCard = giveCard();
		playerSum += newCard;
		System.out.println("You drew a " + newCard + "\nYour total is " + playerSum);
	
	}

	public void loopGame(String proceed, Scanner scan) { //Metoden f�r att loopa spelet tills man vinner, v�ljer att stanna eller f�rlorar
		boolean run = true;
		
		while (run == true) {
			
			if (proceed.equals("s")) {
				run = false;
				break;
			}
			if (proceed.equals("h")) {
				
				if (playerSum < 21) { //Om man f�r under 21 och v�ljer att 'hit' s� forts�tter spelet
					proceedGame();
				}
				
				if (playerSum > 21) { // Om man f�r �ver 21
					System.out.println("\tYou lost");
					break;
				}

				if (playerSum == 21) { // Om man f�r 21
					System.out.println("Blackjack!");
					run = false;
					break;
				}
				System.out.println("\n'h' for hit, 's' for stay");
				proceed = scan.nextLine();
			}
			else if (!(proceed.equals("s")) || !(proceed.equals("h"))) { //"Felmeddelande" om man inte skriver in 's' eller 'h'
				System.out.println(hitOrStay);
				proceed = scan.nextLine();
			}
		}
	}
	public boolean dealerWon () {
		System.out.println("Dealer's turn\nHis hidden card was a " + dealerSecondCard + "\nHis total was " + dealerSum);
		while (dealerSum < 17) { // Dealern m�ste ta "hit" n�r den har mindre �n 17
			int newCard = giveCard();
			dealerSum = dealerSum + newCard;
			System.out.println("\nDealer chooses to hit\nHe draws a " + newCard + "\nHis total is " + dealerSum);
		}
		if (playerSum > dealerSum || dealerSum > 21) { // Spelaren vinner om playerSum �r �ver dealerSum eller dealer f�r �ver 21
			System.out.println("\nYou win");
			return false;
		}
		else {
			System.out.println("\nDealer win");
			return true;
		}		
	}
}
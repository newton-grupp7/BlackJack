import java.util.ArrayList;
import java.util.Collections;

public class Dealer extends CardDeck {

	public int playerSum;
	public String hitOrStay = "Press '1' for new card or '0' to stay";

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
		System.out.println("Welcome to BlackJack\n");
		int firstCard = giveCard(); // Dealern ger f�rsta kortet
		int secondCard = giveCard(); // Dealern ger andra kortet
		playerSum = firstCard + secondCard;
		System.out.println("You get a " + firstCard + " and a " + secondCard +"\nYour total is " + playerSum + "\n" + hitOrStay);
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

}
import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {

	public ArrayList<Integer> cardDeck = new ArrayList<Integer>();

	public ArrayList<Integer> createCardDeck() {
	
		for (int i = 0; i < 4; i++)	cardDeck.add(11);
		for (int j = 0; j < 16; j++) cardDeck.add(10);
		for (int k = 2; k <= 9; k++)
			for (int i = 0; i < 4; i++)	cardDeck.add(k);
		
		Collections.shuffle(cardDeck);
		return cardDeck;
		
	}

}
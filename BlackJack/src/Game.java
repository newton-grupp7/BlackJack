
public class Game {
	
	static CardDeck skapaKortlek = new CardDeck();
	
	public static void main(String[] args) {
		Game game = new Game();
		
		System.out.println("V�lkommen till BlackJack");
		skapaKortlek.createCardDeck();
		System.out.println(game.getCards());
		
	}
	
	private int getCards() {
		int kort = skapaKortlek.cardDeck.get(0);
		skapaKortlek.cardDeck.remove(0);
		return kort;
	}
	
}
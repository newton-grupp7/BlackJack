import java.util.Scanner;

public class Game {
	
	public static CardDeck cardDeckObject = new CardDeck(); // Skapar ett objekt av klassen CardDeck
	
	public static void main(String[] args) {
		
		Game player = new Game(); //Skapar ett objekt av klassen Game
		cardDeckObject.createCardDeck(); // Skapar kortleken
		int sum;
		
		System.out.println("Welcome to BlackJack");

		int card1 = player.getCard(); //Får första kortet
		int card2 = player.getCard(); //Får andra kortet
		sum = card1 + card2;
		
		System.out.println("You get a " + card1 + " and a " + card2);
		System.out.println("Your total is " + sum);
		
		Scanner scan = new Scanner(System.in);
		int proceed = scan.nextInt();
		
		boolean run = false;
		if (proceed == 0)
			run = true;
		
		while (run == false) {
			
			if (proceed == 1) {
				int newCard = player.getCard();
				sum += newCard;
				System.out.println("You drew a " + newCard);
				System.out.println("Your total is " + sum);
				if (sum > 21) {
					System.out.println("You lost");
					break;
				}
				if (sum == 21)
					run = true;
			}
		}
		scan.close();
	}
	
	public int getCard() { //Metoden för att få kort
		int kort = cardDeckObject.cardDeck.get(0); //Ger kort värdet av kortet på index 0
		cardDeckObject.cardDeck.remove(0); //Tar bort det kortet ifrån kortleken
		return kort;
	}
	
}
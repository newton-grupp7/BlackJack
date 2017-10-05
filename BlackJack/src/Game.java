import java.util.Scanner;

public class Game {
	
	public static Dealer dealer = new Dealer(); // Skapar ett objekt av klassen Dealer
	
	public static void main(String[] args) {

		dealer.createCardDeck(); // Skapar kortleken och blandar den
		dealer.initiateGame(); // Startar spelet och delar ut tv� kort till spelaren

		Scanner scan = new Scanner(System.in);
		String proceed = scan.nextLine();

		dealer.loopGame(proceed, scan); // Loopar spelet tills man vinner, v�ljer att stanna eller f�rlorar

		scan.close();
	}
	
}
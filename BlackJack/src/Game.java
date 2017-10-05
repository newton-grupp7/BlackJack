import java.util.Scanner;

public class Game {
	
	public static Dealer dealer = new Dealer(); // Skapar ett objekt av klassen Dealer
	
	public static void main(String[] args) {

		dealer.createCardDeck(); // Skapar kortleken och blandar den
		dealer.initiateGame(); // Startar spelet och delar ut två kort till spelaren
		
		Scanner scan = new Scanner(System.in);
		int proceed = scan.nextInt();
		
		boolean run = true;
		
		while (run == true) {
			
			if (proceed == 0) {
				run = false;
				break;
			}
			if (proceed == 1) {
				
				if (dealer.playerSum < 21) {
					dealer.proceedGame();
				}
				
				if (dealer.playerSum > 21) {
					System.out.println("You lost");
					break;
				}

				else if (dealer.playerSum == 21) {
					System.out.println("Du fick 21");
					run = false;
					break;
				}
				System.out.println("\nPress '1' for new card or '0' to stay");
				proceed = scan.nextInt();
			}
//			else if (!(proceed == 1) || !(proceed == 0)) {
//				System.out.println(dealer.hitOrStay);
//				proceed = scan.nextInt();
//			}
		}
		scan.close();
	}
	
}
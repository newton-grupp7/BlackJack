import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		
		Dealer dealer = new Dealer(); // Skapar ett objekt av klassen Dealer
		Scanner scan = new Scanner(System.in);

		boolean playAgain = true;
			
		System.out.println("Welcome to Blackjack!\n\nHow much money do you have?");
		
		int balance = 1;
		
		boolean keyCheck = true;
		
		while (keyCheck){
		
			try {
			balance = scan.nextInt();
			System.out.println("hej");
			break;
		} catch (InputMismatchException e){
			
			System.out.println("We don't take letters...");
			keyCheck = false;
			
			}
		}
		
		while (balance == 0) {
			System.out.println("You can't play without any money\nHow much money do you have?");
			balance = scan.nextInt();
		}
		
		while (playAgain) { // S� l�nge som playAgain �r true s� k�rs spelet
			
			System.out.println("How much do you want to bet?");
			int wager = scan.nextInt();
			
			while (wager == 0) {
				System.out.println("You have to bet money to play\nHow much do you want to bet?");
				wager = scan.nextInt();
			}
			while (wager > balance) {
				System.out.println("You can't bet more money than you have\nHow much do you want to bet?");
				wager = scan.nextInt();
			}
	
			balance = balance - wager;
	
			System.out.println("Your balance is " + balance + ", " + wager + " is on the table");
			dealer.cardDeck.createCardDeck(); // Skapar kortleken och blandar den
			dealer.initiateGame(); //  Startar spelet och delar ut tv� kort till spelaren
	
			String proceed = scan.next();

			dealer.playerStay(proceed, scan); // 
			boolean dealerWin = dealer.dealerWon();

			String yesOrNo;
			if (!dealerWin)
				balance = balance + ( wager * 2 );
			
			if (balance > 0) { // Om man har pengar kvar s� ska man f� alternativet att spela igen
				if (dealerWin) {
					while (balance > 0) {

						System.out.println("Your balance is " + balance + "\n\nWould you like to play again? 'y' for yes, 'n' for no");
						yesOrNo = scan.next();
						if (yesOrNo.equals("y")) {
							playAgain = true;
							break;
						}
						else if (yesOrNo.equals("n")) {
							playAgain = false;
							break;
						}
						else
							System.out.println("'y' for yes, 'n' for no");
					}
				}
				else {
					while (balance > 0) {

						System.out.println("Your balance is " + balance + "\n\nWould you like to play again? 'y' for yes, 'n' for no");
						yesOrNo = scan.next();
						if (yesOrNo.equals("y")) {
							playAgain = true;
							break;
						}
						else if (yesOrNo.equals("n")) {
							playAgain = false;
							break;
						}
						else
							System.out.println("'y' for yes, 'n' for no");
					}
				}
			}
			else  {
				System.out.println("Your balance is " + balance +  "\nYou're out of money");
				playAgain = false;
			}
		}
		System.out.println("Thank you for playing!");
		scan.close();
	}
}
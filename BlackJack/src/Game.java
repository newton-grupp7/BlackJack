import java.util.Scanner;

public class Game {

	public static Dealer dealer = new Dealer(); // Skapar ett objekt av klassen Dealer

	public static void main(String[] args) {

		Scanner scanMoney = new Scanner(System.in);
		System.out.println("Welcome to BlackJack!\n\nHow much money do you have?");
		int balance = scanMoney.nextInt();

		while (balance == 0) {
			System.out.println("You can't play without any money\nHow much money do you have?");
			balance = scanMoney.nextInt();
		}
		System.out.println("How much do you want to bet?");
		int wager = scanMoney.nextInt();

		while (wager == 0) {
			System.out.println("You have to bet money to play\nHow much do you want to bet?");
			wager = scanMoney.nextInt();
		}

		balance = balance - wager;

		System.out.println("Your balance is " + balance + ", " + wager + " is on the table");
		dealer.createCardDeck(); // Skapar kortleken och blandar den
		dealer.initiateGame(); // Startar spelet och delar ut två kort till spelaren

		Scanner scanHitOrStay = new Scanner(System.in);
		String proceed = scanHitOrStay.nextLine();

		dealer.loopGame(proceed, scanHitOrStay); // Loopar spelet tills man vinner, väljer att stanna eller förlorar
		boolean lost = dealer.dealerWon();
		
		if (!lost) {
			balance = balance + ( wager*2) ;
			System.out.println("Your balance is " + balance);
		}
		
		scanHitOrStay.close();
		scanMoney.close();

	}

}
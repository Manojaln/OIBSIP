package org.com;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to Guess the Number Game!");
		System.out.print("Enter your name: ");
		String name = scanner.nextLine();
		Player player = new Player(name);

		boolean playAgain;
		do {
			System.out.println(
					"\nChoose difficulty level: \n1. Easy (10 attempts) \n2. Medium (7 attempts) \n3. Hard (5 attempts)");
			int choice = scanner.nextInt();
			int maxAttempts = (choice == 1) ? 10 : (choice == 2) ? 7 : 5;

			Game game = new Game(maxAttempts, player);
			System.out.println("Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");

			while (!game.isGameOver()) {
				System.out.print("Enter your guess: ");
				int guess = scanner.nextInt();
				game.makeGuess(guess);
			}

			System.out.println("Your current score: " + player.getScore());
			playAgain = askToPlayAgain(scanner);
		} while (playAgain);

		System.out.println("Thanks for playing, " + player.getName() + "! Your final score is: " + player.getScore());
		scanner.close();
	}

	private static boolean askToPlayAgain(Scanner scanner) {
		System.out.print("Do you want to play again? (yes/no): ");
		String response = scanner.next().toLowerCase();
		return response.equals("yes");
	}
}

package org.com;

import java.util.Random;

public class Game {
	private int targetNumber;
	private int maxAttempts;
	private int attempts;
	private boolean isGameOver;
	private Player player;

	public Game(int maxAttempts, Player player) {
		this.maxAttempts = maxAttempts;
		this.player = player;
		this.isGameOver = false;
		this.attempts = 0;
		generateRandomNumber();
	}

	private void generateRandomNumber() {
		Random random = new Random();
		this.targetNumber = random.nextInt(100) + 1;
	}

	public boolean makeGuess(int guess) {
		attempts++;
		if (guess == targetNumber) {
			System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
			player.updateScore(attempts);
			isGameOver = true;
			return true;
		} else if (guess < targetNumber) {
			System.out.println("Too low! Try again.");
		} else {
			System.out.println("Too high! Try again.");
		}

		if (attempts >= maxAttempts) {
			isGameOver = true;
			System.out.println("Game Over! The correct number was: " + targetNumber);
		}
		return false;
	}

	public boolean isGameOver() {
		return isGameOver;
	}
}

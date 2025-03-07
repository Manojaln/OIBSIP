package org.com;

public class Player {
	private String name;
	private int score;
	private int totalAttempts;

	public Player(String name) {
		this.name = name;
		this.score = 0;
		this.totalAttempts = 0;
	}

	public void updateScore(int attempts) {
		int points = 100 - (attempts * 10); // Less attempts = higher score
		if (points < 0)
			points = 0;
		this.score += points;
	}

	public int getScore() {
		return this.score;
	} 

	public void resetAttempts() {
		this.totalAttempts = 0;
	}

	public String getName() {
		return this.name;
	}
}

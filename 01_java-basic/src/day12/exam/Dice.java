package day12.exam;

import java.util.Random;

public class Dice implements Game {

	Random r = new Random();
	int me = r.nextInt(6) + 1;
	static int dGameScore;

	Dice(int you) {
	}

	public int startGame(int you) {

		if (me == you) {
			System.out.println("You win " + me);
			dGameScore++;
			return 1;
		} else {
			System.out.println("You lose " + me);
			return 0;
		}


	}

}

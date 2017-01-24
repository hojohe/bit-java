package day12.exam;

import java.util.Random;

public class ScissorsRockPaper implements Game {

	final static int SCISSOR = 1;
	final static int ROCK = 2;
	final static int PAPER = 3;
	static int aGameScore;

	Random r = new Random();
	int me = r.nextInt(3) + 1;

	public ScissorsRockPaper(int you) {}

	public int startGame(int you) {

		if (me == SCISSOR) {

			if (you == ROCK) {
				System.out.println("You win 가위 ");
				aGameScore++;
				return 1;
			} else if (you == PAPER) {
				System.out.println("You lose 가위");
				return 0;
			} else {
				System.out.println("비겼습니다.가위 ");
				return 0;
			}

		} else if (me == ROCK) {

			if (you == PAPER) {
				System.out.println("You win 바위");
				aGameScore++;
				return 1;
			} else if (you == SCISSOR) {
				System.out.println("You lose 바위");
				return 0;
			} else {
				System.out.println("비겼습니다. 바위");
				return 0;
			}

		} else if (me == PAPER) {
			if (you == SCISSOR) {
				System.out.println("You win 보");
				aGameScore++;
				return 1;
			} else if (you == ROCK) {
				System.out.println("You lose 보 ");
				return 0;
			} else {
				System.out.println("비겼습니다.보");
				return 0;
			}
		}
		
		return 0;

	}
}

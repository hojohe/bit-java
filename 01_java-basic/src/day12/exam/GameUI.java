package day12.exam;

import java.util.Scanner;

public class GameUI {
	
	Game game = null;
	Scanner sc;

	public GameUI() {
		sc = new Scanner(System.in);
	}

	public void executeGame() {

		while (true) {
			System.out.println("게임을 선택하세요");
			System.out.println("A. 가위바위보");
			System.out.println("B. 주사위 값 맞추기");
			System.out.println("C. 종료");
			String gameType = sc.nextLine();

			if (gameType.equals("A"))
				scissorsRockPaper();
			
			else if (gameType.equals("B"))
				dice();
				
			else if (gameType.equals("C"))
				gameEnd();

			else
				System.out.println("다시 입력하세요.");

		}

	}

	public void scissorsRockPaper() {
		
		boolean flag = false;
		while(!flag) {
			
			System.out.println("가위바위보 게임입니다.");
			System.out.println("가위바위보중 하나를 선택하세요.");
			System.out.println("(1:가위, 2:바위, 3:보)");
			int you = Integer.parseInt(sc.nextLine());
			
			if (you != 1 && you != 2 && you != 3) {
				System.out.println("다시 입력하세요");
			}else {
				game = new ScissorsRockPaper(you);
				game.startGame(you);
				flag = true;
			}
		}

		
	}

	public void dice() {
		
		boolean flag = false;
		while(!flag) {
			
			System.out.println("주사위 값 맞추기 게임입니다.");
			System.out.println("주사위를 선택하세요(1~6값 중 하나)");
			int you = Integer.parseInt(sc.nextLine());
			
			if (you != 1 && you != 2 && you != 3 &&
				you != 4 && you != 5 && you != 6) {
				System.out.println("다시 입력하세요");
			}else {
				game = new Dice(you);
				game.startGame(you);
				flag = true;
			}
		}
		
	}

	public void gameEnd() {
		
		int totalScore = ScissorsRockPaper.aGameScore + Dice.dGameScore;
		System.out.println("게임을 종료합니다.");
		System.out.println("당신의 total Score는 " + totalScore  + "입니다.");
		System.exit(0);
		
	}

}

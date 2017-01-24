package day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LottoService {

	static List<LottoNum> pool = new ArrayList<>();
	static {
		for (int i = 1; i <= 45; i++) {
			pool.add(new LottoNum(i));
		}
	}

	List<LottoGame> games = new ArrayList<>();
	
	public boolean inputLottoGame(int turnNo, int[] selectNum) {

		for (LottoGame game : games) {
			if (game.getTurnNo() == turnNo) {
				return false;
			}
		}

		LottoGame game = new LottoGame(turnNo);
		for (int i = 0; i < selectNum.length; i++) {
			int num = selectNum[i]; // 입력받은 숫자
			LottoNum lottoNum = pool.get(num - 1);
			game.addNum(lottoNum);
		}

		games.add(game);

		return true;

	}

	public void printNums() {
		for (LottoNum o : pool) {
			System.out.println(o.getNum() + "번 : " + o.getCount() + "회");
		}
	}
	
	public void printGames() {
		for (int i = games.size() - 1; i >=0; i--) {
			games.get(i).print();
		}
	}
	
	public void service() {

		while (true) {
			Scanner sc = new Scanner(System.in);

			System.out.println("-----------------------");
			System.out.println("로또(LOTTO) 관리자 시스템");
			System.out.println("-----------------------");
			System.out.println("1. 각 회별 로또 번호 보기");
			System.out.println("2. 번호별 당첨된 횟수 보기");
			System.out.println("3. 당첨 번호 등록");
			System.out.println("4. 종료");
			System.out.println("-----------------------");
			System.out.print("메뉴 선택 : ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				printGames();
				break;
			case 2:
				printNums();
				break;
			case 3:
				printInsert();
				break;
			case 4:
				exit();
				break;
			}

		}

	}

	/* 4: 종료 */
	public void exit() {

		Scanner sc = new Scanner(System.in);
		System.out.println("------------------------");
		System.out.print("종료하시겠습니까? (취소 : N, 종료 : 엔터) : ");
		if (!sc.nextLine().equals("N")) {
			System.out.println("종료되었습니다.");
			System.exit(0);
		} else {
			System.out.println("취소하였습니다.");
		}
		System.out.println("------------------------");

	}

	/* 3: 로또 번호 등록 */
	public void printInsert() {

		Scanner sc = new Scanner(System.in);

		System.out.println("-----------------------");
		System.out.println("로또 당첨 번호 등록");
		System.out.println("-----------------------");

		System.out.print("회차 : ");
		int turnNo = Integer.parseInt(sc.nextLine());

		System.out.print("당첨번호 : ");
		int[] selectNum = new int[6];
		for (int i = 0; i < selectNum.length; i++) {
			selectNum[i] = sc.nextInt();
		}

		System.out.println("배열 " + Arrays.toString(selectNum));

		if (inputLottoGame(turnNo, selectNum)) {
			System.out.println(turnNo + "회차 당첨번호가 등록되었습니다.");
			System.out.println("-----------------------");
		} else {
			System.out.println("이미 등록된 회차입니다.");
			System.out.println("-----------------------");
		}

	}
	
}

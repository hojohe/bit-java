package day07.test;

import java.util.Scanner;

public class BoardTest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		BoardVO[] list = new BoardVO[3];
		
		int pos = 0;
		int no = 0;

		outer: while (true) {

			System.out.println("-------------------");
			System.out.println("1. 전체 게시물 조회");
			System.out.println("2. 글번호 조회");
			System.out.println("3. 글등록");
			System.out.println("4. 글수정");
			System.out.println("5. 글삭제");
			System.out.println("0. 종료");
			System.out.println("-------------------");
			System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");

			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:

				System.out.println("전체 " + pos + "개");
				System.out.println("-------------------");
				System.out.println("번호\t글쓴이\t제목\t");
				System.out.println("-------------------");
				for (int i = pos - 1; i >= 0; i--) {
					System.out.printf("%d\t%s\t%s\t\n", list[i].no, list[i].writer, list[i].title);
				}

				if (pos == 0) {
					System.out.println("게시물이 존재하지 않습니다.");
				}
				break;

			case 2:

				System.out.print("조회할 글번호를 입력하세요 : ");
				int findNum = Integer.parseInt(sc.nextLine());

				boolean findFlag = false;
				for (int i = 0; i < pos; i++) {
					if (findNum != list[i].no)
						continue;

					System.out.println("-------------------");
					System.out.println("번호    : " + list[i].no);
					System.out.println("글쓴이  : " + list[i].writer);
					System.out.println("제목    : " + list[i].title);
					System.out.println("-------------------");
					findFlag = true;
				}

				if (!findFlag)
					System.out.println("입력된 번호는 존재하지 않습니다.");
				break;

			case 3:

				if (pos == list.length) {
					BoardVO[] temp = new BoardVO[pos * 2];
					System.arraycopy(list, 0, temp, 0, pos);
					list = temp;
				}

				list[pos] = new BoardVO();

				list[pos].no = ++no;
				System.out.print("제목을 입력하세요 : ");
				list[pos].title = sc.nextLine();
				System.out.print("글쓴이를 입력하세요 : ");
				list[pos].writer = sc.nextLine();
				System.out.print("내용을 입력하세요 : ");
				list[pos].content = sc.nextLine();

				pos++;
				System.out.println("게시글 등록이 완료되었습니다.");
				break;

			case 4:

				System.out.print("수정할 글번호를 입력하세요 : ");
				int modNum = Integer.parseInt(sc.nextLine());

				System.out.print("변경할 제목을 입력하세요 : ");
				String modTitle = sc.nextLine();

				boolean modFlag = false;
				for (int i = 0; i < pos; i++) {
					if (modNum != list[i].no)
						continue;

					list[i].title = modTitle;
					System.out.println("게시글이 수정되었습니다.");
					modFlag = true;
				}

				if (!modFlag)
					System.out.println("입력된 번호는 존재하지 않습니다.");
				break;

			case 5:

				System.out.print("삭제할 글번호를 입력하세요 : ");
				int delNum = Integer.parseInt(sc.nextLine());

				int delIndex = -1;
				for (int i = 0; i < pos; i++) {
					if (delNum == list[i].no) {
						delIndex = i;
						break;
					}
				}

				if (delIndex == -1) {
					System.out.println("입력하신 번호에 해당하는 게시글이 없습니다.");
					break;
				}
				
				if (pos - (delIndex + 1) > 0) {
					System.arraycopy(list, delIndex + 1, list, delIndex, pos - (delIndex + 1));
				}

				System.out.println("게시글이 삭제되었습니다.");
				list[--pos] = null;
				break;

			case 0:

				System.out.println("게시판 프로그램을 종료합니다.");
				break outer;

			}

		}
	}
}

package day16;

import java.io.File;

public class Test01 {
	public static void main(String[] args) {
		
		File f = new File("data/mya/aa/bb");
		boolean bool = f.exists();
		if (bool) {
			System.out.println("존재하는 경로");
			
			if (f.isDirectory()) {
				System.out.println("디렉토리임");
			} else if (f.isFile()) {
				System.out.println("파일임");
			}
			
		} else {
			System.out.println("존재하지 않는 경로");
			
			// 존재하지 않은 경로일 경우 생성
			if (f.mkdirs()) {
				System.out.println("디렉토리 생성 성공");
			} else {
				System.out.println("디렉토리 생성 실패");
			}

		}
		
		
		
	}
}

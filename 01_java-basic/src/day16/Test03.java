package day16;

import java.io.File;
import java.io.IOException;

public class Test03 {
	public static void main(String[] args) {
		
		File f = new File("data/a1.txt");
		
		boolean result = f.delete();
		if(result) {
			System.out.println("파일 삭제 성공");
		}else {
			System.out.println("파일 삭제 실패");
		}
		
		/*if (!f.exists()) {
			System.out.println("파일 생성");
			
			try {
				boolean result = f.createNewFile();
				if (result) {
					System.out.println("파일 생성 성공");
				} else {
					System.out.println("파일 생성 실패");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}*/
		
		
		/*
		// byte의 크기를 반환
		long length = f.length();
		System.out.println("length : " + length);
		*/
		
		
		/*String path = f.getPath();
		String name = f.getName();
		String parent = f.getParent();
		
		System.out.println("path : " + path);
		System.out.println("name : " + name);
		System.out.println("parent : " + parent);*/
		
		
	}
}

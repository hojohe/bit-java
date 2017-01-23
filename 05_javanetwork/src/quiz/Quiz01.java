package quiz;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Quiz01 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("도메인 주소를 입력하세요 : ");
			String domain = sc.nextLine();
			
			if(domain.startsWith("www.") == false) {
				System.out.println("도메인 주소는 www로 시작해야 합니다.");
				continue;
			}
			
			if(domain.equals("quit")) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
			
			try {
				InetAddress[] hosts = InetAddress.getAllByName(domain);
				System.out.println("---------------------------------");
				for(InetAddress host : hosts) {
					System.out.println(host.getHostAddress());
				}
				System.out.println("---------------------------------");
			} catch (UnknownHostException e) {
				System.out.println("존재하지 않는 도메인 주소입니다.");
			}
		}
	}
}

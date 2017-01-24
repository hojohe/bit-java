package day04.exam;

import java.util.Random;

public class LoopTest11 {
	public static void main(String[] args) {
		
		Random r = new Random();
		int arr[] = new int[6];
		
		for(int k = 0; k < 5; k++) {
			
			boolean flag = false;
			for(int i = 0; i < 6; i++) {
				int randomNum = r.nextInt(45) + 1;
				
				for(int j = 0; j < i; j++) {
					if(arr[j] == randomNum) {
						flag = true;
						i--;
					}
				}
				
				if(!flag)	
					arr[i] = randomNum;
				else		
					flag = false;
				
			}
			
			System.out.printf("Set%d : %3d %3d %3d %3d %3d %3d \n"
					, k+1, arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
			
		}
		
	}
}

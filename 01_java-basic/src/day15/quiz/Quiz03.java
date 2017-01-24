package day15.quiz;

import java.util.Arrays;

public class Quiz03 {
	public static void main(String[] args) {
		
		Data d1 = new Data(3);
		Data d2 = new Data(9);
		Data d3 = new Data(5);
		
		Data[] arr = {d1, d2, d3};
		Data tmp;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].getNum() < arr[j].getNum()) {
					tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
				}
			}
		}

		System.out.println(Arrays.toString(arr));
		
	}
}

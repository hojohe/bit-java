package day15.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Quiz05 {
	public static void main(String[] args) {
		
		List<Data> list = new ArrayList<>();
		list.add(new Data(3));
		list.add(new Data(9));
		list.add(new Data(5));

		Collections.sort(list);
		System.out.println(list);
		
		Collections.reverse(list);
		System.out.println(list);
		
		
		
		List<Integer> numbers = new ArrayList<>();
		for(int i = 1; i < 46; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		for (int i = 1; i < 7; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i + "번째 볼 : " + numbers.get(i - 1));
		} 
	}
}

package day15;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test02 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		System.out.println(set.add("one"));
		System.out.println(set.add("two"));
		System.out.println(set.add("three"));
		// 중복 허용하지 않음
		System.out.println(set.add("two"));
		System.out.println(set);

		System.out.println(set.size());
		
		set.remove("one");
		System.out.println(set);
	
		// 사용불가능 : Set 객체는 index 접근 불가능
		for (int i = 0; i < set.size(); i++) {}
		
		// 1.4 버전까지
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		// 1.5 버전 이후
		for(String val : set) {
			System.out.println(val);
		}

		
	}
}

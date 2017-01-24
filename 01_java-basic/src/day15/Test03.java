package day15;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class Test03 {

	public static Map<String, Character> randomMap() {

		Map<String, Character> map = new HashMap<>();

		Random r = new Random();
		String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < 10; i++) {
			int keyNum = r.nextInt(52);
			map.put(String.valueOf(keyNum), alpha.charAt(keyNum));
		}
		return map;

	}

	public static void main(String[] args) {
		
		Map<String, Character> map = randomMap();
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println("key : " + key + ", value : " + map.get(key));
		}
		
		// Entry 내부클래스! 멤버변수로 key와 value를 가지고 있고 set,get 메소드를 가지고있다.
		Set<Entry<String,Character>> entrySet = map.entrySet();
		for(Entry<String,Character> entry : entrySet) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
		
		System.out.println(keys);
		
		System.out.println(map);
		
		
		
/*
		Map<String, String> map = new HashMap<>();
		map.put("name", "이재명");
		map.put("name", "표창원");
		map.put("addr", "국회의사당");
		map.put("hompage", "nabo@ass.com");

		System.out.println(map);

		String name = map.get("name");
		System.out.println(name);

		System.out.println(map.get("age"));

		// Map의 name에 해당하는 데이터를 temp로 이동
		Map<String, String> temp = new HashMap<>();
		temp.put("name", map.remove("name"));

		// temp.put("name", map.get("name"));
		// map.remove("name");

		System.out.println(map);
*/
	}
}
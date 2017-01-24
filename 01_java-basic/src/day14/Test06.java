package day14;

public class Test06 {
	public static void main(String[] args) {
		Box01 b = new Box01();
		b.setData("test");
		String data = b.getData();
		System.out.println("data  : " + data);
		
		Box02 b2 = new Box02();
		b2.setData("test");
		String data2 = (String)b2.getData();
		System.out.println("data2 : " + data2);
		
		b2.setData(100);
		Integer data3 = (Integer)b2.getData();
		System.out.println("data3 : " + data3);
		
		// 1.5부터 제네릭 나옴
		Box03<String> b3 = new Box03<String>();
		b3.setData("test");
		String data4 = b3.getData();
		System.out.println(data4);
		
		
		Box03<Integer> box03 = new Box03<Integer>();
		box03.setData(1);
		Integer data5 = box03.getData();
		System.out.println(data5);
		
		Box04<String, String> box04 = new Box04<String, String>("apple","사과");
		System.out.println(box04.getKey());
		System.out.println(box04.getValue());
		
		// 1.7부터 제네릭 간소화
		Box04<String, String> b4 = new Box04<>("apple","사과");
	}
}

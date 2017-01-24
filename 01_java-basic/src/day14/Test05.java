package day14;

import day11.exam.MyArrayList;

public class Test05 {
	public static void main(String[] args) {
		// Wrapper 클래스
		// 기본형에 대한 참조타입 클래스
		/*
		 *	byte	-> Byte
		 *	short	-> Short
		 *	int		-> Integer
		 *	long	-> Long
		 *	float	-> Float
		 *	double	-> Double
		 *	boolean	-> Boolean
		 *	char	-> Character
		 * 
		 */
		int i = 100;
		// 기본형을 참조형
		Integer iObj = new Integer(i);
		
		// 참조형을 기본타입 값으로
		int val = iObj.intValue();
		
		MyArrayList list = new MyArrayList();
		list.add(new Integer(val));
		
		// 1.5버전 부터
		// auto boxing	 : 기본형 -> 참조형
		int i2 = 100;
		Integer iObj2 = i2;	// Integer iObj2 = new Integer( i2 );
		
		// auto unboxing : 참조형 -> 기본형
		int i3 = iObj2;
		list.add(i3);
		// Object obj = i3; // Object obj = new Integer(i3);

		Object obj  = 100;
		Object obj2 = "안녕?";
		Object obj3 = false;
		Object obj4 = 'A';
		Object obj5 = 3.14;
		
		System.out.println(obj  instanceof Integer);
		System.out.println(obj2 instanceof String );
		System.out.println(obj3 instanceof Boolean);
		System.out.println(obj4 instanceof Character);
		System.out.println(obj5 instanceof Double);
		System.out.println(obj5 instanceof Float);
		System.out.println(obj5 instanceof Short);
		
	}
}

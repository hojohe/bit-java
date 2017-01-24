package day08;

import java.util.Arrays;


public class Test03 {
	public static void main(String[] args) {


		String result = String.valueOf(true);
		System.out.println(result);

		result = String.valueOf(1);
		System.out.println(result);

		
		/*
		System.out.printf("나이 : %d, 이름 : %s\n", 33, "홍길동");
		//static String	format(String format, Object... args)
		String result = String.format("나이 : %d, 이름 : %s\n", 33, "홍길동");
		System.out.println(result);
		
		String s = "java is easy";
		
		//String	trim()
		s = "     a b c d e     ";
		System.out.println("|" + s + "|");
		System.out.println("|" + s.trim() + "|");
		System.out.println("|" + s.replace(" ", "") + "|");
		
		// String[]	split(String regex)
		s = "수지:33:분당:su@a.com";
		String[] st = s.split(":");
		System.out.println(Arrays.toString(st));
		
		// String	substring(int beginIndex)
		// String	substring(int beginIndex, int endIndex)
		
		String result = s.substring(2);
		System.out.println(result);
		
		
		result = s.substring(2,3);
		System.out.println(result);

		s.replace("easy", "hard");
		System.out.println(s);
		
		s = s.replace("easy", "hard");
		System.out.println(s);
		
		s = "abc123def456ghi";
		s = s.replace("123", "***");
		s = s.replace("456", "***");
		System.out.println(s);
		
		s = "a123sdf3kldjkf345546lksdjfk";
		for (int i = 0; i < 10; i++) {
			s = s.replace(""+i, "*");
		}
		System.out.println(s);
		
		s = "a123sdf3kldjkf345546lksdjfk";
		for (char i = 'a'; i <= 'z'; i++) {
			s = s.replace(""+i, "*");
		}
		System.out.println(s);
		
		//String	replaceAll(String regex, String replacement)
		s = "a123sdf3kldjkf345546lksdjfk";
		s = s.replaceAll("[0-9]", "*");
		System.out.println(s);
		
		s = "a123sdf3kldjkf345546lksdjfk";
		s = s.replaceAll("[A-Za-z]", "*");
		System.out.println(s);
		 
		//char[]	toCharArray()
		char[] arr = s.toCharArray();
		System.out.println(Arrays.toString(arr));
		
		 //String	toLowerCase()
		 //String	toUpperCase()
		 System.out.println(s.toLowerCase());
		 System.out.println(s.toUpperCase());
		 // boolean	startsWith(String prefix)
		 boolean bool = s.startsWith("java");
		 System.out.println(bool);
		 //boolean	endsWith(String suffix)
		 bool = s.endsWith("easy");
		 System.out.println(bool);
		 //int	lastIndexOf(String str)
		 //int	lastIndexOf(String str, int fromIndex)
		 int index = s.lastIndexOf("a");
		 System.out.println(index);
		 index = s.lastIndexOf("a", 8);
		 System.out.println(index);
		 
		 // int indexOf(String str) 
		 // int indexOf(String str, int fromIndex)
		 int index = s.indexOf("a"); 
		 System.out.println(index); 
		 index = s.indexOf("a", index + 1); 
		 System.out.println(index); 
		 index = s.indexOf("a", index + 1); 
		 System.out.println(index); 
		 index = s.indexOf("ab"); 
		 System.out.println(index); 
		  
		 //boolean contains(CharSequence s) 
		 System.out.println(s.contains("is"));
		  
		 //boolean equals(Object anObject) 
		 //boolean equalsIgnoreCase(String anotherString) 
		 String s1 = "Java Is Easy";
		 System.out.println(s.equals(s1));
		 System.out.println(s.equalsIgnoreCase(s1));
		 
		 // char charAt(int index) 
		 char c = s.charAt(0);
		 System.out.println(c);
		  
		 // i가 출력되도록 c = s.charAt(5); 
		 System.out.println(c);
		 
		 // int length() 문자열의 길이 
		 int len = s.length(); 
		 System.out.println("문자열의 길이 : " + len); 
		 System.out.println("문자열의 길이 : " + s.length());
		  
		 */

	}
}

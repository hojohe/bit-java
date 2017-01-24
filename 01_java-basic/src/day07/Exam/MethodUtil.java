package day07.exam;

public class MethodUtil {
	
	boolean isLowerChar(char c) {
		if(c == 'a') return true;
		return false;
	}
	boolean isUpperChar(char c) {
		if(c == 'A') return true;
		return false;
	}
	
	int max(int i, int j) {
		if(i > j) 
			return i;
		return j;
	}
	
	int min(int i, int j) {
		if(j < i) 
			return j;
		return i;
	}
	
	String reverse(String s) {
		StringBuffer buf = new StringBuffer(s);
		return buf.reverse().toString();
	}
	
	String toUpperString(String s) {
		String test =new String(s);
		return test.toUpperCase();
	}
	
	String toLowerString(String s) {
		String test =new String(s);
		return test.toLowerCase();
	}
	

}

package day05;

public class Test01 {
	public static void main(String[] args) {

		int i = 1;
		int i2 = 1;
		int i3 = 1;
		int i4 = 1;

		int[] iArr;
		iArr = new int[7];

		/*
		 	iArr[0] = 10; iArr[1] = 20; iArr[2] = 30; iArr[3] = 40;
		 */
		/*
		for (int j = 0; j < 10; j++) {
			iArr[j] = (j + 1) * 10;
			System.out.println(iArr[j]);
		}
		 */		
		
		for (int j = 0; j < iArr.length; j++) {
			iArr[j] = (j + 1) * 10;
			System.out.println("iArr["+ j +"] = " + iArr[j]);
		}
		
		
		
		String[] sArr = new String[4];
		
		sArr[1] = "자바";
		
		for (int j = 0; j < sArr.length; j++) {
			System.out.println("sArr[" + j + "] = " + sArr[j]);
		}
		
		

	}
}

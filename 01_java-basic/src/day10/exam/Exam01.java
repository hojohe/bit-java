package day10.exam;

public class Exam01 {

	int getValue(int[] arr, boolean b) {
		int max = 0;
		int min = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (max < arr[j]) {
					max = arr[j];
				} else if (min > arr[j] || min <= 0) {
					min = arr[j];
				}
			}
		}

		if (b)
			return max;
		else
			return min;
	}

	public static void main(String[] args) {
		Exam01 ex01 = new Exam01();
		int[] arr = { 9, 2, 87, 12, 30 };
		int max = ex01.getValue(arr, true);
		System.out.println("최대값 : " + max);

		int min = ex01.getValue(arr, false);
		System.out.println("최소값 : " + min);
	}
}

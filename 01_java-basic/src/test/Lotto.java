package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {

	private int num;
	private int count;

	private static Lotto lotto;
	private int[] intArray;
	private List<Integer> lottoNum;

	private Lotto() {
		// TODO Auto-generated constructor stub
	}

	public void excute() {
		ArrayList<Integer> lottoList = new ArrayList<Integer>();
		
		for (int i = 1; i < 46; i++) {
			lottoList.add(i);
		}
		
		Collections.shuffle(lottoList);
		this.setLottoNum(lottoList.subList(0, 6));
		
		List<Integer> lottoNum = this.getLottoNum();
		Integer[] toArray = lottoNum.toArray(new Integer[lottoNum.size()]);
		intArray = new int[6];
		
		for (int a = 0; a < toArray.length; a++) {
			intArray[a] = toArray[a].intValue();
		}
		
		Arrays.sort(intArray);
		this.setIntArray(intArray);
		this.wonNumber();
	}

	public void wonNumber() {
		
		String str = "";
		intArray = this.getIntArray();
		int index = 1;
		for (int i : intArray) {
			if (index == intArray.length) {
				str += i + "";
			} else {
				str += i + ",";
			}
			index++;
		}
		System.out.println(str);
	}

	public static Lotto getInstance() {
		if (lotto == null) {
			lotto = new Lotto();
		}
		return lotto;
	}

	public List<Integer> getLottoNum() {
		return lottoNum;
	}

	public void setLottoNum(List<Integer> lottoNum) {
		this.lottoNum = lottoNum;
	}

	public int[] getIntArray() {
		return intArray;
	}

	public void setIntArray(int[] intArray) {
		this.intArray = intArray;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
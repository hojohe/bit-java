package day17;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class Exam01 {
	public static void dataCheck(String file1, String file2) throws Exception {
		// 구현하세요~ ---------------------------------------------------
		// 비교 대상 파일인 file1 과 file2 에는 문자열 데이터의 라인수가 같다고 가정합니다~!!

		// --------------------------------------------------------------

		try (FileInputStream fis = new FileInputStream(file1); 
			FileOutputStream fos = new FileOutputStream(file2);
		) {

			int ch = 0;
			String low = "";
			while ((ch = fis.read()) != -1) {
				Character c = (char) ch;
				if (Character.isAlphabetic(c)) {
					low += c.toString();
				} else {
					if ('\n' == (char) ch)
						low += ":";
					else if (' ' == (char) ch)
						low += " ";
				}
			}

			String[] arrLow = new String[4];
			String[] resultLow = new String[4];
			arrLow = low.split(":");
			resultLow[0] = arrLow[0].replace(" ", "");
			resultLow[1] = arrLow[1].substring(0, 1).toLowerCase() 
					+ arrLow[1].substring(1, arrLow[1].length());
			resultLow[2] = arrLow[2].substring(0, 1).toLowerCase()
					+ arrLow[2].substring(1, 3)
					+ arrLow[2].substring(3, 4).toUpperCase()
					+ arrLow[2].substring(4, arrLow[2].length());
			resultLow[3] = arrLow[3] + "!";
			
			for(int i = 0; i < arrLow.length; i++) {
				fos.write(resultLow[i].getBytes());
				fos.write('\r');
				fos.write('\n');
				
				String rsl = "";
				if(resultLow[i].equalsIgnoreCase(arrLow[i])) {
					rsl = "Equal";
				}else {
					rsl = "Not Equal";
				}
				System.out.println("LINE " + (i+1) + " : " + rsl);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// main 메서드는 수정하지 마세요.
	public static void main(String[] args) throws Exception {
		try {
			dataCheck("data/data1.txt", "data/data2.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

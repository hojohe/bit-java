package day17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Exam02 {
	public static void main(String[] args) {
        try {
            searchFileContent("data/find.txt", "System");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * @param readFileName : 읽을 파일명
     * @param findStr      : 파일에서 찾을 내용
     * @throws Exception
     */
    public static void searchFileContent(String readFileName, String findStr) throws Exception {
            
    	try(
    		FileReader fr = new FileReader(readFileName);
    		BufferedReader br = new BufferedReader(fr);
    	) {
    		String str = "";
    		int i = 0;
    		while((str = br.readLine()) != null) {
    			i++;
    			if(str.indexOf(findStr) > -1) {
    				System.out.println(i+": "+str);
    			}
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    		
    	}
    	
    	
    }
}

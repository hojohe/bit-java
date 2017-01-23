package network.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Test01 {
	public static void main(String[] args) {
		
		String requestUrl = "https://apis.daum.net/search/blog";
		String parameter = "?apikey=6fb91f7917aa4403d12e368046b18a94&q=java&result=3&output=xml";
		
		String apiUrl = requestUrl + parameter;
		System.out.println(apiUrl);
		
		try {
			URL url = new URL(apiUrl);
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				System.out.println(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

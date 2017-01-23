package network.webserver;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncodeDecodeTest {
	public static void main(String[] args) {
		
		String word = "자바";
		try {
			String encodeWord = URLEncoder.encode(word, "utf-8");	// %16진수
			System.out.println(encodeWord);
			
			String decodeWord = URLDecoder.decode(encodeWord, "utf-8");
			System.out.println(decodeWord);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		
	}

}

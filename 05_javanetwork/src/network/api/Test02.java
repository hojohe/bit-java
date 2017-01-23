package network.api;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test02 {
	public static void main(String[] args) {
		
		String requestUrl = "https://apis.daum.net/search/blog";
		String parameter = "?apikey=6fb91f7917aa4403d12e368046b18a94&q=java&result=3&output=xml";
		
		String apiUrl = requestUrl + parameter;
		
		try {
			URL url = new URL(apiUrl);
			InputStream is = url.openStream();
			
			// Dom Parser에게 입력 스트림 처리를 넘기기
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document dom = builder.parse(is);
			
			NodeList list = dom.getElementsByTagName("item");
			
			List<ItemVO> items = new ArrayList<>();
			for(int i=0; i<list.getLength(); i++) {
				
				Node item = list.item(i);
				NodeList chList = item.getChildNodes();
				ItemVO itemvo = new ItemVO();
				
				
				for(int j = 0; j<chList.getLength(); j++) {

					Node chNode = chList.item(j);
					String chName = chNode.getNodeName();
					String value = chNode.getTextContent();
					if("#text".equals(chName)) continue;
					
					switch(chName) {
						case "title" : itemvo.setTitle(value); break;
						case "description" : itemvo.setDescription(value); break;
						case "link" : itemvo.setLink(value); break;
						case "author" : itemvo.setAuthor(value); break;
						case "comment" : itemvo.setComment(value); break;
						case "pubDate" : itemvo.setPubDate(value); break;
					}
				}
				
				items.add(itemvo);
			}
			
			System.out.println("--------------------------");
			System.out.println("블로그 검색 결과");
			System.out.println("--------------------------");
			System.out.println();
			int i = 1;
			for(ItemVO vo : items) {
				System.out.printf("%d%s\n%s\n%s\n%s\n%s\n%s\n%s\n\n",
						i++,"번째 검색 결과"
						, vo.getTitle()
						, vo.getDescription()
						, vo.getLink()
						, vo.getAuthor()
						, vo.getComment()
						, vo.getPubDate());
				System.out.println("--------------------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

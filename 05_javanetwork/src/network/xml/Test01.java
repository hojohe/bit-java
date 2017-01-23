// xml 데이터 파싱 : api 연습
package network.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test01 {

	public static void main(String[] args) {

		// 파서 객체를 가져오기 위한 팩토리 객체 얻기
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			// xml 내용을 파싱할 파서 준비
			DocumentBuilder builder = factory.newDocumentBuilder();

			// xml 형식의 데이터 파싱처리하기
			Document dom = builder.parse("src/network/xml/family.xml");
			NodeList list = dom.getElementsByTagName("family");
			int len = list.getLength();
			System.out.println("family의 수 : " + len);
			
			for (int i = 0; i < len; i++) {
				
				Node cNode = list.item(i);
				// 각각의 family 태그 접근
				String cName = cNode.getNodeName();
				System.out.println("cNode name : " + cName);
				
				NodeList chList = cNode.getChildNodes();	// 엔터라는 text노드까지 포함시킨다. 그래서 text노드(엔터값)은 제외시켜야한다.
				int chLen = chList.getLength();
				System.out.println("family의 자식 수 : " + chLen);
				
				for(int j = 0; j < chLen; j++) {
				
					Node chNode = chList.item(j);
					String chName = chNode.getNodeName();
					if("#text".equals(chName)) continue;

					String value = chNode.getTextContent();
					System.out.println(chName + "," + value);
					
				}
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

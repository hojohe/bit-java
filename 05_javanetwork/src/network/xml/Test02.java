// xml 데이터 파싱 : api 연습
package network.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test02 {

	public static void main(String[] args) {

		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document dom = builder.parse("src/network/xml/family.xml");
			NodeList list = dom.getElementsByTagName("family");
			int len = list.getLength();
			
			List<FamilyVO> familys = new ArrayList<>();
			for (int i = 0; i < len; i++) {
				FamilyVO family = new FamilyVO();
				
				Node cNode = list.item(i);
				
				NodeList chList = cNode.getChildNodes();
				int chLen = chList.getLength();
				
				for(int j = 0; j < chLen; j++) {
				
					Node chNode = chList.item(j);
					String chName = chNode.getNodeName();
					if("#text".equals(chName)) continue;

					String value = chNode.getTextContent();
					System.out.println(chName + "," + value);
					switch(chName) {
						case "father":
							family.setFather(value);
							break;
						case "mother":
							family.setMother(value);
							break;
						case "me":
							family.setMe(value);
							break;
						
					}
					
				}
				
				familys.add(family);
			}
			
			
			System.out.println("-----------------------");
			System.out.println("가족 정보");
			System.out.println("-----------------------");
			for(FamilyVO f : familys) {
				System.out.printf("%s\t%s\t%s\n"
						, f.getFather(), f.getMother(), f.getMe());
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package day17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {

	int lPrice;
	int hPrice;
	String name;
	List<Product> list = new ArrayList<>();
	
	ProductService() throws IOException {

		try (FileReader fr = new FileReader("data/product.txt"); 
		BufferedReader br = new BufferedReader(fr);) {
			
			String arr = "";
			String tmp = "";
			while ((arr = br.readLine()) != null) {
				tmp += arr + "/";
			}

			String[] arrTmp = new String[3];
			arrTmp = tmp.split("/");
			for (int i = 0; i < arrTmp.length; i++) {
				Product vo = new Product();
				String[] product = arrTmp[i].split(":");
				vo.setCorp(product[0]);
				vo.setPrdNm(product[1]);
				vo.setPrdNo(product[2]);
				vo.setPrice(Integer.parseInt(product[3]));

				list.add(vo);
			}
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public void selectAll() {
		
		selectPrint("전체", list);
	}

	public void selectPrice(int lPrice, int hPrice) {
		
		List<Product> productList = new ArrayList<>();
		for(Product arrList : list) {
			if(arrList.getPrice() >= lPrice
			&& arrList.getPrice() <= hPrice) {
				productList.add(arrList);
			}
		}
		
		selectPrint("금액", productList);
		
	}

	void selectPrdNm(String name) {
		
		List<Product> productList = new ArrayList<>();
		for(Product arrList : list) {
			if(arrList.getPrdNm().indexOf(name) > -1) {
				productList.add(arrList);
			}
		}
		
		selectPrint("상품명", productList);

	}
	
	
	Scanner sc = new Scanner(System.in);

	public void print() throws IOException {
		ProductService ps = new ProductService();
		int menu = 0;
		while (true) {
			System.out.println("------------------------");
			System.out.println("상품관리 시스템");
			System.out.println("------------------------");
			System.out.println("1. 전체 검색");
			System.out.println("2. 금액 검색");
			System.out.println("3. 상품명 검색");
			System.out.println("4. 종료");
			System.out.println("------------------------");

			System.out.print("메뉴 선택 : ");
			menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				ps.selectAll();
				break;
			case 2:
				inputPrice();
				break;
			case 3:
				inputPrdNm();
				break;
			case 4:
				exit();
				break;
			}
		}

	}

	/* 1: 전체 검색 */
	void selectPrint(String flag, List<Product> list) {

		if (flag.equals("전체")) {
			System.out.println("총 " + list.size() + "개");
		} else if (flag.equals("금액")) {
			System.out.println(lPrice + "원 ~ " + hPrice + "원 사이의 상품");
		} else if(flag.equals("상품명")) {
			System.out.println( "[" + name + "]자를 포함하는 상품");
		}

		System.out.println("------------------------------------------------");
		System.out.println("제조회사\t상품명\t\t상품번호\t가격");
		System.out.println("------------------------------------------------");

		if (list.size() == 0) {
			System.out.println("검색된 상품정보가 없습니다.");
			System.out.println("------------------------------------------------");
			return;
		}

		for (Product productList : list) {
			System.out.println(String.format("%s\t%s\t%s\t%d", productList.getCorp(), productList.getPrdNm(),
					productList.getPrdNo(), productList.getPrice()));
		}

		System.out.println("------------------------------------------------");

	}

	void inputPrice() throws IOException {

		System.out.println("------------------------------------------------");
		System.out.println("금액으로 검색");
		System.out.println("------------------------------------------------");
		System.out.print("낮은금액 : ");
		lPrice = Integer.parseInt(sc.nextLine());
		System.out.print("높은금액 : ");
		hPrice = Integer.parseInt(sc.nextLine());
		System.out.println("------------------------------------------------");

		selectPrice(lPrice, hPrice);

	}
	
	void inputPrdNm() throws IOException {
		
		System.out.println("------------------------------------------------");
		System.out.println("상품명 검색");
		System.out.println("------------------------------------------------");
		System.out.print("검색어 입력 : ");
		name = sc.nextLine();
		System.out.println("------------------------------------------------");

		selectPrdNm(name);
	}

	/* 4: 종료 */
	void exit() {

		System.out.println("------------------------");
		System.out.print("종료하시겠습니까? (취소 : N, 종료 : 엔터) : ");
		if (!sc.nextLine().equals("N")) {
			System.out.println("종료되었습니다.");
			System.exit(0);
		}
		System.out.println("------------------------");

	}

}

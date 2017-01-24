package day17;

import java.io.IOException;

public class ProductMain {
	public static void main(String[] args) throws IOException {

		try {
			ProductService ps = new ProductService();
			ps.print();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}

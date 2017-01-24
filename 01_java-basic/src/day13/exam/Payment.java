package day13.exam;

public abstract class Payment implements Payable{

	protected String shopName;
	protected String productName;
	protected Long productPrice;

	public Payment(String shopName, String productName, Long productPrice) {
		this.shopName = shopName;
		this.productName = productName;
		this.productPrice = productPrice;
	};
	
}

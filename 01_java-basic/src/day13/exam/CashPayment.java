package day13.exam;

public class CashPayment extends Payment {
	private String cashReceiptNumber;
	
	public CashPayment(String shopName
			, String productName
			, long productPrice
			, String cashReceiptNumber) {
		super(shopName, productName, productPrice);
		this.cashReceiptNumber = cashReceiptNumber;
	}
	
	public String toString() {
		
		String result = String.format("현금이 정상적으로 지불되었습니다.\n"
									+ "[현금 결제 정보]"
									+ "\n상점명\t :%s"
									+ "\n상품명\t :%s"
									+ "\n상품가격\t :%s"
									+ "\n현금영수증번호:%s"
									, shopName, productName, productPrice.toString(), cashReceiptNumber);
		return result;
	}

	@Override
	public void pay() throws PayException {
		
		try {
			
			Long price = productPrice;
			if(price <= new Long(0)) {
				throw new PayException("가격이 잘못되었습니다.");
			}
			
		} catch(PayException fe) {
			throw fe;
		}
		
	}

}

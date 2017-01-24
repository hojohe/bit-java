package day13.exam;

public class CardPayment extends Payment {
	
	private String cardNumber;
	private String cardPassword;
	private int monthlyInstallment;
	
	public CardPayment(String shopName
			, String productName
			, long productPrice
			, String cardNumber
			, String cardPassword
			, int monthlyInstallment) {
		
		super(shopName, productName, productPrice);
		this.cardNumber = cardNumber;
		this.cardPassword = cardPassword;
		this.monthlyInstallment = monthlyInstallment;
		
	}
	
public String toString() {
		
		String result = String.format("신용카드가 정상적으로 지불되었습니다.\n"
									+ "[신용카드 결제 정보]"
									+ "\n상점명\t:%s"
									+ "\n상품명\t:%s"
									+ "\n상품가격\t:%s"
									+ "\n신용카드번호:%s"
									+ "\n할부개월수\t:%s"
									, shopName, productName, productPrice.toString(), cardNumber, monthlyInstallment);
		return result;
	}

	@Override
	public void pay() throws PayException {
		
		Long price = productPrice;
		try {
			if(price <= new Long(0) || monthlyInstallment < 0) {
				throw new PayException("가격이나 할부개월수가 잘못되었습니다.");
			}

		} catch(PayException fe) {
			throw fe;
		}
		
	}
	
	

}

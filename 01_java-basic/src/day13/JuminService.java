package day13;

public class JuminService {

	public boolean valid(String juminNo) throws JuminNumberException {

		// 유효하지 않은 주민번호일 경우 예외를 발생시킨다.
		juminNo = juminNo.replace("-", "");
		if (juminNo.length() != 13) {
			throw new JuminNumberException("주민번호는 13자리 입니다.("+ juminNo +")");
		}

		for (int i = 0; i < juminNo.length(); i++) {
			char c = juminNo.charAt(i);
			if(c < '0' || c > '9') {
				throw new JuminNumberException("");
			}
		}

		return true;
	}

}

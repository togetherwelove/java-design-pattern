package design.pattern.app.strategy.case2.payment;

public class PurchaseService {
	
	public String pay(Payment payment) {
		return payment.pay();
	}
}

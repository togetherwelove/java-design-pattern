package design.pattern.app.strategy.case2;

import design.pattern.app.strategy.case2.payment.Payment;

public class Cash implements Payment{

	@Override
	public String pay() {
		return "pay cash";
	}

}

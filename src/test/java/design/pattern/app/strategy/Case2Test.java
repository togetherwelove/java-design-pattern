package design.pattern.app.strategy.case2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import design.pattern.app.strategy.case2.payment.PurchaseService;

public class CaseTest {

	@Test
	void Client() {
		PurchaseService purchaseService = new PurchaseService();
		
		String cardResult = purchaseService.pay(new PayCard());
		assertEquals("pay card", cardResult);
		
		String cashResult = purchaseService.pay(new PayCash());
		assertEquals("pay cash", cashResult);
	}
}

package design.pattern.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import design.pattern.app.strategy.case1.transport.RoadTransport;
import design.pattern.app.strategy.case1.transport.TrackTransport;
import design.pattern.app.strategy.case1.transport.Transport;
import design.pattern.app.strategy.case2.PayCard;
import design.pattern.app.strategy.case2.PayCash;
import design.pattern.app.strategy.case2.payment.PurchaseService;

public class StrategyTest {

	@Test
	void TransportTest() {
		Transport train = new Transport();
		Transport bus = new Transport();
		
		train.setMovableStrategy(new TrackTransport());
		bus.setMovableStrategy(new RoadTransport());
		
		String trainResult = train.move();
		assertEquals("move along a track", trainResult);
		
		String busResult = bus.move();
		assertEquals("move along a road", busResult);
		
		// bus 객체의 전략이 TrackStrategy로 바뀜
		bus.setMovableStrategy(new TrackTransport());
		assertEquals("move along a track", trainResult);		
	}
	
	@Test
	void PurchaseServiceTest() {
		PurchaseService purchaseService = new PurchaseService();
		
		String cardResult = purchaseService.pay(new PayCard());
		assertEquals("pay card", cardResult);
		
		String cashResult = purchaseService.pay(new PayCash());
		assertEquals("pay cash", cashResult);
	}
}

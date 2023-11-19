package design.pattern.app.strategy.case1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import design.pattern.app.strategy.case1.transport.RoadTransport;
import design.pattern.app.strategy.case1.transport.TrackTransport;
import design.pattern.app.strategy.case1.transport.Transport;

public class CaseTest {

	@Test
	void Client() {
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
}

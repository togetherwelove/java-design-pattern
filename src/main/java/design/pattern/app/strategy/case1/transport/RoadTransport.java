package design.pattern.app.strategy.case1.transport;

public class RoadTransport implements TransportStrategy {

	@Override
	public String move() {
		return "move along a road";
	}

}

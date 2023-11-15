package design.pattern.app.strategy.case1.transport;

public class TrackTransport implements TransportStrategy {

	@Override
	public String move() {
		return "move along a track";
	}

}

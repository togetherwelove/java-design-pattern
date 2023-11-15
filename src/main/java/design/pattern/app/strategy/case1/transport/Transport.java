package design.pattern.app.strategy.case1.transport;

public class Transport {

	private TransportStrategy transportStrategy;
	
	public void setMovableStrategy(TransportStrategy transportStrategy) {
		this.transportStrategy = transportStrategy;
	}
	
	public String move() {
		return transportStrategy.move();
	}
}

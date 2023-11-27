package design.pattern.app.proxy;

public class Logging implements Aspect{

	@Override
	public void before() {
		System.out.println("logging start... " + System.nanoTime());
	}

	@Override
	public void after() {
		System.out.println("logging end... " + System.nanoTime());
	}

}

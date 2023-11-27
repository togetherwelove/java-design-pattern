package design.pattern.app.proxy;

public class UserAuth implements Aspect {

	@Override
	public void before() {
		System.out.println("Your Authorization is...");
	}

	@Override
	public void after() {
		System.out.println("UserAuth end...");
	}

}

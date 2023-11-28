package design.pattern.app.factory;

public class UserDataFactory extends DataFactory<User> {

	@Override
	public User createEntity() {
		return User.builder()
				.name("dean")
				.gender("male")
				.build();
	}

}

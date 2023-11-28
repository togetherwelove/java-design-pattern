package design.pattern.app.builder;

public class UserBuilder {
	
	private User user = new User();
	
	public static UserBuilder builder() {
		return new UserBuilder();
	}

	public UserBuilder id(long id) {
		user.setId(id);
		return this;
	}
	
	public UserBuilder name(String name) {
		user.setName(name);
		return this;
	}

	public UserBuilder birth(String birth) {
		user.setBirth(birth);
		return this;
	}

	public User build() {
		return user;
	}

}

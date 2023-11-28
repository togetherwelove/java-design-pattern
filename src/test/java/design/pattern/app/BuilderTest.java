package design.pattern.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import design.pattern.app.builder.User;
import design.pattern.app.builder.UserBuilder;

public class BuilderTest {

	@Test
	void Constructor_only() {
		User dean = new User(1);
		User son = new User(2, "son");
		User john = new User(3, "john", "20000101");
		// 만약 파라미터가 100개라면..?
	}
	
	@Test
	void Solution_Setter() {
		User dean = new User(1);
		
		dean.setName("dean");
		dean.setBirth("20000101");
		
		// Test
		assertEquals("dean", dean.getName());
		assertEquals("20000101", dean.getBirth());
	}
	
	@Test
	void Solution_Builder() {
		UserBuilder userBuilder = UserBuilder.builder();
		
		userBuilder.id(1).name("dean");
		userBuilder.birth("20000101");
		
		User dean = userBuilder.build();
		
		assertEquals("20000101", dean.getBirth());
	}
	
	@Test
	void Solution_Lombok() {
		User dean = User.builder()
				.id(1L)
				.name("dean")
				.birth("20000101")
				.gender("male")
				.build();
		
		assertEquals("20000101", dean.getBirth());
	}
}

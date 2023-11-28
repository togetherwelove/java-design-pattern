package design.pattern.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import design.pattern.app.factory.Car;
import design.pattern.app.factory.CarDataFactory;
import design.pattern.app.factory.DataFactory;
import design.pattern.app.factory.User;
import design.pattern.app.factory.UserDataFactory;

public class FactoryTest {

	@Test
	void Object() {
		 User user = User.builder()
				 .name("dean")
				 .birth(LocalDateTime.now())
				 .gender("male")
				 .build();
		 
		 User another = User.builder()
				 .name("son")
				 .birth(LocalDateTime.now())
				 .gender("female")
				 .build();
		 
		 List<User> users = List.of(user, another);
		 
		 assertEquals(2, users.size());
		 
		 // 다른 객체가 추가된다면..?
	}
	
	@Test
	void Factory_Method() {
		DataFactory<User> userFactory = new UserDataFactory();
		List<User> users = userFactory.withAll();
		assertEquals(3, users.size());
		
		User user = userFactory.withOne();
		assertEquals("dean", user.getName());
		
		DataFactory<Car> carFactory = new CarDataFactory();
		List<Car> cars = carFactory.withAll();
		assertEquals(3, cars.size());
		
		Car car = carFactory.withOne();
		assertEquals("thunder", car.getName());
	}
	
	public static Stream<Arguments> carSource() {
		return Stream.of(
				Arguments.arguments(Car.builder().name("power").build(), "power"),
				Arguments.arguments(Car.builder().name("dark").build(), "dark")
				);
	}
	
	@ParameterizedTest
	@MethodSource("carSource")
	void Parameterized_Test(Car car, String expectName) {
		assertEquals(expectName, car.getName());
	}
}

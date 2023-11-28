package design.pattern.app.factory;

public class CarDataFactory extends DataFactory<Car> {

	@Override
	public Car createEntity() {
		return Car.builder()
				.id(1L)
				.name("thunder")
				.build();
	}

}

package design.pattern.app.factory;

import java.util.List;

public abstract class DataFactory <T> {

	public List<T> withAll() {
		List<T> list = List.of(
				createEntity(),
				createEntity(),
				createEntity()
				);
		return list;
	};

	public T withOne() {
		return createEntity();
	};

	public abstract T createEntity();
}

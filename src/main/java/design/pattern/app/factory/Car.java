package design.pattern.app.factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Car {

	private Long id;
	private String name;
}

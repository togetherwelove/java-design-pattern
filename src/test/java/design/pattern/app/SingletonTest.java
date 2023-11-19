package design.pattern.app;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import design.pattern.app.singleton.case1.Card;

public class SingletonTest {

	@Test
	void InstanceTest() {
		Card card1 = Card.getInstance();
		Card card2 = Card.getInstance();
		
		assertEquals(card1, card2);
	}
}

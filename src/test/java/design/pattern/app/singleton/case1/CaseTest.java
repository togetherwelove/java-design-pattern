package design.pattern.app.singleton.case1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CaseTest {

	@Test
	void Client() {
		Card card1 = Card.getInstance();
		Card card2 = Card.getInstance();
		
		assertEquals(card1, card2);
	}
}

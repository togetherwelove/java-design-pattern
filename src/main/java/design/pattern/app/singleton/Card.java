package design.pattern.app.singleton;

public class Card {
	
	private static Card instance = new Card();
	
	private Card() {
		
	}

	public static Card getInstance() {
		return instance;
	}
}

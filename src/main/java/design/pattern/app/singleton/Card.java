package design.pattern.app.singleton.case1;

public class Card {
	
	private static Card instance = new Card();
	
	private Card() {
		
	}

	public static Card getInstance() {
		return instance;
	}
}

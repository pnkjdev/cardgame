package cardgames.util;

public class NamingUtil {
	
	public static final String [] CARDNAMES = {"ACE","2","3","4","5","6","7","8","9","10","JACK","QUEEN","KING"};
	
	public static final String [] SUITS = {"SPADES", "HEARTS", "DIAMONDS", "CLUBS"};
	
	public static String getCardName(int i) {
		
		if(i == 14) {
			return CARDNAMES[0];
		}
		return CARDNAMES[i-1];
	}
	
	public static String getSuitName(int i) {
		return SUITS[i-1];
	}
}

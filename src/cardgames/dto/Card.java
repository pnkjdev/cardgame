package cardgames.dto;

public interface Card extends Comparable<Card>{
	
	public static final int SPADES = 1;
	public static final int HEARTS =  2;
	public static final int DIAMONDS = 3;
	public static final int CLUB = 4;
	
	public int getSuit();
	public int getValue();
	public int getSuitValue();
	
}

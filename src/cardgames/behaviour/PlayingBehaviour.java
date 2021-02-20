package cardgames.behaviour;

import cardgames.dto.Card;
import cardgames.dto.Hand;

public interface PlayingBehaviour {
	
	public Card play(Hand hand, Card[] cardOnPlay, Card baseCard);
}

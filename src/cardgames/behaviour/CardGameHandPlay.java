package cardgames.behaviour;

import cardgames.dto.Card;
import cardgames.dto.Hand;

public class CardGameHandPlay implements PlayingBehaviour {

	@Override
	public Card play(Hand hand, Card[] cardOnPlay, Card baseCard) {
		Card highCard = null;
		Card lowCard = baseCard;

		for (Card card : cardOnPlay) {
			if (card != null) {
				highCard = card;
				break;
			}
		}
		for (Card card : cardOnPlay) {
			if (card != null) {
				if (card.compareTo(highCard) > 0) {
					highCard = card;
				} else if (card.getSuit()==baseCard.getSuit() &&  card.compareTo(lowCard) < 0) {
					lowCard = card;
				}
			}
		}
		if (highCard == null && lowCard == null) {
			return hand.getHighestRankedCard();
		}

		return hand.drawCardByValueAndTrump(highCard, lowCard);

	}

}

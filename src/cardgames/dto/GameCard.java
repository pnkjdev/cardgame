package cardgames.dto;

public class GameCard implements Card {

	private final int cardSuit;
	private final int cardValue;
	private final int trumpSuit;
	private final int cardSuitValue;
	
	public GameCard(int cardSuit, int cardValue, int trumpSuit) {
		super();
		this.cardSuit = cardSuit;
		this.cardValue = cardValue;
		this.trumpSuit = trumpSuit;
		if(cardSuit == trumpSuit) {
			cardSuitValue = trumpSuit;
		}else {
			cardSuitValue=0;
		}
	}

	public int getSuit() {
		return this.cardSuit;
	}

	public int getValue() {
		return this.cardValue;
	}

	public int getTrumpSuit() {
		return trumpSuit;
	}

	public int getSuitValue() {
		return cardSuitValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cardSuit;
		result = prime * result + cardSuitValue;
		result = prime * result + cardValue;
		result = prime * result + trumpSuit;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameCard other = (GameCard) obj;
		if (cardSuit != other.cardSuit)
			return false;
		if (cardSuitValue != other.cardSuitValue)
			return false;
		if (cardValue != other.cardValue)
			return false;
		if (trumpSuit != other.trumpSuit)
			return false;
		return true;
	}

	@Override
	public int compareTo(Card o) {
		int rank = getValue() - o.getValue();
		int t = this.getSuitValue() - o.getSuitValue();
		if(t == 0) {
			if(rank == 0) {
				return 0;
			}else if(rank > 0) {
				return 1;
			}else {
				return -1;
			}
		}
		return t;
	}
	
}

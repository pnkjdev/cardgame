package cardgames.dto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hand {
	
	private List<Card> cards;

	public Hand() {
		super();
	}
	
	public List<Card> getCurrentHand(){
		if(cards == null) {
			cards = new ArrayList<>();
		}
		return cards;
	}
	
	public boolean isEmptyHand() {
		return cards.size() == 0;
	}
	
	public void sortHand() {
		cards.sort(Comparator.reverseOrder());
	}
	
	
	public Card getHighestRankedCard() {
		sortHand();
		return cards.get(0);
	}
	
	public Card getLowestRankedCard() {
		sortHand();
		return cards.get(cards.size()-1);
	}

	public Card drawCardByValueAndTrump(Card highCard, Card lowCard) {
		int baseSuitId = lowCard.getSuit();
		Card max = null;
		Card min = null;
		Card nextMax = null;
		Card sameSuiteMinCard = null;
		boolean isMaxFound =false;
		boolean isMinFound = false;
		boolean isSameSuiteFound = false;
		if(highCard.getSuit() == lowCard.getSuit()) {
			max = highCard;
			min = lowCard;
			for(Card card: cards) {
				if(card.getSuit() != baseSuitId) {
					continue;
				}
				sameSuiteMinCard = card;
				isSameSuiteFound = true;
				if(card.compareTo(max) > 0) {
					max = card;
					isMaxFound=true;
				}else if(card.compareTo(min) < 0) {
					min = card;
					isMinFound = true;
				}else if(card.compareTo(sameSuiteMinCard) < 0) {
					sameSuiteMinCard = card;
				}
			}
			if(isMaxFound) {
				return max;
			}else if(isMinFound) {
				return min;
			}else if(isSameSuiteFound) {
				return sameSuiteMinCard;
			}
			max = getHighestRankedCard();
			if(max.getSuitValue() == 0) {
				return getLowestRankedCard();
			}
			return max;
		}
		max = lowCard;
		min = lowCard;
		for(Card card : cards) {
			if(card.getSuit() != baseSuitId) {
				continue;
			}
			if(card.compareTo(max)> 0) {
				max = card;
				if(!isMaxFound) {
					nextMax =card;
				}
				isMaxFound = true;
			}
			else if(card.compareTo(min) < 0) {
				min = card;
				isMinFound= true;
			}
		}
		if((isMaxFound && highCard.getSuitValue() == 0)){
			return max;
		}else if(isMinFound) {
			return min;
		}else if(isMaxFound) {
			return nextMax;
		}
		max = getHighestRankedCard();
		if(max.getSuitValue() == 0) {
			return getLowestRankedCard();
		}
		return max;
		
	}

	public void removeCard(Card t) {
		cards.remove(t);
	}

	public void receiveHand(Card x) {
		if(cards == null) {
			cards = new ArrayList<>();
		}
		cards.add(x);
	}

	public void clearHand() {
		cards.clear();
	}
	
	
	
}

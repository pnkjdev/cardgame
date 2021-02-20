package cardgames.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import cardgames.util.NamingUtil;

public class Deck implements Iterator<Card> {
	List<Card> myCardList;
	int myIndex;
	public Deck() {
		myCardList = new ArrayList<>();
		Random ran = new Random();
		int trumpSuit = ran.nextInt(5);
		if(trumpSuit == 0) {
			trumpSuit += 1;
		}
		System.out.println("Trump is: "+ NamingUtil.getSuitName(trumpSuit));
		for (int suit = Card.SPADES; suit <= Card.CLUB; suit++) {
			for (int i = 2; i <= 14; i++) {
				myCardList.add(new GameCard(suit, i, trumpSuit));
			}
		}
		shuffle();
	}

	protected void shuffle() {
		Collections.shuffle(myCardList);
		myIndex = 0;
	}

	public boolean hasNext() {
		return myIndex < myCardList.size();
	}

	public Card next() {
		Card card = myCardList.get(myIndex);
		myIndex++;
		return card;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
	
}

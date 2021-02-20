package cardgames.dto;

import cardgames.behaviour.PlayingBehaviour;

public class Player {
	
	private String name;
	private int id;
	private Hand hand;
	private PlayingBehaviour playType;

	public Player(String name, int id, PlayingBehaviour playType) {
		super();
		this.name = name;
		this.id = id;
		this.playType = playType;
	}
	
	public Player(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}



	public Card playHand(Card[] cardOnPlay, Card baseCard) {
		Card t = playType.play(hand, cardOnPlay, baseCard);
		hand.removeCard(t);
		return t;
	}
	
	public void receiveHand(Card x) {
		if(hand == null) {
			hand = new Hand();
		}
		hand.receiveHand(x);
	}
	
	public void resetPlayerHand() {
		hand.clearHand();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PlayingBehaviour getPlayType() {
		return playType;
	}

	public void setPlayType(PlayingBehaviour playType) {
		this.playType = playType;
	}

	public Hand getHand() {
		return hand;
	}

	
}

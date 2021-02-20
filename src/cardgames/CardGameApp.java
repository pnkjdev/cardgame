package cardgames;

import java.util.Arrays;

import cardgames.behaviour.CardGameHandPlay;
import cardgames.dto.Card;
import cardgames.dto.Deck;
import cardgames.dto.Player;
import cardgames.util.NamingUtil;

public class CardGameApp {

	private static final CardGameApp game = new CardGameApp();

	private Deck deck;
	private Player[] players;

	public static CardGameApp getGameInstance() {
		return game;
	}

	private CardGameApp() {
		super();
		players = new Player[4];
	}

	public Player playGame(Player[] players) {
		initializePlayers(players);
		deck = new Deck();
		dealCards();
		int hands = 1;
		int indexOfCurrentPlayer = 0;
		int currentPlayHands=0;
		Card[] playedCards = new Card[4];
		int [] winningCount = new int[4];
		Card baseCard= null;
		while (hands <= 13) {
			System.out.println("--------------------------------"+String.valueOf(hands)+"------------------------------------------------");
			Arrays.fill(playedCards, null);
			baseCard = null;
			while(currentPlayHands < 4) {
				playedCards[indexOfCurrentPlayer] = (players[indexOfCurrentPlayer].playHand(playedCards, baseCard));
				if(currentPlayHands == 0) {
					baseCard = playedCards[indexOfCurrentPlayer];
				}
				System.out.println("Card Played by "+ players[indexOfCurrentPlayer].getName()+ " is " + NamingUtil.getCardName(playedCards[indexOfCurrentPlayer].getValue())+ " of: "+ NamingUtil.getSuitName(playedCards[indexOfCurrentPlayer].getSuit()));
				currentPlayHands++;
				indexOfCurrentPlayer = (indexOfCurrentPlayer+1) %4;
			}
			currentPlayHands = 0;
			indexOfCurrentPlayer =  getWinningrHand(playedCards);
			System.out.println();
			System.out.println("Round Won by "+ players[indexOfCurrentPlayer].getName());
			winningCount[indexOfCurrentPlayer]++;
			hands++;
		}
		endGame(players);
		return players[winner(winningCount)];
	}

	private int winner(int[] winningCount) {
		int max = 0;
		for(int i=1; i<4; i++) {
			if(winningCount[i]> winningCount[max]) {
				max = i;
			}
		}
		return max;
	}

	private int getWinningrHand(Card[] playedCards) {
		int index = 0;
		for(int i=1; i<playedCards.length; i++) {
			if(playedCards[i].compareTo(playedCards[index]) > 0) {
				index = i;
			}
			
		}
		return index;
	}

	private void initializePlayers(Player[] players) {
		for(Player p : players) {
			p.setPlayType(new CardGameHandPlay());
		}
		this.players = players;
	}

	private void dealCards() {
		int i = 0;
		while (deck.hasNext()) {
			players[i % 4].receiveHand(deck.next());
			i++;
		}

	}

	private void endGame(Player[] players) {
		for(Player p : players) {
			p.resetPlayerHand();
		}
	}

}

package cardgames.driver;

import cardgames.CardGameApp;
import cardgames.dto.Player;

public class GameDriver {
	
	public static void main(String[] args) {
		
		Player [] players = {new Player("Pankaj", 1), new Player("Bunty", 2), new Player("Rahul", 3), new Player("Sameer", 4)};
		Player winner = CardGameApp.getGameInstance().playGame(players);
		System.out.print("Game Winner: "+ winner.getName()+ " with Id: "+ String.valueOf(winner.getId()));
		
	}
}

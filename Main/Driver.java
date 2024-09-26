package Main;

import DeckofCards.Deck;
import People.Player;

public class Driver {

	public static void main(String[] args) {
		Deck deck = new Deck();
		Player player = new Player();
		Player dealer = new Player();
		
		
		player.setName("Juan");
		player.setMoney(100);
		
		dealer.setName("Dealer");
		dealer.setMoney(100);
		
		deck.initDeck();
		
		deck.cardCount();
		System.out.println(deck);
	
		System.out.println("\n\n");
		System.out.println("------------------------\n");

		deck.shuffleDeck();
		
		deck.cardCount();
		System.out.println(deck);
		
		
		System.out.println( deck.getCard(0).toNum() + "-"+ deck.getCard(0).toChar());

		// Giving the player 2 Playing cards		
		for (int i = 0 ; i < 2; i++ ) {
		player.drawFromDeck(deck);
		dealer.drawFromDeck(deck);
		}
		System.out.println("\n\n");
		
		System.out.println(player.getHand());
		System.out.println(player.getName() +"'s Hand Size: "+ player.getHand().size());
		System.out.println("Score: " + player.evaluateHand());
		
		System.out.println("\n\n");

		System.out.println(dealer.getHand());
		System.out.println("Dealers Hand Size: "+ dealer.getHand().size());
		System.out.println("Score: " + dealer.evaluateHand());

		deck.cardCount();
		
		System.out.println("\n\n");

		player.Hit(deck);
		
		System.out.println(player.getHand());
		System.out.println(player.getName() +"'s Hand Size: "+ player.getHand().size());
		System.out.println("Score: " + player.evaluateHand());
		deck.cardCount();
		System.out.println("\n\n");
		
		// Grabbing the first index of Dealers Hand to show player
		System.out.println(dealer.getName()+ "'s Hand: " + dealer.getHand().get(0).toString() + " and [Hidden]");

		System.out.println(deck.getCard(0).toChar());
	
		
		
	}

}

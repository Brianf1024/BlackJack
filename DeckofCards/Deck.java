package DeckofCards;

import java.util.ArrayList;
import java.util.Collections;

import com.sun.jdi.Value;

public class Deck {
	// Variable for adding cards to form a deck
	private ArrayList<Card> deck;

	public Deck() {
		this.deck = new ArrayList<Card>();
	}

	public void initDeck() {
		// Building Deck
		for (Suits S : Suits.values()) {
			for (Values V : Values.values()) {
				// Associating each card with a Suit and Value, then adding it into the deck
				this.deck.add(new Card(S, V));

			}
		}
	}

	public void shuffleDeck() {
		Collections.shuffle(deck);
		// System.out.println("Cards Available: "+deck.size());
	}

	public String toString() {
		String Deck = "";
		// int i = 0;
		// Iterated through each card in the deck and will print the list of cards
		for (Card C : this.deck) {
			Deck += "\n" + C.toString();
			// i++;
		}
		// System.out.println("Cards Available: " + deck.size());
		return Deck;
	}

	public void removeCardFromDeck(int i) {
		this.deck.remove(i);
	}

	public Card getCard(int i) {
		return this.deck.get(i);
	}

	public void addCard(Card addCard) {
		this.deck.add(addCard);
	}

	public void cardCount() {
		int j = deck.size();
		System.out.println("Cards Available: " + j);
	}

	
	
	
}

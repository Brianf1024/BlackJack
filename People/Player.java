package People;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import DeckofCards.Card;
// IDEA
// Players 3 potential moves in poker
// Call : Player puts out the same amount of chips into the pot equal to the bet of the previous player 
// Raise : Place a bigger bet than the previous one
// Fold : Give up cards and lose
import DeckofCards.Deck;

public class Player {
	private String Name;
	private Integer Money;
	private ArrayList<Card> Hand;

	public Player() {
		setName("Unknown");
		Hand = new ArrayList<Card>();
		setMoney(100);
	}

	public void addCard(Card card) {
		Hand.add(card);
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public ArrayList<Card> getHand() {
		return Hand;
	}

	// Sets for array of five cards given at the round
	public void setHand(ArrayList<Card> hand) {
		Hand = hand;
	}

	public Integer getMoney() {
		return Money;
	}

	public void setMoney(Integer money) {
		Money = money;
	}

	// Once Round is Over we Clear the hand
	public void clearHand() {
		Hand.clear();
	}

	public void drawFromDeck(Deck d) {
		// Removing the first index of Cards to replicate removing card from top of deck
		this.Hand.add(d.getCard(0));
		// While we take card we have to remove it from the deck
		d.removeCardFromDeck(0);
	}

	public Integer bet(int bet) {
		Money = Money - bet;
		return Money;
	}

	public int evaluateHand() {
		int playerSum = 0;
		int aceCounter = 0;
		// Iterating thorugh the players hand and 
		for (Card card : this.Hand) {
			switch (card.getValue()) {
			case TWO:
				playerSum += 2;
				break;
			case THREE:
				playerSum += 3;
				break;
			case FOUR:
				playerSum += 4;
				break;
			case FIVE:
				playerSum += 5;
				break;
			case SIX:
				playerSum += 6;
				break;
			case SEVEN:
				playerSum += 7;
				break;
			case EIGHT:
				playerSum += 8;
				break;
			case NINE:
				playerSum += 9;
				break;
			case TEN:
				playerSum += 10;
				break;
			case JACK:
				playerSum += 10;
				break;
			case QUEEN:
				playerSum += 10;
				break;
			case KING:
				playerSum += 10;
				break;
			case ACE:
				aceCounter++;
				break;
			}
		}

		// Aces can be 1 or 11. Adjust based on current sum.
		for (int i = 0; i < aceCounter; i++) {
			if (playerSum + 11 > 21) {
				playerSum += 1;
			} else {
				playerSum += 11;
			}
		}

		return playerSum;
	}

	
	public void Hit(Deck deck) {
        drawFromDeck(deck);
    }
	
}

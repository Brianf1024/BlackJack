package DeckofCards;

public class Card {

	// calls enum constants
	private Suits suit;
	private Values value;

	public Card(Suits suit, Values value) {
		this.suit = suit;
		this.value = value;
	}

	public String toString() {
		return this.value.toString() + " of " + this.suit.toString();
	}

	public Values getValue() {
		return this.value;
	}

	public char toChar() {
		if (this.suit == Suits.CLUBS) {
			return 'C';
		} else if (this.suit == Suits.DIAMONDS) {
			return 'D';
		} else if (this.suit == Suits.SPADES) {
			return 'S';
		} else if (this.suit == Suits.HEARTS) {
			return 'H';
		}
		return ' ';
	}

	public char toNum() {
        switch (this.value) {
            case TWO:
                return '2';
            case THREE:
                return '3';
            case FOUR:
                return '4';
            case FIVE:
                return '5';
            case SIX:
                return '6';
            case SEVEN:
                return '7';
            case EIGHT:
                return '8';
            case NINE:
                return '9';
            case TEN:
                return 'T';
            case JACK:
                return 'J';
            case QUEEN:
                return 'Q';
            case KING:
                return 'K';
            case ACE:
                return 'A';
            default:
                return ' '; 
        }
    }

	public String getImagePath() {
	    String path = "/cards/" + toNum() + "-" + toChar() + ".png";
	    return path;
	}
}
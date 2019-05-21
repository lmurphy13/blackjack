public class Card {

	private String suit;
	private String value;

	public Card(String suit, String value) {
		this.suit = suit;
		this.value = value;
	}

	public String toString() {
		String str = String.format("%s of %s", this.value, this.suit);
		return str;
	}

	public int getNum() {
		if(this.value.equals("TWO")) {
			return 2;
		} else if(this.value.equals("THREE")) {
			return 3;
		} else if(this.value.equals("FOUR")) {
			return 4;
		} else if(this.value.equals("FIVE")) {
			return 5;
		} else if(this.value.equals("SIX")) {
			return 6;
		} else if(this.value.equals("SEVEN")) {
			return 7;
		} else if(this.value.equals("EIGHT")) {
			return 8;
		} else if(this.value.equals("NINE")) {
			return 9;
		} else if(this.value.equals("TEN") || this.value.equals("JACK") ||
			this.value.equals("QUEEN") || this.value.equals("KING")) {
			return 10;
		}
		return 0;
	}

	public String getSuit() {
		return this.suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
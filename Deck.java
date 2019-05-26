import java.util.Collections;
import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card>();
	private int length = 0;
	
	private static String[] suits = {"HEARTS", "SPADES", "CLUBS", "DIAMONDS"};
	private static String[] values = {"TWO", "THREE", "FOUR", "FIVE", "SIX",
	"SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE"};

	
	public Deck() {
		genDeck();
	}

	private void genDeck() {
		for(String suit : suits) {
			for(String value : values) {
				 deck.add(new Card(suit,value));
				 this.length++;
			}
		}

	}

	public void shuffle() {
		Collections.shuffle(this.deck);
	}

	public Card getCard(int index) {
		return this.deck.get(index);
	}

	public void setCard(int index, Card card) {
		this.deck.set(index, card);
	} 

	public Card dealCard() throws Exception {
		if(this.length > 0) {
			Card c = this.deck.get(0);
			this.deck.remove(0);
			this.length--;
			return c;
		} else {
			throw new Exception("Cannot deal card from empty deck!");
		}
	}

	public int deckLen() {
		return this.length;
	}

	public static void main(String[] args) {
		Deck deck = new Deck();

		// for(int i = 0; i < 52; i++) {
		// 	System.out.println(deck.getCard(i));
		// }

		deck.shuffle();
		deck.shuffle();

		// System.out.println(deck.deckLen());

		// for(int i = 0; i < deck.deckLen(); i++) {
		// 	System.out.println(i + ". " + deck.getCard(i));
			
		// }

		// System.out.println(deck.dealCard());
		// System.out.println(deck.dealCard());
		// System.out.println(deck.dealCard());
		// System.out.println(deck.dealCard());
		// System.out.println(deck.dealCard());

		// for(int i = 0; i < deck.deckLen(); i++) {
		// 	System.out.println(i + ". " + deck.getCard(i));
		// }

		for(int i = 0; i < 52; i++) {
			try { System.out.println(deck.dealCard()); } catch(Exception e) { e.printStackTrace(); }
			System.out.println("dealt card");
		}

		try { System.out.println(deck.dealCard()); } catch(Exception e) { e.printStackTrace(); }

	}

}
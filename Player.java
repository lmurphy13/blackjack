import java.util.ArrayList;

public class Player {
	private int id;
	private double bank;
	private double bet;
	private ArrayList<Card> hand = new ArrayList<Card>();

	public Player(int id) {
		this.id = id;
		this.bank = 0.0;
		this.bet = 0.0;

	}

	public String toString() {
		String str = String.format("Player %d has $%.2f.\nBet: $%.2f\nHand total: $%.2f.", 
			this.id, this.bank, this.bet, this.hand);
		return str;
	}

	public void giveCard(Card c) {
		this.hand.add(c);
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBank() {
		return this.bank;
	}

	public void setBank(double bank) {
		this.bank = bank;
	}

	public double getBet() {
		return this.bet;
	}

	public void setBet(double bet) {
		this.bet = bet;
	}

	public ArrayList<Card> getHand() {
		return this.hand;
	}

	public int getHandTotal() {
		int total = 0;
		for(Card c : hand) {
			if(!c.getValue().equals("ACE")) {
				total += c.getNum();
			} else if(total <= (21 - 11) && c.getValue().equals("ACE")) {
				total += 11;
			} else if(total > (21 - 11) && c.getValue().equals("ACE")) {
				total += 1;
			}
		}
		return total;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle();

		Player p1 = new Player(1);

		try {
			p1.giveCard(deck.dealCard());
			p1.giveCard(deck.dealCard());
		} catch(Exception e) {
			e.printStackTrace();
		}

		System.out.println(p1.getHand());


	}

}
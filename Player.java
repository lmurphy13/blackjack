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
		String str = String.format("Player %d has $%.2f and is betting $%.2f. Their hand total is: %d.", 
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
		
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

}
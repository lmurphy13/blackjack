public class Blackjack {
	
	public static final int MAXPLAYERS = 5;

	public static void main(String[] args) {
		Blackjack game = new Blackjack();

	}

	public Blackjack() {
		
		/* Dealer is always has ID of 0 */
		Player dealer = new Player(0);

		/* Other players have ID 1 - MAXPLAYERS */
		Player[] players = new Player[MAXPLAYERS];
		for(int i = 1; i <= MAXPLAYERS; i++) {
			players[i - 1] = new Player(i);
		}

		dealer.setBank(20);
		dealer.setBet(10);

		for(int i = 0; i < players.length; i++) {
			players[i].setBank(20);
			players[i].setBet(10);
		}

	}


	public void play(Player dealer, Player[] players) {
		/* Standard 52 card deck */
		Deck deck = new Deck();
		deck.shuffle();

		for(Player player : players) {
			try { player.giveCard(deck.dealCard()); } catch(Exception e) {e.printStackTrace();}
		}

		/* Play until dealer has no more money */
		while(dealer.getBank() > 0) {
			try { dealer.giveCard(deck.dealCard()); } catch(Exception e) {e.printStackTrace();}
			
			/* Let each player take their turn */
			for(Player player : players) {




			}







		}



	}	


}
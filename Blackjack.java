public class Blackjack {
	public static final int MAXPLAYERS = 5;

	private Player dealer;
	private Player[] players;


	public static void main(String[] args) {
		Blackjack game = new Blackjack();
		game.play(game.getDealer(), game.getPlayers());

	}

	public Blackjack() {
		
		/* Dealer is always has ID of 0 */
		Player dealer = new Player(0);

		/* Other players have ID 1 - MAXPLAYERS */
		Player[] players = new Player[MAXPLAYERS];
		for(int i = 0; i < MAXPLAYERS; i++) {
			players[i] = new Player(i);
		}

		dealer.setBank(20);
		dealer.setBet(10);

		for(int i = 0; i < players.length; i++) {
			players[i].setBank(20);
			players[i].setBet(10);
		}

	}

	public Player getDealer() { return this.dealer; }
	public Player[] getPlayers() { return this.players; }

	public void play(Player dealer, Player[] players) {
		/* Standard 52 card deck */
		Deck deck = new Deck();
		deck.shuffle();

		// for(Player player : this.players) {
		// 	try { player.giveCard(deck.dealCard()); } catch(Exception e) {e.printStackTrace();}
		// }

		for (int i = 0; i < MAXPLAYERS; i++) {
			try {
				this.players[i].giveCard(deck.dealCard());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/* Play until dealer has no more money */
		while(dealer.getBank() > 0) {
			try { dealer.giveCard(deck.dealCard()); } catch(Exception e) {e.printStackTrace();}
			
			/* Let each player take their turn */
			for(Player player : players) {
				System.out.printf("Player %d has hand: %s\n", player.getId(), player);
				if(!player.getHand().get(1).equals("ACE")) {
					if(player.getHand().get(1).getNum() < 10) {
						try {
							player.giveCard(deck.dealCard());
						} catch(Exception e) {
							System.err.print(e);
						}
					}
				}
			}
		}
	}
}
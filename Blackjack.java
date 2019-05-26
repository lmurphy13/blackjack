import java.util.Scanner;

public class Blackjack {
	

	private Player dealer;
	private Player player;


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Blackjack game = new Blackjack();
		Boolean playAgain = true;
		String response;
		while(playAgain) {
			game.play();
			System.out.print("Would you like to play again?: (y/n)");
			response = in.next();

			if(response.equals("n"))
				playAgain = false;
			else
				continue;
		}
	}

	public Blackjack() {
		
		/* Dealer is always has ID of 0 */
		dealer = new Player(0);
		/* One player configuration */
		player = new Player(1);

		player.setBank(20);


	}

	public void play() {

		Scanner in = new Scanner(System.in);

		/* Standard 52 card deck */
		Deck deck = new Deck();
		deck.shuffle();

		try {
			dealer.giveCard(deck.dealCard());
			dealer.giveCard(deck.dealCard());
			player.giveCard(deck.dealCard());
			player.giveCard(deck.dealCard());
		} catch (Exception e) {
			e.printStackTrace();
		}




		System.out.printf("You have a bank of $%.2f. What is your bet?: ", player.getBank());
		player.setBet(in.nextDouble());
		System.out.printf("Your bet is set at $%.2f.\n", player.getBet());

		System.out.printf("The dealer's hand is: %s, [HIDDEN].\n", dealer.getHand().get(0));

		System.out.print("Your hand is: ");
		System.out.println(player.getHand() + ", which has a total of: " + player.getHandTotal());

		while(player.getHandTotal() <= 21) {

			int selection;
			System.out.printf("Would you like to:\n1. Hit\n2. Stand\n");
			System.out.print("Response: ");
			selection = in.nextInt();

			
			if(selection == 1) {
				try {
					player.giveCard(deck.dealCard());
				} catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("Your hand is now: " + player.getHand() + " and has a total of: " + player.getHandTotal());
				if(player.getHandTotal() == 21) {
					player.setBank(player.getBank() + player.getBet());
					System.out.printf("You win! Your bank is now: $%.2f.\n", player.getBank());
					break;
				}

				if(dealer.getHandTotal() >= 15) {
					if(dealer.getHandTotal() == 21) {
						System.out.println("The dealer's hand is: " + dealer.getHand() + ". The dealer wins!");
						player.setBank(player.getBank() - player.getBet());
						System.out.printf("Your bank is now: $%.2f.\n", player.getBank());
						break;
					} else {
						System.out.println("The dealer stays.");
					}

				} else {
					try {
						dealer.giveCard(deck.dealCard());
					} catch(Exception e) {
						e.printStackTrace();
					}
					System.out.println("The dealer was delt a card.");
				}


			} else if(selection == 2) {
				if(player.getHandTotal() == 21) {
					player.setBank(player.getBank() + player.getBet());
					System.out.printf("You win! Your bank is now: $%.2f.\n", player.getBank());
					break;
				}

				if(dealer.getHandTotal() >= 15) {
					if(dealer.getHandTotal() == 21) {
						System.out.println("The dealer's hand is: " + dealer.getHand() + ". The dealer wins!");
						player.setBank(player.getBank() - player.getBet());
						System.out.printf("Your bank is now: $%.2f.\n", player.getBank());
						break;
					} else {
						System.out.println("The dealer stays.");
					}

				} else {
					try {
						dealer.giveCard(deck.dealCard());
					} catch(Exception e) {
						e.printStackTrace();
					}					
					System.out.println("The dealer was delt a card.");
				}
			}
		}
	}
}
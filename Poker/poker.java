package poker;
import java.util.Scanner;

public class poker {
	private static pokerDeck myDeck = new pokerDeck();
	public static pokerPlayer createPlayer(String name, int cash) {
		pokerPlayer toMake = new pokerPlayer(name, myDeck.deal(), myDeck.deal(),cash);
		return toMake;
	}
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		myDeck.shuffle();
		System.out.print("Please enter the number of players: ");
		int numOfPlayers = input.nextInt();
		pokerPlayer[] players = new pokerPlayer[numOfPlayers];
		for (int i = 1; i <= numOfPlayers; i++) {
			System.out.printf("Please have player#%d enter his name: ",i);
			String name = input.next();
			System.out.printf("Enter how much money %s has: ",name);
			int cash = input.nextInt();
			players[i-1] = createPlayer(name,cash);
		}
		for(int b = 0; b < players.length; b++) {
			players[b].display();
		}
	}
}

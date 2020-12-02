// Issa Issa
// CECS 274-05
// Prog 3 - Solitaire Prime
// 09/26/2019
import java.util.Scanner;
public class solitairePrime {
	// Function to print menu
	public static void printMenu() {
		System.out.println("Welcome to Solitaire Prime!");
		System.out.println("1) New Deck");
		System.out.println("2) Display Deck");
		System.out.println("3) Shuffle Deck");
		System.out.println("4) Play Solitaire Prime");
		System.out.println("5) Exit");
	}
	// Get the user input from menu
	public static int menu(){
		Scanner input = new Scanner(System.in);
		System.out.print("\nPlease choose an option or enter 5 to exit: ");
		int choice = input.nextInt();
		return choice;
	}
	// Check if the number is prime, will be used for checking if sum of pile is prime
	// I'm assuming it's prime then checking if it's not
	public static boolean isPrime(int number) {
		int divisors = 0;
		if(number == 0 || number == 1) {
			return false;
		}
		for(int i = 1; i <= number; i++) {
			if(number % i == 0) {
				divisors++;
			}
		}
		if(divisors > 2) {
			return false;
		}
		return true;
    }
	public static void main (String args[]) {
		printMenu();
		int choice = menu();
		// Get an empty deck object called deck
		Deck myDeck = null;
		while (choice != 5) {
			// New deck
			if (choice == 1) {
				myDeck = new Deck();			
			}
			// Display the deck, if there is one, if not say so
			if (choice == 2) {
				if (myDeck == null) {
					System.out.println("There is no deck to display.");
				}
				else {
					myDeck.display();
				}
			}
			// Shuffle deck if there is one, if not say so
			if (choice == 3) {
				if (myDeck == null) {
					System.out.println("There is no deck to shuffle.");
				}
				else {
					myDeck.shuffle();
				}
			}
			// Play Solitaire Prime if there's a deck, if not then tell the user
			// If they played the game already and the deck is empty then tell the user
			if (choice == 4) {
				if (myDeck == null || myDeck.cardsLeft() == 0) {
					if (myDeck == null) {
						System.out.println("There is no deck to play solitarie prime with.");
					}
					else {
						System.out.println("There is no more cards, please make a new deck first.");
					}
				}
				// There is a deck and they can play Solitaire Prime
				else {
					int winnerIn = 0;
					int summ = 0;
					// Pile to store cards that are not prime, most you can have is 52
					// because there is 52 cards in a deck
					Card [] pile = new Card[52];
					int indexOfPile = 0;
					while (myDeck.cardsLeft() >= 0) {
						if (!isPrime(summ)) {
							// If it's the last pile and it's not prime then it's a loser
							if (myDeck.cardsLeft() == 0) {
								for (int j = 0; j < indexOfPile; j++) {
									pile[j].display();
								}
								System.out.print("Loser\n");
								break;
							}
							else {
								pile[indexOfPile] = myDeck.deal();
								summ = summ + pile[indexOfPile].getValue();
								indexOfPile++;
							}
						}
						else{
							winnerIn++;
							for (int j = 0; j < indexOfPile; j++) {
								pile[j].display();
							}
							System.out.printf("Prime:%d\n",summ);
							// If it's the last pile and it's prime then it's a winner
							if (myDeck.cardsLeft() == 0) {
								System.out.printf("Winner in %d piles!\n",winnerIn);
								break;
							}
							else {
								// Discard pile and start everything over
								pile = new Card[52];
								summ = 0;
								indexOfPile = 0;
							}
						}
					}
				}
			}
			choice = menu();
		}	
	}
	
}			

	

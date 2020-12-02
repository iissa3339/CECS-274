// Issa Issa
// CECS 274-05
// Prog 3 - Linked List
// 10/15/2019
import java.util.Random;
import java.util.Scanner;
public class stringList {
	// Make up a word to add to the list
	public static String createWord() {
		Random rand = new Random();
		char[] letter = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char[] vowel = {'a','e','i','o','u'};
		char a1 = letter[rand.nextInt(letter.length)];
		char a2 = vowel[rand.nextInt(vowel.length)];
		char a3 = letter[rand.nextInt(letter.length)];
		char a4 = letter[rand.nextInt(letter.length)];
		String result = "" + a1 + a2 + a3 + a4;
		return result;
	}

	public static void main(String args[]) {
		linkedList myList = new linkedList();
		for (int i = 0; i < 100; i++) {
			myList.add(createWord());
		}
		myList.display();
		System.out.printf("\n(A)dd, (D)elete, (F)ind, (Q)uit List Size:%d ",myList.size());
		Scanner input = new Scanner(System.in);
		String choice = input.next();
		while (choice.compareTo("Q") != 0) {
			if (choice.compareTo("A") == 0) {
				String toAdd = createWord();
				myList.add(toAdd);
				myList.display();
				System.out.printf("\n%s was added at location %d",toAdd,myList.find(toAdd));
				System.out.printf("\n(A)dd, (D)elete, (F)ind, (Q)uit List Size:%d ",myList.size());
				choice = input.next();
			}
			else if (choice.compareTo("D") == 0) {
				Random randomm = new Random();
				int wordIndex = randomm.nextInt(myList.size());
				String word = myList.getElement(wordIndex);
				myList.remove(word);
				myList.display();
				System.out.printf("\n%s was removed from location %d",word,wordIndex+1);
				System.out.printf("\n(A)dd, (D)elete, (F)ind, (Q)uit List Size:%d ",myList.size());
				choice = input.next();
			}
			else if (choice.compareTo("F") == 0) {
				System.out.printf("Please enter a word to find: ");
				String toSearch = input.next();
				int found = myList.find(toSearch);
				if (found == 0) {
					System.out.printf("\n%s not found", toSearch);
				}
				else {
					System.out.printf("\n%s found at location %d",toSearch,found);
				}
				System.out.printf("\n(A)dd, (D)elete, (F)ind, (Q)uit List Size:%d ",myList.size());
				choice = input.next();				
			}
			else {
				break;
			}
		}
		input.close();
	}
}

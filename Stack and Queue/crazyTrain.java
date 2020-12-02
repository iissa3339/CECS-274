// Issa Issa
// CECS 274-05
// Prog 5 - Stacks and Queue
// 11/21/19
import java.util.Scanner;
public class crazyTrain {
	private static Scanner input = new Scanner(System.in);
	// Get the beginning train info and process it
	public static queue getTrain(char trainAorB) {
		queue train = new queue();
		System.out.printf("\n\tEnter the order of the original in train%s: ",trainAorB);
		String beginOrder = input.next();
		String[] beginOrderArray = beginOrder.split("");
		for(int i = 0; i < beginOrderArray.length; i++) {
			train.push(Integer.parseInt(beginOrderArray[i]));
		}
		return train;
	}
	public static void main(String args[]) {
		int cars = -1;
		while(cars != 0) {
			System.out.print("Welcome to the Crazy Train\n\tEnter the number of train cars: ");
			cars = input.nextInt();
			if(cars == 0) {
				System.out.print("Bye Bye");
				break;
			}
			// get the trains and store in a queue
			queue trainA = getTrain('A');
			queue trainB = getTrain('B');
			// Get a copy of both trains to print at the end
			queue copyOfA = new queue();
			queue copyOfB = new queue();
			// Determine if the beginning train can look like the ending train using a stack
			queue outputQueue = new queue();
			stack workStack = new stack();
			// everytime we pop something from the trains, we will push them to the copies
			// the copies should look like the trains when we started with them
			// this will help in printing at the end
			int temp1 = trainA.pop();
			copyOfA.push(temp1);
			int temp2 = trainB.pop();
			copyOfB.push(temp2);
			// counter for inserting last car to actual output if both train and stack are empty
			int counter = 0;
			// Here we will have the work
			while(!trainA.isEmpty() || !workStack.isEmpty() || counter<cars) {
				if(trainA.isEmpty()) {
					if(temp1 == temp2) {
						outputQueue.push(temp1);
						temp1 = -1;
						if(!trainB.isEmpty()) {
							temp2 = trainB.pop();
							copyOfB.push(temp2);
						}
					}
					// Train A is empty but the stack has stuff in it
					else {
						if(workStack.top() == temp2) {
							outputQueue.push(workStack.pop());
							if(!trainB.isEmpty()) {
								temp2 = trainB.pop();
								copyOfB.push(temp2);
							}
						}
						else {
							while(!trainB.isEmpty()) {
								temp2 = trainB.pop();
								copyOfB.push(temp2);
							}
							System.out.print("Bozo! you can't do that! Reconfiguration is impossible\n");
							break;
						}
					}
				}
				else {
					if(temp1 == temp2) {
						outputQueue.push(temp1);
						temp1 = trainA.pop();
						copyOfA.push(temp1);
						if(!trainB.isEmpty()) {
							temp2 = trainB.pop();
							copyOfB.push(temp2);
						}
					}
					else if(!workStack.isEmpty() && workStack.top() == temp2) {
						outputQueue.push(workStack.pop());
						if(!trainB.isEmpty()) {
							temp2 = trainB.pop();
							copyOfB.push(temp2);
						}
					}
					else {
						workStack.push(temp1);
						temp1 = trainA.pop();
						copyOfA.push(temp1);
					}
				}
				counter++;
			}
			if(workStack.isEmpty() && trainA.isEmpty()) {
				System.out.println("\nSmooth move - the reconfiguration is successful");
			}
			System.out.print("original (train A) :");
			copyOfA.display();
			System.out.println();
			System.out.print("target (train B)   :");
			copyOfB.display();
			System.out.println();
			System.out.print("actual             :");
			outputQueue.display();
			System.out.println();
		}
	}
}

				
				
				
				
				
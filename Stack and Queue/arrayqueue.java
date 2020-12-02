
public class arrayqueue {
	private int[] queue;
	private int emptySpot = 0;
	private int toPop = 0;
	
	public arrayqueue(int length) {
		queue = new int[length];
	}
	public void push(int x) {
		queue[emptySpot++] = x;
	}
	public int pop() {
		int temp = queue[toPop];
		toPop++;
		return temp;
	}
	public void display() {
		for(int i = 0; i < queue.length; i++) {
			System.out.print(queue[i] + " ");
		}
	}
	public int size() {
		return queue.length;
	}
	public boolean isEmpty() {
		if(toPop == queue.length) {
			return true;
		}
		return false;
	}
}

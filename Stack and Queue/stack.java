
public class stack {
	private Node top;
	
	public stack() {
		top = null;
	}
	public void push(int n) {
		Node temp = new Node(n);
		temp.setNext(top);
		top = temp;
	}
	public int top() {
		return top.getValue();
	}
	public int pop() {
		int temp = top.getValue();
		top = top.getNext();
		return temp;
	}
	public int size() {
		int count = 0;
		Node temp = top;
		while (temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}
	public boolean isEmpty() {
		if(top == null) {
			return true;
		}
		return false;
	}
}


public class Node {
	private int value;
	private Node next;
	
	public Node(int v){
		value = v;
		next = null;
	}
	
	public void setNext(Node node1) {
		next = node1;
	}
	
	public void setValue(int x) {
		value = x;
	}
	
	public Node getNext() {
		return next;
	}
	
	public int getValue() {
		return value;
	}
	
	public void display() {
		if(next == null) {
			System.out.printf("%s",value);
		}
		else {
			System.out.printf("%s-",value);
		}
	}
}

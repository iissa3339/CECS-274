
public class Node {
	private String value;
	private Node next;
	
	public Node(String v){
		value = v;
		next = null;
	}
	
	public void setNext(Node node1) {
		next = node1;
	}
	
	public void setValue(String x) {
		value = x;
	}
	
	public Node getNext() {
		return next;
	}
	
	public String getValue() {
		return value;
	}
	
	public void display() {
		System.out.printf("%s ",value);
	}
}

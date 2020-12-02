
public class queue {
	private Node head;
	public queue(){
		head = null;
	}
	public void push(int x) {
		Node temp = new Node(x);
		if(head == null) {
			head = temp;
		}
		else {
			Node cur = head;
			while(cur.getNext() != null) {
				cur = cur.getNext();
			}
			cur.setNext(temp);
		}
	}
	public int pop() {
		int tempo = head.getValue();
		head = head.getNext();
		return tempo;
	}
	public void display() {
		Node temp = head;
		while (temp != null) {
			temp.display();
			temp = temp.getNext();
		}
	}
	public int size() {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}
	public boolean isEmpty() {
		if(head == null) {
			return true;
		}
		return false;
	}
}

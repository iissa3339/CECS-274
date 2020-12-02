
public class linkedList {
	private Node head;
	
	public linkedList() {
		head = null;
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
	// 4 cases to add
	public void add(String xy) {
		Node temp = new Node(xy);
		// insert to empty list
		if(head == null) {
			head = temp;
		}
		// insert to front of list
		else if(temp.getValue().compareTo(head.getValue()) < 0) {
			temp.setNext(head);
			head = temp;
		}
		// insert to inside in order. If it's the greatest value, insert to the end
		else {
			Node cur = head;
			while(cur.getNext() != null) {
				if (temp.getValue().compareTo(cur.getNext().getValue()) < 0) {
					Node nextUp = cur.getNext();
					cur.setNext(temp);
					cur.getNext().setNext(nextUp);
					break;
				}
				cur = cur.getNext();
			}
			if (cur.getNext() == null) {
				cur.setNext(temp);
			}
		}
	}
	public void remove(String yy) {
		Node temp = head;
		Node prev = null;
		Node next = null;
		while(temp.getValue().compareTo(yy) != 0) {
			prev = temp;
			temp = temp.getNext();
			if (temp == null) {
				System.out.println("Data entered was not found!");
				break;
			}
		}
		if(temp.getValue().compareTo(yy) == 0) {
			next = temp.getNext();
			prev.setNext(next);
		}
	}
	// Return the position, if not found, return a zero
	public int find(String toFind) {
		int position = 0;
		Node temp = head;
		while(temp != null) {
			position++;
			if (toFind.compareTo(temp.getValue()) == 0) {
				break;
			}
			temp = temp.getNext();
		}
		if (temp == null) {
			position = 0;
		}
		return position;
	}
	public void display() {
		// Count to display 12 columns and as many rows as needed
		int count = 0;
		Node temp = head;
		while (temp != null) {
			if (count % 12 == 0 && count != 0) {
				System.out.println();
			}
			temp.display();
			temp = temp.getNext();
			count++;
		}
	}
	public String getElement(int z) {
		Node tempo = head;
		for(int count = 0; count < z; count++) {
			tempo = tempo.getNext();
		}
		return tempo.getValue();
	}
}

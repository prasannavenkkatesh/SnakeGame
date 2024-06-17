package Snake;

public class SnakeList {
	
	Node head;
	
	public class Node{	
		int row;
		int col;
		Node next;
		
		Node(int row, int col){
			this.row = row;
			this.col = col;
			next = null;
		}

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}

		public int getCol() {
			return col;
		}

		public void setCol(int col) {
			this.col = col;
		}
		
		
	}
	
	
	
	public void addNode(int row, int col) {
		Node newNode = new Node(row, col);
		
		if(head == null) {
			head = newNode;
		}
		else {
			Node temp = head;
			newNode.next = temp;
			head = newNode;
		}
	}
	
	public void display() {
		Node cur = head;
		while(cur != null){
			System.out.println(cur.row+" "+cur.col);
			cur = cur.next;
		}
	}
	
	public void removeTail() {
		Node cur = head;
		Node prev = null;
		while(cur.next != null) {
			prev = cur;
			cur = cur.next;
		}
		prev.next = null;
	}
	
	
	public int getSize() {
		int count = 0;
		Node cur = head;
		while(cur != null) {
			cur = cur.next;
			count++;
		}
		return count;
	}
	
	public Node getTail() {
		Node cur = head;
		while(cur.next != null) {
			cur = cur.next;
		}
		return cur;
	}
	
	public Node getHead() {
		Node cur = head;
		if(cur!= null) {
			return cur;
		}
		else {
			System.out.println("Sanke head is empty...");
			return cur;
		}
	}

}

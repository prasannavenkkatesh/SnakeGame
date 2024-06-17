package Snake;

import Snake.SnakeList.Node;

public class Check {
	
	public static void main (String [] agrs) {
		
		SnakeList snake = new SnakeList();
		int row = 0, col = 0;
		snake.addNode(row, col);
		snake.display();
		System.out.println("Next");
		// D
		System.out.println("D");
		Node head = snake.getHead();
		snake.addNode(head.row+1, head.col);
		snake.removeTail();
		snake.display();
		System.out.println("Next");
		
		System.out.println("R");
		Node head2 = snake.getHead();
		snake.addNode(head2.row, head2.col+1);
		snake.removeTail();
		snake.display();
		System.out.println("Next");
		
		System.out.println("R");
		Node head3 = snake.getHead();
		snake.addNode(head3.row, head3.col+1);
		snake.removeTail();
		snake.display();
		System.out.println("Next");
		
	
		
	}

}

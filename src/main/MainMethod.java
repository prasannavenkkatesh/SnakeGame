package main;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import Snake.SnakeList;
import Snake.SnakeList.Node;

public class MainMethod {

	private static int[][] createBoard(int length, int width) {
		int[][] board = new int[length][width];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = -1;
			}
		}
		return board;
	}

	private static boolean isValid(int row, int col, int[][] board) {
		if ((row >= 0 && col >= 0) && (row <= board.length - 1 && col <= board[0].length - 1) && (board[row][col] != 1))
			return true;
		return false;
	}

	private static boolean isFood(int row, int col, int[][] board) {
		if (board[row][col] == 2)
			return true;
		return false;
	}

	private static void displayBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			System.out.print("|");
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 1)
					System.out.print("S|");
				else if (board[i][j] == 2)
					System.out.print("F|");
				else
					System.out.print(" |");
			}
			System.out.println();
		}
	}

	private static void displaY(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			System.out.print("|");
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] agrs) {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the length of the board");
		int length = input.nextInt();

		System.out.println("Enter the width of the board");
		int width = input.nextInt();

		System.out.println("Getting the board ready...");
		int[][] board = createBoard(length, width);

		System.out.println("Board Ready... Type anything to start the game...");
		input.nextLine();
		String status = input.nextLine();

//		SnakeList food = new SnakeList();
//		food.addNode(1, 2);
//		food.addNode(0, 1);
//		food.addNode(1, 0);

		Stack<String> food = new Stack<String>();
		food.add("10");
		food.add("01");
		food.add("12");

		SnakeList snake = new SnakeList();
		board[0][0] = 1;
		snake.addNode(0, 0);
		board[1][2] = 2;
		int row = 0, col = 0;

		while (!status.equals("END")) {

			if (food.isEmpty()) {
				System.out.println("You Win... Your Score: " + snake.getSize());
				status = "END";
				continue;
			}
			displayBoard(board);
//			System.out.println("BOARD");
//			displaY(board);
//			System.out.println("BOARD");

			System.out.println("Enter your next move: U/D/L/R");
			String nextMove = input.next();

			if (nextMove.equals("U")) {
				if (isValid(row - 1, col, board)) {
					Node head = snake.getHead();
					snake.addNode(head.getRow() - 1, head.getCol());

					if (!isFood(row - 1, col, board)) {
						Node tail = snake.getTail(); // remove tail and simultaneously dereference the board with value
														// -1
						int oldRow = tail.getRow();
						int oldCol = tail.getCol();
						board[oldRow][oldCol] = -1;
						snake.removeTail();
					} else {
						food.pop();
						if (!food.isEmpty()) {
							String foodIndex = food.peek();
							int foodRow = Character.getNumericValue(foodIndex.charAt(0));
							int foodCol = Character.getNumericValue(foodIndex.charAt(1));
							board[foodRow][foodCol] = 2;
						}
					}
					board[row - 1][col] = 1;
					row = row - 1;
				} else {
					System.out.println("Game Over... Your SCORE is: " + snake.getSize());
					status = "END";
				}
			} else if (nextMove.equals("D")) {
				if (isValid(row + 1, col, board)) {
					Node head = snake.getHead();
					snake.addNode(head.getRow() + 1, head.getCol());

					if (!isFood(row + 1, col, board)) {
						Node tail = snake.getTail(); // remove tail and simultaneously dereference the board with value
														// -1

						int oldRow = tail.getRow();
						int oldCol = tail.getCol();
						board[oldRow][oldCol] = -1;
						snake.removeTail();
					} else {
						food.pop();
						if (!food.isEmpty()) {
							String foodIndex = food.peek();
							int foodRow = Character.getNumericValue(foodIndex.charAt(0));
							int foodCol = Character.getNumericValue(foodIndex.charAt(1));
							board[foodRow][foodCol] = 2;
						}
					}
					board[row + 1][col] = 1;
					row = row + 1;
				} else {
					System.out.println("Game Over... Your SCORE is: " + snake.getSize());
					status = "END";
				}
			} else if (nextMove.equals("L")) {
				if (isValid(row, col - 1, board)) {
					Node head = snake.getHead();
					snake.addNode(head.getRow(), head.getCol() - 1);

					if (!isFood(row, col - 1, board)) {
						Node tail = snake.getTail(); // remove tail and simultaneously dereference the board with value
														// -1
						int oldRow = tail.getRow();
						int oldCol = tail.getCol();
						board[oldRow][oldCol] = -1;
						snake.removeTail();
					} else {
						food.pop();
						if (!food.isEmpty()) {
							String foodIndex = food.peek();
							int foodRow = Character.getNumericValue(foodIndex.charAt(0));
							int foodCol = Character.getNumericValue(foodIndex.charAt(1));
							board[foodRow][foodCol] = 2;
						}
					}
					board[row][col - 1] = 1;
					col = col - 1;
				} else {
					System.out.println("Game Over... Your SCORE is: " + snake.getSize());
					status = "END";
				}
			} else if (nextMove.equals("R")) {
				if (isValid(row, col + 1, board)) {
					Node head = snake.getHead();
					snake.addNode(head.getRow(), head.getCol() + 1);

					if (!isFood(row, col + 1, board)) {
						Node tail = snake.getTail(); // remove tail and simultaneously dereference the board with value
														// -1
						int oldRow = tail.getRow();
						int oldCol = tail.getCol();
						board[oldRow][oldCol] = -1;
						snake.removeTail();
					} else {
						food.pop();
						if (!food.isEmpty()) {
							String foodIndex = food.peek();
							int foodRow = Character.getNumericValue(foodIndex.charAt(0));
							int foodCol = Character.getNumericValue(foodIndex.charAt(1));
							board[foodRow][foodCol] = 2;
						}
					}
					board[row][col + 1] = 1;
					col = col + 1;
				} else {
					System.out.println("Game Over... Your SCORE is: " + snake.getSize());
					status = "END";
				}

			}

		}

	}
}

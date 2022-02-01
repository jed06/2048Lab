import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Board {

	private int[][] board; // holds state of game
	private Random rnd = new Random(); // setup random # generator
	boolean isFull = false;

	// What instance variable can you add to keep track of the size or the number of
	// tiles occupied?

	/* default constructor for board */
	// constructors must match exactly the name
	// of the class.
	public Board() {

		// instantiate the board
		board = new int[4][4];
		populateOne();
		populateOne();
	}

	public void combineDown() {
		for (int col = 0; col < board.length; col++) {
			int arr[] = getCol(board, col); // Get Column as Array

			combineRight(arr);

			for (int row = 0; row < board.length; row++) {
				board[row][col] = arr[row];
			}
		}
	}

	public void combineLeft() {
		for (int row = 0; row < board.length; row++) {
			combineLeft(board[row]);
		}
	}

	public void combineLeft(int[] array) {
		for (int col = 0; col < array.length - 1; col++) {
			if (array[col] == array[col + 1]) {
				array[col] += array[col];
				array[col + 1] = 0;
			}
		}
	}

	public void combineRight() {
		for (int row = 0; row < board.length; row++) {
			combineRight(board[row]);
		}
	}

	public void combineRight(int[] arr) {

		for (int col = arr.length - 1; col > 0; col--) {
			if (arr[col] == arr[col - 1]) {
				arr[col] += arr[col - 1];
				arr[col - 1] = 0;
			}
		}
	}

	public void combineUp() {
		for (int col = 0; col < board.length; col++) {
			int arr[] = getCol(board, col); // Get Column as Array

			combineLeft(arr);

			for (int row = 0; row < board.length; row++) {
				board[row][col] = arr[row];
			}
		}
	}

	public void down() {
		slideDown();
		combineDown();
		slideDown();
	}

	public void eraseBoard() {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = 0;
			}
		}
	}

	public int[][] getBoard() {
		return board;
	}

	public int[] getCol(int[][] data, int c) {
		int[] a = new int[data.length];
		for (int i = 0; i < data.length; i++) {
			a[i] = data[i][c];
		}
		return a;
	}

	public void left() {
		slideLeft();
		combineLeft();
		slideLeft();

	}

	// populate with a given 2d array
	public void populate(int[][] arr) {
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				board[r][c] = arr[r][c];
			}
		}
	}

	public void populateOne() {
		int rndrow = rnd.nextInt(4);
		int rndcol = rnd.nextInt(4);
		int randomNum = rnd.nextInt(100);
		for (int row = 0; row < 1000; row++) {
			if (board[rndrow][rndcol] == 0) {
				if (randomNum <= 90) {
					board[rndrow][rndcol] = 2;
				} else {
					board[rndrow][rndcol] = 4;
				}
				return;
			} else {
				rndrow = rnd.nextInt(4);
				rndcol = rnd.nextInt(4);
				randomNum = rnd.nextInt(100);
			}
		}
	}

	public void right() {
		slideRight();
		combineRight();
		slideRight();
	}

	public void slideDown() {

		for (int col = 0; col < board.length; col++) {
			int array[] = new int[4];
			array = getCol(board, col);
			slideDown(array);
			for (int row = 0; row < board.length; row++) {
				board[row][col] = array[row];
			}
		}
	}

	public void slideDown(int[] arr) {
		slideRight(arr);
	}

	public void slideLeft() {
		for (int i = 0; i < board.length; i++) {
			slideLeft(board[i]);
		}
	}

	public void slideLeft(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] == 0) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public void slideRight() {
		for (int i = 0; i < board.length; i++) {
			slideRight(board[i]);
		}
	}

	public void slideRight(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j + 1] == 0) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public void slideUp() {
		for (int col = 0; col < board.length; col++) {
			int array[] = getCol(board, col);
			slideUp(array);
			for (int row = 0; row < board.length; row++) {
				board[row][col] = array[row];
			}
		}
	}

	public void slideUp(int[] arr) {
		slideLeft(arr);
	}

	public String toString() {

		String builder = String.format("");

		builder += String.format("");
		builder += "";
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				builder += String.format("%04d", board[row][col]);
				builder += " ";
			}
			builder += "\n";
		}
		return builder;
	}

	public void up() {
		slideUp();
		combineUp();
		slideUp();
	}

}

import java.util.Arrays;

public class Activity4Tester {

	static int board[][] = {{2,2,2,2},
							{0,0,2,0},
							{0,2,0,0},
							{2,0,0,0}};
	// {[2, 2, 2, 2],[2, 2, 2, 0],[0, 0, 0, 0],[0, 0, 0, 0],}	
	public static void main(String[] args) {
		
		// Create a Board object
//		Board b = new Board();
		//slideLeft(board[1]);
		//print();
		//int[] arr = getCol(board, 0);
//		for (int row = 0; row < board.length; row++) {
//			int[] arr = getCol(board, row);
//			slideLeft(arr);
//			System.out.println(Arrays.toString(arr));
//
//		}
		slideUp();
		print();
		
	}
	
	public static void print() {
		String builder = String.format("");
		builder += String.format("");
		builder += "";
		//setup loops to visit
		//every spot possible
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				builder += String.format("%04d", board[row][col]);
				builder += " ";
			}
			builder +="\n";
		}
		
		
		System.out.println(builder);
	}
	//{128,0,64,32}
	
	public static void slideLeft(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j= 0; j < arr.length-1; j++) {
				if (arr[j] == 0) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}	
			}
		}	
	}
	
public static int[] getCol(int[][] data, int c) {
		
		//you can also add print out statements here
		int [] a = new int[data.length];
		for (int i = 0; i < data.length; i++) {
			a[i] = data[i][c];
		}
		return a;
		
		
	}
	
	public static void combineUp(int [] array) {
		for (int i = 0; i < array.length-1; i++) {
			if (array[i] == array[i+1]) {
				array[i] += array[i];
				array[i+1] = 0;
			}
		}
	}
	
	public static void slideUp(int[] arr) {
		/* calls a helper method */
		// do not rewrite logic you already have!
		slideLeft(arr);
	
	}
	
	public static void slideUp() {
		
		//visit every column index
		//grab each column as an array using getCol -> keep track of it in a 1d array
		// variable/reference
		//have slideLeft perform manipulation on the array
		// copy over the 1D array representation of the column
		// back to the 2D board array
		for (int col = 0; col < board.length; col++) {
			int array [] = getCol(board, col);
			slideUp(array);
			//System.out.println(Arrays.toString(array));
			for(int row = 0; row < board.length; row++) {
				board[row][col] = array[row];
			}
		}	
	}
	public static void up() {
		slideUp();
		//combineUp();
		//slideUp();
	}
	
}

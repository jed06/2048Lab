
public class Activity1Tester {

	static int board[][] = {{2,2,0,2},
							{2,2,2,2},
							{128,128,64,32},
							{4,4,2,2}};
	// {[0, 0, 2, 4],[0, 0, 4, 4],[0, 256, 64, 32],[0, 0, 8, 4],}	
	public static void main(String[] args) {
		
		// Create a Board object
		Board b = new Board();
		right();
		print();
		
		// invoke the toString method by passing the object to 
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
	public static void slideRight(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j= 0; j < arr.length-1; j++) {
				if (arr[j+1] == 0) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}	
			}
		}	
	}

	public static void slideRight() {
		for (int i = 0; i < board.length; i++) {
			slideRight(board[i]);
		}
	}
	
	public static void combineRight() {
		for (int row = 0; row < board.length; row++) {
			for (int col = board.length-1; col > 0; col--) {
				if (board[row][col] == board[row][col-1]) {
					board[row][col] += board[row][col-1];
					board[row][col-1] = 0;
				}
			}
		}
	}
	
	
	public static void right() {
		slideRight();
		combineRight();
		slideRight();
		
	}
	
}

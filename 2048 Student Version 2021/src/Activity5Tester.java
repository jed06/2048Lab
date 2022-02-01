public class Activity5Tester {

	public int nextMove(int[][] b) {
		int move = 0;
		int sum = 0;
		for (int row = 0; row < b.length - 1; row++) {
			for (int col = 0; col < b.length - 1; col++) {
				sum = 0;
				// if (b[row][col] != 0){
				if (b[row][col] == b[row][col + 1]) {
					sum = b[row][col] + b[row][col + 1];
					move = 1;
				}

				// }
			}
		}

		for (int col = 0; col < b.length; col++) {
			int[] arr = getCol(b, col);
			for (int i = 0; i < b.length - 1; i++) {
				if (arr[i] == arr[i + 1]) {
					int colSum = arr[i] + arr[i + 1];
					if (colSum > sum) {
						sum = colSum;
						move = 3;
					}
				}
			}
		}
		
		for (int col = 0; col < b.length; col++) {
			int[] arr = getCol(b, col);
			for (int i = b.length-1; i > 0; i--) {
				if (arr[i] == arr[i - 1]) {
					int colSum = arr[i] + arr[i - 1];
					if (colSum > sum) {
						sum = colSum;
						move = 2;
					}
				}
			}
		}
		return move;
	}

	public int[] getCol(int[][] data, int c) {
		int[] a = new int[data.length];
		for (int i = 0; i < data.length; i++) {
			a[i] = data[i][c];
		}
		return a;
	}
}

import java.util.Arrays;

public class Activity3Tester {

	public static void main(String[] args) {
		Board b = new Board();
		int [][] array = {{2,2,4,0}, {0,2,2,4}, {2,0,0,0}, {0,0,0,0}};
		int result [] = b.getCol(array, 0);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		slideLeft(result);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		for(int row = 0; row < array.length; row++) {
			array[row][0] = result[row];
			
		}
		result = b.getCol(array, 0);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
	
	
	
	public static void slideLeft(int[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] != 0) {
				for (int j = i-1; j >= 0; j--) {
					if (arr[j] == 0) {
						arr[j] = arr[i];
						arr[i] = 0;
					}
				}
			}
		}	
		
		
	}

}
		

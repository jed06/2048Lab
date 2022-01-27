import java.util.Arrays;

public class Activity3Tester {

	public static void main(String[] args) {
		
		//Declare a Board object
		Board b = new Board();
		//create an array with some values you want to 
		//slideRight. ie [2 0 0 0]
		
		int a[][] = {{2, 0, 2, 0},
					 {2, 2, 2, 2},
					 {2, 4, 0, 5}};
		
		
		int [] array = {0,2,0,2};
		//System.out.println(result);
		//invoke the slideRight method on the array 
		b.slideUp(array);
		
		for (int val : array) {
			System.out.println(val);
		}
	}	
}
		

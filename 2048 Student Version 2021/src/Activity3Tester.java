import java.util.Arrays;

public class Activity3Tester {

	public static void main(String[] args) {
		
		//Declare a Board object
		Board b = new Board();
		//create an array with some values you want to 
		//slideRight. ie [2 0 0 0]
		
		int a[] = {2, 0, 2, 0};
		slideLeft(a); 
		System.out.println();
		
		//invoke the slideRight method on the array 
		
		
		//print out the array to see if slideRight
		//worked
		
		
	}
	
	public static void SlideRight(int[] a) {
		for(int i=0; i < a.length ; i++){
			if(a[i] != 0) {
				for(int j = i+1; j < a.length ; j++) {
					if(a[j] == 0) {
						a[j] = a[i];
						a[i] = 0;
					}
				}
			}
		}
		
		System.out.println(Arrays.toString(a));
	}
	
	public static void slideLeft(int[]a) {
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] != 0) {
				for (int j = i-1; j >= 0; j--) {
					if (a[j] == 0) {
						a[j] = a[i];
						a[i] = 0;
					}
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}

}

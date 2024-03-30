package ds.arrays;

public class RotateArray {
	
	public static void main(String[] args) {
		
		int[] a = {1 , 2, 3, 4, 5, 6 } ;
		
		for (int i = 0; i < 7; i++) {
			leftRotate(a);
		}
		
		leftRotate(a);
		printArray(a);
	}


	private static void rightRotate(int[] a) {
		
	}


	private static void leftRotate(int[] a) {

		if (a.length == 0) return;
		
		int temp = a[0];
		for (int j = 1; j < a.length; j++) {
			a[j-1] = a[j];
		}
		
		a[a.length-1] = temp;
	}
	
	

	private static void printArray(int[] a) {

		for (int i : a) {
			System.out.print(i + " ");
		}
	}
}

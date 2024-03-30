package ds.arrays;

import java.util.Random;

public class InsertionSort {
	
	public static void main(String[] args) {
		
		int[] arr = generateRandomArray(10);
		sort(arr);
		print(arr);
		
	}
	
	public static void sort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {

			int hole = i;
			int temp = arr[i];
			while (hole > 0 && arr[hole - 1] > temp) {
				arr[hole] = arr[hole - 1];
				hole--;
			}
			
			arr[hole] = temp;
		}
	}

	private static int[] generateRandomArray(int len) {
		int[] a = new int[len];
		for (int j = 0; j < len; j++) {
			a[j] = new Random().nextInt(100);
		}
		return a;
	}

	private static void print(int[] nums) {
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}

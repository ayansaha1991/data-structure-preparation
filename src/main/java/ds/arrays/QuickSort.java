package ds.arrays;

import java.util.Random;

/**
 * Find partition index and divide the array in two parts in a way that left of
 * partition contains items lesser than it, and right side contains items
 * greater than it. Find partition index in the divided left , right half.
 * Continue until array is completed.
 * 
 * @author K7BL
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] randomArray = generateRandomArray(10000);
		long start = System.currentTimeMillis();
		sort(randomArray, 0, randomArray.length - 1);
		System.out.println("Time taken: " + (System.currentTimeMillis() - start) + "ms");
		print(randomArray);
	}

	public static void sort(int[] arr, int start, int end) {

		if (start >= end) {
			return;
		}

		int pInd = partition(arr, start, end);
		sort(arr, 0, pInd - 1);
		sort(arr, pInd + 1, end);
	}

	private static int partition(int[] arr, int start, int end) {
		int pInd = start;
		int pivot = arr[end];

		for (int i = start; i < end; i++) {

			if (arr[i] <= pivot) {
				swap(arr, pInd, i);
				pInd++;
			}
		}

		swap(arr, pInd, end);

		return pInd;
	}

	private static void swap(int[] a, int i, int pInd) {
		int temp = a[i];
		a[i] = a[pInd];
		a[pInd] = temp;
	}

	private static void print(int[] nums) {
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static int[] generateRandomArray(int len) {
		int[] a = new int[len];
		for (int j = 0; j < len; j++) {
			a[j] = new Random().nextInt(20);
		}
		return a;
	}
}

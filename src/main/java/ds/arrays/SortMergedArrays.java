package ds.arrays;

import java.util.Random;

public class SortMergedArrays {

	public static void main(String[] args) {
		
		int[] a = generateRandomArray(5);
		int[] b = generateRandomArray(3);
		
		int na = a.length;
		int nb = b.length;
		
		int[] mergedArray = mergeWithExtraSpace(a, na, b, nb);
		print(mergedArray);
		
		System.out.println("------------");
		mergeWithoutExtraSpace(a, na, b, nb);
		print(a);
		print(b);
	}
	
	private static void mergeWithoutExtraSpace(int[] a, int na, int[] b, int nb) {
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] > b[0]) {
				swap(a, i, b, 0);
				InsertionSort.sort(b);
			}
			
		}
		
	}

	private static void swap(int[] a, int i, int[] b, int j) {

		int temp = a[i];
		a[i] = b[j];
		b[j] = temp;
	}

	private static void swap(int[] a, int i, int j) {

		
	}

	

	private static int[] mergeWithExtraSpace(int[] a, int na, int[] b, int nb) {
		
		int[] result = new int[a.length + b.length];
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < na && j < nb) {
			
			if (a[i] < b[j]) {
				result[k] = a[i];
				i++; k++;
			} else {
				result[k] = b[j];
				j++; k++;
			}
			
		}
		
		for (int k2 = i; k2 < na; k2++) {
			result[k] = a[k2];
			k++;
		}

		for (int k2 = j; k2 < nb; k2++) {
			result[k] = b[k2];
			k++;
		}
		
		return result;
	}
	
	private static int[] generateRandomArray(int len) {
		int[] a = new int[len];
		for (int j = 0; j < len; j++) {
			a[j] = new Random().nextInt(20);
		}
		QuickSort.sort(a, 0, len-1); 
		return a;
	}
	
	private static void print(int[] nums) {
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}

package ds.arrays;

import java.util.Iterator;
import java.util.Random;

public class MergeSort {

	public static void main(String[] args) {
		int[] nums = generateRandomArray(1000) ;
//		print(nums);
//		sort(nums);
		practise_sort(nums);
		print(nums);
	}

	private static void sort(int[] nums) {
		
		int len = nums.length;
		
		if (len < 2 ) {
			return;
		}
		
		int mid = len/2;
		
		int[] l = new int[mid];
		int[] r = new int[len-mid];
		
		for (int i = 0; i < mid; i++) {
			l[i] = nums[i];
		}
		
		for (int j = mid; j < len; j++) {
			r[j-mid] = nums[j];
		}
		
		sort(l);
		sort(r);
		
		merge(l, r, nums);
		
//		print(l);
//		print(r);
		
	}

	private static void merge(int[] l, int[] r, int[] nums) {

		int i = 0;
		int j = 0;
		int k = 0;
		
		int nL = l.length;
		int nR = r.length;
		
		while (i < nL && j < nR) {
			
			if(l[i] < r[j]) {
				
				nums[k] = l[i];
				k++; i++;
			} else {
				nums[k] = r[j];
				k++; j++;
			}
		}
		
		for (int m = i; m < nL; m++) {
			nums[k] = l[m];
			k++;
		}

		for (int m = j; m < nR; m++) {
			nums[k] = r[m];
			k++;
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
	
	private static void practise_sort(int[] nums) {
		
		if (nums.length < 2) {
			return;
		}
		
		int len = nums.length;
		int mid = (len/2);
		
		int[] left = new int[mid];
		int[] right = new int[len-mid];
		
		for (int i = 0; i < mid; i++) {
			left[i] = nums[i];
		}
		for (int j = mid; j < len; j++) {
			right[j-mid] = nums[j];
		}
		
		practise_sort(left);
		practise_sort(right);
		
		practise_merge(left, right, nums);
		
		
	}

	private static void practise_merge(int[] left, int[] right, int[] nums) {

		int i=0, j=0, k=0;
		
		while (i<left.length && j <right.length) {
			
			if (left[i] <= right[j]) {
				nums[k] = left[i];
				k++; i++;
			}  else  {
				nums[k] = right[j];
				k++; j++;
			}
		}
		
		for (int k2 = i; k2 < left.length; k2++) {
			nums[k] = left[k2];
			k++;
		}
		
		for (int k2 = j; k2 < right.length; k2++) {
			nums[k] = right[k2];
			k++;
		}
		
	}
	
	
}

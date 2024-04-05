package ds.arrays;

import java.util.Random;

public class InvertionCount {

	public static void main(String[] args) {
		long[] nums = {5,3,2,1,4} ;
		//print(nums);
		long invCount = sort(nums);
		System.out.println(invCount);
	}

	private static long sort(long[] arr) {
		
		int len = arr.length;
		long invCount = 0;
		
		if (len > 1 ) {
			
			int mid = len/2;
			
			long[] l = new long[mid];
			long[] r = new long[len-mid];
			
			for (int i = 0; i < mid; i++) {
				l[i] = arr[i];
			}
			
			for (int i = mid; i < len; i++) {
				r[i-mid] = arr[i];
			}

			invCount =  invCount + sort(r);
			invCount = invCount + sort(l);

			invCount = invCount + merge(l, r, arr);
		}
		
		return invCount;
		
	}

	private static long merge(long[] l, long[] r, long[] nums) {

		int i = 0;
		int j = 0;
		int k = 0;
		int invCount = 0;
		
		int nL = l.length;
		int nR = r.length;
		
		while (i < nL && j < nR) {
			
			if(l[i] < r[j]) {
				
				nums[k] = l[i];
				k++; i++;
			} else {

				nums[k] = r[j];
				k++; j++;
				invCount = invCount + (nL-i);
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
		
		return invCount;
		
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

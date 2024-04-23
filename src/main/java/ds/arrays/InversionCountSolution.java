package ds.arrays;

import ds.utils.ArrayUtils;

public class InversionCountSolution {
	public static void main(String[] args) {
		int[] generateRandomArray = ArrayUtils.generateRandomArray(100);
		int[] a = {5,3,2,1,4};
		System.out.println(numberOfInversions(a, a.length));;
//		int numberOfInversions = numberOfInversions(a, a.length);
		//ArrayUtils.print(generateRandomArray);
//		System.out.println(numberOfInversions);
	}
	
	public static int numberOfInversions(int []a, int n) {
		int invCount = 0;

		if (a.length == 1) {
			return 0;
		}

		int mid = n/2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
		}

		for (int i = mid; i < n; i++) {
			right[i-mid] = a[i];
		}

		invCount = invCount + numberOfInversions(left, left.length);
		invCount = invCount + numberOfInversions(right, right.length);

		invCount = invCount + merge(left, right, a);

		return invCount;
    }

	private static int merge(int[] left, int[] right, int[] a) {

		int i = 0, j= 0, k=0;
		int invCount = 0;

		while (i < left.length && j < right.length) {

			if (left[i] <= right[j]){
				a[k] = left[i];
				k++; i++;
			} else if (left[i] > right[j]) {
				a[k] = right[j];
				k++; j++;
				invCount = invCount + (left.length-i);
			}


		}

		for (int l = i; l < left.length; l++) {
			a[k] = left[l];
			k++;
		}
		for (int l = j; l < right.length; l++) {
			a[k] = right[l];
			k++;
		}

		return invCount;

	}


}
package ds.arrays;

import ds.utils.ArrayUtils;

public class InversionCountSolution {
	public static void main(String[] args) {
		int[] generateRandomArray = ArrayUtils.generateRandomArray(100);
		int[] test = {4, 3,2, 1};
		int numberOfInversions = numberOfInversions(test, test.length);
		//ArrayUtils.print(generateRandomArray);
		System.out.println(numberOfInversions);
	}
	
	public static int numberOfInversions(int []a, int n) {
		
		if (n < 2) return 0;
		
		int cnt = 0;
		
		int mid = n/2;
		int[] l = new int[mid];
		int[] r = new int[n-mid];
 		
		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}

		for (int i = mid; i < n; i++) {
			r[i-mid] = a[i];
		}
		
		cnt = cnt + numberOfInversions(l, l.length);
		cnt = cnt + numberOfInversions(r, r.length);
		
		int inversionCount = cnt +  mergeNumberOfInversion(l, r, a);
		
        return inversionCount;
    }

	private static int mergeNumberOfInversion(int[] l, int[] r, int[] a) {

		int i=0, j=0, k=0;
		int count = 0;
		
		while(i<l.length && j<r.length ) {
			
			if (l[i] <= r[j]) {
				a[k] = l[i];
				k++; i++;
			} else {
				// inverse pair
				a[k] = r[j];
				k++; j++;
				count = count  + (l.length-i);
			}
			
		}
		
		for (int k2 = i; k2 < l.length; k2++) {
			a[k] = l[k2]; k++;
		}

		for (int k2 = j; k2 < r.length; k2++) {
			a[k] = r[k2]; k++;
		}
		
		return count;
	}
	
	
}
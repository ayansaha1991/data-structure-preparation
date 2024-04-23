package ds.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithZeroSum {

	public static void main(String[] args) {
		
		int[] nums = {0, 1, 1, 1} ;
		
		System.out.println(findLongestSubarray(nums, 0));
	}

	private static int findLongestSubarray(int[] arr, int n) {
		
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int maxLenWithZeroSum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			sum = sum + arr[i];
			
			if (sum == n && i > maxLenWithZeroSum ) {
				maxLenWithZeroSum = i+1;
			}
			
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			} else {
				
				int foundSameSumAt = map.get(sum);
				int arrayLen = (i - foundSameSumAt );
				
				if (arrayLen > maxLenWithZeroSum) {
					maxLenWithZeroSum = arrayLen;
				}
			}
		}

		return maxLenWithZeroSum;
	}
}

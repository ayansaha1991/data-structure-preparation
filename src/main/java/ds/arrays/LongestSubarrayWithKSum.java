package ds.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithKSum {

	public static void main(String[] args) {
		
		int[] nums = {1, 2} ;
		
		findKsum(nums, 3);
	}

	private static void findKsum(int[] nums, int k) {

		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int maxLen = 0;
		
		for (int i = 0; i < nums.length; i++) {
			
			sum = sum + nums[i];

			if (sum == k) {
				maxLen = i+1;
			}
			
			if (!map.containsKey(k)) {
				map.put(sum, i);
			} else {
				Integer sumAt = map.get(sum);
				//maxLen = (i - sumAt + );
			}
		}
	}
}

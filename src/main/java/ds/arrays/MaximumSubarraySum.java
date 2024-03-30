package ds.arrays;

import java.util.ArrayList;
import java.util.List;

import ds.utils.ArrayUtils;

/**
 * Kadane's algorithm to find maximum sum from an array that may include
 * negative nos.
 * 
 * @author K7BL
 *
 */
public class MaximumSubarraySum {

	public static void main(String[] args) {

		int[] a = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		ArrayList<Integer> r = new ArrayList<>();
		int max = maxSubArray(a, r);
		System.out.println(max);
		System.out.println(r);
	}

	public static int maxSubArray(int[] nums, List<Integer> sub) {

		if (nums.length == 0) {
			return 0;
		}

		int max = nums[0];
		int sum = 0;

		for (int k = 0; k < nums.length; k++) {

			sum = sum + nums[k];
			if (sum > max) {
				max = sum;
				sub.add(nums[k]);
			}

			if (sum < 0) {
				sum = 0;
				sub.clear();
			}

		}

		return max;
	}

}

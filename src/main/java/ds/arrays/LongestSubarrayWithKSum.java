package ds.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithKSum {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 1, 1};

        System.out.println(findKsum(nums, 6));
    }

    private static int findKsum(int[] nums, int k) {

        int prefixSum = 0;
        Map<Integer, Integer> prefixSumIndex = new HashMap<>();
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            prefixSum = prefixSum + nums[i];

            if (prefixSum == k) {
                maxLen = i + 1;
            } else if (prefixSumIndex.containsKey(prefixSum-k)) {
                int sumAtIndex = prefixSumIndex.get(prefixSum -k);
                int currentArrayLen = (i - sumAtIndex);
                if (currentArrayLen > maxLen) {
                    maxLen = currentArrayLen;
                }
            }

            // Not updating the index because we want the first index that stores the prefixSum to get the longest array size
            if (!prefixSumIndex.containsKey(prefixSum)) {
                prefixSumIndex.put(prefixSum, i);
            }
        }
        return maxLen;
    }
}

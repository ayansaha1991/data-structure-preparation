package ds.arrays;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraySumEqualsK {
    public static void main(String[] args) {
        int[] n = { 1, 1, 1 };//{ 1, 2, 3, -3 , 1, 1 , 1, 4, 2, -3  };//{1};
        int k = 2;
        int count = countSubarraySumEqualsK(n, k);
        System.out.println(count);
    }

    private static int countSubarraySumEqualsK(int[] nums, int k) {

        if (nums.length == 0 ) return  0;
        if (nums.length == 1 && nums[0] == k) {
            return 1;
        }

        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int remove = (prefixSum - k);
            if (prefixSumMap.containsKey(remove)) {
                count += prefixSumMap.get(remove);
            }
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) +1);
        }

        return count;
    }
}

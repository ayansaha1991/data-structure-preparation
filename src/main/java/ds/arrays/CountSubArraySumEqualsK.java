package ds.arrays;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraySumEqualsK {
    public static void main(String[] args) {
        int[] n = { -1, -1, 1 };//{ 1, 2, 3, -3 , 1, 1 , 1, 4, 2, -3  };//{1};
        int k = 0;
        int count = countSubarraySumEqualsK(n, k);
        System.out.println(count);
    }

    private static int countSubarraySumEqualsK(int[] arr, int s) {

        if (arr.length == 0 ) return  0;
        if (arr.length == 1 && arr[0] == s) {
            return 1;
        }

        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (!prefixSumMap.containsKey(prefixSum)) {
                prefixSumMap.putIfAbsent(prefixSum, 1);
            } else {
                prefixSumMap.computeIfPresent(prefixSum, (key, oldSum) -> oldSum+1 );
            }
            int toRemove = (prefixSum - s);
            if (s == 0) toRemove = 0-toRemove;

            count = count + prefixSumMap.getOrDefault(toRemove, 0);
        }
        return count;
    }
}

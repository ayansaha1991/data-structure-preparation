package ds.arrays;

import ds.utils.ArrayUtils;

import static ds.utils.ArrayUtils.*;
import static java.lang.Math.max;

public class MaximumProductSubarray {
    public static void main(String[] args) {

        int[] a = generateRandomArrayIncludingNegativeNumbers(10);
        print(a);
        int maxProductSubarray = findMaxProductSubarray(a);
        System.out.println("Subarray product = %d".formatted(maxProductSubarray));
    }

    private static int findMaxProductSubarray(int[] nums) {

        if (nums.length == 0 ) return 0;
        if (nums.length == 1 ) return nums[0];

        int max = Integer.MIN_VALUE;
        int prefixProduct = 1;
        int suffixProduct = 1;

        for (int i = 0; i < nums.length; i++) {

            if (prefixProduct == 0) prefixProduct = 1;
            if (suffixProduct == 0) suffixProduct = 1;

            prefixProduct = prefixProduct * nums[i];
            suffixProduct = suffixProduct * nums[nums.length- i-1];

            max = max(max, max(prefixProduct, suffixProduct));
        }

        return max;

    }


}

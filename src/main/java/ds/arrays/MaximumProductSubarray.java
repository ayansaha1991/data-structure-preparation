package ds.arrays;

import ds.utils.ArrayUtils;

import static ds.utils.ArrayUtils.*;
import static java.lang.Math.max;

public class MaximumProductSubarray {
    public static void main(String[] args) {

        int[] a = generateRandomArrayIncludingNegativeNumbers(10);
        print(a);
        int maxProductSubarray = findMaxProductSubarray2(a);
        System.out.println();
//        System.out.println("Subarray product = %d".formatted(findMaxProductSubarray(a)));
//        System.out.println("Subarray product = %d".formatted(findMaxProductSubarray2(a)));
        for (int i = 0; i < 1000; i++) {
            int[] a1 = generateRandomArrayIncludingNegativeNumbers(10);
            if (findMaxProductSubarray2(a1) != findMaxProductSubarray(a1)) {
                System.out.println("Wrong!");
            }
        }
    }

    private static int findMaxProductSubarray2(int[] a) {

        int prefixProduct = 1;
        int suffixProduct = 1;
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {

            if (prefixProduct == 0) {
                prefixProduct = 1;
            }

            if (suffixProduct == 0) {
                suffixProduct = 1;
            }

            prefixProduct = prefixProduct * a[i];
            suffixProduct = suffixProduct * a[a.length-1-i];
            maxProduct = Math.max(maxProduct, Math.max(prefixProduct, suffixProduct));
        }

        return maxProduct;

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

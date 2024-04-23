package ds.arrays;

import ds.utils.ArrayUtils;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] a = ArrayUtils.generateRandomArray(5);
        int result = findTrappedRainWater(a);
        ArrayUtils.print(a);
        System.out.println();
        System.out.println(result);
    }

    private static int findTrappedRainWater(int[] height) {

        int low = 0;
        int high = height.length -1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;

        while (low < high) {

            if (height[low] <= height[high]) {

                if (height[low] > leftMax) {
                    leftMax = height[low];
                } else {
                    result += leftMax - height[low];
                }
                low++;

            } else {
                if (height[high] > rightMax) {
                    rightMax = height[high];
                    high--;
                } else {
                    result += rightMax - height[high];
                    high--;
                }
            }

        }


        return result;
    }
}

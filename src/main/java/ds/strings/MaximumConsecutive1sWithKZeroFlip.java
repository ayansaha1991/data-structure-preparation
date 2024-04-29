package ds.strings;

public class MaximumConsecutive1sWithKZeroFlip {
    public static void main(String[] args) {
        int[] a = { 0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1 };
        int k = 3;
        System.out.println(longestOnes(a, k));;
    }

    private static int longestOnes(int[] nums, int k) {
        int l = 0 , r = 0, i=0, max = Integer.MIN_VALUE;

        while (l <= r && r < nums.length) {
            if (nums[r] == 0){
                i++;
                if (i > k) {
                    while (i > k && l <=r ) {
                        if (nums[l] == 0) {
                            i = i -1;
                        }
                        l = l + 1;
                    }
                }
            }
            max = Math.max(max, (r - l + 1));
            r++;
        }
        return max;
    }
}

package ds.recursion;

import ds.utils.ArrayUtils;

import static ds.arrays.ReverseArray.swap;

public class ReverseArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        reverseRecursive(a, 0, a.length - 1);
        ArrayUtils.print(a);
    }

    public static void reverseRecursive(int[] a, int start, int end) {

        if (start > end) {
            return;
        }

        swap(a, start, end);

        reverseRecursive(a, ++start, --end);
    }
    private static void reverse(int[] a, int start, int end) {

        while (start < end) {
            swap(a, start, end);
            start++; end--;
        }
    }
}

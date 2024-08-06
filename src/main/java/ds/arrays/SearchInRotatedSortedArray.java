package ds.arrays;

import ds.utils.ArrayUtils;

/**
 * Algorithm works with a modified binary search method.
 * Observation - At any point one half left or right of middle element is sorted.
 * We find out which half is sorted. To check if left half is sorted check if start item is less than middle item.
 * Else It is sorted in other half .
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2,3};
        int searchIndex = search(arr, 6);
        ArrayUtils.print(arr);
        System.out.println();
        System.out.println(searchIndex == -1 ? -1 : searchIndex+1);
    }

    private static int search(int[] a, int k) {

        int low = 0, high = a.length - 1;

        while (low <= high) {
            int mid = (low + high)/2;
            if (a[mid] == k) {
                return mid;
            }
            // find which half is sorted
            if (a[low] <= a[mid]) {
                //if the number is within low to mid range
                if (k >= a[low] && k <= a[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else if (a[mid] <= a[high]) {
                if (k >= a[mid] && k <= a[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }


}

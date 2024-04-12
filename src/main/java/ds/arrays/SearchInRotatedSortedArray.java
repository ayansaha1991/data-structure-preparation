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
        int[] arr = ArrayUtils.generateSequencialArray(15);
        int searchIndex = search(arr, 14);
        ArrayUtils.print(arr);
        System.out.println();
        System.out.println(searchIndex == -1 ? -1 : searchIndex+1);
    }

    private static int search(int[] arr, int searchElem) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;
            if (arr[mid] == searchElem) {
                return mid;
            }

            // check which half is sorted if start item is less than less that the middle item
            if (arr[start] <= arr[mid]) {
                // left half is sorted
                if (searchElem >= arr[start] && searchElem <= arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            // right half is sorted
            } else if (arr[mid] < arr[end]){
                if (searchElem >= arr[mid] && searchElem <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}

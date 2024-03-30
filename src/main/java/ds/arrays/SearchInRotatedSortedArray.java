package ds.arrays;

import ds.utils.ArrayUtils;

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

            // check which half is sorted
            if (arr[start] <= arr[mid]) {
                // left half is sorted
                if (searchElem >= arr[start] && searchElem <= arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] < arr[end]){
                // right half is sorted
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

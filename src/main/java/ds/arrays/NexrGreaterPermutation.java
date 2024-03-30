package ds.arrays;

import ds.utils.ArrayUtils;

import static ds.arrays.ReverseArray.swap;

public class NexrGreaterPermutation {
    public static void main(String[] args) {
        int[] a = { 1, 3, 2 };
//        ArrayUtils.print(a);
        int index = findIndex(a);

        if (index == -1) {
            reverseTheArrayStartingFromIndex(a, 0);
        } else {
            swapWithNextBigNumberThanIndex(a, index);
            reverseTheArrayStartingFromIndex(a, index+1);
        }
        System.out.println();
        ArrayUtils.print(a);


    }

    private static void reverseTheArrayStartingFromIndex(int[] a, int index) {

        int low = index ;
        int high = a.length -1;

        while (low < high) {
            int temp = a[low];
            a[low] = a[high];
            a[high] = temp;
            low ++; high--;
        }
    }

    private static void swapWithNextBigNumberThanIndex(int[] a, int index) {
        int len = a.length;
        for (int i = len -1; i > index ; i--) {
            if (a[i] > a[index]) {
                swap(a, index, i);
                break;
            }
        }
    }

    private static int findIndex(int[] a) {

        int len = a.length;
        int index = -1;

        for (int i = len-2; i >= 0; i--) {
            if (a[i] < a[i + 1]) {
                index = i;
                break;
            }
        }

        return index;
    }


}

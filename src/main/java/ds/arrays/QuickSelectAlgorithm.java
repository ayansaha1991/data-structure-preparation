package ds.arrays;

import ds.utils.ArrayUtils;

public class QuickSelectAlgorithm {
    public static void main(String[] args) {
        int[] a = ArrayUtils.generateRandomArray(10);
        int k = 9;
        int kthItem = quickSelect(a, k, 0, a.length-1);
        ArrayUtils.print(a);
        System.out.println();
        System.out.println(kthItem);
    }

    int findKthLargestItem(int[] a, int k) {
       return quickSelect(a, k, 0, a.length-1);
    }

    private static int quickSelect(int[] a, int k, int l, int r) {

        int pInd = l;
        int pivot = a[r];
        int find = a.length - k;

        for (int i = l; i < r; i++) {
            if (a[i] <= pivot) {
                swap(a, i, pInd);
                pInd++;
            }
        }

        swap(a, pInd, r);

        if (find < pInd) {
            return quickSelect(a, k, l, pInd - 1);
        } else if (find > pInd) {
            return quickSelect(a, k, pInd + 1, r);
        }else {
            return a[pInd];
        }

    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

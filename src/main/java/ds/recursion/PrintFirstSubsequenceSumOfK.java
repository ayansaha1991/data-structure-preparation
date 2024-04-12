package ds.recursion;

import java.util.LinkedList;

public class PrintFirstSubsequenceSumOfK {
    public static void main(String[] args) {
        int[] a = { 1, 2, 1, 1};
        int k = 3;
        LinkedList<Integer> emptyList = new LinkedList<>();
        printFirstSubsequenceSumK(a, 0, k, 0, emptyList);
    }

    private static boolean printFirstSubsequenceSumK(int[] a, int i, int k, int sum, LinkedList<Integer> e) {

        if (i == a.length) {
            // if subsequence sum is matching k
            if (sum == k) {
                e.forEach(System.out::print);
                System.out.println();
                return  true;
            }
            return false;
        }

        //taking the ith element
        e.addLast(a[i]);
        sum = sum + a[i];
        if (printFirstSubsequenceSumK(a, i + 1, k, sum , e)) {
            return true;
        }

        // not taking the ith element
        e.removeLast();
        sum = sum - a[i];
        if (printFirstSubsequenceSumK(a, i + 1, k, sum, e)) {
            return true;
        }

        return false;
    }
}

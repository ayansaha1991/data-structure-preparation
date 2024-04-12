package ds.recursion;

import java.util.LinkedList;

public class SubsequenceSumOfK {
    public static void main(String[] args) {
        int[] a = { 1, 2, 1, 1};
        int k = 3;
        LinkedList<Integer> emptyList = new LinkedList<>();
        printAllSubsequenceSumK(a, 0, k, 0, emptyList);
    }

    private static void printAllSubsequenceSumK(int[] a, int i, int k, int sum, LinkedList<Integer> e) {

        if (i == a.length) {
            // if subsequence sum is matching k
            if (sum == k) {
                e.forEach(System.out::print);
                System.out.println();
            }
            return;
        }

        //taking the ith element
        e.addLast(a[i]);
        sum = sum + a[i];
        printAllSubsequenceSumK(a, i+1, k, sum   , e);

        // not taking the ith element
        e.removeLast();
        sum = sum - a[i];
        printAllSubsequenceSumK(a, i + 1, k, sum, e);

    }
}

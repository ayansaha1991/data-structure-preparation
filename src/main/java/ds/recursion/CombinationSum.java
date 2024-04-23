package ds.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Same number can be used multiple times to come to the sum.
 * Hence recursion transition does not opt for next index or next number in input array.
 * Algorithm is as follows -
 * If we take the first number, target is reduced by that number num[i] and check next recursion,
 * until target is not 0 (base case) or there is no number left to pick.
 */

public class CombinationSum {
    public static void main(String[] args) {
        int[] a = {2,3,6,7};
        int target = 7;
        LinkedList<Integer> ds = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        f2(a, 0, target, ds, result);
        System.out.println(result);
    }

    private static void f(int[] a, int i, int target, LinkedList<Integer> ds, List<List<Integer>> ans) {

        if (i == a.length ||target == 0) {
            if (target == 0) {
                ds.forEach(System.out::print);
                System.out.println();
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        // Take the item if current number num[i] is more than the target as we are looking for a sum
        if (target >= a[i]) {
            ds.addLast(a[i]);
            f(a, i, target-a[i], ds, ans);
            ds.removeLast();
        }

        // Dont take the item and pursue to the next index for further recursion.
        f(a, i+1, target, ds, ans);
    }

    private static void f2(int[] a, int i, int target, LinkedList<Integer> ds, List<List<Integer>> ans) {

        if (i == a.length || target == 0) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (target >= a[i]) {
            ds.add(a[i]);
            f2(a, i , target - a[i], ds, ans);
            ds.removeLast();
        }

        f2(a, i+1, target, ds, ans);
    }
}

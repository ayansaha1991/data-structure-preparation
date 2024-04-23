package ds.recursion;

import java.util.*;

/**
 * Find all combination of elements that once added is equal to target value
 * Numbers should appear in increasing order.
 * Duplicate should be avoided in answer.
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> ds = new LinkedList<>();

        int target= 2;
        Arrays.sort(a);
        findCombination(a, 0, target, ds, ans);
//        findCombination2(a, 0, target, ds, ans);
        System.out.println(ans);
    }

    private static void findCombination(int[] a, int i, int target, LinkedList<Integer> ds, List<List<Integer>> ans) {

        if (target == 0 ) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int j = i; j < a.length; j++) {
            if (j > i &&  a[j] == a[j-1] ) continue;
            if (a[j] > target) break;

            ds.add(a[j]);
            findCombination(a, j+1, target-a[j], ds, ans);
            ds.removeLast();
        }
    }

    private static void findCombination2(int[] a, int ind, int target, LinkedList<Integer> ds, List<List<Integer>> ans) {

        if (target == 0 || ind == a.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        for (int i = ind; i < a.length; i++) {
            if (i > ind && a[i] == a[i - 1]) continue;
            if (a[i] > target) break;

            ds.add(a[i]);
            findCombination2(a, ind+1, target-a[i], ds, ans);
            ds.removeLast();
        }
    }
}

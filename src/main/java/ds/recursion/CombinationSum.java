package ds.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class CombinationSum {
    public static void main(String[] args) {
        int[] a = {2,3,6,7};
        int target = 7;
        LinkedList<Integer> ds = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        f(a, 0, target, ds, result);
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

        if (target >= a[i]) {
            ds.addLast(a[i]);
            f(a, i, target-a[i], ds, ans);
            ds.removeLast();
        }

        f(a, i+1, target, ds, ans);
    }
}

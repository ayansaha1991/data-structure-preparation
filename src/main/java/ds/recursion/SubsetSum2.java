package ds.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubsetSum2 {
    public static void main(String[] args) {

        int[] a = {1, 2, 2, 3};
        LinkedList<Integer> ds = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        findUniqueSubsetSum(a, 0, ds, result);
        System.out.println(result);
    }

    private static void findUniqueSubsetSum(int[] a, int ind, LinkedList<Integer> ds, List<List<Integer>> result) {
        result.add(new ArrayList<>(ds));
        for (int i = ind; i < a.length; i++) {
            if (i != ind && a[i] == a[i-1]) continue;

            ds.add(a[i]);
            findUniqueSubsetSum(a, ind + 1, ds, result);
            ds.removeLast();
        }
    }
}

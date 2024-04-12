package ds.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        int[] a = {3, 1, 2};
        int ind =  0;
        LinkedList<Integer> ds = new LinkedList<>();
        int sum = 0;
        f(a, ind, ds, sum);
    }

    private static void f(int[] a, int ind, LinkedList<Integer> ds, int sum) {

        if (ind == a.length) {
            System.out.print(sum + ", ");
            return;
        }

        ds.add(a[ind]);
        f(a, ind+1, ds, sum+a[ind]);
        ds.removeLast();

        f(a, ind+1, ds, sum);
    }
}

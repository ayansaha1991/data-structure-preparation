package ds.recursion;

import java.util.LinkedList;
import java.util.List;

public class PrintSubsequences {
    public static void main(String[] args) {
        int[] a = {3, 1, 2};
        LinkedList emptyArray = new LinkedList();
        f(a, 0, a.length, emptyArray);

    }

    private static void f(int[] a, int i, int n, LinkedList emptyArray) {
        if (i == n) {
            emptyArray.stream().forEach(item -> System.out.print(item));
            System.out.println();
            return;
        }
        // Take the ith element for further sequence generation
        emptyArray.add(a[i]);
        f(a, i+1, n, emptyArray);
        emptyArray.removeLast();

        // don't take ith element for further sequence generation
        f(a, i+1, n, emptyArray);

    }

    private static void print(List emptyArray) {
        emptyArray.stream().forEach(item -> System.out.print(item));
        System.out.println();
    }


}

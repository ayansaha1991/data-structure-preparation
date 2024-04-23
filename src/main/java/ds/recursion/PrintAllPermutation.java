package ds.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static ds.arrays.ReverseArray.swap;

public class PrintAllPermutation {
    public static void main(String[] args) {
        PrintAllPermutation printAllPermutation = new PrintAllPermutation();
        int[] a = {1, 2, 3};
        List<List<Integer>> results = printAllPermutation.permute(a);
        System.out.println(results);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> ds = new LinkedList<>();
        boolean[] freq = new boolean[nums.length];
//        permuteRecursively(nums, ds, freq, result);
        permuteRecursively2(nums, 0, result);
        return  result;
    }

    private void permuteRecursively2(int[] nums, int ind, List<List<Integer>> result){

        if (ind == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            result.add(list);
        }

        for (int i = ind; i < nums.length; i++) {
            swap(nums, ind, i);
            permuteRecursively2(nums, ind+1, result);
            swap(nums, ind, i);
        }
    }
    private void permuteRecursively(int[] nums, LinkedList<Integer> ds, boolean[] freq, List<List<Integer>> result) {

        // base case
        if (nums.length == ds.size()) {
            result.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // if the item is not taken
            if (!freq[i]) {
                ds.add(nums[i]);
                freq[i] = true;
                permuteRecursively(nums, ds, freq, result);
                ds.removeLast();
                freq[i] = false;
            }
        }
    }

}

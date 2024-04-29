package ds.strings;

import java.util.HashMap;

public class FruitBasketProblem {
    public static void main(String[] args) {
        int[] arr = {8,17,16,7,1,25,26,3,13,5,28,26,2,8,3,28,12,27,0,19,3,7,26,10,16,14,23,23,15,21,15};
        int n = 2;
        int count = findMaxFruits(arr, arr.length);
        System.out.println(count);
    }

    private static int findMaxFruits(int[] arr, int n) {
        int maxCount = 0;
        int low = 0, high = 0;
        HashMap<Integer, Integer> ds = new HashMap<>();

        while (high < n && low <= high) {
            // add a new item if not present
            ds.computeIfPresent(arr[high], (key, value)-> value+1);
            ds.putIfAbsent(arr[high], 1);

            if (ds.size() > 2) {
                // reduce number of distinct entity to n
                while ( ds.size() > 2 && low <= high ) {
                    ds.computeIfPresent(arr[low], (key, value) -> value - 1);
                    if (ds.get(arr[low]) == 0) {
                        ds.remove(arr[low]);
                    }
                    low++;
                }
            }

            maxCount = Math.max(maxCount, (high-low+1));
            high++;
        }

        return maxCount;
    }
}

package ds.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 8, 5, 4};
        int target = 9;

        int[] found2Sum = find2SumPractice(a, target);
        printArray(found2Sum);
    }

    private static int[] find2Sum(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] empty = {};
        for (int i = 0; i < numbers.length; i++) {

            int delta = target - numbers[i];

            if (map.containsKey(delta)) {
                Integer j = map.get(delta);

                int[] result = {numbers[i], numbers[j]};
                return result;
            }

            map.put(numbers[i], i);
        }

        return empty;
    }

    private static int[] find2SumPractice(int[] arr, int target) {

        int[] emptyArray = {};
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i=0; i < arr.length; i++) {
            int a = arr[i];
            int toFind = target - a;
            if (numberMap.containsKey(toFind)) {
                return new int[]{ a, toFind };
            }

            numberMap.put(a, i);
        }

        return emptyArray;
    }

    private static void printArray(int[] found2Sum) {

        if (found2Sum.length == 0) {
            System.out.println("No pair");
        }

        for (int i = 0; i < found2Sum.length; i++) {
            System.out.print(found2Sum[i] + " ");
        }

    }


}

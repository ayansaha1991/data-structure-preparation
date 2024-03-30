package ds.arrays;

import ds.utils.ArrayUtils;

public class GenerateAllSubarrays {

    public static void main(String[] args) {
        int[] a = ArrayUtils.generateRandomArray(5);
        ArrayUtils.print(a);
        System.out.println("---------------");
        printAllSubArrays(a);
    }

    private static void printAllSubArrays(int[] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                for (int k = i; k < j; k++) {
                    System.out.print(a[k] + ", ");
                }
                System.out.println();
            }
        }
    }

}

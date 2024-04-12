package ds.arrays;

import java.util.Arrays;

public class ThreeSum {

    public static void main(String[] args) {

        // sort the numbers array first as this algorithm works on sorted number only
        int a[] = {-1, -1, 0, 1, 2, 3, 4, 5};
        int sum = 6;

        findTriplets2(a, sum);

    }

    private static void findTriplets(int[] num, int sum) {

        for (int i = 0; i < num.length - 2; i++) {

            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {

                int low = i + 1, high = num.length - 1, sumToFind = sum - num[i];

                while (low < high) {

                    if (sumToFind == (num[low] + num[high])) {

                        System.out.println(num[i] + ", " + num[low] + ", " + num[high]);

                        // skip the same numbers to ignore duplicates
                        while (low < high && num[low] == num[low + 1])
                            low++;
                        while (low < high && num[high] == num[high - 1])
                            high--;

                        low++;
                        high--;

                    } else if (num[low] + num[high] < sumToFind) {
                        low++;
                    } else {
                        high--;

                    }
                }
            }
        }
    }

    private static void findTriplets2(int[] num, int sum) {

        Arrays.sort(num);

        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int toFind = sum - num[i];
                // two pointers one at start and another one at the end
                int start = i+1;
                int end = num.length -1;

                while (start<end) {
                    if (num[start] + num[end] == toFind) {
                        System.out.println("%s + %s + %s = %s".formatted(num[i], num[start], num[end], sum));

                        while (start == start+1) start++;
                        while (end == end-1) end--;

                        start++; end--;
                    } else if (num[start] + num[end] < toFind){
                        start++;
                        while (start == start+1) start++;
                    } else {
                        end--;
                        while (end == end-1) end--;
                    }
                }
            }
            }
        }


    }


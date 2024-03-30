package ds.utils;

import java.util.Random;

public class ArrayUtils {
	
	public static void main(String[] args) {
		
	}
	
	public static void print(int[] nums) {
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] generateRandomArray(int len) {
		int[] a = new int[len];
		for (int j = 0; j < len; j++) {
			a[j] = new Random().nextInt(20);
		}
		return a;
	}

	public static int[] generateSequencialArray(int len) {
		int[] a = new int[len];
		for (int j = 0; j < len; j++) {
			a[j] = j;
		}
		return a;
	}
	
	public static int[] generateRandomArrayIncludingNegativeNumbers(int len){
		int[] a = new int[len];

		for (int i = 0; i < len; i++) {
			int newInt = new Random().nextInt(len);
			if (i != 0 && newInt % i == 0) {
				a[i] = (0 - newInt);
			} else {
				a[i] = newInt;
			}
		}

		return a;
	}
	
}

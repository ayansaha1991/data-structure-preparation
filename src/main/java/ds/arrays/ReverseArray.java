package ds.arrays;

import java.util.Arrays;
import java.util.Iterator;

import ds.utils.ArrayUtils;

public class ReverseArray {

	public static void main(String[] args) {
		
		int[] nums = ArrayUtils.generateRandomArray(10);
		
		ArrayUtils.print(nums);
		reverse(nums);
		System.out.println("");
		
		ArrayUtils.print(nums);
	}

	private static void reverse(int[] nums) {

		int start = 0; 
		int end = nums.length -1 ;
		
		while (start < end) {
			swap(nums, start++, end--);
		}
		
		
	}

	public static void swap(int[] nums, int start, int end) {
		
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}
}

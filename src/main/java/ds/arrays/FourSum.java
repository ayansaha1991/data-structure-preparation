package ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ds.utils.ArrayUtils;

public class FourSum {

	public static void main(String[] args) {
		
		int[] nums = ArrayUtils.generateRandomArray(1000);
		
		List<List<Integer>> quads = findFourSum(nums, 9);
		
		for (List<Integer> list : quads) {
			for (int list2 : list) {
				System.out.print(list2 + " ");
			}
			System.out.println();
		}
	}

	private static List<List<Integer>> findFourSum(int[] nums, int target) {

		Arrays.sort(nums);
		
		int len = nums.length;
		List<List<Integer>> quads = new ArrayList<>();
		
		for (int i = 0; i < len; i++) {
			
			for (int j = i+1; j < len; j++) {
				
				int noToFind = target - nums[i] - nums[j];
				
				int start = j+1;
				int end = len-1;
				
				while ( start < end ) {
					
					if ( (nums[start] + nums[end]) < noToFind ) {
							start++;
					} else if ( (nums[start] + nums[end]) > noToFind ) {
							end--;
					} else {
						List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[start], nums[end]);
						quads.add(quad);
						
						while ( start < end && quad.get(2) == nums[start]) {
							++start;
						}
						
						while (start < end && (quad.get(3) == nums[end])) {
							--end;
						}
						
					}
				}
				
				while (j+1 < len && nums[j] == nums[j+1]) {
					j++;
				}
				
			}
			
			while (i+1 < len && nums[i] == nums[i+1]) {
				i++;
			}
		}
		
		return quads;
	}
}

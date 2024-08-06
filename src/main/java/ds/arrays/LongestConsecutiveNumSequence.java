package ds.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Find length of a consecutive number sequence.
 * Example - a = { 9 100 8 101 10} . Ans - Count 3, a - { 8 9 10 }
 * Naive Solution - Sort the input array and find distinct consecutive sequences.
 * Better Solution -
 * 1. Find a number such that input does not contain next smaller number.
 * 2. Check if the next number is present in the array in a loop
 * 3. Count the length and update result if len is bigger than the result.
 */
public class LongestConsecutiveNumSequence {

	public static void main(String[] args) {
		
		int[] nums = {0,3,7,2,5,8,4,6,0,1};
		System.out.println(findLCN2(nums));
		System.out.println(findLCN(nums));
		System.out.println(findLCN(nums) == findLCN2(nums));
	}

	private static int findLCN2(int[] nums) {
		Set<Integer> inputSet = new HashSet<>();
		int finalResult = 1;
		// create a set out of int array
		for (int num : nums) {
			inputSet.add(num);
		}

		// try to find a starting number in a sequence
		for (int i = 0; i < nums.length; i++) {
			// not the starting number in the sequence
			if (inputSet.contains(nums[i] - 1)) {
				continue;
			} else {
				// starting point of a sequence
				int result = 1;
				// loop until next consecutive number is present in set
				while (inputSet.contains(++nums[i])) {
					result += 1;
				}
				if (result > finalResult) {
					finalResult = result;
				}
			}
		}

		return finalResult;
	}

	private static int findLCN(int[] nums) {
		
		if (nums == null || nums.length == 0 ) {
			return 0;
		}
		
		if (nums.length == 1 ) {
			return 1;
		}
		
		HashSet<Integer> numsSet = new HashSet<>();
		for (int i : nums) {
			numsSet.add(i);
		}
		
		int len = nums.length;
		int longestSequence = 1;
		
		for (int i=0 ; i < len ; i++) {
			if (numsSet.contains(nums[i]-1)) {
				continue;
			} else {
				
				int numsToCheck = nums[i];
				int currentSeqLen = 1;
				while (numsSet.contains(++numsToCheck)) {
					currentSeqLen++;
				}
				
				if (currentSeqLen > longestSequence) {
					longestSequence = currentSeqLen;
				}
			}
			
		}
		
		return longestSequence;
	}
	
	
}

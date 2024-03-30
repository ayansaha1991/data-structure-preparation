package ds.arrays;

import java.util.HashSet;

public class LongestConsecutiveNumSequence {

	public static void main(String[] args) {
		
		int[] nums = {0,3,7,2,5,8,4,6,0,1};
		int longestSequenceLen = findLCN(nums);
		System.out.println(longestSequenceLen);
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

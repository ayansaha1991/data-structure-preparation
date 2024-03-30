package ds.arrays;

class RemoveDuplicates {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 2, 2, 3, 4, 5, 5, 6 };
		int k = removeDuplicates2(nums);
		printArray(nums, k);
	}

	
	private static int removeDuplicates(int[] nums) {
		
		int u = 0;
		
		for (int i = 1; i < nums.length; i++) {
			
			if (nums[u] != nums[i]) {
				
				u++;
				nums[u] = nums[i];
			}
		}
		
		return u+1;
	}

	private static int removeDuplicates2(int[] nums) {

		int c = 0;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[++c] = nums[i];
			}
		}
		return c+1;
	}

	private static void printArray(int[] nums, int k) {

		for (int i = 0; i < k; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
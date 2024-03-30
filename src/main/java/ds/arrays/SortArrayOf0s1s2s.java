package ds.arrays;

public class SortArrayOf0s1s2s {

	public static void main(String[] args) {
		
		int[] nums = {2,0,2,1,1,0};
		
		partition2(nums);
		print(nums);
	}

	private static void print(int[] nums) {

		for (int i : nums) {
			System.out.print(i + ", ");
		}
	}

	private static int partition(int[] nums) {

		int low = 0 ,mid = 0;
		int high = nums.length-1;
		
		while (mid <= high) {
			
			if (nums[mid] == 0) {
				swap(nums, low, mid);
				low++;
				mid++;
			} else if (nums[mid] == 1) {
				mid++;
			} else {
				swap(nums, mid, high);
				high--;
			}
		}
		
		return 0;
	}

	public static void partition2(int[] a ) {

		int low = 0;
		int high = a.length - 1;
		int mid = low;

		while (mid < high) {

			if (a[mid] == 0) {
				swap(a, mid, low);
				mid++; low++;
			} else if (a[mid] == 1) {
				mid++;
			} else {
				swap(a, mid, high);
				high--;
			}
		}

	}

	private static void swap(int[] nums, int i, int pInd) {

		int temp = nums[i];
		nums[i] = nums[pInd];
		nums[pInd] = temp;
	}
}

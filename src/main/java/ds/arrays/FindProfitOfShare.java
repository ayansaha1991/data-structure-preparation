package ds.arrays;

import ds.utils.ArrayUtils;

public class FindProfitOfShare {
	
	public static void main(String[] args) {
		int[] nums = ArrayUtils.generateRandomArray(20) ;
		int profit = findProfit(nums);
		int profit1 = findProfit1(nums);
		ArrayUtils.print(nums);
		System.out.println();
		System.out.println(profit);
		System.out.println(profit1);
	}

	private static int findProfit(int[] nums) {
		
		int lowest = Integer.MAX_VALUE;
		int profit = 0;
		
		for (int i = 0; i < nums.length; i++) {
			
			if (nums[i] < lowest) {
				lowest = nums[i];
			}
			
			if ((nums[i] - lowest) > profit) {
				profit = nums[i] - lowest;
			}
			
		}
		
		return profit;
	}
	
	private static int findProfit1(int[] prices) {

		int profit = 0;
		int lowest = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < lowest) {
				lowest = prices[i];
			}

			if (prices[i] - lowest > profit) {
				profit = prices[i] - lowest;
			}
		}
		return profit;
		
	}

}

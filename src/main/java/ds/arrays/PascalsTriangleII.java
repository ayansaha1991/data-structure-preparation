package ds.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

	public static void main(String[] args) {
		int N = 4;
		List<Long> extracted = pascalTriangleLine(N);
		print(extracted);
	}

	private static void print(List<Long> nums) {
		for (Long num : nums) {
			System.out.print(num + " ");
		}
	}

	private static List<Long> pascalTriangleLine(int rowIndex) {
		List<Long> row = new ArrayList<>();
		Long item = 1L;
		for (int i = 0; i < rowIndex; i++) {
			
			if (i == 0) {
				row.add(item);
			} else {
				item = item/i;
				item = item * (rowIndex-i);
				row.add(item);
			}
		}
		
		return row;
	}
}

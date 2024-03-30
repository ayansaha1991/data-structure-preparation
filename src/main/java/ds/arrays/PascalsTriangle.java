package ds.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public static void main(String[] args) {
		
		int N = 7;

		List<List<Integer>> pascalsTriangle = pascalsTriangle(N);
		
		print2DArray(pascalsTriangle);
		
	}

	private static void print2DArray(List<List<Integer>> pascalsTriangle) {

		for (List<Integer> row : pascalsTriangle) {
			for (Integer item : row) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}

	private static List<List<Integer>> pascalsTriangle(int numRows) {
		
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> pre = null ;
		
		for(int i=0 ; i < numRows; i++) {
			List<Integer> row = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				
				if (j == 0 || j == i) {
					row.add(1);
				} else {
					row.add(pre.get(j-1) + pre.get(j));
				}
				
				
			}
			pre = row;
			result.add(row);
		}
		
		return result;
	}	
}

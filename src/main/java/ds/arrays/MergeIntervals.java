package ds.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Merge overlapping time intervals and return non-overlapping intervals.
 * @author Ayan Saha
 *
 */
public class MergeIntervals {

	public static void main(String[] args) {
		
//		List<List<Integer>> intervals = new ArrayList<>();
//		intervals.add(Arrays.asList(1, 3));
//		intervals.add(Arrays.asList(2, 6));
//		intervals.add(Arrays.asList(8, 10));
//		intervals.add(Arrays.asList(15, 18));
//		intervals.add(Arrays.asList(15, 18));
		
		int[][] intervals = {
				{1,3},
				{2,6},
				{8,10},
				{15,18}
		};
		
		int[][] mergeIntervals = mergeIntervals(intervals);
		print(mergeIntervals);
		
	}
	private static void print(int[][] mergeIntervals) {

		for (int[] is : mergeIntervals) {
			System.out.println(is[0]+ ", " + is[1]);
		}
	}
	//current	interval
	//(1, 3) , (2, 6)
	

//	private static List mergeIntervals(List<List<Integer>> intervals) {
//
//		List results = new ArrayList<>();
//		List<Integer> current = intervals.get(0);
//		
//		for (List<Integer> interval : intervals) {
//			
//			if ((interval.get(0) >= current.get(0) && (interval.get(0) <= current.get(1))) ) {
//				current = merge(current, interval);
//				
//			} else {
//				results.add(current);
//				current = interval;
//			}
//		}
//		
//		results.add(current);
//		
//		return results;
//	}
	
	private static int[][] mergeIntervals(int[][] intervals) {
		
		int[][] results = new int[intervals.length][2];
		List<int[]> list = new ArrayList<>();
		
		int[] current = intervals[0];
		int id = 0;
		
		for (int i = 0; i < intervals.length; i++) {
			int[] interval = intervals[i];
			
			if ((interval[0] >= current[0] && (interval[0] <= current[1])) ) {
				current = merge(current, interval);
				
			} else {
				list.add(current);
				results[id++] = current;
				current = interval;
			}
		}
		
		results[id++] = current;
		list.add(current);
		
		return results;
	}


	private static int[] merge(int[] current, int[] interval) {
		
		int lower = current[0] < interval[0] ? current[0]: interval[0];
		int upper = current[1] > interval[1] ? current[1]: interval[1];
		
		int[] result = {lower, upper} ;
	
		return result;
	}
	
	
}

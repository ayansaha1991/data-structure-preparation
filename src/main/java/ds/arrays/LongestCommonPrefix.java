package ds.arrays;

public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		
		String[] str = {"flower", "fl", "fla"};
		String longestCommonPrefix = findLongestCommonPrefix(str);
		System.out.println(longestCommonPrefix);
	}

	
	//["flower", "flow", "fla"]
	private static String findLongestCommonPrefix(String[] strs) {

		if (strs == null || strs.length == 0) {
			return "";
		}
		
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			String current = strs[i];
			
			while (!current.startsWith(prefix)) {
				 prefix = (String) prefix.subSequence(0, prefix.length()-1);
			}
		}
		
		return prefix;
	}



	private static void print(int[] nums) {
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}

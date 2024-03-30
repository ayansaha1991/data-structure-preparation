package ds.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalanceBrackets {

	public static void main(String[] args) {
		String brackets =  "[{{}}]" ;
		System.out.println(balancedBracket(brackets));
	}

	private static boolean balancedBracket(String s) {
		
		if (s == null || s.length() == 0 ) {
			return false;
		}
		
		Stack<Character> stack = new Stack<>();
		
		
		List<Character> open = Arrays.asList('{', '[', '(');
		
		for (int i = 0; i < s.length(); i++) {
		
			char currentBracket = s.charAt(i);
			
			if (open.contains(s.charAt(i))) {
				stack.push(currentBracket);
			} else {
				
				if (stack.isEmpty()) {
					return false;
				}
				
				char poppedChar = stack.pop();
				
				if (( currentBracket == '}' && poppedChar != '{' )
						|| (currentBracket == ')' && poppedChar != '(') || ( currentBracket == ']' && poppedChar != '[')) {
					return false;
				}
				
			}
		}
		
		return stack.isEmpty();
	}
}

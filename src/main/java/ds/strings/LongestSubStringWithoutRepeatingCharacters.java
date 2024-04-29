package ds.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        String s = "bbbbb";
        int len = lengthOfLongestSubstring(s);
        System.out.println(len);
    }

    /*Using sliding window pattern*/
    private static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int maxLen = 0;
        int strLen = s.length();
        Map<Character, Integer> charMap = new HashMap<>();

        while (right < strLen) {
            char key = s.charAt(right);
            if ( charMap.containsKey(key)) {
                Integer charIndex = charMap.get(key);
                if (charIndex >= left) {
                    left = charIndex+1;
                }
            }
            maxLen = Math.max(maxLen, (right - left + 1));
            charMap.put(key, right);
            right++;
        }

        return maxLen;
    }
}

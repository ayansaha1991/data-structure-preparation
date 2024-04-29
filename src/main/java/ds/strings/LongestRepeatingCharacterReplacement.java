package ds.strings;

    import java.util.HashMap;
    import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "ABCD";
        int k = 2;
        int result = characterReplacement(s, k);
        System.out.println(result);
    }

    /*
    Concept : Find the most frequent letter. Below formula tells us how many
    character we need to change to get all same characters.
    maxLen = (segment_length - max_char_frequency)
    Increase the sliding window until condition satisfies.*/
    public static int characterReplacement(String str, int k) {
        int maxLen = 0, low = 0, high = 0, maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (high < str.length()) {
            char c = str.charAt(high);
            map.computeIfPresent(c, (key, value) -> value + 1);
            map.putIfAbsent(c, 1);
            maxFreq = Math.max(map.get(c), maxFreq);

            // check if Condition satisfies anymore
            while ((high - low + 1) - maxFreq > k) {
                char c1 = str.charAt(low);
                map.computeIfPresent(c1, (key, value) -> value - 1);
                low = low + 1;
                int maxFreq1 = 0;
                for (Integer freq : map.values()) {
                    maxFreq1 = Math.max(freq, maxFreq1);
                }
                maxFreq = maxFreq1;
            }
            // update the result if
            if ((high - low + 1) - maxFreq <= k) {
                maxLen = Math.max(maxLen, (high-low+1));
            }
            high++;
        }

        return maxLen;
    }
}

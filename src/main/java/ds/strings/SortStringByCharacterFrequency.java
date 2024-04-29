package ds.strings;

import java.util.*;

public class SortStringByCharacterFrequency {
    public static void main(String[] args) {
        String s = "eeeee";
        System.out.println( frequencySort(s));;
    }

    private static String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> charFrequency = new HashMap<>();
        // count the character frequency
        for (char c :  chars) {
            charFrequency.computeIfPresent(c, (key, value) -> value + 1);
            charFrequency.putIfAbsent(c, 1);
        }

        Map<Integer, List<Character>> charfrequencyMap2 = new HashMap<>();
        Collection<Integer> values = charFrequency.values();
        for (Map.Entry<Character, Integer> frequency:  charFrequency.entrySet()) {
            Character character = frequency.getKey();
            Integer frequencyValue = frequency.getValue();
            List<Character> orDefault = charfrequencyMap2.getOrDefault(frequencyValue, new ArrayList<>());
            orDefault.add(character);
            charfrequencyMap2.put(frequencyValue, orDefault);
        }
        StringBuilder result = new StringBuilder();
        for (int i = chars.length; i >= 1; i--) {
            List<Character> orDefault = charfrequencyMap2.getOrDefault(i, List.of());
            for (Character c : orDefault) {
                Integer freq = charFrequency.get(c);
                for (int j = 0; j < freq; j++) {
                    result.append(c);
                }
            }

        }

        return result.toString();
//        System.out.println(charFrequency);
//        System.out.println(charfrequencyMap2);
    }
}

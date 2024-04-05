package ds.recursion;

public class PalindromCheck {
    public static void main(String[] args) {
        String s = " madama";
        char[] chars = s.toCharArray();
        boolean isPalindrom = isPalindrom(chars, 0, s.length()-1);
        System.out.println(isPalindrom);
    }

    private static boolean isPalindrom(char[] s, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (s[start] != s[end]) {
            return false;
        }
        return  isPalindrom(s, ++start, --end);

    }
}

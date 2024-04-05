package ds.recursion;

public class FibonachiNumbers {
    public static void main(String[] args) {
        Integer fibonachi = fibonachi(50);
        System.out.println(fibonachi);
    }

    private static int fibonachi(int i) {

        if (i <= 1) {
            return i;
        }

        return fibonachi(i-1) + fibonachi(i-2);
    }
}

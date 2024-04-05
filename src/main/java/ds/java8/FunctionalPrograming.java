package ds.java8;

import java.util.stream.Stream;

public class FunctionalPrograming {
    public static void main(String[] args) {

//        Stream.iterate(0, n -> n + 1)
//                .limit(100)
//                .filter(SimplePrimerChecker::isPrime);
    }
}

@FunctionalInterface
interface PrimeChecker {
    boolean isPrime(int number);
}

class SimplePrimerChecker implements PrimeChecker {
    @Override
    public boolean isPrime(int number) {
        return number %3 == 0;
    }
}

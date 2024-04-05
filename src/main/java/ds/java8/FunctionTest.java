package ds.java8;

import java.util.function.*;

public class FunctionTest {
    public static void main(String[] args) {

        Function<String, String> fun = s -> s.toUpperCase();
        String hello = fun.apply("Hello");
        System.out.println(hello);

        Function<String, Integer> fun2 = s -> Integer.parseInt(s);
        Integer apply = fun2.apply("2");
        System.out.println(apply);

        BiFunction<Integer, Integer, String> addAndConvert = (first, second) -> "Result : " + String.valueOf(first + second);
        String apply1 = addAndConvert.apply(10, 20);
        System.out.println(apply1);

        Consumer<String> consumerAndPrint = s -> System.out.println(s);
        consumerAndPrint.accept("Hello");

        Supplier<String> supplierOfStrings = () -> "Random String";

        Predicate<String> isNull = s -> s == null ;
        isNull.test(null);




    }
}

package mf.java8ws.examples.example09;

import java.util.stream.IntStream;

public class ParallelStreamsWithSideEffect {

    public static String sideEffectConcat(int n) {
        StringBuilder sb = new StringBuilder();
        IntStream.rangeClosed(1, n).mapToObj(i -> i + " ").forEach(sb::append);
        return sb.toString();
    }

    public static String sideEffectParallelConcat(int n) {
        StringBuilder sb = new StringBuilder();
        IntStream.rangeClosed(1, n).parallel().mapToObj(i -> i + " ").forEach(sb::append);
        return sb.toString();
    }

    public static String parallelConcat(int n) {
        return IntStream.rangeClosed(1, n).parallel()
                        .mapToObj(i -> i + " ").reduce("", (a, b) -> a+b);
    }

}

package mf.java8ws.examples.example09;

public class ParallelStreamsHarness {

    public static void main(String[] args) {
        System.out.println(ParallelStreamsWithSideEffect.sideEffectConcat(100));
        System.out.println(ParallelStreamsWithSideEffect.sideEffectParallelConcat(100));
        System.out.println(ParallelStreamsWithSideEffect.parallelConcat(100));
    }

}

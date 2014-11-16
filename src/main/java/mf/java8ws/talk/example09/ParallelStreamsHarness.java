package mf.java8ws.talk.example09;

import java.util.concurrent.ForkJoinPool;

public class ParallelStreamsHarness {

    public static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();

    public static void main(String[] args) {
        System.out.println(ParallelStreamsWithSideEffect.sideEffectConcat(100));
    }
}

package mf.java8ws.examples.example14;

import java.util.function.*;

public interface Monoid<A> extends BinaryOperator<A> {

    A zero();
}

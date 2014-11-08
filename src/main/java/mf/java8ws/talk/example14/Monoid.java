package mf.java8ws.talk.example14;

import java.util.function.*;

public interface Monoid<A> extends BinaryOperator<A> {

    A zero();
}

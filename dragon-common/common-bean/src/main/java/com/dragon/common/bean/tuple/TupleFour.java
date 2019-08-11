package com.dragon.common.bean.tuple;

public class TupleFour<A, B, C, D> extends TupleThree<A, B, C> {

    public final D fourth;

    public TupleFour(A a, B b, C c, D d) {
        super(a, b, c);
        fourth = d;
    }
}
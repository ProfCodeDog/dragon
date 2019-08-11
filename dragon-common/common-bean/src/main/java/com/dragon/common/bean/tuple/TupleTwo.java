package com.dragon.common.bean.tuple;

public class TupleTwo<A, B> {

    public final A first;

    public final B second;

    public TupleTwo(A a, B b) {
        first = a;
        second = b;
    }
}

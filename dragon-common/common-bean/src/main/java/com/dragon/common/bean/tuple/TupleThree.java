package com.dragon.common.bean.tuple;

public class TupleThree<A, B, C> extends TupleTwo<A, B> {

    public final C third;

    public TupleThree(A a, B b, C c) {
        super(a, b);
        third = c;
    }
}
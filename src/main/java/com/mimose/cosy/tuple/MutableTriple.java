package com.mimose.cosy.tuple;

/**
 * @author mimose
 * @description mutable tuple with left, middle, right
 * @date 2021/5/23
 */
public final class MutableTriple<L, M, R> extends Triple<L, M, R>{

    public MutableTriple(L left, M middle, R right) {
        super(left, middle, right);
    }

    public void setLeft(L left) {
        this.left = left;
    }

    public void setMiddle(M middle) {
        this.middle = middle;
    }

    public void setRight(R right) {
        this.right = right;
    }
}

package com.mimose.cosy.tuple;

import com.mimose.cosy.lang.Objs;
import com.mimose.cosy.tuple.api.IValOne;
import com.mimose.cosy.tuple.api.IValThree;
import com.mimose.cosy.tuple.api.IValTwo;

/**
 * @author mimose
 * @description tuple with left, middle, right
 * @date 2021/4/23
 */
public class Triple<L, M, R> implements IValOne<L>, IValTwo<M>, IValThree<R> {

    protected Triple(L left, M middle, R right) {
        this.left = left;
        this.middle = middle;
        this.right = right;
    }

    protected L left;

    protected M middle;

    protected R right;

    public L getLeft() {
        return left;
    }

    public M getMiddle() {
        return middle;
    }

    public R getRight() {
        return right;
    }

    @Override
    public L getValueOne() {
        return this.left;
    }

    @Override
    public M getValueTwo() {
        return this.middle;
    }

    @Override
    public R getValueThree() {
        return this.right;
    }

    public static <L, M, R> Triple<L, M, R> of(L left, M middle, R right) {
        return new Triple<>(left, middle, right);
    }

    @Override
    public String toString() {
        return "(" + left +", " + middle +", " + right +")";
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(!(o instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) o;
        return Objs.equals(this.getLeft(), triple.getLeft()) && Objs.equals(this.getMiddle(), triple.getMiddle()) && Objs.equals(this.getRight(), triple.getRight());
    }

}

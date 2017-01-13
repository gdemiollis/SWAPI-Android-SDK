package com.swapi.comparator;

public abstract class BaseComparator {
    protected int compare(int lhs, int rhs) {
        return lhs < rhs ? -1 : (lhs == rhs ? 0 : 1);
    }

}

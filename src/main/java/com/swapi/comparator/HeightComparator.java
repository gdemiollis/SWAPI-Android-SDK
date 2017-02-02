package com.swapi.comparator;

import com.swapi.model.People;

import java.util.Comparator;

public class HeightComparator extends BaseComparator implements Comparator<People> {
    @Override
    public int compare(People lhs, People rhs) {
        int heightLhs = Integer.parseInt(lhs.height);
        int heightRhs = Integer.parseInt(rhs.height);
        return super.compare(heightLhs, heightRhs);
    }
}

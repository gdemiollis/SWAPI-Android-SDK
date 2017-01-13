package com.swapi.comparator;

import com.swapi.models.People;

import java.util.Comparator;

public class MassComparator extends BaseComparator implements Comparator<People> {
    @Override
    public int compare(People lhs, People rhs) {
        int heightLhs = Integer.parseInt(lhs.mass);
        int heightRhs = Integer.parseInt(rhs.mass);
        return super.compare(heightLhs, heightRhs);
    }
}

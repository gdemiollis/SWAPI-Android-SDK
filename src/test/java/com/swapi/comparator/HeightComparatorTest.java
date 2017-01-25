package com.swapi.comparator;

import com.swapi.models.People;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HeightComparatorTest {
    @Test
    public void compare() throws Exception {
        People people1 = new People();
        people1.height = "1";
        People people2 = new People();
        people2.height = "2";
        People people3 = new People();
        people3.height = "3";
        People people4 = new People();
        people4.height = "4";
        People people5 = new People();
        people5.height = "5";
        People people6 = new People();
        people6.height = "6";

        List<People> peoples = new ArrayList<>();
        peoples.add(people4);
        peoples.add(people3);
        peoples.add(people5);
        peoples.add(people1);
        peoples.add(people6);
        peoples.add(people2);

        assertEquals(people4, peoples.get(0));
        assertEquals(people3, peoples.get(1));
        assertEquals(people5, peoples.get(2));
        assertEquals(people1, peoples.get(3));
        assertEquals(people6, peoples.get(4));
        assertEquals(people2, peoples.get(5));

        Collections.sort(peoples, new HeightComparator());

        assertEquals(people1, peoples.get(0));
        assertEquals(people2, peoples.get(1));
        assertEquals(people3, peoples.get(2));
        assertEquals(people4, peoples.get(3));
        assertEquals(people5, peoples.get(4));
        assertEquals(people6, peoples.get(5));
    }

}
package com.swapi.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Oleur on 22/12/2014.
 * Generic list model
 */
public class SWModelList<T> implements Serializable {
    public int count;
    public String next;
    public String previous;
    public ArrayList<T> results;

    public boolean hasMore() {
        return next != null && next.trim().length() != 0;
    }
}

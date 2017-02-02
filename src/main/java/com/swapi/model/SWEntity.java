package com.swapi.model;

import java.io.Serializable;

public interface SWEntity extends Serializable{

    String getName();

    String getDescription();

    Category getCategory();
}

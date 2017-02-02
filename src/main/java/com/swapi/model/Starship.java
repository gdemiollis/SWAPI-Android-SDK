package com.swapi.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Oleur on 22/12/2014.
 * Starship model represents a single transport craft that has hyperdrive capability.
 */
public class Starship extends Vehicle implements SWEntity, Serializable {

    @SerializedName("starship_class")
    public String starshipClass;

    @SerializedName("hyperdrive_rating")
    public String hyperdriveRating;

    @SerializedName("MGLT")
    public String mglt;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return model;
    }

    @Override
    public Category getCategory() {
        return Category.Starship;
    }

}

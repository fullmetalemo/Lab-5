package com.polina.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
    @JsonProperty("x")
    private float x;
    @JsonProperty("y")
    private Float y; //Поле не может быть null
    @JsonProperty("z")
    private int z;
    @JsonProperty("name")
    private String name; //Длина строки не должна быть больше 465, Поле не может быть null

    public Location(float x, Float y, int z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }
    public Location(){

    }

    @Override
    public String toString() {
        return "x: " + x + ",y: " + y + ",z: " + z + ",name: " + name;
    }
}
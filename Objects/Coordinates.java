package com.polina.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordinates {
    @JsonProperty("x")
    private Double x; //Максимальное значение поля: 849, Поле не может быть null
    @JsonProperty("y")
    private Long y; //Значение поля должно быть больше -963, Поле не может быть null

    public Coordinates(Double x, Long y) {
        this.x = x;
        this.y = y;
    }
    public Coordinates(){

    }

    @Override
    public String toString() {
        return "x: " + x + ",y: " + y;
    }
}

package com.polina.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Person implements Comparable<Person>{
    private static int Ids;
    @JsonProperty("id")
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @JsonProperty("name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @JsonProperty("coordinates")
    private Coordinates coordinates; //Поле не может быть null

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @JsonSerialize(using = DateSerializer.class)
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    private double height; //Значение поля должно быть больше 0

    private java.time.LocalDateTime birthday; //Поле не может быть null

    @JsonProperty("color")
    private Color hairColor; //Поле не может быть null
    @JsonProperty("nationality")
    private Country nationality; //Поле не может быть null
    @JsonProperty("location")
    private Location location; //Поле может быть null

    public Person(String name, Coordinates coordinates, double height, LocalDateTime birthday, Color hairColor, Country nationality, Location location) {
        creationDate = new Date();
        id = Ids;
        Ids++;
        this.name = name;
        this.coordinates = coordinates;
        this.height = height;
        this.birthday = birthday;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    public Person(){

    }
    public LocalDateTime getBirthday() {
        return birthday;
    }

    public int getId() {
        return id;
    }

    public double getHeight() {
        return height;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String dateB = birthday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.println(coordinates.toString());
        return "Id: " + id + "\nname: " + name + "\ncoorditates ates.toString() + "\nдата: " + creationDate.toString()
                + "\nвысота: " + height + "\nдата рождения: " + dateB + "\nцвет волос: " + hairColor + "\nнациональность:" +
                nationality + "\nлокация: " + location;
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }
}

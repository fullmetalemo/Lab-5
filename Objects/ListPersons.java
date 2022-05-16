package com.polina.Objects;

import java.util.HashSet;

public class ListPersons {
    private final HashSet<Person> people = new HashSet<>();

    public HashSet<Person> getPeople() {
        return people;
    }

    public void Add(Person person){
        people.add(person);
    }

    public String getToStrings(){
        StringBuilder builder = new StringBuilder();
        for (Person person : people){
            builder.append(person.toString()).append("\n");
        }
        return builder.toString();
    }

    public void Remove(Person person){
        people.remove(person);
    }

    private static ListPersons Instance = new ListPersons();


    public static ListPersons getInstance() {
        return Instance;
    }

    public static void setInstance(ListPersons instance) {
        Instance = instance;
    }
}

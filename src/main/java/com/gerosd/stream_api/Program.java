package com.gerosd.stream_api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Sergey", 38));
        persons.add(new Person("Darya", 68));
        persons.add(new Person("Anna", 24));
        persons.add(new Person("Tom", 19));
        persons.add(new Person("Prepod", 45));

        persons.stream().
                filter(p -> p.getAge() >= 25).
                sorted(Comparator.comparing(Person::getName)).
                map(Person::getName).
                forEach(System.out::println);
    }
}

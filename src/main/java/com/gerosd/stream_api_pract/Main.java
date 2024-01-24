package com.gerosd.stream_api_pract;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Arrays.stream(Person.people).filter(p -> (p.age() > 25) && (!p.male())).sorted(Comparator.comparing(Person::name)).forEach(System.out::println);

    }
}

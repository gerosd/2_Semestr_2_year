package com.gerosd.stream_api_pract;

public record Person(String name, int age, boolean male) {
    public static Person[] people = new Person[6];

    static {
        people[1] = new Person("Igor", 34, true);
        people[2] = new Person("Kate", 19, false);
        people[3] = new Person("Ann", 45, false);
        people[4] = new Person("Vasily", 15, true);
        people[5] = new Person("Bob", 29, true);
        people[0] = new Person("Lisa", 26, false);
    }

    @Override
    public String toString() {
        return name();
    }
}

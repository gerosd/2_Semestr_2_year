package com.gerosd.stream_api_pract;

import java.util.Arrays;
import java.util.List;

public class FindString {
    private final List<String> stringList = Arrays.asList("Jeffry", "Boiko", "Smirnov", "Jameson", "Rodrigo");

    public void findJ() {
        stringList.stream().filter(p -> p.charAt(0) == 'J').forEach(System.out::println);
    }
}

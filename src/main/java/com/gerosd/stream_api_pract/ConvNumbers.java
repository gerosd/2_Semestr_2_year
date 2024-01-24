package com.gerosd.stream_api_pract;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ConvNumbers {
    static List<Integer> nums = new ArrayList<>();
    static Random random = new Random();

    static {
        for (int i = 0; i < 15; i++) {
            nums.add(random.nextInt(100));
        }
    }

    public void setNewNums() {
        System.out.println(nums);
        List<Integer> newList = nums.stream().map(x -> x + 10).map(x -> x * x).distinct().collect(Collectors.toList());
        System.out.println(newList);
    }
}

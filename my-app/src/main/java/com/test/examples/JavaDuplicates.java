package com.test.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaDuplicates {

    public static void main(String[] args) {

        // 3, 4, 9
        List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);

        Set<Integer> result = findDuplicateBySetAdd(list);

        result.forEach(System.out::println);

    }


    public static <T> Set<T> findDuplicateBySetAdd(List<T> list) {

        Set<T> items = new HashSet<>();
        return list.stream()
                .filter(n -> !items.add(n))
                .collect(Collectors.toSet());

    }

    public static <T> Set<T> findDuplicateByGrouping(List<T> list) {

        return list.stream()
                .collect(Collectors.groupingBy(Function.identity()
                        , Collectors.counting()))    // create a map {1=1, 2=1, 3=2, 4=2, 5=1, 7=1, 9=2}
                .entrySet().stream()                 // Map -> Stream
                .filter(m -> m.getValue() > 1)       // if map value > 1, duplicate element
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

    }

    public static <T> Set<T> findDuplicateByFrequency(List<T> list) {

        return list.stream().filter(i -> Collections.frequency(list, i) > 1)
                .collect(Collectors.toSet());

    }

    public Map<String, Integer> duplicates(final List<String> stringList) {
        final Map<String, Integer> map = new HashMap<>();
        // final Map<String, Long> collect = stringList.stream().collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        stringList.forEach(x -> {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        });
        return map;
    }
}

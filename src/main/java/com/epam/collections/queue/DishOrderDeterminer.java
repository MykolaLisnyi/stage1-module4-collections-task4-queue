package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> resultList = new ArrayList<>();
        Deque<Integer> deque = Stream
                .iterate(1, i -> i <= numberOfDishes, i -> i + 1)
                .collect(Collectors.toCollection(ArrayDeque::new));

        while(!deque.isEmpty()) {
            for (int i = 1; i < everyDishNumberToEat; i++) {
                deque.addLast(deque.pollFirst());
            }
            resultList.add(deque.pollFirst());
        }

        return resultList;
    }
}
package mf.java8ws.talk.example06;

import java.util.*;

public class CollectorFeatures {

    public static void main(String... args) {
        System.out.println("Dishes grouped by type: " + groupDishesByType());
        System.out.println("Most caloric Dish by type: " + mostCaloricDishByType());
    }

    private static Map<Dish.Type, List<Dish>> groupDishesByType() {
        return null;
    }

    private static Map<Dish.Type, Optional<Dish>> mostCaloricDishByType() {
        return null;
    }
}

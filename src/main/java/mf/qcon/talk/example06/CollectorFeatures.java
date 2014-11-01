package mf.qcon.talk.example06;

import java.util.*;
import java.util.function.*;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import static mf.qcon.talk.example06.Dish.menu;

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

package epam.com.java.module1.collection.maintask.vegetables;

import epam.com.java.module1.collection.maintask.vegetables.categories.FruitVegetables;

public class Cucumber extends FruitVegetables {
    private static final int KCAL_PER_100G = 11;

    public Cucumber(){
        super(VegetableName.TOMATO, KCAL_PER_100G);
    }

    public Cucumber(double weight) {
        super( VegetableName.TOMATO, KCAL_PER_100G, weight);
    }
    public Cucumber(int kcalPer100g, double weight) {
        super( VegetableName.TOMATO, kcalPer100g, weight);
    }

}

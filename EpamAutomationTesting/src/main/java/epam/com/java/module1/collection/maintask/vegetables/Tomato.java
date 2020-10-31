package epam.com.java.module1.collection.maintask.vegetables;

import epam.com.java.module1.collection.maintask.vegetables.categories.FruitVegetables;

public class Tomato extends FruitVegetables {
    private static final int KCAL_PER_100G = 78;

    public Tomato(int kcalPer100g, double weight) {
        super( VegetableName.TOMATO, kcalPer100g, weight);
    }
    public Tomato(){
        super(VegetableName.TOMATO, KCAL_PER_100G);
    }

    public Tomato(double weight) {
        super( VegetableName.TOMATO, KCAL_PER_100G, weight);
    }
}

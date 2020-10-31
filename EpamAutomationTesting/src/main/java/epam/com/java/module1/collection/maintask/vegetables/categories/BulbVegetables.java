package epam.com.java.module1.collection.maintask.vegetables.categories;

import epam.com.java.module1.collection.maintask.vegetables.VegetableName;
import epam.com.java.module1.collection.maintask.vegetables.Vegetable;

//Onion, Garlic, Spring Onion, Leek, Kohlrabi, Fennel and Shallots.

public abstract class BulbVegetables extends Vegetable {

    public BulbVegetables(VegetableName name, int kcalPer100g, double weight){
        super(VegetableCategory.BULB_VEGETABLES, name, kcalPer100g, weight);
    }

    public BulbVegetables(VegetableName name, int kcalPer100g){
        super(VegetableCategory.BULB_VEGETABLES, name, kcalPer100g);
    }
}

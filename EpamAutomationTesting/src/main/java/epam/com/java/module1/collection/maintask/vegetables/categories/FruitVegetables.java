package epam.com.java.module1.collection.maintask.vegetables.categories;

import epam.com.java.module1.collection.maintask.vegetables.VegetableName;
import epam.com.java.module1.collection.maintask.vegetables.Vegetable;

//Tomatoes, Avocado, Bitter Gourd, Eggplant, Caigua or Bottle Gourd, Bell Peppers,
// Ackee, African Eggplant, Ash Gourd or Winter Melon, Chayote, etc.

public abstract class FruitVegetables extends Vegetable {
//    private  static String category = "Fruit";

    public FruitVegetables(VegetableName name, int kcalPer100g, double weight){
        super(VegetableCategory.FRUIT_VEGETABLES, name, kcalPer100g, weight);
    }

    public FruitVegetables(VegetableName name, int kcalPer100g){
        super(VegetableCategory.FRUIT_VEGETABLES, name, kcalPer100g);
    }
}

package epam.com.java.module1.collection.maintask.vegetables.categories;

import epam.com.java.module1.collection.maintask.vegetables.VegetableName;
import epam.com.java.module1.collection.maintask.vegetables.Vegetable;

//Spinach, Cabbage, Water Cress, Lettuce, Bok Choy, Gai Lan, Choy Sum, Brussels Sprouts,
// Witloof, Silverbeet, Radicchio, Kale, Collard Leaves, Swiss Chard, Mustard Leaves, Fenugreek Leaves, etc.

public abstract class LeavesVegetables extends Vegetable {

    public LeavesVegetables(VegetableName name, int kcalPer100g, double weight){
        super(VegetableCategory.LEAVES_VEGETABLES, name, kcalPer100g, weight);
    }

    public LeavesVegetables(VegetableName name, int kcalPer100g){
        super(VegetableCategory.LEAVES_VEGETABLES, name, kcalPer100g);
    }
}

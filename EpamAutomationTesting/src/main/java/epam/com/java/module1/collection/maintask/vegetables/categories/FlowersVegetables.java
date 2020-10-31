package epam.com.java.module1.collection.maintask.vegetables.categories;

import epam.com.java.module1.collection.maintask.vegetables.VegetableName;
import epam.com.java.module1.collection.maintask.vegetables.Vegetable;

//Cauliflower, Broccoli, Courgette Flowers, Squash Blossoms, Artichoke, Agati (Dok Kae, Thailand), Banana Flower, and Lotus.

public abstract class FlowersVegetables extends Vegetable {

    public FlowersVegetables(VegetableName name, int kcalPer100g, double weight){
        super(VegetableCategory.FLOWERS_VEGETABLES, name, kcalPer100g, weight);
     }

    public FlowersVegetables(VegetableName name){
        super(VegetableCategory.FLOWERS_VEGETABLES, name);
    }

    public FlowersVegetables(VegetableName name, int kcalPer100g){
        super(VegetableCategory.FLOWERS_VEGETABLES, name, kcalPer100g);

    }
}

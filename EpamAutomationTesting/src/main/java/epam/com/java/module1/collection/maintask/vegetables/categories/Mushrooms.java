package epam.com.java.module1.collection.maintask.vegetables.categories;

import epam.com.java.module1.collection.maintask.vegetables.VegetableName;
import epam.com.java.module1.collection.maintask.vegetables.Vegetable;

// Button Mushroom, Enoki, Oyster, Shitake, Truffles, Portabello, Boletus,
// Chanterelles, Grifola Fondosa, Morchella, Shimeji, Straw Mushroom, Porcini, Morel, etc.

public abstract class Mushrooms extends Vegetable {

    public Mushrooms(VegetableName name, int kcalPer100g, double weight){
        super(VegetableCategory.MUSHROOMS, name, kcalPer100g, weight);
    }
    public Mushrooms(VegetableName name, int kcalPer100g){
        super(VegetableCategory.MUSHROOMS, name, kcalPer100g);
    }
}

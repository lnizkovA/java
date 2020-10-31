package epam.com.java.module1.collection.maintask.vegetables.categories;

// Asparagus, Celery, Kohlrabi, Leek, Rhubarb

import epam.com.java.module1.collection.maintask.vegetables.VegetableName;
import epam.com.java.module1.collection.maintask.vegetables.Vegetable;

public abstract class StemVegetables extends Vegetable {

    public StemVegetables(VegetableName name, int kcalPer100g, double weight){
        super(VegetableCategory.STEM_VEGETABLES, name, kcalPer100g, weight);
    }
    public StemVegetables(VegetableName name, int kcalPer100g){
        super(VegetableCategory.STEM_VEGETABLES, name, kcalPer100g);
    }
}

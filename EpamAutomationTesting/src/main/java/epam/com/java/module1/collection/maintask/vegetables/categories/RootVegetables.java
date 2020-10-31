package epam.com.java.module1.collection.maintask.vegetables.categories;

import epam.com.java.module1.collection.maintask.vegetables.VegetableName;
import epam.com.java.module1.collection.maintask.vegetables.Vegetable;

//Beet, Carrot, Radish, Horseradish, Turnip, Celeriac, Daikon, Enset, Jicama, Konjac, Maca, Arrowroot, Chinese Water Chestnut, Taro, etc

public abstract class RootVegetables extends Vegetable {

    public RootVegetables(VegetableName name, int kcalPer100g, double weight){
        super(VegetableCategory.ROOT_VEGETABLES, name, kcalPer100g, weight);
    }

    public RootVegetables(VegetableName name, int kcalPer100g){
        super(VegetableCategory.ROOT_VEGETABLES, name, kcalPer100g);
    }

}

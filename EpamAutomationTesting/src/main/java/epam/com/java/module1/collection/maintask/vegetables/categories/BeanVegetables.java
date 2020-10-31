package epam.com.java.module1.collection.maintask.vegetables.categories;

import epam.com.java.module1.collection.maintask.vegetables.VegetableName;
import epam.com.java.module1.collection.maintask.vegetables.Vegetable;

//Fava Beans, Kidney Beans, Green Peas, French Beans, English Beans, Lima Beans, Licorice, Peanut, Snow Peas, Soy Beans, etc.

public abstract class BeanVegetables extends Vegetable {

//    public BeanVegetables(String category, String name, int kcalPer100g) {
//        super("Bean Vegetables",name, kcalPer100g);
//    }

    public BeanVegetables(VegetableName name, int kcalPer100g, double weight){
        super(VegetableCategory.BEAN_VEGETABLES, name, kcalPer100g, weight);
    }

    public BeanVegetables(VegetableName name, int kcalPer100g){
        super(VegetableCategory.BEAN_VEGETABLES, name, kcalPer100g);
    }

}

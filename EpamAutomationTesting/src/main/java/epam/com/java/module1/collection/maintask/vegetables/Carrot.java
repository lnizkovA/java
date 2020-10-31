package epam.com.java.module1.collection.maintask.vegetables;

import epam.com.java.module1.collection.maintask.vegetables.categories.RootVegetables;

public class Carrot extends RootVegetables {

    private static final int KCAL_PER_100G = 63;

    public Carrot(int kcalPer100g, double weight){
       super(VegetableName.CARROT, kcalPer100g, weight);
    }

    public Carrot(){
        super(VegetableName.CARROT, KCAL_PER_100G);
    }

    public Carrot(double weight){
        super(VegetableName.CARROT, KCAL_PER_100G, weight);
    }
}

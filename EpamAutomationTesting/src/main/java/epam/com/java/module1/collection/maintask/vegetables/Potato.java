package epam.com.java.module1.collection.maintask.vegetables;

import epam.com.java.module1.collection.maintask.vegetables.categories.RootVegetables;

public class Potato extends RootVegetables {
    private static final int KCAL_PER_100G = 112;

    public Potato(int kcalPer100g, double weight){
        super(VegetableName.POTATO, kcalPer100g, weight);
    }

    public Potato(){
        super(VegetableName.POTATO, KCAL_PER_100G);
    }

    public Potato(double weight){
        super(VegetableName.POTATO, KCAL_PER_100G, weight);
    }
}

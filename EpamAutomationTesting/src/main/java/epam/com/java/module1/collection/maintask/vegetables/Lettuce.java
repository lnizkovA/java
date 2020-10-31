package epam.com.java.module1.collection.maintask.vegetables;

import epam.com.java.module1.collection.maintask.vegetables.categories.LeavesVegetables;

public class Lettuce extends LeavesVegetables {
    private static final int KCAL_PER_100G = 13;

    public Lettuce(int kcalPer100g, double weight) {
        super(VegetableName.LETTUCE, kcalPer100g, weight);

    }
    public Lettuce(){
        super(VegetableName.LETTUCE, KCAL_PER_100G);
    }

    public Lettuce(double weight){
        super(VegetableName.LETTUCE, KCAL_PER_100G, weight);
    }
}

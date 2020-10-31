package epam.com.java.module1.collection.maintask.vegetables;

import epam.com.java.module1.collection.maintask.vegetables.categories.BulbVegetables;

public class Onion extends BulbVegetables {
    private static final int KCAL_PER_100G = 35;

    public Onion(int kcalPer100g, double weight) {
      super(VegetableName.ONION, kcalPer100g, weight);

    }
    public Onion(){
        super(VegetableName.ONION, KCAL_PER_100G);
    }

    public Onion(double weight){
        super(VegetableName.ONION, KCAL_PER_100G, weight);
    }
}

package epam.com.java.module1.collection.maintask.vegetables;

import epam.com.java.module1.collection.maintask.vegetables.categories.RootVegetables;

public class BeetRoot extends RootVegetables {
    private static final int KCAL_PER_100G = 47;

    public BeetRoot(){
        super(VegetableName.BEET_ROOT, KCAL_PER_100G);
    }

    public BeetRoot(double weight) {
        super(VegetableName.BEET_ROOT, KCAL_PER_100G, weight);
    }

    public BeetRoot(int kcalPer100g, double weight) {
        super(VegetableName.BEET_ROOT, kcalPer100g, weight);
    }
}

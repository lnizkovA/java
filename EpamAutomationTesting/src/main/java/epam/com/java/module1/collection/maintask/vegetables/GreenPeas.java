package epam.com.java.module1.collection.maintask.vegetables;

import epam.com.java.module1.collection.maintask.vegetables.categories.BeanVegetables;

public class GreenPeas extends BeanVegetables {
    private static final int KCAL_PER_100G = 62;

    public GreenPeas(int kcalPer100g, double weight){
        super(VegetableName.GREEN_PEAS, kcalPer100g, weight);
    }

    public GreenPeas(){
        super(VegetableName.GREEN_PEAS, KCAL_PER_100G);
    }

    public GreenPeas(double weight){
        super(VegetableName.GREEN_PEAS, KCAL_PER_100G, weight);
    }
}

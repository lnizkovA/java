package epam.com.java.module1.collection.maintask.vegetables;

import epam.com.java.module1.collection.maintask.vegetables.categories.FlowersVegetables;

public class Broccoli extends FlowersVegetables {

    private static final int KCAL_PER_100G = 15;

    public Broccoli(){
        super(VegetableName.BROCCOLI, KCAL_PER_100G);
    }

    public Broccoli(double weight) {
        super(VegetableName.BROCCOLI, KCAL_PER_100G, weight);
    }

    public Broccoli(int kcalPer100g, double weight) {
        super(VegetableName.BROCCOLI, kcalPer100g, weight);
    }



//    public Broccoli(double weight){
//        super(VegetableName.BROCCOLI);
//        this.kcalPer100g = 15;
//        this.weight = weight;
//    }

}

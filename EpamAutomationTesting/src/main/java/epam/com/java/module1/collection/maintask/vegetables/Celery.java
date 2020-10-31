package epam.com.java.module1.collection.maintask.vegetables;

import epam.com.java.module1.collection.maintask.vegetables.categories.StemVegetables;

public class Celery extends StemVegetables {
    private static  final int KCAL_PER_100G = 11;

    public Celery(int kclaPer100g, double weight){
      super(VegetableName.CELERY, kclaPer100g, weight);
    }

    public Celery(){
        super(VegetableName.CELERY, KCAL_PER_100G);
    }

    public Celery(double weight){
        super(VegetableName.CELERY, KCAL_PER_100G, weight);
    }


}

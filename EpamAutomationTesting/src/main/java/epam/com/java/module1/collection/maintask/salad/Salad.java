package epam.com.java.module1.collection.maintask.salad;

import epam.com.java.module1.collection.maintask.vegetables.Vegetable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Salad {
    private String nameSalad;
    private List<Vegetable> vegetables;


    public Salad(){
        vegetables = new ArrayList<Vegetable>();
    }

    public Salad(String nameSalad){
        this.nameSalad = nameSalad;
        vegetables = new ArrayList<Vegetable>();
    }

    public String getNameSalad() {
        return nameSalad;
    }

    public void setNameSalad(String nameSalad) {
        this.nameSalad = nameSalad;
    }

    public List<Vegetable> getVegetables() {
        return vegetables;
    }

    public void setVegetables(List<Vegetable> vegetables) {
        this.vegetables = vegetables;
    }

    public double getSaladCalories() {
        double totalCalories = 0;
        totalCalories += vegetables.stream().mapToDouble(Vegetable::getTotalKcal).sum();
        return totalCalories;
    }

    public double getSaladWeight() {
        double totalWeight = 0;
        totalWeight += vegetables.stream().mapToDouble(Vegetable::getWeight).sum();
        return totalWeight;
    }

    public void addVegetable(Vegetable vegetable) {
        vegetables.add(vegetable);
    }

    public void sortVegetablesByName(){
        Collections.sort(vegetables, new Comparator<Vegetable>() {
            @Override
            public int compare(Vegetable o1, Vegetable o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public void sortVegetablesByKcalPer100g(){
        Collections.sort(vegetables, new Comparator<Vegetable>() {
            @Override
            public int compare(Vegetable o1, Vegetable o2) {
                return (int) (o1.getKcalPer100g() - o2.getKcalPer100g());
            }
        });
    }

    public List<Vegetable> getVegetablesFromKcalDiapason(int maxKcal, int minKcal){
        List<Vegetable> result = new ArrayList<>();

        vegetables.stream().filter(vegetable -> vegetable.getKcalPer100g() >= minKcal && vegetable.getKcalPer100g() <= maxKcal)
        .forEach(result::add);

        return result;
    }
}

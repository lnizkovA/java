package epam.com.java.module1.collection.maintask.vegetables;

import epam.com.java.module1.collection.maintask.vegetables.categories.VegetableCategory;

public abstract class Vegetable {
    private VegetableCategory vegetableCategory;
    private VegetableName name;
    protected int kcalPer100g;
    protected double weight;

    public Vegetable(){

    }

    public Vegetable(VegetableCategory vegetableCategory, VegetableName name, int kcalPer100g){
        this.vegetableCategory = vegetableCategory;
        this.name = name;
        this.kcalPer100g = kcalPer100g;
    }

    public Vegetable(VegetableCategory vegetableCategory, VegetableName name, int kcalPer100g, double weight){
        this(vegetableCategory, name, kcalPer100g);
        this.weight = weight;
    }

    //---
    public Vegetable(VegetableCategory vegetableCategory, VegetableName name){
        this.vegetableCategory = vegetableCategory;
        this.name = name;
    }

    public VegetableCategory getVegetableCategory() {
        return vegetableCategory;
    }

    public void setVegetableCategory(VegetableCategory vegetableCategory) {
        this.vegetableCategory = vegetableCategory;
    }

    public VegetableName getName() {
        return name;
    }

    public void setName(VegetableName name) {
        this.name = name;
    }

    public int getKcalPer100g() {
        return kcalPer100g;
    }

    public void setKcalPer100g(int kcalPer100g) {
        this.kcalPer100g = kcalPer100g;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getTotalKcal(){
        return (kcalPer100g*weight/100);
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "category='" + vegetableCategory + '\'' +
                ", name='" + getName() + '\'' +
                ", kcalPer100g=" + kcalPer100g +
                ", weight=" + weight +
                '}';
    }
}

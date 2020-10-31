package epam.com.java.module1.collection.maintask.vegetables;

public enum VegetableName {
    BROCCOLI("Broccoli"), CARROT("Carrot"), CELERY("Celery"), GREEN_PEAS("Green peas"),
    LETTUCE("Lettuce"), ONION("Onion"), POTATO("Potato"), TOMATO("Tomato"),
    CUCUMBER("Cucumber") , BEET_ROOT("Beet root");

    private String name;

    VegetableName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

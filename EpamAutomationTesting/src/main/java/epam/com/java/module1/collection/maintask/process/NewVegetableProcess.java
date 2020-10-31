package epam.com.java.module1.collection.maintask.process;

import epam.com.java.module1.collection.maintask.utils.IntegerUtil;
import epam.com.java.module1.collection.maintask.vegetables.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NewVegetableProcess {

    public Vegetable createNewVegetable(Scanner scanner) {
        Vegetable vegetable;
        vegetable = chooseVegetable(scanner);

        while(true) {
            System.out.println("Enter weight of selected vegetable '"+vegetable.getName()+"' for salad: ");
            double weight;
            try {
                weight = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect value! Try again!");
                scanner.next();
                continue;
            }
            if (weight <= 0) {
                System.out.println("Weight cannot be less o equal '0'! ");
                continue;
            }
            vegetable.setWeight(weight);
            return vegetable;
        }
    }

    private Vegetable chooseVegetable(Scanner scanner) {
        final int BROCCOLI = 1;
        final int CARROT = 2;
        final int CELERY = 3;
        final int GREEN_PEAS = 4;
        final int LETTUCE = 5;
        final int ONION = 6;
        final int POTATO = 7;
        final int TOMATO = 8;
        final int CUCUMBER = 9;
        final int BEET_ROOT = 10;

        int selectedVegetable;

        System.out.println("Choose vegetable for salad");
        System.out.println("1. Broccoli");
        System.out.println("2. Carrot");
        System.out.println("3. Celery");
        System.out.println("4. Green peas");
        System.out.println("5. Lettuce");
        System.out.println("6. Onion");
        System.out.println("7. Potato");
        System.out.println("8. Tomato");
        System.out.println("9. Cucumber");
        System.out.println("10. Beet root");

        while (true) {

            try {
                selectedVegetable = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Incorrect value! Try again!");
                scanner.next();
                continue;
            }

            if(IntegerUtil.checkInputMenuSelection(selectedVegetable, 1, 10)){
                System.out.println("Incorrect vegetable choice! Please try again.");
            } else {
                if (selectedVegetable == BROCCOLI) {
                    return new Broccoli();
                }
                if (selectedVegetable == CARROT) {
                    return new Carrot();
                }
                if (selectedVegetable == CELERY) {
                    return new Celery();
                }
                if (selectedVegetable == GREEN_PEAS) {
                    return new GreenPeas();
                }
                if (selectedVegetable == LETTUCE) {
                    return new Lettuce();
                }
                if (selectedVegetable == ONION) {
                    return new Onion();
                }
                if (selectedVegetable == POTATO) {
                    return new Potato();
                }
                if (selectedVegetable == TOMATO) {
                    return new Tomato();
                }
                if (selectedVegetable == CUCUMBER) {
                    return new Cucumber();
                } else {
                    return new BeetRoot();
                }
            }
        }
    }


}

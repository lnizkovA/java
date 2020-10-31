package epam.com.java.module1.collection.maintask.process;

import epam.com.java.module1.collection.maintask.salad.Salad;
import epam.com.java.module1.collection.maintask.utils.IntegerUtil;
import epam.com.java.module1.collection.maintask.vegetables.Vegetable;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NewSaladProcess  {
    private static final int DEFAULT_USER_CHOICE = 0;
    private static final int EXIT_CODE = 9;

    public void createNewSalad(Scanner scanner) {
        Salad salad = new Salad();
        int userOptionChoice = DEFAULT_USER_CHOICE;
        while (userOptionChoice != EXIT_CODE){
            System.out.println("\nChoose one of the options:");
            System.out.println("1. Set the salad name.");
            System.out.println("2. Add vegetable to salad.");
            System.out.println("3. Show all vegetables in salad.");
            System.out.println("4. Sort vegetables by Name");
            System.out.println("5. Sort vegetables by Kcal per 100g");
            System.out.println("6. Total salad weight");
            System.out.println("7. Total kcal in salad");
            System.out.println("8. Show vegetables in salad between kcal diapason");
            System.out.println("9. Exit");

            try {
                userOptionChoice = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Incorrect value! Try again!");
                scanner.next();
                continue;
            }

            if(IntegerUtil.checkInputMenuSelection(userOptionChoice, DEFAULT_USER_CHOICE, EXIT_CODE)){
                System.out.println("Incorrect choice! Please try again.");
                continue;
            }

            switch (userOptionChoice){
                case 1:
                    System.out.println("Enter salad name");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    salad.setNameSalad(name);
                    System.out.println(salad.getNameSalad());
                    break;
                case 2:
                    salad.addVegetable(getVegetable(scanner));
                    break;
                case 3:
                    if(salad.getVegetables().size() == 0) {
                        System.out.println("No vegetable(s) in salad!");
                    } else {
                        salad.getVegetables().forEach(System.out::println);
                    }
                    break;
                case 4:
                    if(salad.getVegetables().size() == 0) {
                        System.out.println("No vegetable(s) in salad!");
                    } else {
                        salad.sortVegetablesByName();
                        System.out.println("Sorting vegetables in salad by Name:" + salad.getVegetables());
                    }
                    break;
                case 5:
                    if(salad.getVegetables().size() == 0) {
                        System.out.println("No vegetable(s) in salad!");
                    } else {
                        salad.sortVegetablesByKcalPer100g();
                        System.out.println("Sorting vegetables in salad by Kcal per 100g:" + salad.getVegetables());
                    }
                    break;
                case 6:
                    if(salad.getVegetables().size() == 0) {
                        System.out.println("No vegetable(s) in salad!");
                    } else {
                        System.out.println("Total salad ' " + salad.getNameSalad() + "' weight =" + salad.getSaladWeight() + "g");
                    }
                    break;
                case 7:
                    if(salad.getVegetables().size() == 0) {
                        System.out.println("No vegetable(s) in salad!");
                    } else {
                        System.out.println("Total kcal in salad = " + salad.getSaladCalories());
                    }
                    break;
                case 8:
                    if(salad.getVegetables().size() == 0) {
                        System.out.println("No vegetable(s) in salad!");
                    } else {
                        String label ="max Kcal";
                        int max = IntegerUtil.getIntegerValue(scanner, label);
                        label = "min Kcal";
                        int min = IntegerUtil.getIntegerValue(scanner,label);
                        System.out.println("Vegetables in salad between kcal diapason: max = " + max + " min = " + min);
                        System.out.println(salad.getVegetablesFromKcalDiapason(max, min));
                    }
                    break;
            }
        }
    }
    private Vegetable getVegetable(Scanner scanner) {
        return new NewVegetableProcess().createNewVegetable(scanner);
    }

}

package epam.com.java.module1.collection.maintask.process;

import epam.com.java.module1.collection.maintask.salad.Salad;
import epam.com.java.module1.collection.maintask.utils.IntegerUtil;
import epam.com.java.module1.collection.maintask.vegetables.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static epam.com.java.module1.collection.maintask.vegetables.VegetableName.valueOf;

public class SaladFromFileProcess {
    private static final String FILE_NAME = "src/main/resources/Salad.txt";
    private static final int DEFAULT_SELECTION_CODE = 0;
    private static final int EXIT_CODE = 7;

    public void createSaladFromFile(Scanner scanner) {
        Salad salad = constructSalad();

        int menuSelection = DEFAULT_SELECTION_CODE;
        while (menuSelection != EXIT_CODE) {
            System.out.println("\nChoose one of the options:");
            System.out.println("1. Show all vegetables in salad");
            System.out.println("2. Sort vegetables by Name");
            System.out.println("3. Sort vegetables by Kcal per 100g");
            System.out.println("4. Total salad weight");
            System.out.println("5. Total kcal in salad");
            System.out.println("6. Show vegetables in salad between kcal diapason");
            System.out.println("7. Exit");

            try {
                menuSelection = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect value! Try again!");
                scanner.next();
                continue;
            }

            if(IntegerUtil.checkInputMenuSelection(menuSelection, DEFAULT_SELECTION_CODE, EXIT_CODE)){
                System.out.println("Incorrect choice! Please try again.");
                continue;
            }
            switch (menuSelection) {
                case 1:
                    System.out.println("Salad contains vegetable(s): \n" + salad.getVegetables());
                    break;
                case 2:
                    salad.sortVegetablesByName();
                    System.out.println("Sorting vegetables in salad by Name: \n" + salad.getVegetables());
                    break;
                case 3:
                    salad.sortVegetablesByKcalPer100g();
                    System.out.println("Sorting vegetables in salad by Kcal per 100g: \n" + salad.getVegetables());
                    break;
                case 4:
                    System.out.println("Total salad weight = "
                            + salad.getSaladWeight());
                    break;
                case 5:
                    System.out.println("Total kcal in salad = "
                            + salad.getSaladCalories());
                    break;
                case 6:
                    String label ="max Kcal";
                    int max = IntegerUtil.getIntegerValue(scanner, label);
                    label = "min Kcal";
                    int min = IntegerUtil.getIntegerValue(scanner,label);
                    System.out.println("Show vegetables in salad between kcal diapason max = " + max + " min = " + min);
                    System.out.println(salad.getVegetablesFromKcalDiapason(max, min));
                    break;
            }
        }

    }

    private Salad constructSalad() {
        Salad salad = new Salad();
        List<String[]> entries = getEntriesFromFile();
        for (String[] entry : entries) {
            if (entry[0].equals("Salad")) {
                salad.setNameSalad(entry[1]);
            } else salad.addVegetable(constructVegetable(entry));
        }
        return salad;
    }

    private Vegetable constructVegetable(String[] entry) {
        Vegetable vegetable;
        VegetableName vegetableName = valueOf(entry[0]);
        switch (vegetableName) {
            case TOMATO:
                vegetable = new Tomato(Double.parseDouble(entry[1]));
                break;
            case LETTUCE:
                vegetable = new Lettuce(Double.parseDouble(entry[1]));
                break;
            case BEET_ROOT:
                vegetable = new BeetRoot(Double.parseDouble(entry[1]));
                break;
            case BROCCOLI:
                vegetable = new Broccoli(Double.parseDouble(entry[1]));
                break;
            case CARROT:
                vegetable = new Carrot(Double.parseDouble(entry[1]));
                break;
            case CELERY:
                vegetable = new Celery(Double.parseDouble(entry[1]));
                break;
            case GREEN_PEAS:
                vegetable = new GreenPeas(Double.parseDouble(entry[1]));
                break;
            case ONION:
                vegetable = new Onion(Double.parseDouble(entry[1]));
                break;
            case POTATO:
                vegetable = new Potato(Double.parseDouble(entry[1]));
                break;
            case CUCUMBER:
                vegetable = new Cucumber(Double.parseDouble(entry[1]));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + vegetableName);
        }
        return vegetable;
    }

    private List<String[]> getEntriesFromFile() {
        List<String[]> entries = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(SaladFromFileProcess.FILE_NAME));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                entries.add(line.split(" "));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

}

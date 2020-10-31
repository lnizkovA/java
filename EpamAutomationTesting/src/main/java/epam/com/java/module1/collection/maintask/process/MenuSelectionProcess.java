package epam.com.java.module1.collection.maintask.process;

import epam.com.java.module1.collection.maintask.utils.IntegerUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuSelectionProcess {

    private static final int DEFAULT_USER_SELECTION_CODE = 0;
    private static final int EXIT_CODE = 3;

    public void processUSerMenuSelection(Scanner scanner)  {
        int menuSelection = DEFAULT_USER_SELECTION_CODE;

        while (menuSelection != EXIT_CODE) {

            System.out.println("1. Salad from file");
            System.out.println("2. Create a new salad");
            System.out.println("3. Exit");

            try {
                menuSelection = scanner.nextInt();
            }catch (InputMismatchException ignored) {
                System.out.println("Incorrect value! Try again!");
                scanner.next();
                continue;
            }

            if(IntegerUtil.checkInputMenuSelection(menuSelection, DEFAULT_USER_SELECTION_CODE, EXIT_CODE)){
                System.out.println("Incorrect menu choice! Please try again.");
                continue;
            }


            switch (menuSelection) {
                case 1:
                    processSaladFromFile(scanner);
                    break;
                case 2:
                    processNewSalad(scanner);
                    break;
            }
        }
    }

    private void processSaladFromFile(Scanner scanner) {
        new SaladFromFileProcess().createSaladFromFile(scanner);
    }

    private void processNewSalad(Scanner scanner) {
        new NewSaladProcess().createNewSalad(scanner);
    }

}


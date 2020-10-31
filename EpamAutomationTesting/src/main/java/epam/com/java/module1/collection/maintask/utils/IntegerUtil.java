package epam.com.java.module1.collection.maintask.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntegerUtil {
    public static int getIntegerValue(Scanner scanner, String label){
        int value;
        do{
            System.out.println("Enter "+label);
            try{
                value = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Incorrect value! Try again!");
                value = -1;
                scanner.next();
            }
        } while (value < 0);
        return value;
    }

    public static boolean checkInputMenuSelection(int inputValue, int defaultCode, int exitCode){
//        return  (inputValue >= defaultCode && inputValue <= exitCode);
        return (inputValue < defaultCode || inputValue > exitCode);
    }
}

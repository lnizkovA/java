package epam.com.java.module1.fundamentals.maintask;

import java.util.Scanner;

public class CalculateSumOfIntNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integer numbers:");
        String string = scanner.nextLine();
        String[] numbers = string.split("\\s");
        int size = numbers.length;
        int sum = 0;
        try {
            for (int i=0; i<size; i++){
                sum+= Integer.parseInt(numbers[i]);
            }
            System.out.println("Summa = " + sum);
        }
        catch(Exception ex){
            System.out.println("Invalid number!");
        }
        scanner.close();
    }
}

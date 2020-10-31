package epam.com.java.module1.fundamentals.maintask;

import java.util.Scanner;

public class PrintRandomNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set a number of random numbers  n=");
        int n = scanner.nextInt();
        System.out.println("Print random N numbers in one line: ");
        for(int i=0; i<n; i++){
            int number = (int) (Math.random()*100);
            System.out.print(number+" ");
        }
        System.out.println("\nPrint random N numbers moving to a new line: ");
        for(int i=0; i<n; i++){
            int number = (int) (Math.random()*100);
            System.out.println(number+" ");
        }
        scanner.close();
    }
}

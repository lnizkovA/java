package epam.com.java.module1.fundamentals.maintask;

import java.util.Scanner;

public class PrintReverseLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any symbols");
        String line = scanner.nextLine();
        StringBuilder reverseLine = new StringBuilder(line);
        System.out.println(reverseLine.reverse());
        scanner.close();
    }
}

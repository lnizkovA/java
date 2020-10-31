package epam.com.java.module1.fundamentals.maintask;

import java.util.Scanner;

public class WelcomeUser {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name");
        String name = scanner.nextLine();
        System.out.println("Welcome "+name+" !");
        scanner.close();
    }
}

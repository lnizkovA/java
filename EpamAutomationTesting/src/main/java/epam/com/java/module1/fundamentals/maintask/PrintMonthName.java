package epam.com.java.module1.fundamentals.maintask;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class PrintMonthName {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter integer number between 1 and 12!");
        int number = scanner.nextInt();
        if (number < 1 || number > 12) {
            throw new Exception("Number should be between 1 and 12!");
        }
        Month month = Month.of(number);
        Locale locale = Locale.forLanguageTag("ru");
        System.out.println(month.getDisplayName(TextStyle.FULL_STANDALONE, locale));

        scanner.close();
    }

}

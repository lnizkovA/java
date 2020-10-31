package epam.com.java.module1.collection.maintask;

import epam.com.java.module1.collection.maintask.process.MenuSelectionProcess;

import java.util.Scanner;


//Шеф-повар. Определить иерархию овощей. Сделать салат. Подсчитать калорийность.
// Провести сортировку овощей для салата на основе одного из параметров.
// Найти овощи в салате, соответствующие заданному диапазону калорийности.

public class Main {

    public static void main(String[] args) {

        MenuSelectionProcess process = new MenuSelectionProcess();
        process.processUSerMenuSelection(new Scanner(System.in));

    }
}

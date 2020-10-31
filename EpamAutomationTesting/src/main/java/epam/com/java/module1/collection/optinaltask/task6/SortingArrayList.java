package epam.com.java.module1.collection.optinaltask.task6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из класса Collections.

public class SortingArrayList {
    private static final String FILE_NAME = "task6.txt";

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        File file = new File("src/main/resources/task4.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null){
                list.add(line);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }

        Collections.sort(list);
        list.forEach(System.out::println);
    }
}

package epam.com.java.module1.collection.optinaltask.task4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

//Занести стихотворение в список. Провести сортировку по возрастанию длин строк.

public class SortingStringsByAscending {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        File file = new File("src/main/resources/task4.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null){
                list.add(line);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }

        if (list.isEmpty()){
            System.out.println("Empty ArrayList!");
        } else {
            SortedMap<Integer, String> result = new TreeMap<>();
            for (String line: list) {
                result.put(line.length(), line);
            }
            result.forEach((key, value)-> System.out.println(key+": "+value));
        }
    }
}

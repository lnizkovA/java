package epam.com.java.module2.files.optinaltask.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWithRandomNumbers {
    public static void main(String[] args) {
        File dir = new File("src/main/resources/data");
        dir.mkdir();
        File file = new File(dir.getAbsolutePath(),"fileTask1.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < 5; i++) {
                int number = (int) (Math.random()*100);
                bw.write(Integer.toString(number));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Collections.sort(list);


        dir = new File("src/main/resources/result");
        dir.mkdir();
        File newFile = new File(dir.getAbsolutePath(), "ResultTask1.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFile))) {
            for (Integer item : list) {
                bw.write(Integer.toString(item));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



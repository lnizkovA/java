package epam.com.java.module2.files.optinaltask.task2;

import java.io.*;

public class ReplacePublicToPrivate {
    public static void main(String[] args) {

        File file = new File("src/main/resources/data/Student.java");

        File resultDir = new File("src/main/resources/result");
        File resultFile = new File(resultDir.getAbsolutePath(), "ResultTask2.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file));
             BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile))) {
            String line;
            while ((line = br.readLine()) != null) {
//                String[] strings = line.split("\\s");
//                System.out.println(strings.toString());
//                for (String item : strings) {
//                    if (item.equals("public")) {
//                        item = "private";
//                    }
//                    bw.write(item + " ");
//                }
//                bw.newLine();
                if (line.trim().contains("public")){
                    line = line.replace("public", "private");
                }
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}

package epam.com.java.module2.files.optinaltask.task5;

import java.io.*;

public class StudentAndAverageMark {
    public static void main(String[] args) {
        File file = new File("src/main/resources/data/task5.txt");

        File dir = new File("src/main/resources/result");
        dir.mkdir();
        File resultFile = new File(dir.getAbsolutePath(), "ResultTask5.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile))){
            String line;
            while ((line = br.readLine()) !=null){
                String[] strings = line.split("\\s*(\\s|,|!|\\.)\\s*");
                bw.write(overwriteSurname(strings)+" ");
                for (int i=1 ; i< strings.length; i++){
                    bw.write(strings[i]+" ");
                }
                bw.newLine();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private static String overwriteSurname(String [] strings){
        double sum =0;
        int count = 0;
        for(int i=1; i< strings.length; i++){
            sum += Double.parseDouble(strings[i]);
            count++;
        }
        if ((sum/count) < 7){
            return strings[0].toLowerCase();
        } else {
            return strings[0];
        }
    }
}

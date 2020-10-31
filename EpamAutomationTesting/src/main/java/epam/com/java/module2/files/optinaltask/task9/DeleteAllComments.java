package epam.com.java.module2.files.optinaltask.task9;

import java.io.*;

public class DeleteAllComments {

    public static void main(String[] args) {

        File file = new File("src/main/resources/data/task9.java");

        File resultDir = new File("src/main/resources/result");
        File resultFile = new File(resultDir.getAbsolutePath(), "ResultTask9.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file));
             BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile))) {
            String line;
            boolean insideMultiLineComment = false;
            while ((line = br.readLine()) != null) {
                if (line.trim().endsWith("*/")) {
                    insideMultiLineComment = false;
                    continue;
                }
                if (insideMultiLineComment) {
                    continue;
                }
                if (line.trim().startsWith("//")) {
                    continue;
                }

                if (line.contains("//")) {
                    line = line.substring(0, line.indexOf("//"));
                    insideMultiLineComment = false;
                }

                if (line.trim().startsWith("/*") && line.trim().endsWith("*/")) {
                    continue;
                }

                if (line.trim().startsWith("/*") && !line.contains("*/")) {
                    insideMultiLineComment = true;
                    continue;
                }

                if (line.contains("/*")) {
                    int firstIndex = line.indexOf("/*");
                    if (line.contains("*/")) {
                        if (line.trim().endsWith("*/")) {
                            line = line.substring(0, firstIndex);
                        } else {
                            int lastIndex = line.lastIndexOf("*/");
                            line = line.substring(0, firstIndex).concat(line.substring(lastIndex + 2));
                        }
                    } else {
                        line = line.substring(0, firstIndex);
                        insideMultiLineComment = true;
                    }
                }

                bw.write(line + " ");
                bw.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}


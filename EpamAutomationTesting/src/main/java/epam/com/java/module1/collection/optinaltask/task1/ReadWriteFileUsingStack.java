package epam.com.java.module1.collection.optinaltask.task1;

import java.io.*;
import java.util.Stack;

//Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.

public class ReadWriteFileUsingStack {
    private static final String FILE_NAME = "task1.txt";

    public static void main(String[] args) {

//        1. This document serves as the complete definition of Google's coding standards for source code in the Java™ Programming Language.
//        2. A Java source file is described as being in Google Style if and only if it adheres to the rules herein.
//        3. Like other programming style guides, the issues covered span not only aesthetic issues of formatting,
//        4. but other types of conventions or coding standards as well.
//        5. However, this document focuses primarily on the hard-and-fast rules
//        6. that we follow universally, and avoids giving advice that isn't clearly enforceable (whether by human or tool).


        Stack<String> stack = new Stack<String>();
        File file = new File("src/main/resources/task1.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = br.readLine() )!= null){
                stack.push(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            while (!stack.isEmpty()){
                bw.write(stack.pop());
                bw.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}

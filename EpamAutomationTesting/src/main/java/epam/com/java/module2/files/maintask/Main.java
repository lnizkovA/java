package epam.com.java.module2.files.maintask;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        String inputParam = "c:/data";
        String inputParam = "c:/webdrivers/test2.txt";
        FileWalkerUtils walker = new FileWalkerUtils();
        walker.checkInputParamIfFileOrDir(inputParam);

    }
}

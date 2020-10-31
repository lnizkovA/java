package epam.com.java.module2.files.maintask;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Pattern;

public class FileWalkerUtils {

    public void walk(String path, int depth) {
        File file = new File(path);
        File[] files = file.listFiles();

        if (files == null) {
            return;
        }
        depth++;
        for (File f : files) {
            boolean isDirectory = f.isDirectory();
            System.out.println("| " + createLine(depth, isDirectory) + f.getName());
            if (f.isDirectory()) {
                walk(f.getAbsolutePath(), depth);
            }
        }
    }

    public String createLine(int depth, boolean isDirectory) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            line.append(isDirectory ? "-" : " ");
        }
        return line.toString();
    }

    public void checkInputParamIfFileOrDir(String inputParam) throws IOException {
        File file = new File(inputParam);
        if (file.isFile()) {
            System.out.println(file.getName());
            Path dir = Paths.get(file.getParent());
            countFolders(dir);
            countFiles(dir);
            countAverageName(file);
        } else {
            if (file.isDirectory()) {
                walk(inputParam, 0);
            }
        }
    }

    private void countAverageName(File file) {
        String[] strings = (file.getAbsolutePath()).split(Pattern.quote(File.separator));
        double countChars = 0;
        for (String s: strings ) {
            countChars += (s.contains(":") ? (s.substring(0, s.indexOf(":"))).length() : s.length());
        }
        NumberFormat formatted = new DecimalFormat("#0.00");
        System.out.println("Average number of File name = "+ formatted.format(countChars/strings.length));
    }

    private void countFiles(Path dir) throws IOException {
        long count = Files.list(dir)
                .filter(p -> Files.isRegularFile(p)).count();
        System.out.println("In directory "+dir+" file(s) = "+count);
    }

    private void countFolders(Path dir) throws IOException {
        long count = Files.list(dir)
                .filter(p -> Files.isDirectory(p) && !p.equals(dir)).count();
        System.out.println("In directory "+dir+" folder(s) = "+count);
    }


}

package decorator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Марат on 16.11.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream(new File("../2.homework/src/main/resources/in.txt"));
        CaeserInputStream caeserInputStream = new CaeserInputStream(inputStream);
        int c;
        while ((c = caeserInputStream.read()) != -1) {
            System.out.print((char) c);
        }
    }
}

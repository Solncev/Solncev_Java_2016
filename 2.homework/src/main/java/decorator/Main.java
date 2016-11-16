package decorator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Марат on 16.11.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File("../2.homework/src/main/resources/in.txt")));
        CaeserReader caeserReader = new CaeserReader(inputStreamReader);
        int c;
        while ((c = caeserReader.read()) != -1) {
            System.out.print((char) c);
        }
    }
}

package ru.itis.kpfu.decorator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Марат on 13.11.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream(new File("in.txt"));
        CaeserInputStream caeserInputStream = new CaeserInputStream(is);
        int c;
        while ((c = caeserInputStream.read()) != -1) {
            System.out.print(Character.toChars(c));
//            System.out.println((char) (c + '0'));
        }
    }
}

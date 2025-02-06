package ru.io.files;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Фильтрация файлов/
 * Размер файла в байтах
 */
public class Filter {
    public static void main(String[] args)
    {
        try {
            FileInputStream fis;
            fis = new FileInputStream("C:\\\\test_dir\\\\test.txt");
            System.out.println("Размер файла: " + fis.available() + " байт(а)");
            int i = -1;
//            while(( i = fis.read()) != -1){
//                System.out.print((char)i);
//            }
            fis.close();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}

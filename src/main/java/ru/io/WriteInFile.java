package ru.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteInFile {
    public static void main(String[] args) {
        try {
            // Запись в файл
            FileWriter writer = new FileWriter("JavaIO.txt");
            writer.write("Hello, Java IO!");
            writer.close();

            // Чтение из файла
            FileReader reader = new FileReader("JavaIO.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            System.out.println("Read from file: " + line);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

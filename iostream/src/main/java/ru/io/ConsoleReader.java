package ru.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

    public static void main(String[] args) {

        // Вся история введенных данные с консоли сохраняется в файл
        String outputFile = "ConsoleFile.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                String line;
                // Условие прервывание является написание слово exit в Консоли
                while (!(line = reader.readLine()).equals("exit")) {
                    writer.write(line);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package ru.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    public static void main(String[] args) {
        String outputFileName = "FileOfWrite.txt";
        String[] array = { "Hello", ",", "Not", "World" };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (String value : array) {
                writer.write(value + " ");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
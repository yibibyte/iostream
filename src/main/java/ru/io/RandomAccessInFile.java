package ru.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile используется для записи и чтения строки из файла.
 *  Он также позволяет устанавливать указатель файла
 *  в конкретное место для произвольного доступа.
 */
public class RandomAccessInFile {
    public static void main(String[] args) {
        // Запись в файл
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("randomFile.txt", "rw")) {
            randomAccessFile.writeUTF("Hello, RandomAccessFile!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Чтение из файла
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("randomFile.txt", "r")) {
            String message = randomAccessFile.readUTF();
            System.out.println("Read from RandomAccessFile: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package ru.io.files;

import java.io.RandomAccessFile;
import java.io.IOException;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        String filePath = "example.txt"; // Путь к файлу

        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            // Записываем данные в файл
            raf.writeUTF("Привет, мир!"); // Записываем строку
            raf.writeInt(12345);          // Записываем целое число
            raf.writeDouble(3.14159);     // Записываем число с плавающей точкой

            // Перемещаемся в начало файла для чтения
            raf.seek(0);

            // Читаем данные из файла
            String text = raf.readUTF();       // Читаем строку
            int number = raf.readInt();        // Читаем целое число
            double pi = raf.readDouble();      // Читаем число с плавающей точкой

            // Выводим прочитанные данные
            System.out.println("Строка: " + text);
            System.out.println("Целое число: " + number);
            System.out.println("Число с плавающей точкой: " + pi);

            raf.seek(10); // Перемещаемся на позицию 10
            raf.writeBytes("Новое значение"); // Записываем новые данные

            long fileSize = raf.length();
            System.out.println("Размер файла: " + fileSize + " байт");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
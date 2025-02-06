package ru.io.files;

import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        File file = new File("example.txt");

        try {
            // Создание нового файла
            if (file.createNewFile()) {
                System.out.println("\nФайл создан: " + file.getName());
            } else {
                System.out.println("\nФайл уже существует.");
            }

            // Получение информации о файле
            System.out.println("Абсолютный путь: " + file.getAbsolutePath());
            System.out.println("Размер файла: " + file.length() + " байт");
            System.out.println("Последнее изменение: " + file.lastModified());

            // Удаление файла
            if (file.delete()) {
                System.out.println("Файл удален.");
            } else {
                System.out.println("Не удалось удалить файл.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

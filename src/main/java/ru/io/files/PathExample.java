package ru.io.files;

import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class PathExample {
    public static void main(String[] args) {
        // Создание объекта Path
        Path path = Paths.get("E:\\Java\\iostream\\file2.txt");

        // Проверка существования файла
        if (Files.exists(path)) {
            System.out.println("Файл существует.");
        } else {
            System.out.println("Файл не существует.");
        }

        // Создание нового файла
        try {
            Files.createFile(path);
            System.out.println("Файл создан.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Запись в файл
        try {
            Files.write(path, "Привет, мир!".getBytes(StandardCharsets.UTF_8));
            System.out.println("Данные записаны в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Чтение из файла
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            System.out.println("Содержимое файла:");
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Удаление файла
        try {
            Files.delete(path);
            System.out.println("Файл удален.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
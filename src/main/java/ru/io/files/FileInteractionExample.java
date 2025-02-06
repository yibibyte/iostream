package ru.io.files;

import java.io.*;

public class FileInteractionExample {

    public static void main(String[] args) {
        // Создаем объект File для работы с файлом
        File file = new File("example.txt");

        // Используем FileFilter для фильтрации файлов
        FileFilter textFileFilter = pathname -> pathname.getName().endsWith(".txt");

        // Проверяем, является ли файл текстовым
        if (textFileFilter.accept(file)) {
            System.out.println("Файл является текстовым.");

            // Запись в файл с использованием Writer и BufferedWriter
            try (Writer writer = new FileWriter(file);
                 BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                bufferedWriter.write("Привет, мир!");
                bufferedWriter.newLine();
                bufferedWriter.write("Это пример использования BufferedWriter.");
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Чтение из файла с использованием Reader и BufferedReader
            try (Reader reader = new FileReader(file);
                 BufferedReader bufferedReader = new BufferedReader(reader)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Использование InputStream и OutputStream для копирования файла
            File copiedFile = new File("example_copy.txt");
            try (InputStream inputStream = new FileInputStream(file);
                 OutputStream outputStream = new FileOutputStream(copiedFile)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Чтение из скопированного файла с использованием BufferedReader
            try (Reader reader = new FileReader(copiedFile);
                 BufferedReader bufferedReader = new BufferedReader(reader)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Файл не является текстовым.");
        }
    }
}
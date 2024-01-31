package ru.io;

import java.io.*;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileZip {

    public static void main(String[] args) throws IOException {

        // Создаем файл для архивирования
        Path inputFile = Paths.get("input.txt");

        // Создаем объект File для файла
        File inputFileObject = inputFile.toFile();

        // Создаем объект BufferedReader для чтения файла
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileObject))) {

            // Создаем объект Path для архива
            Path zipFile = Paths.get("output.zip");

            // Создаем объект ZipOutputStream для архивирования
            try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile.toFile()))) {

                // Добавляем в архив файл
                ZipEntry zipEntry = new ZipEntry(inputFileObject.getName());
                zipOutputStream.putNextEntry(zipEntry);

                // Читаем данные из файла и записываем их в архив
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    zipOutputStream.write(line.getBytes());
                }

            }
        }
    }
}

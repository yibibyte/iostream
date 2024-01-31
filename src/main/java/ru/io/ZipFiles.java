package ru.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipFiles {
    public static void main(String[] args) {
        // Создаем файл zip
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("archive.zip"))) {
            // Добавляем файлы в zip
            addToZip("file1.txt", zipOutputStream);
            addToZip("file2.txt", zipOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Извлекаем файлы из zip
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("archive.zip"))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                System.out.println("Extracting: " + entry.getName());
                // Чтение данных из zip
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = zipInputStream.read(buffer)) != -1) {
                    System.out.write(buffer, 0, bytesRead);
                }
                System.out.println(); // Перевод строки между файлами
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addToZip(String fileName, ZipOutputStream zipOutputStream) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            ZipEntry entry = new ZipEntry(fileName);
            zipOutputStream.putNextEntry(entry);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                zipOutputStream.write(buffer, 0, bytesRead);
            }

            zipOutputStream.closeEntry();
        }
    }
}

package ru.io.Converter;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConverterRelativePath {

    // Конвертирует наш файл на основе Path класса
    public static String convertToAbsolutePath(String relativePath) {

        Path absolutePath = Paths.get(relativePath).toAbsolutePath();
        return absolutePath.toString();
    }

    // Конвертирует наш файл на основе File класса
    public static String convertToAbsolutePathFromFile(String relativePath) {
        File file = new File(relativePath);
        return file.getAbsolutePath();
    }

    // Конвертирует наш файл на основе FileSystem класса
    public static String convertToAbsoluteFileFromFileSystems(String relativePath) {
        Path absolutePath = FileSystems.getDefault().getPath(relativePath).toAbsolutePath();
        return absolutePath.toString();
    }

    public static void main(String[] args) {
        String relativePath = "folder/file.txt";
        String absolutePath = convertToAbsolutePathFromFile(relativePath);
        System.out.println("Absolute Path: " + absolutePath);
    }

}

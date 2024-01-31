package ru.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInFile {
    public static void main(String[] args) throws IOException {
        File file = new File("");

        //Создание потока, который будет осуществлять чтение байтов из нашего файла
        try (FileInputStream inputStream = new FileInputStream("data.txt");
        FileOutputStream outputStream = new FileOutputStream("result.txt")) {

        //Создание потока, который будет записывать байтов из нашего файла


        byte[] buffer = new byte[1000];

        //Пока есть еще непрочитанные байты, будем продолжать работать с циклом while
        while (inputStream.available() > 0) {

            // Читаем блок байт массива buffer и количество байт в count
            int count = inputStream.read(buffer);

            //Записываем блок частями в выходной поток
            outputStream.write(buffer, 0, count);
        }
        //Обазательно закрываем потоки
        inputStream.close();
        outputStream.close();
        }
    }
}
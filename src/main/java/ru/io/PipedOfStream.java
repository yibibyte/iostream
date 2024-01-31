package ru.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Создаются PipedOutputStream и PipedInputStream, и данные,
 * записанные в PipedOutputStream потоком записи (writerThread),
 * читаются из PipedInputStream потоком чтения (readerThread).
 * Оба потока работают параллельно.
 */
public class PipedOfStream {
    public static void main(String[] args) {
        try {
            // Создаем потоки
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

            // Создаем и запускаем потоки для записи и чтения
            Thread writerThread = new Thread(() -> writeToStream(pipedOutputStream));
            Thread readerThread = new Thread(() -> readFromStream(pipedInputStream));

            writerThread.start();
            readerThread.start();

            // Ждем завершения потоков
            writerThread.join();
            readerThread.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void writeToStream(PipedOutputStream pipedOutputStream) {
        try {
            // Записываем данные в PipedOutputStream
            String message = "Hello, PipedOutputStream!";
            pipedOutputStream.write(message.getBytes());
            pipedOutputStream.close(); // Закрываем поток после записи
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromStream(PipedInputStream pipedInputStream) {
        try {
            // Читаем данные из PipedInputStream
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = pipedInputStream.read(buffer)) != -1) {
                result.write(buffer, 0, bytesRead);
            }

            // Выводим прочитанные данные
            System.out.println("Read from PipedInputStream: " + result.toString());
            pipedInputStream.close(); // Закрываем поток после чтения
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

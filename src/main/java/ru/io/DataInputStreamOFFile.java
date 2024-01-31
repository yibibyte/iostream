package ru.io;

import java.io.*;

/**
 * Пример демонстрирует использование DataOutputStream для записи примитивных данных
 * в файл и DataInputStream для их чтения. В данном случае, записываются
 * целое число, дробное число и строка
 */
public class DataInputStreamOFFile {
    public static void main(String[] args) {
        // Запись данных в файл
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("dataFile.dat"))) {
            dataOutputStream.writeInt(42);
            dataOutputStream.writeDouble(3.14);
            dataOutputStream.writeUTF("Hello, DataInputStream!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Чтение данных из файла
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("dataFile.dat"))) {
            int intValue = dataInputStream.readInt();
            double doubleValue = dataInputStream.readDouble();
            String stringValue = dataInputStream.readUTF();

            System.out.println("Read int: " + intValue);
            System.out.println("Read double: " + doubleValue);
            System.out.println("Read String: " + stringValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

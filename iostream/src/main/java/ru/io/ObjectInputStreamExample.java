package ru.io;

import java.io.*;

/**
 * Пример демонстрирует сериализацию объекта Person в файл
 * с использованием ObjectOutputStream и десериализацию объекта
 * из файла с использованием ObjectInputStream.
 */
public class ObjectInputStreamExample {
    public static void main(String[] args) {
        // Запись объекта в файл
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            Person person = new Person("John", 25);
            objectOutputStream.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Чтение объекта из файла
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person loadedPerson = (Person) objectInputStream.readObject();
            System.out.println("Read from ObjectInputStream: " + loadedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

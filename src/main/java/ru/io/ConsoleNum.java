package ru.io;

import java.util.Scanner;

public class ConsoleNum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число:");

        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            System.out.println("Вы ввели число " + number);
        } else {
            System.out.println("Извините, но это не число. Попробуйте заново");
        }

        /*
        while (scanner.hasNext()) {
            System.out.println(sc.next());
        }
        */
        scanner.close();
    }
}

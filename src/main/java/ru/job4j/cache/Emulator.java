package ru.job4j.cache;

import java.io.IOException;
import java.util.Scanner;

public class Emulator {

    private static void showChoiceMenu() {
        System.out.println("Введите 1 для загрузки содержимого в кэш \n"
                + "Введите 2 для получения содержимого из кэша\n"
                + "Введите 3 для выхода из программы");
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите кэшируемую директорию:");
        String directoryName = scanner.nextLine();
        AbstractCache<String, String> cache = new DirFileCache(directoryName);
        boolean run = true;
        while (run) {
            System.out.println("Введите имя файла");
            String fileName = scanner.next();
            showChoiceMenu();
            int task = scanner.nextInt();
            if (task == 1) {
                cache.put(fileName, cache.load(fileName));
                System.out.println("Данные успешно загружены.");
            }
            if (task == 2) {
                System.out.println(cache.get(fileName));
            }
            if (task == 3) {
                run = false;
            }
        }
    }
}
package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class TODOApp {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        MenuPrinter menuPrinter = new ConsolePrint();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Введите 1 что бы добавить новый пункт меню"
                    + System.lineSeparator()
                    + "Введите 2 что бы посмотреть меню"
                    + System.lineSeparator()
                    + "Введите 3 что бы выйти из программы");
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input == 1) {
                System.out.println("Пункт меню являетя родительским: да/нет ");
                String mainMenu = scanner.nextLine();
                String parentName = Menu.ROOT;
                if ("нет".equals(mainMenu)) {
                    System.out.println("Введите название родительского пункта меню");
                    parentName = scanner.nextLine();
                }
                System.out.println("Введите название пункта меню");
                String childName = scanner.nextLine();
                boolean result = menu.add(parentName, childName, STUB_ACTION);
                if (!result) {
                    throw new IllegalArgumentException("Пункт отстутствует в меню");
                }
            } else if (input == 2) {
                menuPrinter.print(menu);
            } else if (input == 3) {
                run = false;
            } else {
                System.out.println("Ошибка ввода");
            }
        }
    }
}
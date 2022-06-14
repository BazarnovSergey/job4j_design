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
            System.out.println("������� 1 ��� �� �������� ����� ����� ����" + System.lineSeparator()
                    + "������� 2 ��� �� ���������� ����" + System.lineSeparator()
                    + "������� 3 ��� �� ����� �� ���������");
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input == 1) {
                System.out.println("����� ���� �������� �������: ��/��� ");
                String mainMenu = scanner.nextLine();
                String parentName = Menu.ROOT;
                if ("���".equals(mainMenu)) {
                    System.out.println("������� �������� ������������� ������ ����");
                    parentName = scanner.nextLine();
                }
                System.out.println("������� �������� ������ ����");
                String childName = scanner.nextLine();
                boolean result = menu.add(parentName, childName, STUB_ACTION);
                if (!result) {
                    throw new IllegalArgumentException("����������� ����� � ����� ���������");
                }
            } else if (input == 2) {
                menuPrinter.print(menu);
            } else if (input == 3) {
                run = false;
            } else {
                System.out.println("������ �����");
            }
        }
    }
}

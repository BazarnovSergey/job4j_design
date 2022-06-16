package ru.job4j.ood.isp.menu;

public class ConsolePrint implements MenuPrinter {

    public static final String LINE = "----";

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo menuItemInfo : menu) {
            String number = menuItemInfo.getNumber();
            String name = menuItemInfo.getName();
            String separator = LINE.repeat(menuItemInfo.getNumber().split("\\.").length - 1);
            System.out.println(separator + number + name);
        }
    }
}
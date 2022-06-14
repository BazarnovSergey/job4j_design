package ru.job4j.ood.isp.menu;

public class ConsolePrint implements MenuPrinter {
    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo menuItemInfo : menu) {
            String number = menuItemInfo.getNumber();
            String name = menuItemInfo.getName();
            int lineLength = (int) number.chars().
                    filter(ch -> ch == '.').
                    count() - 1;
            System.out.println("----".repeat(lineLength) + number + name);
        }
    }
}
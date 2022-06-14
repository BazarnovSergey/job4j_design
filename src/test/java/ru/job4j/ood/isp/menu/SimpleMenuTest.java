package ru.job4j.ood.isp.menu;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;

public class SimpleMenuTest {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    public void whenAddThenReturnSame() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "������� � �������", STUB_ACTION);
        menu.add(Menu.ROOT, "��������� ������", STUB_ACTION);
        menu.add("������� � �������", "������ ��������", STUB_ACTION);
        menu.add("������ ��������", "������ ����", STUB_ACTION);
        menu.add("������ ��������", "������ ������", STUB_ACTION);
        assertEquals(
                new Menu.MenuItemInfo(
                        "������� � �������", List.of("������ ��������"), STUB_ACTION, "1."
                ),
                menu.select("������� � �������").get()
        );
        assertEquals(
                new Menu.MenuItemInfo(
                        "������ ��������", List.of("������ ����", "������ ������"), STUB_ACTION, "1.1."
                ),
                menu.select("������ ��������").get()
        );
        assertEquals(
                new Menu.MenuItemInfo(
                        "��������� ������", List.of(), STUB_ACTION, "2."
                ),
                menu.select("��������� ������").get()
        );
        menu.forEach(i -> System.out.println(i.getNumber() + i.getName()));
    }

    @Test
    public void whenSelectMenuItem() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "������� � �������", STUB_ACTION);
        menu.add(Menu.ROOT, "��������� ������", STUB_ACTION);
        menu.add("������� � �������", "������ ��������", STUB_ACTION);
        menu.add("������ ��������", "������ ����", STUB_ACTION);
        menu.add("������ ��������", "������ ������", STUB_ACTION);
        assertEquals(
                new Menu.MenuItemInfo(
                        "������ ������", List.of(), STUB_ACTION, "1.1.2."
                ),
                menu.select("������ ������").get()
        );
    }

    @Test
    public void whenConsolePrint() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Menu menu = new SimpleMenu();
        MenuPrinter menuPrinter = new ConsolePrint();
        menu.add(Menu.ROOT, "������� � �������", STUB_ACTION);
        menu.add(Menu.ROOT, "��������� ������", STUB_ACTION);
        menu.add("������� � �������", "������ ��������", STUB_ACTION);
        menu.add("������ ��������", "������ ����", STUB_ACTION);
        menu.add("������ ��������", "������ ������", STUB_ACTION);
        String ls = System.lineSeparator();
        String expected = "1.������� � �������" + ls
                + "----1.1.������ ��������" + ls
                + "--------1.1.1.������ ����" + ls
                + "--------1.1.2.������ ������" + ls
                + "2.��������� ������" + ls;
        menuPrinter.print(menu);
        assertEquals(expected, output.toString()
                );
        System.setOut(null);
    }
}

package ru.job4j.collection.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User user1 = new User("Andrey", 1,
                new GregorianCalendar(1988, Calendar.DECEMBER, 29));
        User user2 = new User("Andrey", 1,
                new GregorianCalendar(1988, Calendar.DECEMBER, 29));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        for (User user : map.keySet()) {
            System.out.println("key=" + user + " value=" + map.get(user));
        }
    }
}


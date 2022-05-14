package ru.job4j.gc;

public class User {
    private int id;
    private String name;


    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", id, name);
    }

    public static void main(String[] args) {
        GCDemo.info();
        for (int i = 1; i < 18200; i++) {
            new User(i, "Name" + i);
        }
        GCDemo.info();
    }
}

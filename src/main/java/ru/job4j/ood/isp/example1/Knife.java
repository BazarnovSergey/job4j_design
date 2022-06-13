package ru.job4j.ood.isp.example1;

public class Knife implements Weapon {
    @Override
    public void attack() {
        System.out.println("Режет");
    }

    @Override
    public void reload() {
    }
}
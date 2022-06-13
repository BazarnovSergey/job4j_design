package ru.job4j.ood.isp.example1;

public class Gun implements Weapon {

    @Override
    public void attack() {
        System.out.println("Стреляет");
    }

    @Override
    public void reload() {
        System.out.println("Перезаряжает");
    }
}

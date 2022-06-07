package ru.job4j.ood.lsp.foodstore;

import java.time.LocalDate;

public class Chicken extends Food {

    public Chicken(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}

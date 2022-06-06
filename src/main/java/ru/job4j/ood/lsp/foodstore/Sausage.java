package ru.job4j.ood.lsp.foodstore;

import java.time.LocalDate;

public class Sausage extends Food {

    public Sausage(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}

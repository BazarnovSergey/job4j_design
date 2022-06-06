package ru.job4j.ood.lsp.foodstore;

import java.util.List;

public interface Store {

    List<Food> getFoodList();

    void check(Food food);

}

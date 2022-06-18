package ru.job4j.ood.lsp.foodstore;

import java.util.ArrayList;
import java.util.List;

import static ru.job4j.ood.lsp.foodstore.PercentConstants.*;

public class Trash implements Store {
    private List<Food> foodList = new ArrayList<>();

    public boolean add(Food food) {
        boolean rsl = false;
        if (check(food)) {
            foodList.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getFoodList() {
        return new ArrayList<Food>(foodList);
    }

    @Override
    public boolean check(Food food) {
        return getPercentLifeExpired(food) > PERCENT_100;
    }

    @Override
    public void clearStorage() {
        foodList.clear();
    }
}
package ru.job4j.ood.lsp.foodstore;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private List<Food> foodList = new ArrayList<>();

    private void add(Food food) {
        foodList.add(food);
    }

    @Override
    public List<Food> getFoodList() {
        return foodList;
    }

    @Override
    public void check(Food food) {
        long expirationDate = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        long timeFromDateOfManufacture = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDateTime.now());

        if (timeFromDateOfManufacture > expirationDate) {
            foodList.add(food);
        }
    }
}
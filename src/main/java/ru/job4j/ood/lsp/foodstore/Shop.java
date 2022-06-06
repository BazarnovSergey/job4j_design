package ru.job4j.ood.lsp.foodstore;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
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
        float expirationDate = (float) ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        float timeFromDateOfManufacture = (float) ChronoUnit.DAYS.between(food.getCreateDate(), LocalDateTime.now());
        float percent = (timeFromDateOfManufacture / expirationDate) * 100;
        if (percent >= 25 && percent <= 75) {
            foodList.add(food);
        }
        if (percent > 75) {
            food.setPrice(food.getPrice() - food.getDiscount());
            foodList.add(food);
        }
    }
}
package ru.job4j.ood.lsp.foodstore;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public interface Store {

    List<Food> getFoodList();

    boolean add(Food food);

    boolean check(Food food);

    void clearStorage();

    default double getPercentLifeExpired(Food food) {
        float expirationDate = (float) ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        float timeFromDateOfManufacture = (float) ChronoUnit.DAYS.between(food.getCreateDate(), LocalDateTime.now());
        return (timeFromDateOfManufacture / expirationDate) * 100;
    }

}

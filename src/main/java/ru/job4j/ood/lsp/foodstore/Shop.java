package ru.job4j.ood.lsp.foodstore;

import java.util.ArrayList;
import java.util.List;

import static ru.job4j.ood.lsp.foodstore.PercentConstants.*;

public class Shop implements Store {
    private List<Food> foodList = new ArrayList<>();

    public boolean add(Food food) {
        double percent = getPercentLifeExpired(food);
        boolean rsl = false;
        if (check(food)) {
            if  (percent > PERCENT_75 && percent < PERCENT_100) {
                food.setPrice(food.getPrice() - food.getDiscount());
            }
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
        double percent = getPercentLifeExpired(food);
        return percent >= PERCENT_25 && percent <= PERCENT_100;
    }
}
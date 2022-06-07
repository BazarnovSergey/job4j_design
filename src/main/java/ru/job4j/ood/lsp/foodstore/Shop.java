package ru.job4j.ood.lsp.foodstore;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private List<Food> foodList = new ArrayList<>();

    public boolean add(Food food) {
        boolean rsl = false;
        if (check(food)) {
            food.setPrice(food.getPrice() - food.getDiscount());
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
        boolean rsl = false;
        double percent = getPercentLifeExpired(food);
        if (percent >= Food.PERCENT25 && percent <= Food.PERCENT75) {
            rsl = true;
        }
        if (percent > Food.PERCENT75 && percent < Food.PERCENT100) {
            rsl = true;
        }
        return rsl;
    }
}
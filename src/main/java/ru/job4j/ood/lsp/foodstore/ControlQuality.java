package ru.job4j.ood.lsp.foodstore;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void checkQuality(Food food) {
        for (Store store : stores) {
            if (store.check(food)) {
                store.add(food);
            }
        }
    }

    public void resort() {
        List<Food> foodList = new ArrayList<>();
        for (Store store : stores) {
            foodList.addAll(store.getFoodList());
            store.clearStorage();
        }
        for (Food food : foodList) {
            checkQuality(food);
        }
    }
}

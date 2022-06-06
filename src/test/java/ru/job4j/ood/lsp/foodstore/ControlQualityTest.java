package ru.job4j.ood.lsp.foodstore;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void whenSortBreadToWarehouse() {
        Food bread = new Bread("bread", LocalDate.now().plusDays(60),
                LocalDate.now().minusDays(2), 150, 0);
        Store warehouse = new Warehouse();
        List<Store> store = new ArrayList<>();
        store.add(warehouse);
        ControlQuality cq = new ControlQuality(store);
        cq.checkQuality(bread);
        assertThat(warehouse.getFoodList(), is(List.of(bread)));
    }

    @Test
    public void whenSortMilkToShop() {
        Food milk = new Milk("milk", LocalDate.now().plusDays(60),
                LocalDate.now().minusDays(60), 150, 0);
        Store shop = new Shop();
        List<Store> store = new ArrayList<>();
        store.add(shop);
        ControlQuality cq = new ControlQuality(store);
        cq.checkQuality(milk);
        assertThat(shop.getFoodList(), is(List.of(milk)));
    }

    @Test
    public void whenSortMilkToShopWithDiscount() {
        Food milk = new Milk("milk", LocalDate.now().plusDays(10),
                LocalDate.now().minusDays(60), 150, 50);

        Store shop = new Shop();
        List<Store> store = new ArrayList<>();
        store.add(shop);
        ControlQuality cq = new ControlQuality(store);
        cq.checkQuality(milk);
        assertThat(shop.getFoodList(), is(List.of(milk)));
        assertThat(milk.getPrice(), is(100.0));
    }

    @Test
    public void whenSortMilkToTrash() {
        Food sausage = new Sausage("sausage", LocalDate.now().minusDays(5),
                LocalDate.now().minusDays(60), 150, 0);
        Store trash = new Trash();
        List<Store> store = new ArrayList<>();
        store.add(trash);
        ControlQuality cq = new ControlQuality(store);
        cq.checkQuality(sausage);
        assertThat(trash.getFoodList(), is(List.of(sausage)));
    }
}
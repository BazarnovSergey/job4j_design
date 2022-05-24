package ru.job4j.kiss;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaxMinTest {

    @Test
    public void whenFindMaxIntegerType() {
        MaxMin maxMin = new MaxMin();
        int rsl = maxMin.max(List.of(3, 1, 5, 4, 2), Integer::compareTo);
        assertThat(rsl, is(5));
    }

    @Test
    public void whenFindMinIntegerType() {
        MaxMin maxMin = new MaxMin();
        int rsl = maxMin.min(List.of(3, 1, 5, 4, 2), Integer::compareTo);
        assertThat(rsl, is(1));
    }

    @Test
    public void whenFindMaxStringType() {
        MaxMin maxMin = new MaxMin();
        String rsl = maxMin.max(List.of("a", "c", "b", "e", "d"), String::compareTo);
        assertThat(rsl, is("e"));
    }

    @Test
    public void whenFindMinStringType() {
        MaxMin maxMin = new MaxMin();
        String rsl = maxMin.min(List.of("a", "c", "b", "e", "d"), String::compareTo);
        assertThat(rsl, is("a"));
    }
}
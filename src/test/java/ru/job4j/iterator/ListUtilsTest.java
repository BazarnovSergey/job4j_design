package ru.job4j.iterator;

import static org.hamcrest.core.Is.is;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenRemoveIfValueGreatThan3() {
        List<Integer> input = new ArrayList<>(List.of(0, 1, 2, 5, 2, 7, 3));
        ListUtils.removeIf(input, i -> i > 3);
        assertThat(input, is(List.of(0, 1, 2, 2, 3)));
    }

    @Test
    public void whenValueGreaterThan5ReplaceWith4() {
        List<Integer> input = new ArrayList<>(List.of(0, 1, 18, 2, 5, 2, 7, 3));
        ListUtils.replaceIf(input, i -> i > 5, 4);
        assertThat(input, is(List.of(0, 1, 4, 2, 5, 2, 4, 3)));
    }

    @Test
    public void whenRemoveAllValueFromList() {
        List<Integer> input = new ArrayList<>(List.of(0, 1, 18, 2, 5, 2, 7, 3));
        List<Integer> elements = new ArrayList<>(List.of(2, 3));
        ListUtils.removeAll(input, elements);
        assertThat(input, is(List.of(0, 1, 18, 5, 7)));
    }
}
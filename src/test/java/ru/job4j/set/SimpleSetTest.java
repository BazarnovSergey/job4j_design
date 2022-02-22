package ru.job4j.set;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenAdd7ReturnFalse() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(4));
        assertTrue(set.add(7));
        assertTrue(set.add(3));
        assertFalse(set.add(7));
    }

    @Test
    public void whenContainsReturnFalse() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(4));
        assertTrue(set.add(7));
        assertTrue(set.add(3));
        assertFalse(set.contains(9));
    }

    @Test
    public void whenContainsReturnTrue() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(4));
        assertTrue(set.add(7));
        assertTrue(set.add(3));
        assertTrue(set.contains(3));
    }
}
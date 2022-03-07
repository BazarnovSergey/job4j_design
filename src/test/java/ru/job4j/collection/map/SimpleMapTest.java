package ru.job4j.collection.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenPutFirstElementToEmptyMap() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        Assert.assertTrue(map.put("Jon", 2));
    }

    @Test
    public void whenPutThreeElements() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("Sam", 1);
        map.put("Jon", 2);
        map.put("Dave", 3);
        Assert.assertEquals(Integer.valueOf(3), map.get("Dave"));
    }

    @Test
    public void whenGetTrue() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("Dave", 21);
        Assert.assertEquals(Integer.valueOf(21), map.get("Dave"));
    }

    @Test
    public void whenGetElementsToEmptyMap() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        Assert.assertNull(map.get("Jon"));
    }

    @Test
    public void whenRemoveTrue() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("Martin", 1);
        map.put("Dave", 2);
        Assert.assertTrue(map.remove("Martin"));
    }

    @Test
    public void whenRemoveNotExistElement() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("Martin", 1);
        map.put("Dave", 2);
        Assert.assertFalse(map.remove("Kevin"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorNoSuchElementException() {
        Map<String, Integer> map = new SimpleMap<>();
        map.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIterator() {
        Map<String, Integer> map = new SimpleMap<>();
        map.iterator().next();
    }

    @Test
    public void whenGetIteratorSeveralTimes() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("Martin", 1);
        map.put("Dave", 2);
        Iterator<String> iterator = map.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("Martin", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("Dave", iterator.next());
        assertFalse(iterator.hasNext());
    }
}
package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private final int[] data;
    private int index = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    public boolean checkEven(int index) {
        return data[index] % 2 == 0;
    }

    @Override
    public boolean hasNext() {
        while (index < data.length && !checkEven(index)) {
            index++;
        }
        return index < data.length && checkEven(index);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }
}
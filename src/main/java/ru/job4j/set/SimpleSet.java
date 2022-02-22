package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(10);

    @Override
    public boolean add(T value) {
        boolean rsl;
        if (contains(value)) {
            rsl = false;
        } else {
            set.add(value);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean contains(T value) {
        Iterator<T> it = iterator();
        boolean rsl = false;
        if (value == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    rsl = true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (value.equals(it.next())) {
                    rsl = true;
                }
            }
        }
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
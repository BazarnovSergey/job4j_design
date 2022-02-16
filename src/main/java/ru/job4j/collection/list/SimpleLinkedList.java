package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;
    private int modCount;

    @Override
    public void add(E value) {
        if (size == 0) {
            firstNode = new Node<>(value, null);
            lastNode = firstNode;
        } else {
            Node<E> secondLas = lastNode;
            lastNode = new Node<>(value, null);
            secondLas.next = lastNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> element = firstNode;
        for (int i = 0; i < index; i++) {
            element = element.next;
        }
        return element.item;
    }

    private static class Node<E> {
        private final E item;
        private Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> node = firstNode;
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return node != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E item = node.item;
                node = node.next;
                return item;
            }
        };
    }
}


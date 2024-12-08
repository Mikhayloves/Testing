package org.sberuniversity;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomArrayIterator <T> implements Iterator<T> {
    private final T[] array;  // Массив объектов
    private int currentIndex;


    public CustomArrayIterator(T[] array) {
        this.array = array;
        this.currentIndex = 0;
    }
    @Override
    public boolean hasNext() {
        return currentIndex < array.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the array");
        }
        return array[currentIndex++]; // Возвращает текущий элемент и сдвигает индекс
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported.");
    }
}


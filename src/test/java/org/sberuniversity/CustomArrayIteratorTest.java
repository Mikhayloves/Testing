package org.sberuniversity;


import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayIteratorTest {

    @Test
    void testIterationWithNonEmptyArray() {
        String[] car = {"Ferrari", "Bently", "Citroen", "Dodge"};
        CustomArrayIterator<String> iterator = new CustomArrayIterator<>(car);

        assertTrue(iterator.hasNext());
        assertEquals("Ferrari", iterator.next());
        assertEquals("Bently", iterator.next());
        assertEquals("Citroen", iterator.next());
        assertEquals("Dodge", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testIterationWithEmptyArray() {

        Integer[] array = {};
        CustomArrayIterator<Integer> iterator = new CustomArrayIterator<>(array);
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}

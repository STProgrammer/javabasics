package Modul02;

import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class GenericStackArrayTest {
    private GenericStackArray<Integer> integerGenericStackArray;
    private GenericStackArray<String> stringGenericStackArray;
    private GenericStackArray<Integer> integerGenericStackArrayMinCapacity;
    private GenericStackArray<String> stringGenericStackArrayMinCapacity;

    @BeforeEach
    void setUp() {
        integerGenericStackArray = new GenericStackArray<>(100);
        stringGenericStackArray = new GenericStackArray<>(100);
        integerGenericStackArrayMinCapacity = new GenericStackArray<>(1);
        stringGenericStackArrayMinCapacity = new GenericStackArray<>(1);
    }

    @org.junit.jupiter.api.Test
    void size_EmptyIntegerArray_ReturnsZero() {
        assertThat(integerGenericStackArray.size(), is(0));
    }

    @org.junit.jupiter.api.Test
    void size_EmptyStringArray_ReturnsZero() {
        assertThat(stringGenericStackArray.size(), is(0));
    }

    @org.junit.jupiter.api.Test
    void peek_EmptyStack_returnsNull() {
        assertThat(integerGenericStackArray.peek(), is(nullValue()));
        assertThat(stringGenericStackArray.peek(), is(nullValue()));
    }

    @org.junit.jupiter.api.Test
    void push_NotEmptyStack_isNotNull() {
        integerGenericStackArray.push(3);
        assertThat(integerGenericStackArray.peek(), is(3));
        stringGenericStackArray.push("test");
        assertThat(stringGenericStackArray.peek(), is("test"));
    }

    @org.junit.jupiter.api.Test
    void pop_EmptyStack_ReturnsNull() {
        assertThat(integerGenericStackArray.pop(), is(nullValue()));
        assertThat(stringGenericStackArray.pop(), is(nullValue()));
    }

    @org.junit.jupiter.api.Test
    void pop_IntegerArray_ReturnsThree() {
        integerGenericStackArray.push(3);
        assertThat(integerGenericStackArray.pop(), is(3));
    }

    @org.junit.jupiter.api.Test
    void pop_StringArray_ReturnsTest() {
        stringGenericStackArray.push("test");
        assertThat(stringGenericStackArray.pop(), is("test"));
    }

    @org.junit.jupiter.api.Test
    void isFull_NotFullArray_ReturnsFalse() {
        assertThat(integerGenericStackArray.isFull(), is(false));
        assertThat(stringGenericStackArray.isFull(), is(false));
    }

    @org.junit.jupiter.api.Test
    void isFull_FullArray_ReturnsTrue() {
        integerGenericStackArrayMinCapacity.push(1);
        assertThat(integerGenericStackArrayMinCapacity.isFull(), is(true));
        stringGenericStackArrayMinCapacity.push("test");
        assertThat(stringGenericStackArrayMinCapacity.isFull(), is(true));
    }

    @org.junit.jupiter.api.Test
    void push_FullIntegerArray_DoublesArray() {
        integerGenericStackArrayMinCapacity.push(1);
        integerGenericStackArrayMinCapacity.push(2);
        integerGenericStackArrayMinCapacity.push(3);
        integerGenericStackArrayMinCapacity.push(4);
        assertThat(integerGenericStackArrayMinCapacity.getCapacity(), is(4));
    }

    void push_fullStringArray_DoublesArray() {
        stringGenericStackArrayMinCapacity.push("This");
        stringGenericStackArrayMinCapacity.push("is");
        stringGenericStackArrayMinCapacity.push("a");
        stringGenericStackArrayMinCapacity.push("test");
        stringGenericStackArrayMinCapacity.push("yes?");
    }

    @org.junit.jupiter.api.Test
    void isEmpty_EmptyStack_ReturnsTrue() {
        assertThat(integerGenericStackArray.isEmpty(), is(true));
        assertThat(stringGenericStackArray.isEmpty(), is(true));
    }

    @org.junit.jupiter.api.Test
    void isEmpty_NonEmptyStack_ReturnsFalse() {
        integerGenericStackArray.push(1);
        assertThat(integerGenericStackArray.isEmpty(), is(false));
        stringGenericStackArray.push("test");
        assertThat(stringGenericStackArray.isEmpty(), is(false));
    }
}
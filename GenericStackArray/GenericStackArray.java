package Modul02;

@SuppressWarnings("unchecked")
public class GenericStackArray<E> {
    private E[] elements;
    private int indexer;
    private int capacity;

    public GenericStackArray(int capacity) {
        elements = (E[]) new Object[capacity];
        this.capacity = capacity;
    }

    public int size() {
        indexer = 0;
        for (E element : elements) {
            if (element != null)
                indexer++;
        }
        return indexer;
    }

    public E peek() {
        if (size() == 0)
            return null;

        return elements[indexer - 1];
    }

    public void push(E o) {
        if (isFull()) {
            E[] elementsCopy = (E[]) new Object[elements.length * 2];
            System.arraycopy(elements, 0, elementsCopy, 0, elements.length);
            elements = elementsCopy;
            capacity = elements.length;
        }
        elements[indexer++] = o;
    }

    public E pop() {
        if (!isEmpty()) {
            E o = peek();
            elements[indexer - 1] = null;
            indexer--;
            return o;
        }
        return null;
    }

    public boolean isFull() {
        return elements.length == size();
    }

    public boolean isEmpty() {
        return indexer == 0;
    }

    public int getCapacity() {
        return capacity;
    }
}

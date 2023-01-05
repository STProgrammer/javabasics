import java.util.Arrays;

public class MyLinkedList<E> implements MyList<E> {
  private Node<E> head;
  private Node<E> tail;
  private int size = 0; // Number of elements in the list

  public MyLinkedList() {
  }

  public MyLinkedList(E[] objects) {
    this.addAll(Arrays.asList(objects));
  }

  public E getFirst() {
    return isEmpty() ? null : head.element;
  }

  public E getLast() {
    return isEmpty() ? null : tail.element;
  }

  @Override
  public int size() {
    return size;
  }

  /** Add an element to the beginning of the list */
  public void addFirst(E e) {
    Node<E> newHead = new Node<>(e);
    newHead.next = head;
    head = newHead;
    size++;

    if (tail == null) { // The new head is the only node in list
      tail = head;
    }
  }

  /** Add an element to the end of the list */
  public void addLast(E e) {
    Node<E> newTail = new Node<>(e);
    if (tail == null) { // The new tail is the only node in list
      head = tail = newTail;
    } else {
      tail.next = newTail; // Now old tail node points to new tail
      tail = tail.next; // Tail now points to the new tail node
    }

    size++;
  }

  /**
   * Add a new element at the specified index
   * in this list. The index of the head element is 0
   */
  @Override
  public void add(int index, E e) {
    if (index <= 0) { // Index smaller than 0 means that we set new head
      addFirst(e);
    } else if (index >= size) { // Index larger than size means that we set new tail
      addLast(e);
    } else {
      Node<E> current = getNodeAtIndex(--index);
      Node<E> temp = current.next;
      current.next = new Node<>(e);
      current.next.next = temp;
      size++;
    }
  }

  /**
   * Remove the head node and
   * return the object that is contained in the removed node.
   */
  public E removeFirst() {
    if (isEmpty()) { // No elements in list
      return null;
    } else {
      Node<E> temp = head; 
      head = head.next; 
      size--;
      if (head == null) { // If there were only one element in list then tail needs to point to null
        tail = null;
      }
      return temp.element; // Return deleted element
    }
  }

  /**
   * Remove the last node and
   * return the object that is contained in the removed node.
   */
  public E removeLast() {
    if (isEmpty()) {
      return null;
    } else if (size == 1) { // Only one element so we clear list and return head
      E temp = head.element;
      clear();
      return temp;
    } else {
      Node<E> current = getNodeAtIndex(size - 2);
      E temp = tail.element;
      tail = current;
      tail.next = null; // New tail needs to point to null instead of old tail
      size--;
      return temp;
    }
  }

  /**
   * Remove the element at the specified position in this
   * list. Return the element that was removed from the list.
   */
  @Override
  public E remove(int index) {
    checkIndex(index);

    if (index == 0) {
      return removeFirst();
    } else if (index == size - 1) {
      return removeLast();
    } else {
      Node<E> previous = getNodeAtIndex(--index);
      Node<E> current = previous.next; // Get the node at index
      previous.next = current.next;
      size--;
      return current.element;
    }
  }

  /** Override toString() to return elements in the list */
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("[");

    Node<E> current = head;

    for (int i = 0; i < size && current != null; i++, current = current.next) {
      result.append(current.element);
      result.append(", ");
    }

    result.deleteCharAt(result.length() - 1);
    result.append("]");
    return result.toString();
  }

  /** Clear the list */
  @Override
  public void clear() {
    size = 0;
    head = tail = null;
  }

  /** Return true if this list contains the element e */
  @Override
  public boolean contains(Object e) {
    if (isEmpty()) {
    	return false;
    }
    Node<E> current = head;
    for (int i = 0; i < size && current != null; i++) {
    	if (current.element.equals(e)) {
    		return true;
    	}
    	current = current.next;
    }
    return false;
  }

  /** Return the element at the specified index */
  @Override
  public E get(int index) {
	checkIndex(index);
	if (index == 0) {
    	return getFirst();
    }
    else if (index == size-1) {
    	return getLast();
    }
    else {
        Node<E> current = getNodeAtIndex(index);
        return current.element;
    }
  }

  /**
   * Return the index of the head matching element in
   * this list. Return - 1 if no match.
   */
  @Override
  public int indexOf(Object e) {
    if (isEmpty()) {
    	return -1;
    }
    Node<E> current = head;
	for (int index = 0; index < size && current != null; index++) {
    	if (current.element.equals(e)) {
    		return index;
    	}
    	current = current.next;
    }
    return -1;
  }

  /**
   * Return the index of the last matching element in
   * this list. Return - 1 if no match.
   */
  @Override
  public int lastIndexOf(E e) {
	  int index = -1;
	  if (isEmpty()) {
		  return index;
	  }
	  Node<E> current = head;
	  for (int i = 0; i < size && current != null; i++) {
		  if (current.element.equals(e)) {
			  index = i;
		  }
		  current = current.next;
	  }
	  return index;
  }

  /**
   * Replace the element at the specified position
   * in this list with the specified element.
   */
  @Override
  public E set(int index, E e) {
	  E returnelement;
    if (index < 1) {
    	returnelement = get(index);
    	head.element = e;
    }
    else if (index == size-1) {
    	returnelement = get(index);
    	tail.element = e;
    }
    else if (index == size) {
    	returnelement = get(index-1);
    	addLast(e);
    }
    else {
    	checkIndex(index);
    	returnelement = get(index);
    	Node<E> current = getNodeAtIndex(index);
    	current.element = e;
    }
    return returnelement;
  }

  /** Get node at specified index */
  private Node<E> getNodeAtIndex(int index) {
    Node<E> current = head;
    for (int i = 0; i < index; i++) { // Go till the node at index
      current = current.next;
    }
    return current;
  }

  /** Check if specified index is valid */
  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
  }

  /** Override iterator() defined in Iterable */
  @Override
  public java.util.Iterator<E> iterator() {
    return new LinkedListIterator();
  }

  private class LinkedListIterator implements java.util.Iterator<E> {
    private Node<E> current = head; // Current index

    @Override
    public boolean hasNext() {
      return (current != null);
    }

    @Override
    public E next() {
      E e = current.element;
      current = current.next;
      return e;
    }

    @Override
    public void remove() {
      System.out.println("Implementation left as an exercise");
    }
  }

  private static class Node<E> {
    E element;
    Node<E> next;

    public Node(E element) {
      this.element = element;
    }
  }
}

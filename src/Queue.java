import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.*;

public class Queue {
	public static void main(String[] args) {
		Queue queue = new Queue();
		for (int i = 0; i <= 20; i++)
			queue.enqueue(i);
		
		int n = queue.getSize();
		for (int i = 0; i < n; i++) {
			System.out.print(queue.dequeue() + " ");
		}
	}
	private int[] elements;// dette er køen
	private int size;
	/** Construct a queue with the default capacity 8 */
	public Queue() {
		elements = new int[8];
		}

	/** Add a new integer into the queue */
	public void enqueue(int value) {
		if (size >= elements.length) {// Er det plass i arrayet?
			int[] temp = new int[2*elements.length];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
			}
			elements[size++] = value;
			}
	/** Remove and return an element from the queue */
	public int dequeue() {
		int v = elements[0];
		for (int i=1; i < size; i++) {
			elements[i-1] = elements[i];
		} elements[size-1] = 0;
		size--;
		return v;
		}
	/** Test whether the queue is empty */
	public boolean empty() {
		return size == 0;
	}
	/** Return the number of elements in the queue */
	public int getSize() {
		return size;
	}
}
	

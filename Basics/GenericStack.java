
public class GenericStack<E> {
  private E [] elements;
  private int nrOfElements = 0;  // Variabel to track nr of elements in the array
  
  public GenericStack() {
	  this(100);
  }
  
  public GenericStack(int capacity) {
	  elements = (E[]) new Object[capacity];
  }

  public int getSize() {
    return nrOfElements;
  }

  public E peek() {
	  if (nrOfElements < 1) {
		  return null;
	  }
	  else 
		  return elements[nrOfElements-1];
  }

  public void push(E o) {
	  if (elements.length <= nrOfElements) {
		  E [] temp = (E[]) new Object[elements.length*2];
		  System.arraycopy(elements, 0, temp, 0, elements.length);
		  elements = temp;
	  }
	  elements[nrOfElements++] = o;
  }

  public E pop() {
	  if (nrOfElements < 1) {
		  return null;
	  }
	  E o = elements[--nrOfElements];
	  elements[nrOfElements] = null;
	  return o;
  }

  public boolean isEmpty() {
	  return (nrOfElements == 0);
  }
  
  public int getCapacity() {return elements.length;}
  
  @Override
  public String toString() {
	  String string = new String();
	  for (int i = 0; i < nrOfElements-1; i++) {
		  string += elements[i].toString() + ", ";
	  }
	  string += nrOfElements < 1 ? "" :elements[nrOfElements-1].toString();
	  return "stack: [" + string + "]";
  }
}

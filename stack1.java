/**
 * Stack class - Two Queue Version
 * @author 
 * @author
 * CIS 22C, Lab 3
 */

import java.util.NoSuchElementException;

public class Stack<T extends Comparable<T>> implements LIFO<T> {
	private Queue<T> queue1;
	private Queue<T> queue2;

	/**** CONSTRUCTORS ****/

	/**
	 * Default constructor for the Stack class
	 */
	public Stack() {
		queue1 = new Queue<T>();
		queue2 = new Queue<T>();
	}

	/**
	 * Converts an array into a Stack in the same order
	 * 
	 * @param array the array to copy
	 */
	public Stack(T[] array) {
		queue1 = new Queue<T>();
		queue2 = new Queue<T>();
		if (null == array) {
			return;
		}
		for (int i = 0; i < array.length; i++) {
			queue1.enqueue(array[i]);
		}
	}

	/**
	 * Copy constructor for the Stack class
	 * 
	 * @param original the Stack to copy
	 * @postcondition a new Stack object which is an identical, but distinct, copy
	 *                of original
	 */
	public Stack(Stack<T> original) {
		queue1 = new Queue<T>();
		queue2 = new Queue<T>();
		if (original == null) {
			return;
		}

		queue1 = new Queue<T>(original.queue1);
	}

	/**** ACCESSORS ****/

	// Add methods here

	/**** MUTATORS ****/

	// Add methods here

	/**** ADDITONAL OPERATIONS ****/

	/**
	 * Returns the values stored in the Queue as a String, separated by a blank
	 * space with a new line character at the end
	 * 
	 * @return a String of Stack values
	 */
	@Override
	public String toString() {
		return queue1.toString();
	}

	/**
     * Determines whether two objects are Stacks and
     * contain the same values in the same order
     * @param obj the Object to compare to this Stack
     * @return whether obj and this are equal
     */
    @SuppressWarnings("unchecked")
	@Override
    public boolean equals(Object obj) {
    	if(this == obj) {
    		return true;
    	}else if(!(obj instanceof Stack)) {
    		return false;
    	} else {
    		
    		Stack<T> n = (Stack<T>) obj;
    		return this.queue1.equals(n.queue1);
    	}
    }

	@Override
	public T peek() throws NoSuchElementException {
		return queue1.getFront();
	}

	@Override
	public int getSize() {
		return queue1.getSize();
	}

	@Override
	public boolean isEmpty() {
		return queue1.isEmpty();
	}

	@Override
	public void push(T data) {
		// move all the elements in q1 to q2
		while (!queue1.isEmpty()) {
			queue2.enqueue(queue1.getFront());
			queue1.dequeue();
		}
		// q1 receive the data on the top
		queue1.enqueue(data);

		// put the elements back to q1
		while (!queue2.isEmpty()) {
			queue1.enqueue(queue2.getFront());
			queue2.dequeue();
		}
	}

	@Override
	public void pop() throws NoSuchElementException {
		queue1.dequeue();
	}

	@Override
	public String reverseStack() {
		return queue1.reverseQueue();
	}

}

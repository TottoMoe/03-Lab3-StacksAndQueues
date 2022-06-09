/**
 * Stack class - Array Version
 * @author 
 * @author
 * CIS 22C, Lab 3
 */

import java.util.NoSuchElementException;

public class Stack<T> implements LIFO<T> {
	private T[] stack;
	private int curr_size;

	/**** CONSTRUCTORS ****/

	/**
	 * Default constructor for the Queue class with an initial length of 10 and no
	 * elements
	 */
	@SuppressWarnings("unchecked")
	public Stack() {
		stack = (T[]) new Object[10];
		curr_size = 0;

	}

	/**
	 * Converts an array into a Stack in the same order
	 * 
	 * @param array the array to copy
	 */
	@SuppressWarnings("unchecked")
	public Stack(T[] array) {
		if (array == null) {
			return;
		}
		stack = (T[]) new Object[array.length];	//copy the length
		for (int i = 0; i < array.length; i++) {
			stack[i] = array[i];	//copy each element
			curr_size++;
		}
	}

	/**
	 * Copy constructor for the Stack class
	 * 
	 * @param original the Stack to copy
	 * @postcondition a new Stack object which is an identical, but distinct, copy
	 *                of original
	 */
	@SuppressWarnings("unchecked")
	public Stack(Stack<T> original) {
		if (original == null || original.isEmpty()) {	//if original is empty, return
			return;
		}
		T[] ori = original.stack;
		stack = (T[]) new Object[ori.length];	//new stack with the original's length
		curr_size = 0;		//set size to default value 0
		for (int i = 0; i < original.curr_size; i++) {
			stack[i] = ori[i];		//copy each element
			curr_size++;
		}
	}

	/**** ACCESSORS ****/

	// Add methods here

	/**** MUTATORS ****/

	// Add methods here

	/**** ADDITONAL OPERATIONS ****/

	/**
	 * Returns the values stored in the Stack as a String, separated by a blank
	 * space with a new line character at the end
	 * 
	 * @return a String of Stack values
	 */
	@Override
	public String toString() {
		if (isEmpty()) {
			return "\n";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < curr_size; i++) {
			sb.append(stack[i]).append(" ");
		}
		sb.append("\n");
		return sb.toString();
	}

	/**
	 * Determines whether two obects are Stacks and contain the same values in the
	 * same order
	 * 
	 * @param obj the Object to compare to this Stack
	 * @return whether obj and this are equal
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
            return true;
        } else if (!(obj instanceof Stack)) {
            return false;
        } else {
            Stack<T> stack =  (Stack<T>) obj; 
            if (this.curr_size != stack.curr_size) {
                return false;
            } else {
                for (int i = 0; i < curr_size; i++) {
					if(!this.stack[i].equals(stack.stack[i])) {
						return false;
					}
				}
                return true;
            }
        }
	}

	/** PRIVATE HELPER METHODS */

	/**
	 * private helper method for reverseStack
	 * 
	 * @param index the current index
	 * @return a String of this Stack in reverse order
	 */
	private String reverseStack(int index) {
		StringBuilder sb = new StringBuilder();
		for (int i = curr_size - 1; i >= 0; i--) {
			sb.append(stack[i]).append(" ");
		}
		sb.append("\n");
		return sb.toString();
	}

	/**
	 * Increases the current array size by 10
	 */
	@SuppressWarnings("unchecked")
	private void resize() {
		T[] newStack = (T[]) new Object[stack.length + 10];	//create a new array with size +10;
		for (int i = 0; i < curr_size; i++) {	//copy each value
			newStack[i] = stack[i];
		}
		stack = newStack;
	}

	@Override
	public T peek() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return stack[0];
	}

	@Override
	public int getSize() {
		return curr_size;
	}

	@Override
	public boolean isEmpty() {
		return curr_size == 0;
	}

	@Override
	public void push(T data) {
		if (curr_size == 0) {
			stack[0] = data;
		} else {
			
			if(curr_size == stack.length - 1) {
				resize();
			} 
			
			for (int i = curr_size - 1; i >= 0; i--) {
				stack[i + 1] = stack[i];
			}
			stack[0] = data;
			
			
		}
		curr_size++;
	}

	@Override
	public void pop() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		
		for (int i = 0; i < curr_size; i++) {
			if(i == stack.length - 1) {
				stack[i] = null;
			}else {
				stack[i] = stack[i + 1];
			}
		}
		curr_size--;
	}

	@Override
	public String reverseStack() {
		if(isEmpty()) {
			return "\n";
		}
		
		return reverseStack(0);
	}
}

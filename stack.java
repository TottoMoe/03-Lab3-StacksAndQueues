/**
 * Stack class - singly-linked list version
 * @author
 * @author
 * CIS 22C, Lab 3
 */

import java.util.NoSuchElementException;

public class Stack<T> implements LIFO<T> {
    private class Node {
        private T data;
        private Node next;
        
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node top;
    private int size;
    
    /****CONSTRUCTORS****/
    
    /**
     * Default constructor for the Stack class
     * @postcondition a new Stack object with all fields
     * assigned default values
     */
    public Stack() {
    	top = null;
    	size = 0;
    }
    
    /**
     * Constructor for the Stack class
     * Converts an array into a Stack in the same order
     * @param an array of elements to copy
     * e.g. [1,2,3] becomes 1->2->3->null
     */
    public Stack(T[] array) {
    	if(null == array) {
			return;
		}
		for (int i = array.length - 1; i >= 0; i--) {
			push(array[i]);
		}
    }
    
    /**
     * Copy constructor for the Stack class
     * @param original the Stack to copy
     * @postcondition a new Stack object which is
     * an identical, but distinct, copy of original
     * REQUIRED: THIS METHOD MUST BE IMPLEMENTED
     * IN O(N) TIME
     */
    public Stack(Stack<T> original) {
    	if(original == null) {
			return;
		}
		
		if(original.size == 0) {
			top = null;
			size = 0;
		} else {
			Node temp = original.top;
			while(null != temp) {
				push(temp.data);
				temp = temp.next;
			}
			
			//copy and push again to reverse the stack, because the above copy will reverse the original
			temp = top;		//disconnect the top
			top = null;
			while(null != temp) {
				push(temp.data);
				temp = temp.next;
			}
			
		}
    }
    
    /****ACCESSORS****/
    
    /**FILL IN HERE*/
    
    /****MUTATORS****/
    
    /**FILL IN HERE*/
    
    /****ADDITONAL OPERATIONS****/
    
    /**
     * Returns the values stored in the Stack
     * as a String, separated by a blank space
     * with a new line character at the end
     * @return a String of Stack values
     */
    public String toString() {
    	Node temp = top;
		StringBuilder str = new StringBuilder();
		while(temp != null) {
			str.append(temp.data + " ");
			temp = temp.next;
		}
		str.append("\n");
		return str.toString();
    }
    
    /**
     * Determines whether two Stacks contain
     * the same values in the same order
     * @param obj the Object to compare to this Stack
     * @return whether obj and this Stack are equal
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
            if (this.size != stack.size) {
                return false;
            } else {
                Node temp1 = this.top;
                Node temp2 = stack.top;
                while (temp1 !=null) {
					if(!temp1.data.equals(temp2.data)) {
						return false;
					}
					temp1 = temp1.next;
					temp2 = temp2.next;
				}
                return true;
            }
        }
    }
  
    /**RECURSIVE HELPER METHOD*/
    
    /**
     * Recursively (no loops) creates a String
     * where the data is in reverse order
     * @param n the current node
     */
    private String reverseStack(Node n) {
    	StringBuilder sb = new StringBuilder();
		
		if(null != n.next) {
			sb.append(reverseStack(n.next));
		} 
		
		sb.append(n.data).append(" ");
		
		return sb.toString();
    }

	@Override
	public T peek() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return top.data;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void push(T data) {
		Node n = new Node(data);
		if(top == null) {
			this.top = n;
		} else {
			n.next = top;
			top = n;
		}
		size++;
	}

	@Override
	public void pop() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException();
		} else if (size == 1){
			top = null;
		} else {
			top = top.next;
		}
		size--;
	}

	@Override
	public String reverseStack() {
		if(size == 0) {
			return "\n";
		}
		return reverseStack(top) + "\n";
	}
}

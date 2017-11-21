/*
 * 		Name: Ramirez, Cesar
 * 		Project: #3
 * 		Due: 11/22/17
 * 		Course: cs-240-01-f17
 * 
 * 		Description: To create our own Stack ADT, and to implement that interface with java class Expression.
 * 		The Expression class has two primary behaviors: convertPostFix() and evaluatePostFix().
 * 
 */
public class Stack<T> {
	
	// The array of items within the stack, an array implementation of the Stack ADT
	T[] items;
	
	// integer that keeps track of how many items are in the stack and which is the next to be added
	// to the "top" of the stack
	int top;
	
	// max capacity of the stack, for our purposes this will stay constant since most expressions will not
	// extend beyond 50 characters
	final int MAX_CAPACITY;
	
	public Stack(){
		MAX_CAPACITY = 50;
		items = Object[MAX_CAPACITY];
		top = -1;
	}
	
	// Checks if the stack is empty, will use field top to determine it
	public boolean isEmpty() {
		return top == -1;
	}

	// Adds item to the stack, using the field top incremented once, since that spot should be empty
	public void push(T item) {
		items[top++] = item;
	}

	// removes item from the stack, at the location of top. Then decreases top and returns its current
	// entry
	public T pop() {
		items[top] = null;
		return items[top--];
	}

	// checks what the item is at the top field
	public T peek() {
		return items[top];
	}
	
}


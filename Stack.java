/*
 * 		Name: Ramirez, Cesar
 * 		Project: #3
 * 		Due: 11/22/17
 * 		Course: cs-240-01-f17
 * 
 * 		Description: To create our own generic Stack class, and to use that in java class Expression.
 * 		The Expression class has two primary behaviors: convertPostFix() and evaluatePostFix(). The stack is used
 *      in organizing the operands/operators to acheive the desired effect.
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
		items = (T[]) new Object[MAX_CAPACITY];
		top = -1;
	}
	
	// Checks if the stack is empty, will use field top to determine it
	public boolean isEmpty() {
		return top == -1;
	}

	// Adds item to the stack, using the field top incremented once, since that spot should be empty
	public void push(T item) {
		if(top < 50){
			items[++top] = item;
		}
		else{
			throw new IllegalStateException("Stack is Full!");
		}
	}

	// saves the object at top, then removes the item from the stack. Then decreases top and returns its former entry at top
	public T pop() {
		T rObject = items[top];
		items[top] = null;
		top--;
		return rObject;
	}

	// checks what the item is at the top field
	public T peek() {
		if(top == -1){
			throw new IllegalStateException("No items in the stack yet!");
		}
		return items[top];
	}
	
}


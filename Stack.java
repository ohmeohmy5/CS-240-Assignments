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
public interface Stack<T> {
	
	// Checks if the stack is empty, will differ depending on implementation
	boolean isEmpty();
	
	// Adds item to the stack, either top or bottom, will return true if successful
	boolean push();
	
	// removes item from the stack, from same side that the stack implementation pushes to; returns item
	// removed
	T pop();
	
	// checks what the item is at the top/bottom
	T peek();
}

/*
 * 		Name: Ramirez, Cesar
 * 		Project: #2
 * 		Due: 10/30/17
 * 		Course: cs-240-01-f17
 * 
 * 		Description: To create a Set ADT, implementing the set interface and using the generic class Node. A linked set is data
 * 		structure in which the order of the items do not matter, but there can be duplicate items/data. The data should be organized
 * 		in chain, linked together. (in our implementation, we use the Node class to accomplish this)
 * 
 */
public class Node<T> {
	// The data field for Node, holding the appropriate object of whatever type is necessary
	private T data;
	// The link or reference to the next node in the chain
	private Node next;
	
	// constructor for node with no parameters
	public Node(){
		this(null,null);
	}
	// constructor for node if no next node is given, only a single node with no chain
	public Node(T anObject){
		this(anObject,null);
	}
	
	// constructor for node with data and next node
	public Node(T anObject, Node nextNode){
		setData(anObject);
		setNext(nextNode);
	}
	
	// accessor method for next node in the chain will be useful in accessing the chain, one node at a time
	public Node getNext() {
		return next;
	}
	
	// mutator method for next node, allows for manipulation of the chain, since this is a set and order doesnt matter, this is also
	// very useful
	public void setNext(Node next) {
		this.next = next;
	}
	
	// accessor method for data, used to find nodes that match the object of the user's input
	public T getData() {
		return data;
	}
	
	// mutator method for data, allows for changing of values of the nodes in the chain
	public void setData(T data) {
		this.data = data;
	}
}

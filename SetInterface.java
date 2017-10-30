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
public interface SetInterface<T> {
	
	// sees if set contains this object, sets do not allow for duplicates so there should be one matching
	// object if there is any
	public boolean contains(T anEntry);
	
	// removes a given object from set
	public boolean remove(T anEntry);
	
	// removes an object from the set
	public boolean remove();
	
	// adds a node/object to the set
	public boolean add(T anEntry);
	
	// gives amount of objects(nodes) in the set
	public int length();
	
	// converts objects in set into string for user to read
	public String toString();
	
	// boolean method to check if set is empty
	public boolean isEmpty();
	
	// should remove objects from set until the object is empty
	public void clear();
}


public interface SetInterface<T> {
	// sees if set contains this object, sets do not allow for duplicates so there should be one matching
	// object if there is any
	public boolean contains(T anObject);
	// removes a given object from set
	public boolean remove(T anObject);
	// removes an object from the set
	public boolean remove();
	// adds a node/object to the set
	public boolean add(T anObject);
	// gives amount of objects(nodes) in the set
	public int length();
	// converts objects in set into string for user to read
	public String toString();
	// boolean method to check if set is empty
	public boolean isEmpty();
	// should remove objects from set until the object is empty
	public void clear();
	// returns array of objects within set
	public T[] toArray();
}

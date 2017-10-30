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
public class LinkSet<T> implements SetInterface<T> {
	
	// field to hold the amount of nodes/objects are in the set
	private int numberOfEntries;
	
	// first node in the chain of nodes, which will help us traverse the linked set
	private Node firstNode;
	
	// no parameter constructor which initializes the fields
	public LinkSet() {
		numberOfEntries = 0;
		firstNode = null;
	}
	
	// local node variable current node is set to equal firstNode, which is assigned to the next node in the chain in a while loop 
	// after checking if the current node's data equals the given entry. If so, the method will return true.
	@Override
	public boolean contains(T anEntry) {
		if(isEmpty()){
			return false;
		}
		boolean found = false;
		Node currentNode = firstNode;
		if(anEntry != null){
			while(currentNode != null && !found){
				if(currentNode.getData().equals(anEntry)){
				found = true;
				}
				else{
					currentNode = currentNode.getNext();
				}
			}
		}
		return found;
	}
	
	// uses currentNode to traverse chain by setting it equal to currentNode.getNext() in a while loop which checks if the currentNode's
	// data equals the given entry. If it does, the matching node is assigned the firstNode and its data, essentially replacing the 
	// currentNode with the firstNode (possible since order does not matter). It then assigns the firstNode to firstNode.getNext(), removing 
	// the firstNode from the chain. If this is successful, the numberOfEntries decreases and the method will return true.
	@Override
	public boolean remove(T anEntry) {
		Node nodeToRemove = firstNode;
		boolean removed = false;
		while(nodeToRemove != null && !removed){
			if(nodeToRemove.getData().equals(anEntry)){
				nodeToRemove.setData(firstNode.getData());
				if(numberOfEntries > 1){
					firstNode = firstNode.getNext();
				}
				else{
					firstNode.setData(null);
				}
				numberOfEntries--;
				removed = true;
			}
			else{
				nodeToRemove = nodeToRemove.getNext();
			}
		}
		return removed;
	}
	
	// removes any item from the linked set. FirstNode is set to next node in chain as long as the set is empty, or if there is only one
	// object/node, in which case the firstNode is set to null. If the set is able to remove an object, numberOfEntries is decreased and 
	// the method will return true.
	@Override
	public boolean remove() {
		boolean removed = false;
		if(!isEmpty()){
			if(numberOfEntries == 1){
				firstNode.setData(null);
			}
			else{
				firstNode = firstNode.getNext();
			}
			numberOfEntries--;
			removed = true;
		}
		return removed;
	}

	// The entry is used to make a new node. If the set is empty, the firstNode is assigned the new node. If not, the new Node will become
	// become the firstNode, but its next (reference to next in chain) will be set to the previous firstNode before that assignment occurs.
	// If either of these processes succeed, the numberOfEntries increases and the method will return true.
	@Override
	public boolean add(T anEntry) {
		boolean added = false;
		Node addNode = new Node(anEntry);
		if(isEmpty()){
			firstNode = addNode;
			added = true;
			numberOfEntries++;
		}
		else{
			if(!this.contains(anEntry)){
				addNode.setNext(firstNode);
				firstNode = addNode;
				added = true;
				numberOfEntries++;
			}
		}
		return added;
	}
	
	// returns the numberOfEntries field, which will be useful for iterating fully through the chain/linked set
	@Override
	public int length() {
		return numberOfEntries;
	}
	
	// checks if either the firstNode is null or if the numberOfEntries is zero to return true. False otherwise.
	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if(numberOfEntries == 0){
			empty = true;
		}
		return empty;
	}
	
	// while loop on condition of the set being not empty, it will remove objects from the set until it is empty using remove()
	@Override
	public void clear() {
		while(!isEmpty()){
			remove();
		}
	}
	
	// iterates through every item (from 1 to numberOfEntries, using currentNode) in this linked set and checks if every item is contained  
	// within the given linked set. If there is an item in our set not in the other set, the method returns false. Otherwise,
	// method returns true, meaning this linked set is a subset of the given linked set
	public boolean subset(LinkSet<T> otherSet){
		Node currentNode = firstNode;
		boolean sub = true;
		int index = 1;
		while(index <= numberOfEntries && currentNode != null){
			if(!otherSet.contains((T) currentNode.getData())){
				sub = false;
			}
			currentNode = currentNode.getNext();
			index++;
		}
		return sub;
	}
	
	// our linked set = A, given linked set = B. The subset() method is used here on both A and B as such: A.subset(B) and B.subset(B). If
	// both those return true then the equals method will return true. If both are subsets of each other, that means every element in A
	// is in B and every element in B is in A. This means the two sets have identical entries.
	public boolean equals(LinkSet<T> otherSet){
		boolean equal = false;
		if(this.subset(otherSet) && otherSet.subset(this)){
			equal = true;
		}
		return equal;
	}
	
	// this method should return a new linked set with all entries in both A and B. To do this we iterate through all entries in both the sets
	// starting at 1 and increasing to numberOfEntries of the respective set. We will attempt to add every element (using currentNode.getData())
	// to our new linked set from both our linked set and the given linked set. The add method checks if the set contains the given entry
	// before continuing, so this prevents any duplicates of items.
	public LinkSet<T> union(LinkSet<T> otherSet){
		LinkSet<T> lSet = new LinkSet();
		Node ourNode = firstNode;
		Node otherNode = otherSet.firstNode;
		int index1 = 1;
		int index2 = 1;
		while(index1 <= numberOfEntries && ourNode != null){
			lSet.add((T) ourNode.getData());
			index1++;
			ourNode = ourNode.getNext();
		}
		while(index2 <= otherSet.length() && otherNode != null){
			lSet.add((T) otherNode.getData());
			index2++;
			otherNode = otherNode.getNext();
		}
		return lSet;
	}
	
	// This should return a new linked set with all the unique elements of A, those not in B. The complement method, like the intersection 
	// method, will iterate from int 1 to numberOfEntries through this set, setting currentNode = currentNode.getNext()
	// each time. However, we will only attempt to add an element from set A if it is not contained in B.
	// (example: add(element from A) only if !B.contains(element from A))
	public LinkSet<T> complement(LinkSet<T> otherSet){
		LinkSet<T> lSet = new LinkSet();
		Node currentNode = firstNode;
		int index = 1;
		while(index <= numberOfEntries && currentNode != null){
			if(!otherSet.contains((T) currentNode.getData())){
				lSet.add((T) currentNode.getData());
			}
			index++;
			currentNode = currentNode.getNext();
		}
		return lSet;
	}
	
	// This should return a linked set with all the elements that A and B share. This only needs to iterate through the this linked set,
	// again using currentNode. Elements from this set will be added only if the given set contains that element. We only need to iterate
	// through one set this time because for something to be added to the new linked set it needs to exist in both A AND B.
	public LinkSet<T> intersection(LinkSet<T> otherSet){
		LinkSet<T> lSet = new LinkSet();
		Node currentNode = firstNode;
		int index = 1;
		while(index <= numberOfEntries && currentNode != null){
			if(otherSet.contains((T) currentNode.getData())){
				lSet.add((T) currentNode.getData());
			}
			index++;
			currentNode = currentNode.getNext();
		}
		return lSet;
	}
	
	// toString should return a string with a description of the object's state. In this case, our linked set's number of entries and what its first node
	// is.
	public String toString(){
		String state = new String();
		try{
			state = "The current number of entries: " + numberOfEntries + " The first node contains: " + firstNode.getData().toString();
		}
		catch(NullPointerException object){
			state = "The current number of entries: 0 The first node contains: null";
		}
		return state;
	}
	
	// accessor method for firstNode which allows to traverse the chain outside this class. Will be useful for testing.
	public Node getFirstNode(){
		return firstNode;
	}
	}
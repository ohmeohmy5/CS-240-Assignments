
public class BinarySearchTree<T> implements TreeInterface<T> {
	// reference to root of the tree, will help overall traversal
	DNode root;
	// method that finds the given entry. Uses recursive calls, in which the it will use the right child of the node if the
	// greater or the left child if the value is smaller.Once it finds the appropriate entry, it will return the object
	// data.
	private T findEntry(DNode root, T anEntry){
		T result = null;
		if(root != null){
			T rootData = (T) root.getData();
			
			if(rootData.equals(anEntry)){
				result = rootData;
			}
			else if(((Integer) rootData).compareTo((Integer) anEntry) > 0){
				result = findEntry(root.getRight(), anEntry);
			}
			else{
				result = findEntry(root.getLeft(), anEntry);
			}
		}
		return result;
	}
	
	public T getPredecessor(T anEntry){
		
	}
	
	public T getDescendant(T anEntry){
		
	}

	// getEntry is the user version (public) of findEntry because it only needs an entry to find. The findEntry() needs a
	// given node to start at. It is this way to help with the recursive methods, once it is called again it can start at
	// the next appropriate node.This method makes the process simpler by just calling the findEntry with the root node
	// as the node argument.
	@Override
	public T getEntry(T anEntry) {
		return findEntry(root, anEntry);
	}
	
	// has a reference to a node in the tree, it will compare its value to the entry, and adhere to BST rules by recursively
	// calling itself but with the appropriate child (left if entry smaller than node, right if entry bigger than node)
	// Once it finds an appropriate spot, it will use the node reference to set the given entry as the child node as needed.
	// This will complete the while loop by setting local variable foundSpace to true, and return the given entry that was
	// added.
	private T addEntry(DNode node, T anEntry) {
		DNode currentNode = node;
		T result = null;
		boolean foundSpace = false;
		while(!foundSpace){
			T currentData = (T) currentNode.getData();
			if(currentData.equals(anEntry)){
				foundSpace = true;
				result = currentData;
			}
			else if(((Integer) currentData).compareTo((Integer) anEntry) > 0){
				if(currentNode.hasLeft()){
					result = addEntry(currentNode.getLeft(),anEntry);
				}
				else{
					foundSpace = true;
					DNode lNode = new DNode(anEntry);
					currentNode.setLeft(lNode);
					result = anEntry;
				}
			}
			else{
				if(currentNode.hasRight()){
					result = addEntry(currentNode.getRight(),anEntry);
				}
				else{
					foundSpace = true;
					DNode rNode = new DNode(anEntry);
					currentNode.setRight(rNode);
					result = anEntry;
				}
			}
		}
		return result;
	}

	@Override
	public T remove(T anEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	// simply returns boolean expression of whether the getEntry method is able to return a non-null value using the given
	// entry as a parameter
	@Override
	public boolean contains(T anEntry) {
		return getEntry(anEntry) != null;
	}
	
	public void setRootNode(DNode nRoot){
		root = nRoot;
	}
	
	// accessor method of root node of the tree
	public DNode getRootNode(){
		return root;
	}

	// add method that only needs the anEntry parameter and it calls the addEntry method if the root exists, using the root
	// node as parameter. If the root does not exist, then the given entry will be set up as the new root.
	@Override
	public T add(T anEntry) {
		T result = null;
		if(root != null){
			result = addEntry(root,anEntry);
		}
		else{
			root = new DNode(anEntry);
			result = anEntry;
		}
		return result;
	}

}


public class Node<T> {
	private T data;
	private Node next;
	
	public Node(T anObject, Node nextNode){
		data = anObject;
		next = nextNode;
	}
	
	public T getData(){
		return data;
	}
}

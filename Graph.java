
public class Graph<E> {
	private int[][] edges;
	private E[] labels;
	
	public Graph(int num){
		edges = new int[num][num];
		labels = (E[]) new Object[n];
	}
	
	int isEdge(int source,int target){
		return edges[source][target];
	}
	
	void addEdge(int source,int target){
		edges[source][target] = true;
	}
	
	E getLabel(int vertex){
		return labels[vertex];
	}
	
	int[] neighbors(int vertex){
		int count = 0;
		int[] nb;
		for(int i = 0; i < labels.length; i++){
			if(edges[vertex][i] != 0){
				count++;
			}
		}
		nb = new int[count];
		count = 0;
		for(int j = 0; j < labels.length; j++){
			if(edges[vertex][j] != 0){
				nb[count++] = j;
			}
		}
		return nb;
	}
	
	void removeEdge(int source,int target){
		edges[source][target] = 0;
	}
	
	void setLabel(int vertex, E newLabel){
		labels[vertex] = newLabel;
	}
	
	int size(){
		return labels.length;
	}
	
	E findLabel(E newLabel){
		
	}
	
	int shortestPath(){
		
	}
}

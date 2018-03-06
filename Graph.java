
public class Graph<E> {
	private boolean[][] edges;
	private E[] labels;
	
	public Graph(int num){
		edges = new boolean[num][num];
		labels = (E[]) new Object[n];
	}
	
	boolean isEdge(int source,int target){
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
			if(edges[vertex][i]){
				count++;
			}
		}
		nb = new int[count];
		count = 0;
		for(int j = 0; j < labels.length; j++){
			if(edges[vertex][j]){
				nb[count++] = j;
			}
		}
		return nb;
	}
	
	void removeEdge(int source,int target){
		edges[source][target] = false;
	}
	
	void setLabel(int vertex, E newLabel){
		labels[vertex] = newLabel;
	}
	
	int size(){
		return labels.length;
	}
	
	
}

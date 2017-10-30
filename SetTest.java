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
public class SetTest<T> {

	
	public static void main(String args[]){
		LinkSet<String> lSet = new LinkSet();
		lSet.add("A");
		lSet.add("B");
		lSet.add("C");
		System.out.println("The display of numberOfEntries and firstNode is using toString()");
		System.out.println("If add() is working, should display three String items(C, B, and A) : ");
		System.out.println(displaySet(lSet) + " " + lSet.toString());
		System.out.println("");
		
		System.out.println("Will attempt to add another element, but it will be duplicate to an existing element, so it should fail to add");
		System.out.println("Should return false: " + lSet.add("C"));
		System.out.println(displaySet(lSet) + " " + lSet.toString());
		System.out.println("");
		
		System.out.println("Should return false because set is not empty: " + lSet.isEmpty() + " Should return false for set not containing"
				+ " the String 'D': " + lSet.contains("D"));
		System.out.println("Should return true for set containing String 'B': " + lSet.contains("B") + " If so, then the following remove "
				+ "method should be able to remove 'B' and return true: " + lSet.remove("B"));
		System.out.println(displaySet(lSet) + " " + lSet.toString());
		System.out.println("");
		
		System.out.println("Should return false from the remove method because the given String 'B' no longer exists in the set: " + 
							lSet.remove("B"));
		System.out.println(displaySet(lSet) + " " + lSet.toString());
		System.out.println("");
		
		System.out.println("We will now use clear(), so there should be no more elements in the set and the number of entries and firstNode" +
							" should reflect that. This also tests remove() method since it is in clear()");
		lSet.clear();
		System.out.println(displaySet(lSet) + " " + lSet.toString());
		System.out.println("");
		
		System.out.println("Should return true because the set is now Empty: " + lSet.isEmpty());
		System.out.println("Should return false because remove() cannot work: " + lSet.remove());
		System.out.println("We will now create a new linked set to compare our previous set to. The new set is called set 2 and the older set is"
				+ " set 1.");
		LinkSet<String> lSet2 = new LinkSet();
		lSet2.add("B");
		lSet2.add("D");
		lSet2.add("A");
		System.out.println("Set 1: " + displaySet(lSet) + " " + lSet.toString());
		System.out.println("Set 2: " + displaySet(lSet2) + " " + lSet2.toString());
		System.out.println("");
		System.out.println("Should return true for set 1 being a subset of set 2 since set 1 is empty: " + lSet.subset(lSet2));
		System.out.println("Should return false for set 1 being equal to set 2: " + lSet.equals(lSet2));
		System.out.println("Set 1: " + displaySet(lSet) + " " + lSet.toString());
		System.out.println("Set 2: " + displaySet(lSet2) + " " + lSet2.toString());
		System.out.println("");
		
		System.out.println("We will now return new linked sets of the following methods, respectively: union(), intersection(), complement()");
		System.out.println("The union set contains all elements in both sets, the intersection set contains all the elements shared"
							+ " elements between both sets, and complement set contains all the elements unique to one of the respective sets.");
		LinkSet<String> uSet = lSet.union(lSet2);
		LinkSet<String> iSet = lSet.intersection(lSet2);
		LinkSet<String> cSet = lSet.complement(lSet2);
		LinkSet<String> cSet2 = lSet2.complement(lSet);
		System.out.println("Union Set: " + displaySet(uSet));
		System.out.println("Intersection Set: " + displaySet(iSet));
		System.out.println("Complement of Set 1: " + displaySet(cSet));
		System.out.println("Complement of Set 2: " + displaySet(cSet2));
		System.out.println("");
		
		System.out.println("We will now have set 1 equal set 2 but be distinct from each other");
		lSet.add("D");
		lSet.add("B");
		lSet.add("A");
		System.out.println("Set 1: " + displaySet(lSet) + " " + lSet.toString());
		System.out.println("Set 2: " + displaySet(lSet2) + " " + lSet2.toString());
		System.out.println("Should return true for set 1 being a subset of set 2: " + lSet.subset(lSet2));
		System.out.println("Should return true for set 1 being equal to set 2: " + lSet.equals(lSet2));
		uSet = lSet.union(lSet2);
		iSet = lSet.intersection(lSet2);
		cSet = lSet.complement(lSet2);
		cSet2 = lSet2.complement(lSet);
		System.out.println("Union Set: " + displaySet(uSet));
		System.out.println("Intersection Set: " + displaySet(iSet));
		System.out.println("Complement of Set 1: " + displaySet(cSet));
		System.out.println("Complement of Set 2: " + displaySet(cSet2));
		System.out.println("");
		
		System.out.println("We will have set 1 be smaller than set 2, but be a subset of set 2");
		lSet.remove("D");
		lSet.remove("A");
		System.out.println("Set 1: " + displaySet(lSet) + " " + lSet.toString());
		System.out.println("Set 2: " + displaySet(lSet2) + " " + lSet2.toString());
		System.out.println("Should return true for set 1 being a subset of set 2: " + lSet.subset(lSet2));
		System.out.println("Should return false for set 1 being equal to set 2: " + lSet.equals(lSet2));
		uSet = lSet.union(lSet2);
		iSet = lSet.intersection(lSet2);
		cSet = lSet.complement(lSet2);
		cSet2 = lSet2.complement(lSet);
		System.out.println("Union Set: " + displaySet(uSet));
		System.out.println("Intersection Set: " + displaySet(iSet));
		System.out.println("Complement of Set 1: " + displaySet(cSet));
		System.out.println("Complement of Set 2: " + displaySet(cSet2));
		System.out.println("");
		
		System.out.println("We will have the sets be different in size but still have common elements");
		lSet.add("F");
		lSet.add("E");
		lSet.add("D");
		lSet2.remove("B");
		lSet2.add("E");
		System.out.println("Set 1: " + displaySet(lSet) + " " + lSet.toString());
		System.out.println("Set 2: " + displaySet(lSet2) + " " + lSet2.toString());
		System.out.println("Should return false for set 1 being a subset of set 2: " + lSet.subset(lSet2));
		System.out.println("Should return false for set 1 being equal to set 2: " + lSet.equals(lSet2));
		uSet = lSet.union(lSet2);
		iSet = lSet.intersection(lSet2);
		cSet = lSet.complement(lSet2);
		cSet2 = lSet2.complement(lSet);
		System.out.println("Union Set: " + displaySet(uSet));
		System.out.println("Intersection Set: " + displaySet(iSet));
		System.out.println("Complement of Set 1: " + displaySet(cSet));
		System.out.println("Complement of Set 2: " + displaySet(cSet2));
		System.out.println("");
		
		System.out.println("Finally, we will have the sets be non-empty but have nothing in common");
		lSet.remove("E");
		lSet2.remove("D");
		System.out.println("Set 1: " + displaySet(lSet) + " " + lSet.toString());
		System.out.println("Set 2: " + displaySet(lSet2) + " " + lSet2.toString());
		System.out.println("Should return false for set 1 being a subset of set 2: " + lSet.subset(lSet2));
		System.out.println("Should return false for set 1 being equal to set 2: " + lSet.equals(lSet2));
		uSet = lSet.union(lSet2);
		iSet = lSet.intersection(lSet2);
		cSet = lSet.complement(lSet2);
		cSet2 = lSet2.complement(lSet);
		System.out.println("Union Set: " + displaySet(uSet));
		System.out.println("Intersection Set: " + displaySet(iSet));
		System.out.println("Complement of Set 1: " + displaySet(cSet));
		System.out.println("Complement of Set 2: " + displaySet(cSet2));
		System.out.println("");
	}
	
	public static String displaySet(LinkSet set){
		StringBuilder result = new StringBuilder();
		int index = 1;
		Node currentNode = set.getFirstNode();
		result.append("The current items in this linked set are: ");
		while(index <= set.length() && currentNode != null){
			result.append(currentNode.getData().toString());
			result.append(" ");
			index++;
			currentNode = currentNode.getNext();
		}
		return result.toString();
	}
}

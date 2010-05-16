
package Graph.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @param <E> 
 * @author  Ivan Kanakarakis
 */
public class DisjointSet<E> {
	private List<ArrayList<E>> set;

	public DisjointSet() {
		set = new LinkedList<ArrayList<E>>();
	}

	public void createSubsets(Collection<E> items) {
		for (E item : items) {
			ArrayList<E> subset = new ArrayList<E>(items.size());
			subset.add(item);
			set.add(subset);
		}
	}

	public void merge(int setA, int setB) {
		set.get(setA).addAll(set.get(setB));
		set.remove(setB);
	}

	public int find(E searchfor) {
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i).contains(searchfor)) {
				return i;
			}
		}
		return -1;
	}

}

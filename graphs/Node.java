package graphs;

import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author Ivan Kanakarakis
 */
public class Node {
	//TODO: convert name to int?
	//TODO: use sets of nodes?
	private String name;
	private HashSet<String> connectedTo;

	public Node(String name, Collection<String> connectedTo) {
		this.name = name;
		this.connectedTo = new HashSet<String>(connectedTo);
	}

	public String getName() {
		return name;
	}

	public HashSet<String> getConnectedTo() {
		return connectedTo;
	}

	public boolean isConnectedTo(Node node) {
		return connectedTo.contains(node.getName());
	}

	public void addNode(String node) {
		connectedTo.add(node);
	}

	public void addNodes(Collection<String> nodes) {
		connectedTo.addAll(nodes);
	}

	public String encode() {
		StringBuffer str = new StringBuffer(connectedTo.size() << 1);
		for (String node : connectedTo)
			str.append(String.format("%s\t%s", name, node));
		return str.toString();
	}

	@Override
	public String toString() {
		String str = String.format("Node %s is connect to nodes: ", name);
		for (String node : connectedTo)
			str += String.format("%s ", node);
		return str.toString();
	}

}

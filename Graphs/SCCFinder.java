package Graphs;

import java.util.Iterator;
import java.util.List;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.StrongConnectivityInspector;
import org.jgrapht.graph.Subgraph;

/**
 *
 * @author  Ivan Kanakarakis
 */
public class SCCFinder {
	private DirectedGraph<String, DefaultEdge> directedGraph;
	private StrongConnectivityInspector sci;

	public SCCFinder(DirectedGraph<String, DefaultEdge> directedGraph) {
		this.directedGraph = directedGraph;
		sci = new StrongConnectivityInspector(this.directedGraph);
	}

	public List findStringlyConnectedSubgraphs() {
		return sci.stronglyConnectedSubgraphs();
	}

        public List findStronglyConnectedSets() {
                return sci.stronglyConnectedSets();
        }

        public int findSCCNumber() {
                return this.findStronglyConnectedSets().size();
        }
        
        public int[] findAllSCCNUmbers() {
                int[] numbers = new int[this.findSCCNumber()];
                Iterator it = this.findStringlyConnectedSubgraphs().iterator();
                int i = 0;
                while(it.hasNext())
                {
                    numbers[i] = ((Subgraph) it.next()).vertexSet().size();
                    i++;
                }
                return numbers;
        }

}

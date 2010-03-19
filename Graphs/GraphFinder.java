package Graphs;

import java.util.Iterator;
import java.util.List;
import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.Subgraph;

/**
 *
 * @author Periklis Ntanasis
 */
public class GraphFinder {
    
    DirectedGraph digraph;
    
    public GraphFinder(DirectedGraph graph) {
        this.digraph = graph;
    }
    
    private Double[] SSCDiameters() {
        SCCFinder scc = new SCCFinder(digraph);
        DijkstraShortestPath alg;
        List<Subgraph> SSCGraphs = scc.findStringlyConnectedSubgraphs();
        Double[] diameters = new Double[SSCGraphs.size()];
        Double max;
        for(int i=0;i<SSCGraphs.size();i++)
        {
            Iterator it = SSCGraphs.get(i).vertexSet().iterator();
            Object start = it.next();
            max = 0D;
            while(it.hasNext())
            {
                alg = new DijkstraShortestPath(digraph,start,it.next());
                if(alg.getPathLength()>max)
                {
                    max = alg.getPathLength();
                }
            }
            diameters[i] = max;
        }
        return diameters;
    }

    public Double Diameter() {
        Double max = 0D;
        Double[] diameters = this.SSCDiameters();
        for(int i=0;i<diameters.length;i++)
        {
            if(diameters[i]>max)
            {
                max = diameters[i];
            }
        }
        return max;
    }

}

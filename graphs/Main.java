package graphs;

import Forms.MainWindow;
import java.io.FileNotFoundException;
import java.util.List;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultDirectedGraph;

/**
 *
 * @author	Ivan Kanakarakis
 */
public class Main {
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		//TODO: change debug status via main's args
		AppDefs.DEBUG = true;
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow().setVisible(false);
			}//run

		});
		test();
	}

	private static void test() {
		DirectedGraph<String, DefaultEdge> directedGraph = new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
		// read file contents
		try {
			DataReader dr = new DataReader("data/graph1.txt");
			if (dr.readFile(directedGraph)) {
				System.out.println("Read File - Graph is ready");
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println("Wrong file! Please try again with different file");
			fnfe.printStackTrace();
			return;
		}
		// computes all the strongly connected components of the directed graph
		SCCFinder scc = new SCCFinder(directedGraph);
		List stronglyConnectedSubgraphs = scc.findStringlyConnectedSubgraphs();
		// prints the strongly connected components
		System.out.println("Strongly connected components:");
		for (int i = 0; i < stronglyConnectedSubgraphs.size(); i++)
			System.out.println(stronglyConnectedSubgraphs.get(i));
		System.out.println();
	}

}

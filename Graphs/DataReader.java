package Graphs;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import org.jgraph.graph.DefaultEdge;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.DefaultPort;
import org.jgraph.graph.GraphConstants;
import org.jgrapht.graph.ListenableDirectedGraph;

/**
 *
 * @author	Ivan Kanakarakis
 */
public class DataReader {
	private File datafile;
	private Scanner scan;

	public DataReader(final String filename) throws FileNotFoundException {
		datafile = new File(filename);
		scan = new Scanner(new BufferedReader(new FileReader(datafile)));
		if (AppDefs.DEBUG) {
			System.out.format("%s: DataReader Object initialized\n",
					  this.getClass().toString());
		}
	}

	public DataReader(final File filename) throws FileNotFoundException {
		datafile = filename;
		scan = new Scanner(new BufferedReader(new FileReader(datafile)));
		if (AppDefs.DEBUG) {
			System.out.format("%s: DataReader Object initialized\n",
					  this.getClass().toString());
		}
	}

	public boolean readFile(ListenableDirectedGraph<String, DefaultEdge> directedGraph) {
		while (scan.hasNextInt()) {
			String[] vertex = scan.nextLine().split("\\s");
			if (vertex.length != 2) {
				System.err.format("%s: Wrong File Format for file: %s\n",
						  this.getClass().toString(), datafile.getName());
				return false;
			} else {
				directedGraph.addVertex(vertex[0]);
				directedGraph.addVertex(vertex[1]);
				directedGraph.addEdge(vertex[0], vertex[1]);
			}
		}
		scan.close();
		if (AppDefs.DEBUG) {
			System.out.format("%s: Read File Contents: %s\n",
					  this.getClass().toString(), datafile.getName());
		}
		return true;
	}

	private DefaultGraphCell[] createCellEdge(String source, String target) {
		DefaultGraphCell cellsource = new DefaultGraphCell(source);
		GraphConstants.setAutoSize(cellsource.getAttributes(), true);
		GraphConstants.setGradientColor(cellsource.getAttributes(), Color.orange);
		DefaultPort sourceport = new DefaultPort();
		cellsource.add(sourceport);

		DefaultGraphCell celltarget = new DefaultGraphCell(target);
		GraphConstants.setAutoSize(celltarget.getAttributes(), true);
		GraphConstants.setGradientColor(celltarget.getAttributes(), Color.orange);
		DefaultPort targetport = new DefaultPort();
		celltarget.add(targetport);

		DefaultEdge edge = new DefaultEdge();
		edge.setSource(cellsource.getChildAt(0));
		edge.setTarget(celltarget.getChildAt(0));

		int arrow = GraphConstants.ARROW_CLASSIC;
		GraphConstants.setLineEnd(edge.getAttributes(), arrow);
		GraphConstants.setEndFill(edge.getAttributes(), true);

		DefaultGraphCell[] cells = new DefaultGraphCell[3];
		cells[0] = cellsource;
		cells[1] = celltarget;
		cells[2] = edge;
		return cells;
	}

}

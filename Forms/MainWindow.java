package Forms;

import Graphs.DataReader;
import Graphs.GraphFinder;
import Graphs.SCCFinder;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jgraph.JGraph;
import org.jgraph.graph.AttributeMap;
import org.jgraph.graph.DefaultEdge;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphConstants;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.ListenableDirectedGraph;

/**
 *
 * @author Kanakarakis Ivan
 */
public class MainWindow extends javax.swing.JFrame {
	private final JFileChooser fc;
	private File file;
	private JGraphModelAdapter<String, DefaultEdge> graphAdapter;

	/** Creates new form MainWindow */
	public MainWindow() {
		this.setIconImage(new javax.swing.ImageIcon(getClass().getResource(Graphs.AppDefs.MAIN_ICON)).getImage());
		//this.setLocationRelativeTo(null);  //FIXME: Java Bug! Not working for now..
		initComponents();
		startButt.setEnabled(false);
		fc = new JFileChooser();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                fileTextField = new javax.swing.JTextField();
                openButt = new javax.swing.JButton();
                startButt = new javax.swing.JButton();
                sccNumTextField = new javax.swing.JTextField();
                sccNumLabel = new javax.swing.JLabel();
                sccSizeLabel = new javax.swing.JLabel();
                jScrollPane2 = new javax.swing.JScrollPane();
                sccSizeTextArea = new javax.swing.JTextArea();
                diameterLabel = new javax.swing.JLabel();
                diameterTextField = new javax.swing.JTextField();
                graphPane = new javax.swing.JScrollPane();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("JGraphs");

                fileTextField.setEditable(false);

                openButt.setText("Open FIle");
                openButt.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                openButtActionPerformed(evt);
                        }
                });

                startButt.setText("Start");
                startButt.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                startButtActionPerformed(evt);
                        }
                });

                sccNumTextField.setEditable(false);

                sccNumLabel.setText("SSC# :");

                sccSizeLabel.setText("SSC's size:");

                sccSizeTextArea.setColumns(20);
                sccSizeTextArea.setEditable(false);
                sccSizeTextArea.setRows(5);
                jScrollPane2.setViewportView(sccSizeTextArea);

                diameterLabel.setText("Diameter:");

                diameterTextField.setEditable(false);

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(startButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(openButt, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(77, 77, 77)
                                                                .addComponent(sccSizeLabel))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(fileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(sccNumLabel)
                                                        .addComponent(diameterLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(diameterTextField)
                                                        .addComponent(sccNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
                );

                jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {diameterTextField, sccNumTextField});

                jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {openButt, startButt});

                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(openButt)
                                                        .addComponent(fileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(sccSizeLabel)
                                                        .addComponent(startButt))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(sccNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sccNumLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(diameterLabel)
                                                        .addComponent(diameterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                );

                jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {diameterLabel, diameterTextField, sccNumLabel, sccNumTextField});

                jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {fileTextField, openButt, sccSizeLabel, startButt});

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(graphPane, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(graphPane, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void openButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	    fc.setDragEnabled(true);
	    int retVal = fc.showOpenDialog(jPanel1);
	    if (retVal == JFileChooser.APPROVE_OPTION) {
		    file = fc.getSelectedFile();
		    fileTextField.setText(file.getName());
		    startButt.setEnabled(true);
	    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void startButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
	    this.clear();
	    this.repaint();
	    ListenableDirectedGraph<String, DefaultEdge> directedGraph = new ListenableDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
	    graphAdapter = new JGraphModelAdapter<String, DefaultEdge>(directedGraph);
	    JGraph graphComponent = new JGraph(graphAdapter);
	    graphComponent.setPreferredSize(graphPane.getSize());
	    graphComponent.setBackground(Color.LIGHT_GRAY);
	    graphPane.add(graphComponent);
	    try {
		    DataReader dr = new DataReader(file);
		    if (dr.readFile(directedGraph)) {
			    SCCFinder scc = new SCCFinder(directedGraph);
			    int[] sccSizes = scc.getSCCSizePerSubgraph();
			    sccNumTextField.setText(String.valueOf(sccSizes.length));
			    for (int sccNum = 0; sccNum < sccSizes.length; sccNum++)
				    sccSizeTextArea.append(String.format("%0" + String.valueOf(sccSizes.length).length()
									 + "d. SCC size: %d\n", sccNum + 1, sccSizes[sccNum]));
			    GraphFinder gf = new GraphFinder(directedGraph);
			    diameterTextField.setText(String.valueOf(gf.getGreatestDiameter()));
			    Random rand = new Random(50L);
			    for (String vertex : directedGraph.vertexSet()) {
				    //TODO: get vertex and position it;
				    DefaultGraphCell cell = graphAdapter.getVertexCell(vertex);
				    AttributeMap attributeMap = cell.getAttributes();
				    Rectangle2D b = GraphConstants.getBounds(attributeMap);
				    GraphConstants.setBounds(attributeMap, new Rectangle(rand.nextInt(200), rand.nextInt(100), (int)b.getWidth(), (int)b.getHeight()));
				    HashMap<DefaultGraphCell, AttributeMap>cellAttr = new HashMap<DefaultGraphCell, AttributeMap>();
				    cellAttr.put(cell, attributeMap);
				    graphAdapter.edit(cellAttr, null, null, null);
			    }
		    } else {
			    throw new FileNotFoundException();
		    }
	    } catch (FileNotFoundException fnfe) {
		    JOptionPane.showMessageDialog(this, "Unable to read data\nPlease choose another file",
						  "Error Reading File!", JOptionPane.ERROR_MESSAGE);
		    fnfe.printStackTrace();
	    }
	    //graphPane.revalidate();
	    graphPane.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel diameterLabel;
        private javax.swing.JTextField diameterTextField;
        private javax.swing.JTextField fileTextField;
        private javax.swing.JScrollPane graphPane;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JButton openButt;
        private javax.swing.JLabel sccNumLabel;
        private javax.swing.JTextField sccNumTextField;
        private javax.swing.JLabel sccSizeLabel;
        private javax.swing.JTextArea sccSizeTextArea;
        private javax.swing.JButton startButt;
        // End of variables declaration//GEN-END:variables

	private void clear() {
		sccNumTextField.setText("");
		diameterTextField.setText("");
		sccSizeTextArea.setText("");
	}

}

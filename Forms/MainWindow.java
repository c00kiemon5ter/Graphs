package Forms;

import Graphs.AppDefs;
import Graphs.DataReader;
import Graphs.GraphFinder;
import Graphs.SCCFinder;
import com.jgraph.layout.JGraphFacade;
import com.jgraph.layout.JGraphLayout;
import com.jgraph.layout.graph.JGraphSimpleLayout;
import com.jgraph.layout.organic.JGraphOrganicLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.jgraph.JGraph;
import org.jgraph.graph.CellView;
import org.jgraph.graph.DefaultEdge;
import org.jgraph.graph.GraphConstants;
import org.jgraph.graph.GraphLayoutCache;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.ListenableDirectedGraph;

public class MainWindow extends javax.swing.JFrame {
	private File file;
	private JFileChooser fc;
	private OrganicOptionsDialog organic;
	private JGraph graphComponent;
	private JGraphFacade graphFacade;
	private JGraphLayout graphLayout;
	private ListenableDirectedGraph<String, DefaultEdge> directedGraph;
	private JGraphModelAdapter<String, DefaultEdge> graphModel;

	/** Creates new form MainWindow */
	public MainWindow() {
		preInitCustom();
		initComponents();
		initCustomComponents();
		readyStateOk();
	}

	private void preInitCustom() {
		directedGraph = new ListenableDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
		graphModel = new JGraphModelAdapter<String, DefaultEdge>(directedGraph);
		graphComponent = new JGraph(graphModel);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                layoutsGroup = new javax.swing.ButtonGroup();
                infoPanel = new javax.swing.JPanel();
                startButt = new javax.swing.JButton();
                sccsNumberTextField = new javax.swing.JTextField();
                sccNumLabel = new javax.swing.JLabel();
                sccSizeLabel = new javax.swing.JLabel();
                diameterLabel = new javax.swing.JLabel();
                greatestDiameterTextField = new javax.swing.JTextField();
                openButt = new javax.swing.JButton();
                datafileTextField = new javax.swing.JTextField();
                jScrollPane2 = new javax.swing.JScrollPane();
                sccSizesTextArea = new javax.swing.JTextArea();
                graphPane = new javax.swing.JScrollPane(graphComponent);
                menubar = new javax.swing.JMenuBar();
                ready = new javax.swing.JMenu();
                fileMenu = new javax.swing.JMenu();
                openItm = new javax.swing.JMenuItem();
                imgItm = new javax.swing.JMenuItem();
                printItm = new javax.swing.JMenuItem();
                exit = new javax.swing.JMenuItem();
                editMenu = new javax.swing.JMenu();
                bendEdgeItm = new javax.swing.JCheckBoxMenuItem();
                layoutsMenu = new javax.swing.JMenu();
                cyrcleRadio = new javax.swing.JRadioButtonMenuItem();
                tiltRadio = new javax.swing.JRadioButtonMenuItem();
                randomRadio = new javax.swing.JRadioButtonMenuItem();
                organicRadio = new javax.swing.JRadioButtonMenuItem();
                jSeparator1 = new javax.swing.JPopupMenu.Separator();
                debugItm = new javax.swing.JCheckBoxMenuItem();
                aboutMenu = new javax.swing.JMenu();
                helpItm = new javax.swing.JMenuItem();
                authorsItm = new javax.swing.JMenuItem();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("JGraphs");

                startButt.setText("Start");
                startButt.setEnabled(false);
                startButt.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                startButtActionPerformed(evt);
                        }
                });

                sccsNumberTextField.setEditable(false);

                sccNumLabel.setText("number of SCCs :");

                sccSizeLabel.setText("SSCs sizes:");

                diameterLabel.setText("greatest SCC's Diameter:");

                greatestDiameterTextField.setEditable(false);

                openButt.setText("Open File");
                openButt.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                openButtActionPerformed(evt);
                        }
                });

                datafileTextField.setEditable(false);

                sccSizesTextArea.setColumns(20);
                sccSizesTextArea.setEditable(false);
                sccSizesTextArea.setRows(5);
                jScrollPane2.setViewportView(sccSizesTextArea);

                javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
                infoPanel.setLayout(infoPanelLayout);
                infoPanelLayout.setHorizontalGroup(
                        infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(infoPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(infoPanelLayout.createSequentialGroup()
                                                .addComponent(openButt, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(datafileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(infoPanelLayout.createSequentialGroup()
                                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(startButt)
                                                        .addComponent(sccNumLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                                        .addComponent(diameterLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(greatestDiameterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sccsNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sccSizeLabel))))
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                );

                infoPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {openButt, startButt});

                infoPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {greatestDiameterTextField, sccSizeLabel, sccsNumberTextField});

                infoPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {diameterLabel, sccNumLabel});

                infoPanelLayout.setVerticalGroup(
                        infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(infoPanelLayout.createSequentialGroup()
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(infoPanelLayout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addComponent(startButt))
                                        .addGroup(infoPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, infoPanelLayout.createSequentialGroup()
                                                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(openButt)
                                                                        .addComponent(datafileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(sccSizeLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(sccsNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(sccNumLabel))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(greatestDiameterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(diameterLabel))))))
                                .addContainerGap())
                );

                infoPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {diameterLabel, greatestDiameterTextField, sccNumLabel, sccsNumberTextField});

                infoPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {datafileTextField, openButt, sccSizeLabel, startButt});

                graphPane.setBackground(Color.DARK_GRAY);

                ready.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/flag-green.png"))); // NOI18N
                ready.setEnabled(false);
                ready.setIconTextGap(0);
                menubar.add(ready);

                fileMenu.setText("File");

                openItm.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
                openItm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/addwin.png"))); // NOI18N
                openItm.setText("Open File");
                openItm.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                openButtActionPerformed(evt);
                        }
                });
                fileMenu.add(openItm);

                imgItm.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
                imgItm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/grep.png"))); // NOI18N
                imgItm.setText("Save Image");
                imgItm.setEnabled(false);
                imgItm.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                imgItmActionPerformed(evt);
                        }
                });
                fileMenu.add(imgItm);

                printItm.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
                printItm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/copy.png"))); // NOI18N
                printItm.setText("Print");
                printItm.setEnabled(false);
                printItm.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                printItmActionPerformed(evt);
                        }
                });
                fileMenu.add(printItm);

                exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
                exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/exit.png"))); // NOI18N
                exit.setText("Exit");
                exit.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                exitActionPerformed(evt);
                        }
                });
                fileMenu.add(exit);

                menubar.add(fileMenu);

                editMenu.setText("Edit");

                bendEdgeItm.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
                bendEdgeItm.setText("Bend Edges");
                bendEdgeItm.addChangeListener(new javax.swing.event.ChangeListener() {
                        public void stateChanged(javax.swing.event.ChangeEvent evt) {
                                bendEdgeItmStateChanged(evt);
                        }
                });
                editMenu.add(bendEdgeItm);

                layoutsMenu.setText("Layouts");

                layoutsGroup.add(cyrcleRadio);
                cyrcleRadio.setText("Cyrcle");
                cyrcleRadio.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cyrcleRadioActionPerformed(evt);
                        }
                });
                layoutsMenu.add(cyrcleRadio);

                layoutsGroup.add(tiltRadio);
                tiltRadio.setText("Tilt");
                tiltRadio.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                tiltRadioActionPerformed(evt);
                        }
                });
                layoutsMenu.add(tiltRadio);

                layoutsGroup.add(randomRadio);
                randomRadio.setText("Random");
                randomRadio.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                randomRadioActionPerformed(evt);
                        }
                });
                layoutsMenu.add(randomRadio);

                layoutsGroup.add(organicRadio);
                organicRadio.setText("Organic");
                organicRadio.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                organicRadioActionPerformed(evt);
                        }
                });
                layoutsMenu.add(organicRadio);

                editMenu.add(layoutsMenu);
                editMenu.add(jSeparator1);

                debugItm.setText("Debug");
                debugItm.addChangeListener(new javax.swing.event.ChangeListener() {
                        public void stateChanged(javax.swing.event.ChangeEvent evt) {
                                debugItmStateChanged(evt);
                        }
                });
                editMenu.add(debugItm);

                menubar.add(editMenu);

                aboutMenu.setText("Help");

                helpItm.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
                helpItm.setText("Help Contents");
                helpItm.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                helpItmActionPerformed(evt);
                        }
                });
                aboutMenu.add(helpItm);

                authorsItm.setText("Authors");
                authorsItm.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                authorsItmActionPerformed(evt);
                        }
                });
                aboutMenu.add(authorsItm);

                menubar.add(aboutMenu);

                setJMenuBar(menubar);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(graphPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                                        .addComponent(infoPanel, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(graphPane, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

	private void initCustomComponents() {
		this.setIconImage(new javax.swing.ImageIcon(getClass().getResource(Graphs.AppDefs.MAIN_ICON)).getImage());
		this.setLocationRelativeTo(null);
		debugItm.setSelected(AppDefs.DEBUG);
		organic = new OrganicOptionsDialog(this, true, false);
	}

	private void initGraphComponents() {
		graphModel = new JGraphModelAdapter<String, DefaultEdge>(directedGraph);
		graphComponent.setModel(graphModel);
		graphComponent.setAntiAliased(true);
		graphComponent.setEditable(false);
		graphComponent.setConnectable(false);
		graphComponent.setDisconnectable(false);
		graphComponent.setDisconnectOnMove(false);
		graphComponent.setGridEnabled(false);
		graphComponent.setGridVisible(false);
		graphComponent.getGraphLayoutCache().setAutoSizeOnValueChange(true);
		graphFacade = new JGraphFacade(graphComponent);
		graphFacade.setDirected(true);
	}

    private void openButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	    fc = new JFileChooser();
	    fc.setDragEnabled(true);
	    int state = fc.showOpenDialog(this);
	    if (state == JFileChooser.APPROVE_OPTION) {
		    file = fc.getSelectedFile();
		    datafileTextField.setText(file.getName());
		    startButt.setEnabled(true);
	    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void startButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
	    clearFields();
	    readyStateBusy();
	    createGraphWorker().execute();
    }//GEN-LAST:event_jButton2ActionPerformed

	private SwingWorker createGraphWorker() {
		return new SwingWorker<Boolean, Void>() {
			@Override
			protected Boolean doInBackground() throws Exception {
				try {
					DataReader dr = new DataReader(file);
					if (dr.readFile()) {
						directedGraph = (ListenableDirectedGraph<String, DefaultEdge>) dr.getDigraph();
						return true;
					}
				} catch (FileNotFoundException fnfe) {
					JOptionPane.showMessageDialog(getParent(), "Unable to read data\nPlease choose another file",
								      "Error Reading File!", JOptionPane.ERROR_MESSAGE);
					fnfe.printStackTrace();
				}
				return false;
			}

			@Override
			public void done() {
				try {
					if (!get()) {
						JOptionPane.showMessageDialog(getParent(), "Unable to process graph",
									      "Error Processing!", JOptionPane.ERROR_MESSAGE);
					}
					computeGraphWorker().execute();
					visualizeGraphWorker().execute();
					SCCFinder scc = new SCCFinder(directedGraph);
					int[] sccSizes = scc.getSCCSizePerSubgraph();
					sccsNumberTextField.setText(String.valueOf(sccSizes.length));
					for (int sccNum = 0; sccNum < sccSizes.length; sccNum++)
						sccSizesTextArea.append(String.format("%0" + String.valueOf(sccSizes.length).length()
										      + "d. SCC size: %d\n", sccNum + 1, sccSizes[sccNum]));
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				} catch (ExecutionException ee) {
					ee.printStackTrace();
				}
			}

		};
	}

	private SwingWorker computeGraphWorker() {
		return new SwingWorker<GraphFinder, Void>() {
			@Override
			protected GraphFinder doInBackground() throws Exception {
				return new GraphFinder(directedGraph);
			}

			@Override
			public void done() {
				GraphFinder gf;
				try {
					gf = get();
					if (gf == null) {
						JOptionPane.showMessageDialog(getParent(), "Unable to compute graph",
									      "Error Computing!", JOptionPane.ERROR_MESSAGE);
					}
					greatestDiameterTextField.setText(String.valueOf(gf.getGreatestDiameter()));
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				} catch (ExecutionException ee) {
					ee.printStackTrace();
				}
			}

		};
	}

	private SwingWorker visualizeGraphWorker() {
		return new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				initGraphComponents();
				for (CellView cv : graphComponent.getGraphLayoutCache().getAllViews()) {
					if (bendEdgeItm.isSelected()) {
						GraphConstants.setLineStyle(cv.getAttributes(), GraphConstants.STYLE_SPLINE);
						GraphConstants.setRouting(cv.getAttributes(), GraphConstants.ROUTING_SIMPLE);
					} else {
						GraphConstants.setRouting(cv.getAttributes(), GraphConstants.ROUTING_DEFAULT);
					}
					GraphConstants.setLineEnd(cv.getAttributes(), GraphConstants.ARROW_SIMPLE);
					GraphConstants.setBendable(cv.getAttributes(), true);
					GraphConstants.setAutoSize(cv.getAttributes(), true);
					GraphConstants.setBackground(cv.getAttributes(), Color.green);
					GraphConstants.setConnectable(cv.getAttributes(), false);
					GraphConstants.setDisconnectable(cv.getAttributes(), false);
					GraphConstants.setEditable(cv.getAttributes(), false);
					graphComponent.getGraphLayoutCache().edit(graphComponent.getModel().getAttributes(cv));
				}
				if (graphLayout == null) {
					graphLayout = new JGraphOrganicLayout(graphPane.getVisibleRect());
				}
				graphLayout.run(graphFacade);
				return null;
			}

			@Override
			protected void done() {
				graphComponent.getGraphLayoutCache().edit(graphFacade.createNestedMap(true, true));
				imgItm.setEnabled(true);
				printItm.setEnabled(true);
				readyStateOk();
			}

		};
	}

	private SwingWorker edgeStyleWorker() {
		return new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				for (CellView cv : graphComponent.getGraphLayoutCache().getAllViews()) {
					if (bendEdgeItm.isSelected()) {
						GraphConstants.setLineStyle(cv.getAttributes(), GraphConstants.STYLE_SPLINE);
						GraphConstants.setRouting(cv.getAttributes(), GraphConstants.ROUTING_SIMPLE);
					} else {
						GraphConstants.setRouting(cv.getAttributes(), GraphConstants.ROUTING_DEFAULT);
					}
					graphComponent.getGraphLayoutCache().edit(graphComponent.getModel().getAttributes(cv));
				}
				return null;
			}

			@Override
			protected void done() {
				graphComponent.getGraphLayoutCache().refresh(graphComponent.getGraphLayoutCache().getAllViews(), true);
				graphComponent.addOffscreenDirty(GraphLayoutCache.getBounds(graphComponent.getGraphLayoutCache().getAllViews()));
				graphComponent.repaint();
				readyStateOk();
			}

		};
	}

    private void imgItmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgItmActionPerformed
	    File imgfile = null;
	    fc = new JFileChooser();
	    fc.setDragEnabled(true);
	    int state = fc.showOpenDialog(this);
	    if (state == JFileChooser.APPROVE_OPTION) {
		    boolean overwrite = true;
		    imgfile = new File(fc.getSelectedFile().getAbsolutePath() + ".png");
		    if (imgfile.exists()) {
			    int reply = JOptionPane.showConfirmDialog(this, "File exists. Overwrite ?",
								      "Overwrite", JOptionPane.YES_NO_OPTION,
								      JOptionPane.QUESTION_MESSAGE);
			    overwrite = reply != JOptionPane.NO_OPTION;
		    }
		    if (overwrite) {
			    BufferedImage img = graphComponent.getImage(Color.lightGray, 20);
			    try {
				    if (img == null) {
					    throw new IOException("Unable to form image");
				    }
				    ImageIO.write(img, "png", imgfile);
			    } catch (IOException ioe) {
				    System.err.format("%s: Could save image as file: %s", this.getClass().getName(), imgfile);
				    ioe.printStackTrace();
				    JOptionPane.showMessageDialog(this, "Unable to save image\n"
									+ "Please choose another location and/or file",
								  "Error Writing File!", JOptionPane.ERROR_MESSAGE);
			    }
		    }
	    }
    }//GEN-LAST:event_imgItmActionPerformed

    private void printItmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printItmActionPerformed
	    PrinterJob printJob = PrinterJob.getPrinterJob();
	    printJob.setPrintable((Printable) graphPane);
	    if (printJob.printDialog()) {
		    try {
			    printJob.print();
		    } catch (PrinterException pe) {
			    System.err.format("%s: Unable to print: %s", this.getClass().getName(), printJob.toString());
			    pe.printStackTrace();
			    JOptionPane.showMessageDialog(this, "Unable to print graph\n"
								+ "Please check your printer state",
							  "Error Printing!", JOptionPane.ERROR_MESSAGE);
		    }
	    }
    }//GEN-LAST:event_printItmActionPerformed

    private void bendEdgeItmStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_bendEdgeItmStateChanged
	    readyStateBusy();
	    edgeStyleWorker().execute();
    }//GEN-LAST:event_bendEdgeItmStateChanged

    private void cyrcleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cyrcleRadioActionPerformed
	    readyStateBusy();
	    graphLayout = new JGraphSimpleLayout(JGraphSimpleLayout.TYPE_CIRCLE, graphPane.getWidth(), graphPane.getHeight());
	    visualizeGraphWorker().execute();
    }//GEN-LAST:event_cyrcleRadioActionPerformed

    private void tiltRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiltRadioActionPerformed
	    readyStateBusy();
	    graphLayout = new JGraphSimpleLayout(JGraphSimpleLayout.TYPE_TILT, graphPane.getWidth(), graphPane.getHeight());
	    visualizeGraphWorker().execute();
    }//GEN-LAST:event_tiltRadioActionPerformed

    private void randomRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomRadioActionPerformed
	    readyStateBusy();
	    graphLayout = new JGraphSimpleLayout(JGraphSimpleLayout.TYPE_RANDOM, graphPane.getWidth(), graphPane.getHeight());
	    visualizeGraphWorker().execute();
    }//GEN-LAST:event_randomRadioActionPerformed

    private void organicRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organicRadioActionPerformed
	    readyStateBusy();
	    graphLayout = new JGraphOrganicLayout(graphPane.getVisibleRect());
	    organic.setVisible(true);
	    ((JGraphOrganicLayout) graphLayout).setFineTuning(true);
	    ((JGraphOrganicLayout) graphLayout).setDeterministic(!organic.isRandom());
	    if (organic.isEdgeCrossSelected()) {
		    ((JGraphOrganicLayout) graphLayout).setEdgeCrossingCostFactor(organic.getEdgeCrossValue());
	    }
	    if (organic.isEdgeDistSelected()) {
		    ((JGraphOrganicLayout) graphLayout).setEdgeDistanceCostFactor(organic.getEdgeDistValue());
	    }
	    if (organic.isEdgeLengthSelected()) {
		    ((JGraphOrganicLayout) graphLayout).setEdgeLengthCostFactor(organic.getsEdgeLengthValue());
	    }
	    if (organic.isNodeDistributionSelected()) {
		    ((JGraphOrganicLayout) graphLayout).setNodeDistributionCostFactor(organic.getNodeDistributionValue());
	    }
	    if (organic.isBorderLineSelected()) {
		    ((JGraphOrganicLayout) graphLayout).setBorderLineCostFactor(organic.getBorderLineValue());
	    }
	    visualizeGraphWorker().execute();
    }//GEN-LAST:event_organicRadioActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
	    this.dispose();
	    System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void helpItmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpItmActionPerformed
	    String help = String.format("Usefull Phone Numbers:\n\n%s\n%s\n%s\n%s",
					AppDefs.police, AppDefs.fires, AppDefs.calls, AppDefs.cars);
	    JOptionPane.showMessageDialog(this, help, "Help", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_helpItmActionPerformed

    private void authorsItmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorsItmActionPerformed
	    String authors = String.format("Authors:\n\n%s\n%s\n\n%s",
					   AppDefs.c00kie, AppDefs.master, AppDefs.fortune);
	    JOptionPane.showMessageDialog(this, authors, "Authors", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_authorsItmActionPerformed

    private void debugItmStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_debugItmStateChanged
	    AppDefs.DEBUG = debugItm.isSelected();
    }//GEN-LAST:event_debugItmStateChanged

	private void clearFields() {
		sccsNumberTextField.setText("");
		greatestDiameterTextField.setText("");
		sccSizesTextArea.setText("");
	}

	private void readyStateBusy() {
		ready.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/flag-red.png")));
		ready.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/flag-red.png")));
	}

	private void readyStateOk() {
		ready.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/flag-green.png")));
		ready.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/flag-green.png")));
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JMenu aboutMenu;
        private javax.swing.JMenuItem authorsItm;
        private javax.swing.JCheckBoxMenuItem bendEdgeItm;
        private javax.swing.JRadioButtonMenuItem cyrcleRadio;
        private javax.swing.JTextField datafileTextField;
        private javax.swing.JCheckBoxMenuItem debugItm;
        private javax.swing.JLabel diameterLabel;
        private javax.swing.JMenu editMenu;
        private javax.swing.JMenuItem exit;
        private javax.swing.JMenu fileMenu;
        private javax.swing.JScrollPane graphPane;
        private javax.swing.JTextField greatestDiameterTextField;
        private javax.swing.JMenuItem helpItm;
        private javax.swing.JMenuItem imgItm;
        private javax.swing.JPanel infoPanel;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JPopupMenu.Separator jSeparator1;
        private javax.swing.ButtonGroup layoutsGroup;
        private javax.swing.JMenu layoutsMenu;
        private javax.swing.JMenuBar menubar;
        private javax.swing.JButton openButt;
        private javax.swing.JMenuItem openItm;
        private javax.swing.JRadioButtonMenuItem organicRadio;
        private javax.swing.JMenuItem printItm;
        private javax.swing.JRadioButtonMenuItem randomRadio;
        private javax.swing.JMenu ready;
        private javax.swing.JLabel sccNumLabel;
        private javax.swing.JLabel sccSizeLabel;
        private javax.swing.JTextArea sccSizesTextArea;
        private javax.swing.JTextField sccsNumberTextField;
        private javax.swing.JButton startButt;
        private javax.swing.JRadioButtonMenuItem tiltRadio;
        // End of variables declaration//GEN-END:variables
}

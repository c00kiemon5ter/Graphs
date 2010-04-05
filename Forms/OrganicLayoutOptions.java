
/*
 * OrganicLayoutOptions.java
 *
 */
package Forms;

public class OrganicLayoutOptions extends javax.swing.JFrame {
	/** Creates new form OrganicLayoutOptions */
	public OrganicLayoutOptions() {
		initComponents();
		this.setLocationRelativeTo(null);
	}

	/** Creates new form OrganicLayoutOptions */
	public OrganicLayoutOptions(boolean visible) {
		initComponents();
		setVisible(visible);
		this.setLocationRelativeTo(null);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                organicOptionsPane = new javax.swing.JPanel();
                borderLine = new javax.swing.JCheckBox();
                edgeDistSpinner = new javax.swing.JSpinner();
                edgeCrossSpinner = new javax.swing.JSpinner();
                edgeDistLbl = new javax.swing.JLabel();
                edgeDist = new javax.swing.JCheckBox();
                nodeDistribution = new javax.swing.JCheckBox();
                edgeLength = new javax.swing.JCheckBox();
                nodeDistributionLbl = new javax.swing.JLabel();
                nodeDistributionSpinner = new javax.swing.JSpinner();
                randomElements = new javax.swing.JCheckBox();
                edgeCrossLbl = new javax.swing.JLabel();
                edgeCross = new javax.swing.JCheckBox();
                edgeLengthSpinner = new javax.swing.JSpinner();
                edgeLengthLbl = new javax.swing.JLabel();
                borderLineSpinner = new javax.swing.JSpinner();
                borderLineLbl = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("Organic Layout Options");

                borderLine.setText("Optimize Border Line Bounds");
                borderLine.addChangeListener(new javax.swing.event.ChangeListener() {
                        public void stateChanged(javax.swing.event.ChangeEvent evt) {
                                borderLineStateChanged(evt);
                        }
                });

                edgeDistSpinner.setModel(new javax.swing.SpinnerNumberModel(0.5d, 0.0d, 1.0d, 0.1d));
                edgeDistSpinner.setEnabled(false);

                edgeCrossSpinner.setModel(new javax.swing.SpinnerNumberModel(0.5d, 0.0d, 1.0d, 0.1d));
                edgeCrossSpinner.setEnabled(false);

                edgeDistLbl.setText("Cost Factor ");

                edgeDist.setText("Optimize Edge Distance");
                edgeDist.addChangeListener(new javax.swing.event.ChangeListener() {
                        public void stateChanged(javax.swing.event.ChangeEvent evt) {
                                edgeDistStateChanged(evt);
                        }
                });

                nodeDistribution.setText("Optimize Node Distribution");
                nodeDistribution.addChangeListener(new javax.swing.event.ChangeListener() {
                        public void stateChanged(javax.swing.event.ChangeEvent evt) {
                                nodeDistributionStateChanged(evt);
                        }
                });

                edgeLength.setText("Optimize Edge Length");
                edgeLength.addChangeListener(new javax.swing.event.ChangeListener() {
                        public void stateChanged(javax.swing.event.ChangeEvent evt) {
                                edgeLengthStateChanged(evt);
                        }
                });

                nodeDistributionLbl.setText("Cost Factor ");

                nodeDistributionSpinner.setModel(new javax.swing.SpinnerNumberModel(0.5d, 0.0d, 1.0d, 0.1d));
                nodeDistributionSpinner.setEnabled(false);

                randomElements.setText("Make use of random elements (non deterministic output)");

                edgeCrossLbl.setText("Cost Factor ");

                edgeCross.setText("Optimize Edge Crossing");
                edgeCross.addChangeListener(new javax.swing.event.ChangeListener() {
                        public void stateChanged(javax.swing.event.ChangeEvent evt) {
                                edgeCrossStateChanged(evt);
                        }
                });

                edgeLengthSpinner.setModel(new javax.swing.SpinnerNumberModel(0.5d, 0.0d, 1.0d, 0.1d));
                edgeLengthSpinner.setEnabled(false);

                edgeLengthLbl.setText("Cost Factor ");

                borderLineSpinner.setModel(new javax.swing.SpinnerNumberModel(0.5d, 0.0d, 1.0d, 0.1d));
                borderLineSpinner.setEnabled(false);

                borderLineLbl.setText("Cost Factor ");

                javax.swing.GroupLayout organicOptionsPaneLayout = new javax.swing.GroupLayout(organicOptionsPane);
                organicOptionsPane.setLayout(organicOptionsPaneLayout);
                organicOptionsPaneLayout.setHorizontalGroup(
                        organicOptionsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 406, Short.MAX_VALUE)
                        .addGroup(organicOptionsPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(organicOptionsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(randomElements)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, organicOptionsPaneLayout.createSequentialGroup()
                                                .addGroup(organicOptionsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(nodeDistribution)
                                                        .addComponent(edgeLength)
                                                        .addComponent(edgeCross)
                                                        .addComponent(edgeDist)
                                                        .addComponent(borderLine))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                                .addGroup(organicOptionsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(borderLineLbl)
                                                        .addComponent(edgeDistLbl)
                                                        .addComponent(edgeCrossLbl)
                                                        .addComponent(edgeLengthLbl)
                                                        .addComponent(nodeDistributionLbl))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                                .addGroup(organicOptionsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(edgeDistSpinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(edgeCrossSpinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(nodeDistributionSpinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(edgeLengthSpinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(borderLineSpinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
                );

                organicOptionsPaneLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {borderLine, edgeCross, edgeDist, edgeLength, nodeDistribution});

                organicOptionsPaneLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {borderLineLbl, edgeCrossLbl, edgeDistLbl, edgeLengthLbl, nodeDistributionLbl});

                organicOptionsPaneLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {borderLineSpinner, edgeCrossSpinner, edgeDistSpinner, edgeLengthSpinner, nodeDistributionSpinner});

                organicOptionsPaneLayout.setVerticalGroup(
                        organicOptionsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 276, Short.MAX_VALUE)
                        .addGroup(organicOptionsPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(randomElements)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(organicOptionsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nodeDistribution)
                                        .addComponent(nodeDistributionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nodeDistributionLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(organicOptionsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(edgeLength)
                                        .addComponent(edgeLengthLbl)
                                        .addComponent(edgeLengthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(organicOptionsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(edgeCrossLbl)
                                        .addComponent(edgeCrossSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(edgeCross))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(organicOptionsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(edgeDist)
                                        .addComponent(edgeDistLbl)
                                        .addComponent(edgeDistSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(organicOptionsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(borderLine)
                                        .addComponent(borderLineLbl)
                                        .addComponent(borderLineSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(73, Short.MAX_VALUE))
                );

                organicOptionsPaneLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {borderLine, borderLineLbl, borderLineSpinner, edgeCross, edgeCrossLbl, edgeCrossSpinner, edgeDist, edgeDistLbl, edgeDistSpinner, edgeLength, edgeLengthLbl, edgeLengthSpinner, nodeDistribution, nodeDistributionLbl, nodeDistributionSpinner, randomElements});

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(organicOptionsPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(organicOptionsPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

	private void nodeDistributionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nodeDistributionStateChanged
		nodeDistributionSpinner.setEnabled(nodeDistribution.isSelected());
	}//GEN-LAST:event_nodeDistributionStateChanged

	private void edgeLengthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_edgeLengthStateChanged
		edgeLengthSpinner.setEnabled(edgeLength.isSelected());
	}//GEN-LAST:event_edgeLengthStateChanged

	private void edgeCrossStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_edgeCrossStateChanged
		edgeCrossSpinner.setEnabled(edgeCross.isSelected());
	}//GEN-LAST:event_edgeCrossStateChanged

	private void edgeDistStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_edgeDistStateChanged
		edgeDistSpinner.setEnabled(edgeDist.isSelected());
	}//GEN-LAST:event_edgeDistStateChanged

	private void borderLineStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_borderLineStateChanged
		borderLineSpinner.setEnabled(borderLine.isSelected());
	}//GEN-LAST:event_borderLineStateChanged

	public boolean isRandom() {
		return randomElements.isSelected();
	}

	public boolean isBorderLineSelected() {
		return borderLine.isSelected();
	}

	public double getBorderLineValue() {
		return (Double) borderLineSpinner.getValue();
	}

	public boolean isNodeDistributionSelected() {
		return nodeDistribution.isSelected();
	}

	public double getNodeDistributionValue() {
		return (Double) nodeDistributionSpinner.getValue();
	}

	public boolean isEdgeLengthSelected() {
		return edgeLength.isSelected();
	}

	public double getsEdgeLengthValue() {
		return (Double) edgeLengthSpinner.getValue();
	}

	public boolean isEdgeCrossSelected() {
		return edgeCross.isSelected();
	}

	public double getEdgeCrossValue() {
		return (Double) edgeCrossSpinner.getValue();
	}

	public boolean isEdgeDistSelected() {
		return edgeDist.isSelected();
	}

	public double getEdgeDistValue() {
		return (Double) edgeDistSpinner.getValue();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new OrganicLayoutOptions().setVisible(true);
			}

		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JCheckBox borderLine;
        private javax.swing.JLabel borderLineLbl;
        private javax.swing.JSpinner borderLineSpinner;
        private javax.swing.JCheckBox edgeCross;
        private javax.swing.JLabel edgeCrossLbl;
        private javax.swing.JSpinner edgeCrossSpinner;
        private javax.swing.JCheckBox edgeDist;
        private javax.swing.JLabel edgeDistLbl;
        private javax.swing.JSpinner edgeDistSpinner;
        private javax.swing.JCheckBox edgeLength;
        private javax.swing.JLabel edgeLengthLbl;
        private javax.swing.JSpinner edgeLengthSpinner;
        private javax.swing.JCheckBox nodeDistribution;
        private javax.swing.JLabel nodeDistributionLbl;
        private javax.swing.JSpinner nodeDistributionSpinner;
        private javax.swing.JPanel organicOptionsPane;
        private javax.swing.JCheckBox randomElements;
        // End of variables declaration//GEN-END:variables
}


/*
 * OrganicOptionsDialog.java
 *
 */
package Forms;

/**
 *
 * @author c00kiemon5ter
 */
public class OrganicOptionsDialog extends javax.swing.JDialog {
	/** Creates new form OrganicOptionsDialog */
	public OrganicOptionsDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	/** Creates new form OrganicOptionsDialog */
	public OrganicOptionsDialog(java.awt.Frame parent, boolean modal, boolean visible) {
		super(parent, modal);
		initComponents();
		this.setVisible(visible);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

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
                ok = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("Organic Layout Settings");
                setLocationByPlatform(true);

                borderLine.setText("Optimize Border Line Bounds");
                borderLine.addChangeListener(new javax.swing.event.ChangeListener() {
                        public void stateChanged(javax.swing.event.ChangeEvent evt) {
                                borderLineStateChanged(evt);
                        }
                });

                edgeDistSpinner.setModel(new javax.swing.SpinnerNumberModel(0.5d, 0.0d, 1.0d, 0.5d));
                edgeDistSpinner.setEnabled(false);

                edgeCrossSpinner.setModel(new javax.swing.SpinnerNumberModel(0.5d, 0.0d, 1.0d, 0.5d));
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

                nodeDistributionSpinner.setModel(new javax.swing.SpinnerNumberModel(0.5d, 0.0d, 1.0d, 0.5d));
                nodeDistributionSpinner.setEnabled(false);

                randomElements.setText("Make use of random elements (non deterministic output)");

                edgeCrossLbl.setText("Cost Factor ");

                edgeCross.setText("Optimize Edge Crossing");
                edgeCross.addChangeListener(new javax.swing.event.ChangeListener() {
                        public void stateChanged(javax.swing.event.ChangeEvent evt) {
                                edgeCrossStateChanged(evt);
                        }
                });

                edgeLengthSpinner.setModel(new javax.swing.SpinnerNumberModel(0.5d, 0.0d, 1.0d, 0.5d));
                edgeLengthSpinner.setEnabled(false);

                edgeLengthLbl.setText("Cost Factor ");

                borderLineSpinner.setModel(new javax.swing.SpinnerNumberModel(0.5d, 0.0d, 1.0d, 0.5d));
                borderLineSpinner.setEnabled(false);

                borderLineLbl.setText("Cost Factor ");

                ok.setText("OK");
                ok.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                okActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(randomElements)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(edgeLength)
                                                        .addComponent(nodeDistribution)
                                                        .addComponent(edgeDist)
                                                        .addComponent(borderLine)
                                                        .addComponent(edgeCross))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(nodeDistributionLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(edgeDistLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(borderLineLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(edgeLengthLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(edgeCrossLbl, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(ok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(edgeCrossSpinner, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(edgeDistSpinner, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(borderLineSpinner, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(edgeLengthSpinner, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(nodeDistributionSpinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))))
                                .addContainerGap())
                );

                layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {borderLine, edgeCross, edgeDist, edgeLength, nodeDistribution});

                layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {borderLineSpinner, edgeCrossSpinner, edgeDistSpinner, edgeLengthSpinner, nodeDistributionSpinner, ok});

                layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {borderLineLbl, edgeCrossLbl, edgeDistLbl, edgeLengthLbl, nodeDistributionLbl});

                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(randomElements)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nodeDistribution)
                                        .addComponent(nodeDistributionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nodeDistributionLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(edgeLength)
                                        .addComponent(edgeLengthLbl)
                                        .addComponent(edgeLengthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(edgeCrossLbl)
                                        .addComponent(edgeCrossSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(edgeCross))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(edgeDist)
                                        .addComponent(edgeDistLbl)
                                        .addComponent(edgeDistSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(borderLine)
                                        .addComponent(borderLineLbl)
                                        .addComponent(borderLineSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addComponent(ok)
                                .addContainerGap())
                );

                layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {borderLine, borderLineLbl, borderLineSpinner, edgeCross, edgeCrossLbl, edgeCrossSpinner, edgeDist, edgeDistLbl, edgeDistSpinner, edgeLength, edgeLengthLbl, edgeLengthSpinner, nodeDistribution, nodeDistributionLbl, nodeDistributionSpinner, ok, randomElements});

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void borderLineStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_borderLineStateChanged
	    borderLineSpinner.setEnabled(borderLine.isSelected());
}//GEN-LAST:event_borderLineStateChanged

    private void edgeDistStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_edgeDistStateChanged
	    edgeDistSpinner.setEnabled(edgeDist.isSelected());
}//GEN-LAST:event_edgeDistStateChanged

    private void nodeDistributionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nodeDistributionStateChanged
	    nodeDistributionSpinner.setEnabled(nodeDistribution.isSelected());
}//GEN-LAST:event_nodeDistributionStateChanged

    private void edgeLengthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_edgeLengthStateChanged
	    edgeLengthSpinner.setEnabled(edgeLength.isSelected());
}//GEN-LAST:event_edgeLengthStateChanged

    private void edgeCrossStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_edgeCrossStateChanged
	    edgeCrossSpinner.setEnabled(edgeCross.isSelected());
}//GEN-LAST:event_edgeCrossStateChanged

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
	    this.setVisible(false);
	    this.dispose();
    }//GEN-LAST:event_okActionPerformed

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
				OrganicOptionsDialog dialog = new OrganicOptionsDialog(new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}

				});
				dialog.setVisible(true);
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
        private javax.swing.JButton ok;
        private javax.swing.JCheckBox randomElements;
        // End of variables declaration//GEN-END:variables
}

package graphs;

import Forms.MainWindow;

/**
 *
 * @author Ivan Kanakarakis
 */
public class Main {
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow().setVisible(true);
			}//run

		});
	}

}

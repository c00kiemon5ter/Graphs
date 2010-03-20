package Graphs;

import Forms.MainWindow;

/**
 *
 * @author	Ivan Kanakarakis
 */
public class Main {
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		for (String arg : args)
			if (arg.equals(AppDefs.DEBUG_SYMBOL)) {
				AppDefs.DEBUG = true;
			}
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow().setVisible(true);
			}//run

		});
	}

}

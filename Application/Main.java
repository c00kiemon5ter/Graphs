package Application;

import Forms.MainWindow;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws ClassNotFoundException,
						      InstantiationException,
						      IllegalAccessException,
						      UnsupportedLookAndFeelException {
		System.setProperty("awt.useSystemAAFontSettings", "on");
		for (String arg : args)
			if (arg.equals(AppDefs.DEBUG_SYMBOL)) {
				AppDefs.DEBUG = true;
			}
		boolean lafset = false;
		for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels())
			if (laf.getName().equalsIgnoreCase("GTK+")
			    || laf.getName().equalsIgnoreCase("Windows Vista")) {
				UIManager.setLookAndFeel(laf.getClassName());
				lafset = true;
				break;
			}
		if (!lafset) {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow().setVisible(true);
			}//run

		});
	}

}

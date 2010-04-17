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
		// enable antialiased fonts
		System.setProperty("awt.useSystemAAFontSettings", "on");
		// read cmd parameters
		for (String arg : args)
			if (arg.equals(AppDefs.DEBUG_SYMBOL)) {
				AppDefs.DEBUG = true;
			}
		// set look and feel to GTK+|Windows Vista|systemLaf
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
		// set and fix windows font style
		UIManager.getDefaults().put("TextArea.font", UIManager.get("TextPane.font"));
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow().setVisible(true);
			}

		});
	}

}

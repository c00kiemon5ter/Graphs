
package Application;

import Forms.MainWindow;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JGraphs {
	private MainWindow mw;

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		parseCliArgs(args);
		try {
			setLafSettings();
		} catch (ClassNotFoundException ex) {
		} catch (InstantiationException ex) {
		} catch (IllegalAccessException ex) {
		} catch (UnsupportedLookAndFeelException ex) {
		}
		JGraphs jGraphs = new JGraphs();
		jGraphs.showGraphPane();
	}

	private static void parseCliArgs(String[] args) {
		// read cmd parameters
		for (String arg : args) {
			if (arg.equals(AppDefs.DEBUG_SYMBOL)) {
				AppDefs.setDEBUG(true);
			}
		}
	}

	private static void setLafSettings() throws ClassNotFoundException,
												InstantiationException,
												IllegalAccessException,
												UnsupportedLookAndFeelException {
		// enable antialiased fonts
		System.setProperty("awt.useSystemAAFontSettings", "on");
		// set look and feel to GTK+|Windows Vista|systemLaf
		boolean lafset = false;
		for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
			if (laf.getName().equalsIgnoreCase("GTK+")
				|| laf.getName().equalsIgnoreCase("Windows Vista")) {
				UIManager.setLookAndFeel(laf.getClassName());
				lafset = true;
				break;
			}
		}
		if (!lafset) {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		// set and fix windows font style
		UIManager.getDefaults().put("TextArea.font", UIManager.get("TextPane.font"));
	}

	private JGraphs() {
		mw = new MainWindow();
	}

	private void showGraphPane() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				mw.setVisible(true);
			}

		});
	}

}

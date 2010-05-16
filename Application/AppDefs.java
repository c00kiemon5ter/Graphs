package Application;

public class AppDefs {
	public static final String MAIN_ICON = "/Icons/pipeplus.png";
	private static boolean DEBUG = false;
	public static final String DEBUG_SYMBOL = "-d";
	public static final String c00kie = "Κανακαράκης c00kiemonster Ιωάννης p3060190";
	public static final String master = "Ντανάσης Master_ex Περικλής p3070130";
	public static final String fortune = "Testing can show the presense of bugs, but not their absence.\n\t-- Dijkstra";
	public static final String police = "Police :  100";
	public static final String cars = "Road Help :  15658";
	public static final String calls = "Call Center :  11880";
	public static final String fires = "Fire Dep. :  192";

	/**
	 * @return the DEBUG
	 */ public static boolean isDEBUG() {
		return DEBUG;
	}

	/**
	 * @param aDEBUG the DEBUG to set
	 */ public static void setDEBUG(boolean aDEBUG) {
		DEBUG = aDEBUG;
	}

	private AppDefs() {
		/* Noop */
	}
}


package gra;

/**
 *
 * @author Komputer Domowy
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		GameEngine gameEngine = new GameEngine();
		gameEngine.run();
		System.out.println("test");
	    }
	});
    }
}

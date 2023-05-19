
package gra;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author Komputer Domowy
 */
public class OptionFrame {
    protected static StartOptionPane startOptionPane = new StartOptionPane();
    
    public static Player[] showOptionDialog(){
	String[] choices = {"Graj", "Wyjdź"};
	
	int option = JOptionPane.showOptionDialog(null,
			startOptionPane,
			"Ustawienia:",
			JOptionPane.OK_CANCEL_OPTION,
			JOptionPane.PLAIN_MESSAGE,
			null,
			choices,
			choices[0]);
	
	    
	
    	return option == 0 ? initValues() : null;
	
    }
    
    public static Player[] initValues(){
	Player[] players = new Player[InitValue.COUNTER_COLORS.size() - 1];
	
	PlayerInitPane[] playerInitPanes = startOptionPane.getPlayerInitPanes();
	Vector<String> colorNames = InitValue.getKeysVector();
	colorNames.remove(0);
	
	// Numery graczy, którzy nie mają wybranego koloru (ustawiony <Domyślny>)
	ArrayList<Integer> needColor = new ArrayList<>(4);
	
	
	for(int i = 0; i < players.length; i++){
	    players[i] = playerInitPanes[i].getPlayerName().substring(0, 3).equals("Bot") ? 
		    new Bot(playerInitPanes[i].getPlayerName()) : 
		    new User(playerInitPanes[i].getPlayerName());
	    
	    String colorName = (String)playerInitPanes[i].getCBCounterColor().getSelectedItem();
	    if(!colorName.equals("<Domyślny>")){
		colorNames.remove(colorName);
		players[i].setColorOfCounters(InitValue.getCounterColor(colorName));
	    }else
		needColor.add(i);
	}
	
	for(int i = 0; i < needColor.size(); i++){
	    players[needColor.get(i)].setColorOfCounters(InitValue.getCounterColor(colorNames.get(i)));
	}
	
	return players;
	
    }
}

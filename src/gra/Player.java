package gra;

import java.awt.Color;

/**
 *
 * @author Komputer Domowy
 */
public abstract class Player {
    protected String name;
    protected Color colorOfCounters;
    
    public Player(String name){
	setName(name);
    }
    
    public String getName(){
	return name;
    }
    
    public Color getColor(){
	return colorOfCounters;
    }
    
    public void setName(String name){
	this.name = name;
    }
    
    public void setColorOfCounters(Color color){
	this.colorOfCounters = color;
    }
    
    /**
     * Wybór pionka
     * @param board - obiekt, dzięki któremu gracz może odwołać sie do konkretnego pionka.
     * @return numer pionka w tablicy pionków na planszy
     */
    public abstract int chooseCounter(Board board);
    
    public abstract int throwDice(GameFrame gameFrame);
    
    
}

package gra;

/**
 *
 * @author Komputer Domowy
 */
public class Bot extends Player{
    public Bot(String name){
	super(name);
    }
    
    @Override
    public int chooseCounter(Board board) {
	return -1;
    }

    @Override
    public int throwDice(GameFrame gameFrame) {
	gameFrame.viewPlayerDraw(false);
	return gameFrame.viewDieAnimation();
    }
}

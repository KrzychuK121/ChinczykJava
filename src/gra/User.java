package gra;

/**
 *
 * @author Komputer Domowy
 */
public class User extends Player{
    public User(String name){
	super(name);
    }

    @Override
    public boolean ifUser(){
	return true;
    }
    
    @Override
    public int chooseCounter(Board board) {
	return -1;
    }

    @Override
    public int throwDice(GameFrame gameFrame) {
	gameFrame.viewPlayerDraw(true);
	return gameFrame.viewDieAnimation();
    }
}

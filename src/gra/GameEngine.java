
package gra;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Komputer Domowy
 */
public class GameEngine {
    
    private Player[] players;
    private Player winner;
    private GameFrame gameFrame;
    private Board board;
    private int playersIterator = 0;
    //private int currentPlayer = 0;
    
    public GameEngine(){
	gameFrame = new GameFrameAPI();
    }
    
    public ArrayList<Color> getPlayersColors(){
	ArrayList<Color> tmp = new ArrayList<Color>(players.length);
	
	for(Player player : players)
	    tmp.add(player.getColor());
	
	return tmp;
    }
    
    public void run(){
	players = OptionFrame.showOptionDialog();
	if(players == null)
	    exitGame();
	
	board = new Board(getPlayersColors());
	
	gameFrame.viewGame(board, players);
	gameFrame.viewBoard(board);
	
	playersIterator = 3;
	Color playerColor = players[playersIterator].getColor();
	
	/*for(int i = 0; i < 4; i++){
	    board.getCounter(playerColor, i).setPosition(43 - i);
	}	
	gameFrame.viewBoard(board);*/
	//board.getCounter(playerColor, 2).setPosition(5);
	
	//board.getCounter(playerColor, 3).setPosition(40);
	
	board.moveCounter(playerColor, 0, playersIterator, 6);
	board.moveCounter(playerColor, 1, playersIterator, 6);
	board.moveCounter(playerColor, 2, playersIterator, 6);
	
	board.getCounter(players[0].getColor(), 0).setPosition(17);
	
	//board.moveCounter(playerColor, 0, playersIterator, 5);
	//collide(playerColor, board.getCounter(playerColor, 0).getPosition());
	
	gameFrame.viewBoard(board);
	gameFrame.viewAvalibleCounters(players[0].getColor(), 0, true, 6, board);
	
	//game(0);
	
	if(ifPlayerWon(playerColor))
	    gameFrame.viewWinner(players[playersIterator]);
	
	//while(ifPlayerWon(currentPlayer)){
        
	
	//}
	
    }
    
    // Zwraca true gdy gra została wygrana
    public boolean game(int currentPlayer){
	System.out.println(players[currentPlayer].throwDice(gameFrame));
	return true;
    }
    
    public void collide(Color whichGroup, int position){
	for(Color color : board.getBoard().keySet()){
	    if(color.equals(whichGroup))
		continue;
	    
	    for(Counter counter : board.getBoard().get(color)){
		if(position == counter.getPosition()){
		    counter.moveCounterToBase();
		    return;
		}
	    }
		    
	}
    }
    
    /**
     * Funkcja boolowska, która zwraca prawdę jeśli gracz wygrał.
     * Sprawdzane są pionki gracza, który wykonał rzut kostką i ruszył się swoim pionkiem.
     * Jeśli gracz wygrał to program powinien zakończyć swoje działanie i wyświetlić komunikat
     * o wygranej. Jeśli nie to gra powinna toczyć się dalej i przejść do następnego gracza.
     * 
     * Aby sprawdzić czy gracz wygrał trzeba uzyskać z planszy dostęp do pionków, którymi steruje gracz.
     * Następnie trzeba sprawdzić czy wszystkie jego pionki znajdują się na pozycjach w domku
     * (w tym przypadku pozycje od 40 do 43). Nie trzeba sprawdzać czy pionki nie stoją w tym samym polu,
     * ponieważ podczas wykonywania ruchu sprawdzane jest czy gracz może się ruszyć danym pionkiem.
     * Gracz nie ma dostępu do pionka (nie może wykonać ruchu) jeśli ruch spowodował by, że
     * dwa pionki będą w tym samym miejscu.
     * 
     * @param playerColor - kolor aktualnie sprawdzanego gracza
     * @return Zwraca prawdę jeśli gracz wygrał i fałsz w przeciwnym wypadku
     */
    public boolean ifPlayerWon(Color playerColor){
	boolean ifInsideHouse = true;
	for(Counter counter : board.getBoard().get(playerColor))
	    if(counter.getPosition() != 40 && counter.getPosition() != 41 && counter.getPosition() != 42 && counter.getPosition() != 43)
		return !ifInsideHouse;
	return ifInsideHouse;
    }
    
    public void exitGame(){
	gameFrame.viewExitInfo();
	System.exit(0);
    }
}

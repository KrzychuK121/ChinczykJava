
package gra;

import java.awt.*;
import java.util.*;


/**
 *
 * @author Komputer Domowy
 */
public class Board {
    /** przechowuje numer pola w tablicy fields*/
    public final int[] outFields = { 32, 2, 12, 22 }; 
    /** 
     * <pre>
     * Gdy pionek ma pozycję 39 to stoi przed polem końcowym i czeka na wejście w pole końcowe
     * Gdy pionek ma pozycję 40-43 to znajduje się w polu końcowym
     * Gdy pionek ma pozycję -1 to znajduje się ,,w bazie"
     * </pre>
     */
    protected Map<Color, Counter[]> counters = new HashMap<>();
    
    /**
     * Konstruktor klasy <code>Board</code>
     * 
     * @param colors tablica kolorów jakie będą reprezentować grupy pionków.
     */
    public Board(ArrayList<Color> colors){
	initCounters(colors);
    }
    
    /**
     * <pre>
     * Inicjalizacja mapy <code>counters</code>. Wywoływana po tym jak gracze ustalą swoje kolory.
     * </pre>
     * 
     * @param colors tablica kolorów jakie będą reprezentować grupy pionków.
     */
    protected void initCounters(ArrayList<Color> colors){
	for(Color color : colors){
	    counters.put(color, new Counter[4]);
	    
	    for(int i = 0; i < counters.get(color).length; i++)
		counters.get(color)[i] = new Counter();
		
	}
	
    }

    public void reloadBoard(int oldPosition, int newPosition){
	
    }
    
    /**
     * <pre>
     * Metoda, która przemieszcza konkretny pionek na planszy.
     * Wywołuje metodę <code>moveCounter</code> z klasy <code>Counter</code>
     * </pre>
     * 
     * @param whichGroup kolor reprezentujący grupę pionków
     * @param whichCounter który pionek ma zostać przemieszczony
     * @param whichPlayer numer reprezentujący kolejność gracza w kolejce
     * @param jump wartość od 1 do 6, ile pól ma się przemieścić pionek
     */
    public void moveCounter(Color whichGroup, int whichCounter, int whichPlayer,int jump){
        getCounter(whichGroup, whichCounter).moveCounter(outFields[whichPlayer], jump);
    }
    
    public Counter getCounter(Color whichGroup, int whichCounter){
        return counters.get(whichGroup)[whichCounter];
    }
    
    /**
     * <pre>
     * Metoda zwracająca ilość pionków z danej grupy (danego gracza),
     * które stoją na miejscu podanym w drugim parametrze.
     * Przydatne do wyświetlania kiedy trzeba sprawdzić czy jakiś
     * inny pionek gracza nie stoi w tym samym miejscu. Wtedy trzeba
     * inaczej przedstawić pionki na planszy.
     * </pre>
     * 
     * @param whichGroup klucz, dzięki któremu jest dostęp do konkretnej grupy pionków
     * @param position pozycja na planszy, na której sprawdzana jest ilość stojących tam pionków
     * 
     * @return ilość pionków z tej samej grupy podanej w pierwszym parametrze na podanej pozycji w drugim parametrze
     */
    public int countCountersOnField(Color whichGroup, int position){
	int sum = 0;
	for(Counter counter : counters.get(whichGroup))
	    if(position == counter.getPosition())
		sum++;
	return sum;
    }
    
    public Map<Color, Counter[]> getBoard(){
	return counters;
    }
}

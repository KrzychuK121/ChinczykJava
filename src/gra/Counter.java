package gra;

import java.awt.*;

/**
 * Grupa 4 pionków
 * @author Komputer Domowy
 */
public class Counter {
    /** Pozycja bezwzględna na planszy */
    protected int position;
    /** ile pól przeszedł pionek */
    private int road = 0;
    
    public Counter(){
	moveCounterToBase();
    }
    
    public Counter(int position){
	this.position = position;
    }
    
    /**
     * <pre>
     * Metoda odpowiedzialna za przesunięcie pozycji pionka po wyrzuceniu danej liczby oczek.
     * Pionek po podaniu dodatniej liczby <code>jump</code> będzie się poruszał tylko do przodu.
     * </pre>
     * 
     * @param startPosition - numer w tablicy <code>outFields</code> znajdującej się w klasie <code>Board</code>.
     * Potrzebny do tego by sprawdzić czy gracz po wykonaniu ruchu nie wyszedł by poza planszę. 
     * @param jump - wyrzucona przez gracza ilość kostek, czyli tyle ile pól ma się ruszyć pionek
     * 
     * @return Zwraca prawdę jeśli ruch pionka mieści się w zakresie 
     */
    public boolean moveCounter(int startPosition, int jump){
	// Jeśli pionek znajduje się w domku to zwróć fałsz
	if(position > 39)
	    return false;
	
	// Nie trzeba sprawdzać czy gracz wyrzucił 6 czy nie ponieważ plansza dba o to by wyświetlić te pionki,
	// którymi gracz może dokonać ruchu po wyrzuconej konkretnej ilości oczek.
        // Jeśli pionek znajduje się w bazie to trzeba go postawić w polu startowym. 
	// Jeśli pionek nie znajduje się w bazie to trzeba zmienić jego pozycję
	if(position == -1 && jump == 6){
	    road = 1;
	    position = startPosition;
	    return true;
	}
	
	// Ustawienie pozycji pionka, który ma wejść do domku
	// Jeśli pionek znajduje się między 6 polem od wejścia do domku a pierwszym polem od wejścia do domku
	// oraz jego pozycja zwiększona o ilość wyrzuconych oczek oznaczało by przejście poza pole tuż przed wejściem do domku
	// to ma ustawić jego pozycję na pozycję w domku.
	if(ifCanEnterHouse(jump)){
	    road += jump;
	    position = road;
	    return true;
	}
	
	if(position != -1){
	    road += jump;
	    position = (position + jump) % InitValue.BOARD_SIZE;
	}
	    
	
        return true;
            
    }
    
    /**
     * <pre>
     * Metoda sprawdzająca czy pionek po wykonanym skoku nie przejdzie poza zakres planszy
     * i nie wejdzie do domku
     * </pre>
     * 
     * @param jump - ilość wyrzuconych oczek, ilość skoków jakie musi wykonać pionek
     * 
     * @return Zwraca prawdę jeśli pionek nie przeskoczy planszy i po wykonaniu skoku 
     * nie znajdzie się w polu końcowym (domku)
     */
    public boolean ifBeforeHouse(int jump){
	//System.out.println(road + jump);
	return road + jump < 40;
    }
    
    /**
     * <pre>
     * Metoda, która sprawdza czy pionek po wyrzuconej liczbie oczek byłby w stanie
     * wejść na jakiekolwiek pole domku czy przeszedł by poza pola domku (indeks 44 i więcej).
     * </pre>
     * 
     * @param jump - ilość wyrzuconych oczek, ilość skoków jakie musi wykonać pionek
     * 
     * @return Jeśli pozycja pionka zwiększona o ilość wyrzuconych oczek oznaczała by przejście poza pole tuż przed wejściem do domku
     * to funkcja zwraca fałsz. Jeśli nie to funkcja zwraca prawdę.
     */
    public boolean ifCanEnterHouse(int jump){
	return 40 <= road + jump && road + jump <= 43;
    }
    
    /**
     * Metoda potrzebna do tego by spradzić czy pionek po wykonaniu ruchu
     * nie będzie bliżej domku. Jeśli tak to zwróci prawdę. Jeśli nie to zwróci fałsz
     * 
     * @param startPosition
     * @param jump
     * 
     * @return 
     */
    /*public boolean ifCloserToHouse(int startPosition, int jump){
	return -2 < position + jump - startPosition && position + jump - startPosition < 3;
    }*/
    
    public int getHousePosition(int jump){
	//System.out.println(position + jump - startPosition + 41);
	//return position + jump - startPosition + 41;
	return road + jump;
    }
    
    /**
     * Metoda oblicza jaką pozycję będzie miał pionek po wykonaniu ruchu.
     * 
     * @param jump ilość pól jaką może pokonać pionek
     * 
     * @return możliwą pozycję pionka po wykonaniu ruchu 
     */
    public int getPositionAfterJump(int jump){
	return (position + jump) % InitValue.BOARD_SIZE;
    }
    
    public void moveCounterToBase(){
	position = -1;
	road = 0;
    }
    
    /**
     * <pre>
     * Przydatna przy wychodzeniu z bazy, wracania
     * do bazy po zbiciu albo wchodzenia do domku.
     * </pre>
     * 
     * @param position - pozycja, na której chce się postawić pionka
     */
    public void setPosition(int position){
	this.position = position;
    }
    
    public void setRoad(int road){
	this.road = road;
    }
    
    public int getPosition(){
	return this.position;
    }
}

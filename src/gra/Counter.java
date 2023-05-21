package gra;

import java.awt.*;

/**
 * Grupa 4 pionków
 * @author Komputer Domowy
 */
public class Counter {
    // Pozycja bezwzględna na planszy
    protected int position;
    
    public Counter(){
	moveCounterToBase();
    }
    
    public Counter(int position){
	this.position = position;
    }
    
    /**
     * Funkcja odpowiedzialna za przesunięcie pozycji pionka po wyrzuceniu danej liczby oczek.
     * @param startPosition - numer w tablicy <code>fields</code> znajdującej się w klasie <code>GameFrameAPI</code>.
     * Potrzebny do tego by sprawdzić czy gracz po wykonaniu ruchu nie wyszedł by poza planszę. 
     * 
     * @param jump - wyrzucona przez gracza ilość kostek, czyli tyle ile pól ma się ruszyć pionek
     * @return Zwraca prawdę jeśli ruch pionka mieści się w zakresie 
     */
    public boolean moveCounter(int startPosition, int jump){
	// Jeśli pionek znajduje się w domku to zwróć fałsz
	if(position > 39)
	    return false;
	// Ustawienie pozycji pionka, który ma wejść do domku
	// Jeśli pionek znajduje się między 6 polem od wejścia do domku a pierwszym polem od wejścia do domku
	// oraz jego pozycja zwiększona o ilość wyrzuconych oczek oznaczało by przejście poza pole tuż przed wejściem do domku
	// to ma ustawić jego pozycję na pozycję w domku.
	if(ifCloseToHouse(startPosition, jump)){
	    position = getHousePosition(startPosition, jump);
	    return true;
	}
	    
	
	// Nie trzeba sprawdzać czy gracz wyrzucił 6 czy nie ponieważ plansza dba o to by wyświetlić te pionki,
	// którymi gracz może dokonać ruchu po wyrzuconej konkretnej ilości oczek.
        // Jeśli pionek znajduje się w bazie to trzeba go postawić w polu startowym. 
	// Jeśli pionek nie znajduje się w bazie to trzeba zmienić jego pozycję
	if(position == -1 && jump == 6){
	    position = startPosition;
	    return true;
	}
	
	if(position != -1)
	    position = (position + jump) % InitValue.BOARD_SIZE;
	
        return true;
            
    }
    
    /**
     * Funkcja sprawdzająca czy pionek znajduje się tuż przed wejściem do domku (po wyrzuconej liczbie oczek
     * byłby w stanie wejść do domku).
     * 
     * @param startPosition - pozycja, na którą wychodzi pionek po opuszczeniu bazy
     * @param jump - ilość wyrzuconych oczek, ilość skoków jakie musi wykonać pionek
     * 
     * @return Jeśli pionek znajduje się między 6 polem od wejścia do domku a pierwszym polem od wejścia do domku
     * oraz jego pozycja zwiększona o ilość wyrzuconych oczek oznaczało by przejście poza pole tuż przed wejściem do domku
     * to funkcja zwraca prawdę. Jeśli nie to funkcja zwraca fałsz.
     */
    public boolean ifCloseToHouse(int startPosition, int jump){
	return -8 < position - startPosition && position - startPosition < -1 && -2 < position + jump - startPosition;
    }
    
    public int getHousePosition(int startPosition, int jump){
	return position + jump - startPosition + 41;
    }
    
    public int getPositionAfterJump(int jump){
	return (position + jump) % InitValue.BOARD_SIZE;
    }
    
    public void moveCounterToBase(){
	position = -1;
    }
    
    /**
     * Przydatna przy wychodzeniu z bazy, wracania
     * do bazy po zbiciu albo wchodzenia do domku.
     * 
     * @param position - pozycja, na której chce się postawić pionka
     */
    public void setPosition(int position){
	this.position = position;
    }
    
    public int getPosition(){
	return this.position;
    }
}

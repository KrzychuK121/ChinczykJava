
package gra;

import java.awt.Color;
import java.util.*;

/**
 *
 * @author Komputer Domowy
 */
public interface GameFrame {
    public final Random RANDOM = new Random();
    public ArrayList<Integer> eyes = new ArrayList<>(4);
    /** Czyszczenie planszy z poprzednich zapisków */
    public void clearBoard();
    /**
     * <pre>
     * Funkcja odpowiedzialna za ustawienie wszystkich zmiennych
     * potrzebnych do wyświetlenia gry (pola domku, pola bazy, 
     * pola planszy, etykiety graczy itp).
     * </pre>
     * 
     * @param board przechowuje pozycje pionków na planszy oraz posiada informacje<br> o tym gdzie znajduje się pole wyjścia danej grupy pionków.
     * @param players tablica graczy, potrzebna do wyświetlenia etykiet i ustawienia kolorów pól bazy
     */
    public void viewGame(Board board, Player[] players);
    /**
     * Pokazuje aktualny stan planszy po przejściu do następnego gracza, uruchamiając przy tym kostke
     * 
     * @param board przechowuje pozycje pionków na planszy.
     * @param player gracz, który aktualnie wykonuje ruch.
     */
    public void viewBoard(Board board, Player player);
    /**
     * Ma za zadanie pokazać informację o zakończeniu gry.
     * 
     * @param player gracz który wygrał. Potrzebny by wypisać jego nick.
     */
    public void viewWinner(Player player);
    /**
     * Wyświetla użytkownikowi listę pionków, którymi może wykonać ruch.
     * 
     * @param player obiekt reprezentujący gracza wykonującego ruch.
     * @param whichPlayer określa którym w kolejności jest nasz gracz.
     * @param howManyEye ilość wyrzuconych oczek przez gracza podczas rzutu kostką.
     * @param board obiekt planszy zawierający wszystkie pionki z ich położeniami.
     *
     * @return tablicę pionków, którymi można wykonać ruch. 
     *	       Jeśli jest pusta oznacza, że nie ma pionków, którymi można wykonać ruch.
     */
    public ArrayList<Counter> viewAvalibleCounters(Player player, int whichPlayer, int howManyEye, Board board);
    /**
     * <pre>
     * Czyści planszę wyświetloną na ekranie a następnie wyświetla wszystkie
     * pionki znajdujące się na planszy.
     * </pre>
     * 
     * @param board plansza zawierająca wszystkie pionki do wyświetlenia wraz z ich pozycjami.
     */
    public void viewCounters(Board board);
    /**
     * Animacja rzucania kostką (wyświetlanie po kolei ilości oczek)
     * 
     * @return liczbę wylosowanych przez gracza oczek.
     */
    public int viewDieAnimation();
    public void viewExitInfo();
    // Losowanie ilości oczek
    default public int draw(){
	return RANDOM.nextInt(6) + 1;
    }
    
}

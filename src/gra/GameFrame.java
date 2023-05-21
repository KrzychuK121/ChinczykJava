
package gra;

import java.awt.Color;
import java.util.*;

/**
 *
 * @author Komputer Domowy
 */
public interface GameFrame {
    public Random random = new Random();
    public ArrayList<Integer> eyes = new ArrayList<>(4);
    // Czyszczenie planszy z poprzednich zapisków
    public void clearBoard();
    /**
     * Funkcja odpowiedzialna za ustawienie wszystkich zmiennych
     * potrzebnych do wyświetlenia g ry
     */
    public void viewGame(Board board, Player[] players);
    public void viewBoard(Board board, Player player);
    public void viewWinner(Player player);
    // Wyświetla użytkownikowi listę pionków, którymi może wykonać ruch
    public ArrayList<Counter> viewAvalibleCounters(Player player, int whichPlayer, int howManyEye, Board board);
    public void viewCounters(Board board);
    public void viewPlayerDraw(boolean ifUser);
    /**
     * Animacja rzucania kostką (wyświetlanie po kolei ilości oczek)
     * @return liczbę wylosowanych przez gracza oczek.
     */
    public int viewDieAnimation();
    public void viewExitInfo();
    // Losowanie ilości oczek
    default public int draw(){
	return random.nextInt(6) + 1;
    }
    
}

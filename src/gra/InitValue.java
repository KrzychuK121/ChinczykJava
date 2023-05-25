
package gra;

import java.awt.Color;
import java.util.*;

/**
 *
 * @author Krzychu
 */
public class InitValue {
    public static final Map<String, Color> COUNTER_COLORS = new HashMap<>(4);
    public static final int BOARD_SIZE = 40;
    
    public static void initCounterColors(){
	COUNTER_COLORS.put("Czerwony", Color.RED);
	COUNTER_COLORS.put("Niebieski", new Color(91, 162, 255));
	COUNTER_COLORS.put("Żółty", Color.YELLOW);
	COUNTER_COLORS.put("Zielony", Color.GREEN);
	COUNTER_COLORS.put("<Domyślny>", null);
	
    }
    
    /**
     * Funkcja ma za zadanie przygotować wektor z kluczy (Stringów) w tablicy asocjacyjnej counterColors
     * w taki sposób aby na pierwszym elemencie zawsze była wartość <code>"<Domyślny>"</code>.
     * @return Gotowy wektor, który służy do inicjalizacji danych w <code>JComboBox</code> 
     * (w którym znajdują się kolory dostępne na planszy) w klasie <code>PlayerInitPane</code>.
     */
    public static Vector<String> getKeysVector(){
	Vector<String> test = new Vector<>(InitValue.COUNTER_COLORS.keySet());
	Collections.swap(test, test.indexOf("<Domyślny>"), 0);
	return test;
    }
    
    public static Color getCounterColor(String key){
	return COUNTER_COLORS.get(key);
    }
    
}

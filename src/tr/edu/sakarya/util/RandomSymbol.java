package tr.edu.sakarya.util;

import java.util.ArrayList;
import java.util.Random;
/**
 * This class includes the characters with int value between 33 and 126
 */
public class RandomSymbol {

    ArrayList<Character> symbols = new ArrayList<>();

    public RandomSymbol() {
        for (int i = 33; i <= 126; i++) {
            symbols.add((char) i);
        }
    }

    /**
     * @return a random character from the list.
     * @throws RuntimeException when the all symbols in the list have been used.
     */
    public char get() {
        if(symbols.isEmpty()) {
            throw new RuntimeException("All symbols in the list have already been used.");
        }
        Random rand = new Random();
        int randomIndex = rand.nextInt(symbols.size());
        char backup = symbols.get(randomIndex);
        symbols.remove(randomIndex);
        return backup;
    }

}




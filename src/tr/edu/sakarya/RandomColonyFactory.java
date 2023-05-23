package tr.edu.sakarya;

import tr.edu.sakarya.campus.*;
import tr.edu.sakarya.campus.specs.*;
import tr.edu.sakarya.util.RandomSymbol;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomColonyFactory {

    private static final int MAX_POPULATION = 200;

    private static final RandomSymbol randomSymbol = new RandomSymbol();

    /**
     * @param size of the list
     * @return randomly generates list of colonies
     */
    public static List<Colony> generate(int size) {
        return IntStream.range(0, size-1)
                .mapToObj(idx ->
                        new Colony(
                                randomPopulation(),
                                randomSymbol.get(),
                                randomStrategy(),
                                randomProductionMethod())
                )
                .collect(Collectors.toList());
    }

    private static Production randomProductionMethod() {
        if (isEven()) {
            return new RandomProduction();
        } else {
            return new StepProduction();
        }
    }

    private static Strategy randomStrategy() {
        if (isEven()) {
            return new LCGStrategy();
        } else {
            return new FortunaStrategy();
        }
    }

    private static boolean isEven() {
        Random rand = new Random();
        int choice = rand.nextInt(2);
        return choice == 0;
    }

    private static int randomPopulation() {
        Random rand = new Random();
        return rand.nextInt(MAX_POPULATION);
    }
}

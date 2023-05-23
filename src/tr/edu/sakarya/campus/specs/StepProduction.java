package tr.edu.sakarya.campus.specs;

import java.util.Random;

/**
 * Produces a constant value randomly set at the initiation of the instance
 */
public class StepProduction implements Production {

    private final int stepValue = new Random().nextInt(15);

    @Override
    public int produce() {
        return stepValue;
    }
}

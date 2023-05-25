package tr.edu.sakarya.campus.specs;

/**
 * As an achievement value : random a number between 0 and 1000 generated
 *   by using Linear Congruential Generator algorithm.
 */
public class LCGStrategy implements Strategy {

    private static final int A = 48271;
    private static final int M = 2147483647;
    private static final int Q = M / A;
    private static final int R = M % A;

    private static int seed = (int) System.currentTimeMillis();

    @Override
    public int achievement() {
        int hi = seed / Q;
        int lo = seed % Q;
        int test = A * lo - R * hi;
        if (test > 0) {
            seed = test;
        } else {
            seed = test + M;
        }
        return seed % 1001;

    }
}



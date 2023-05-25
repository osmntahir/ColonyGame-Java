package tr.edu.sakarya.campus.specs;

import java.security.SecureRandom;

/**
 * As an achievement value : random a number between 0 and 1000 generated
 *   by using Fortuna algorithm.
 */
public class FortunaStrategy implements Strategy {

    private final SecureRandom secureRandom;

    public FortunaStrategy() {
        secureRandom = new SecureRandom();
        secureRandom.setSeed(System.nanoTime());
    }

    private static int convertBytesToInt(byte[] bytes) {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            value = (value << 8) + (bytes[i] & 0xff);
        }
        return value;
    }

    @Override
    public int achievement() {
        byte[] randomBytes = new byte[4];
        secureRandom.nextBytes(randomBytes);

        int randomNumber = Math.abs(convertBytesToInt(randomBytes));
        return randomNumber % 1001;
    }
}


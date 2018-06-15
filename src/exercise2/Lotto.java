package exercise2;
// A package to generate random numbers
import java.security.SecureRandom;

public class Lotto {
    // The 3 values for the game
    private int[] lottoValues = new int[3];
    // The random number generator
    private SecureRandom rand = new SecureRandom();
    // Class Constructor
    public Lotto(){
        for (int i = 0; i < lottoValues.length; i++) {
            lottoValues[i] = 1 + rand.nextInt(9);
            // Set the values of each to a random number between 1 and 9
        } // End of For loop
    }
    // Return the lottoValues array
    public int[] getLottoValues() {
        return lottoValues;
    }
} // End of Lotto class

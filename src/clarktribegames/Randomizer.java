package clarktribegames;

// <editor-fold defaultstate="collapsed" desc="credits">

import java.util.Random;

/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

public class Randomizer {

    public static void getRandom(int max) {
        Random rand = new Random();
        int ex1 = rand.nextInt(max);
        double ex2 = rand.nextDouble();
        float ex3 = rand.nextFloat();
        long ex4 = rand.nextLong();
        
        System.out.println(ex1 + "\n" + ex2 + "\n" + ex3);
    }
    
}
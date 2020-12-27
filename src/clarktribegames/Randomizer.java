package clarktribegames;

// <editor-fold defaultstate="collapsed" desc="credits">

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    }
    
    public static List<Integer> randomInt(int intMax) {
        List<Integer> selectedInt = new ArrayList<>();
        List<Integer> intKeys = new ArrayList<>();
        for(int i=0 ; i < intMax; i++) {
            selectedInt.add(randomInteger(intMax,intKeys));
        }
        return selectedInt;
    }
    
    private static int randomInteger(int max, List<Integer> keylist) {
        int n = (int) (Math.random() * max);
        if(!keylist.contains(n)) {
                    keylist.add(n);
                    return n;
                } else {
                    return randomInteger(max, keylist);
                }
    }
    
}
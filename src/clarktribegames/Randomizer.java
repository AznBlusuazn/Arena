package clarktribegames;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

// <editor-fold defaultstate="collapsed" desc="credits">
/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

public class Randomizer {
    
    static HashSet<Integer> usedGenericNumbers;

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
    
    public static int[] randGenNums(int numberneeded) {
        int[] randintArray = new int[numberneeded];
        int maxValue=Calculator.getGenRange(GetData.buildingToons);
        //usedGenericNumbers=new HashSet<>();
        for (int i=0; i<numberneeded; i++) {
            int add=(int)(Math.random()*maxValue);
            while (usedGenericNumbers.contains(add)) {
                add = (int)(Math.random()*maxValue);
            }
        usedGenericNumbers.add(add);
        randintArray[i]=add;
        }
        return randintArray;
    }
    
}
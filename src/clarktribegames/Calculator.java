package clarktribegames;

// <editor-fold defaultstate="collapsed" desc="credits">
/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

public class Calculator {
    
    public String getValue(String type,String number) {
        
        switch(type) {
            case "nxtlv":
                return String.valueOf(nextlevel(Double.valueOf(number)));
                // next level value
                
            case "curlv":
                // current level value
                return String.valueOf(curlevel(number));
                
            default:
                //
                return "";
        }
            
    }
    
    private static String theformula(double number) {
        return (String.valueOf((long) (250 * (Math.pow(number,1.806392)) - (250 * number))));
    }
    
    private double curlevel (String exp) {
        long xp = Long.parseLong(exp);
        for (int i = 1; i > 0 ; i++ ) {
            if((long) (Long.parseLong(theformula(i))) > xp) {
                return i - 1;
            }
        }
        return 0;
    }
    
    private double nextlevel(double level) {
        return Long.parseLong(theformula(level));
    }
    
}

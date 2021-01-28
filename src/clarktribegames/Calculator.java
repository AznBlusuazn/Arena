package clarktribegames;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    
    public static String getLevel(String type,String number) {
        
        switch(type) {
            case "stalv":
                return String.valueOf(startxpLevel(Double.valueOf(number)));
                // next level value
                
            case "curlv":
                // current level value
                return String.valueOf(curlevel(number));
            
            case "ranxp":    
                return String.valueOf(randxpStart(Long.parseLong(number)));
                
            default:
                //
                return "";
        }
        
    }
    
    private static String lvformula(double number) {
        return (String.valueOf((long) (250 * (Math.pow(number,1.806392)) - (250 
            * number))));
    }
    
    private static long curlevel (String exp) {
        long xp = Long.parseLong(exp);
        for (int i = 1; i > 0 ; i++ ) {
            if((long) (Long.parseLong(lvformula(i))) > xp) {
                return i - 1;
            }
        }
        return 0;
    }
    
    private static long startxpLevel(double level) {
        return Long.parseLong(lvformula(level));
    }
    
    private static long randxpStart(long level) {
        long max = Long.parseLong(lvformula(level +1));
        long min = Long.parseLong(lvformula(level));
        return (long) ( (long) min + Math.random() * ((long)max - min + 1));
    }
    
    public static String getAge(int age, String race) throws SQLException {
        return analyzeAgemath(age,getMaxAge(race));
    }
    
    private static int getMaxAge(String race) throws SQLException {
        String save = savenameCheck();
        return Integer.parseInt(Converters.fetchfromTable(MemoryBank.dbRace,race,0,5));
//                
//                GetData.dataQuery("*","dbRace","raceID",race,
//            false,false,null,null).get(5));
    }
    
    public static double getageAdjuster(double ratio) {
        double ageadjustVal = 1;
        if(ratio < .02) {
            ageadjustVal = .005;
        }
        if(ratio >= .02 && ratio < .12) {
            ageadjustVal = .5;
        }
        if(ratio >= .12 && ratio < .20) {
            ageadjustVal = 1;
        }
        if(ratio >= .20 && ratio < .30) {
            ageadjustVal = 1.25;
        }
        if(ratio >= .30 && ratio < .50) {
            ageadjustVal = 2.25;
        }
        if(ratio >= .50 && ratio < .80) {
            ageadjustVal = .75;
        }
        if(ratio >= .80 && ratio < .85) {
            ageadjustVal = .50;
        }
        if(ratio >= .85) {
            ageadjustVal = .05;
        }
        return ageadjustVal;
    }
    
    private static String analyzeAgemath(int age, int max) throws SQLException {
        String save = savenameCheck();
        
        List<String> agelist = new ArrayList<>();
        for(int i=0;i<MemoryBank.dbAge.size();i++) {
            agelist.add(Converters.expListtoArray(MemoryBank.dbAge.get(i))[2]);
        }
//                GetData.dataQuery( "*","dbAge","ageCriteria",
//            null, true,false,null,null);
        List<Integer> results = new ArrayList();

        for (int i = 0; i < agelist.size(); i++) {
            String z = "";
            if(agelist.get(i).contains("or")) {
                z = "or";
            }
            if(agelist.get(i).contains("and")) {
                z = "and";
            }
            String master = agelist.get(i);
            String s1 = master.substring(0,master.indexOf(" "));
            String s2 = (master.substring(master.indexOf((" "),master.indexOf(""
                + " ") +1),master.length())).replace(" ","");
            String m1 = s1.replaceAll("[\\d.]", "");
            String x1 = "";
            if(m1.contains("%")) {
                m1 = m1.replaceAll("%", ""); // < = >
                x1 = "%"; // % or none
            }
            String m2 = s2.replaceAll("[\\d.]", "");
            String x2 = "";
            if(m2.contains("%")) {
                m2 = m2.replaceAll("%", "");
                x2 = "%";
            }
            int n1 = Integer.parseInt((s1.replaceAll("[^0-9]", " ")).replaceAll(
                " ", "")); // number1
            int n2 = Integer.parseInt((s2.replaceAll("[^0-9]", " ")).replaceAll(
                " ", "")); // number2
            boolean addit = false;
            
            if(m1.equals("<") && m2.equals("<") && z.equals("or")) {
                if(x1.equals("%") && x2.equals("")) {
                    if((age < (n1 * .01 * max)) || (age < n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age < n1) || ((age < n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age < n1 * .01 * max) || (age < n2 * .01)) {
                                addit = true;
                            }
                    } else {
                            if((age < n1) || (age < n2)) {
                                addit = true;
                            }
                        }
                    }
                }
            }
            if(m1.equals("<") && m2.equals("<") && z.equals("and")) {
                if(x1.equals("%") && x2.equals("")) {
                    if((age < (n1 * .01 * max)) && (age < n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age < n1) && ((age < n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age < n1 * .01 * max) && (age < n2 * .01 * max)) {
                                addit = true;
                            }
                    } else {
                            if((age < n1) && (age < n2)) {
                                addit = true;
                            }
                        }
                    }
                }
            }
            if(m1.equals("<") && m2.equals(">") && z.equals("or")) {
                 if(x1.equals("%") && x2.equals("")) {
                    if((age < (n1 * .01 * max)) || (age > n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age < n1) || ((age > n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age < n1 * .01 * max) || (age > n2 * .01 * max))
                            {
                                addit = true;
                            }
                    } else {
                            if((age < n1) || (age > n2)) {
                                addit = true;
                            }
                        }
                    }
                }               
            }            
            if(m1.equals("<") && m2.equals(">") && z.equals("and")) {
                 if(x1.equals("%") && x2.equals("")) {
                    if((age < (n1 * .01 * max)) && (age > n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age < n1) && ((age > n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age < n1 * .01 * max) && (age > n2 * .01 * max))
                            {
                                addit = true;
                            }
                    } else {
                            if((age < n1) && (age > n2)) {
                                addit = true;
                            }
                        }
                    }
                }               
            }
            if(m1.equals("<") && m2.equals("=") && z.equals("or")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age < (n1 * .01 * max)) || (age == n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age < n1) || ((age == n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age < n1 * .01 * max) || (age == n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age < n1) || (age == n2)) {
                                addit = true;
                            }
                        }
                    }
                }                     
            }
            if(m1.equals("<") && m2.equals("=") && z.equals("and")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age < (n1 * .01 * max)) && (age == n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age < n1) && ((age == n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age < n1 * .01 * max) && (age == n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age < n1) && (age == n2)) {
                                addit = true;
                            }
                        }
                    }
                }                    
            }
            if(m1.equals("<") && m2.equals("<=") && z.equals("or")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age < (n1 * .01 * max)) || (age <= n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age < n1) || ((age <= n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age < n1 * .01 * max) || (age <= n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age < n1) || (age <= n2)) {
                                addit = true;
                            }
                        }
                    }
                }                      
            }
            if(m1.equals("<") && m2.equals("<=") && z.equals("and")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age < (n1 * .01 * max)) && (age <= n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age < n1) && ((age <= n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age < n1 * .01 * max) && (age <= n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age < n1) && (age <= n2)) {
                                addit = true;
                            }
                        }
                    }
                }                    
            }
            if(m1.equals("<") && m2.equals(">=") && z.equals("or")) {
                   if(x1.equals("%") && x2.equals("")) {
                    if((age < (n1 * .01 * max)) || (age >= n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age < n1) || ((age >= n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age < n1 * .01 * max) || (age >= n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age < n1) || (age >= n2)) {
                                addit = true;
                            }
                        }
                    }
                }                   
            }
            if(m1.equals("<") && m2.equals(">=") && z.equals("and")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age < (n1 * .01 * max)) && (age >= n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age < n1) && ((age >= n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age < n1 * .01 * max) && (age >= n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age < n1) && (age >= n2)) {
                                addit = true;
                            }
                        }
                    }
                }                    
            }

            if(m1.equals(">") && m2.equals("<") && z.equals("or")) {
                if(x1.equals("%") && x2.equals("")) {
                    if((age > (n1 * .01 * max)) || (age < n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age > n1) || ((age < n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age > n1 * .01 * max) || (age < n2 * .01)) {
                                addit = true;
                            }
                    } else {
                            if((age > n1) || (age < n2)) {
                                addit = true;
                            }
                        }
                    }
                }
            }
            if(m1.equals(">") && m2.equals("<") && z.equals("and")) {
                if(x1.equals("%") && x2.equals("")) {
                    if((age > (n1 * .01 * max)) && (age < n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age >n1) && ((age < n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age > n1 * .01 * max) && (age < n2 * .01 * max))
                            {
                                addit = true;
                            }
                    } else {
                            if((age > n1) && (age < n2)) {
                                addit = true;
                            }
                        }
                    }
                }
            }
            if(m1.equals(">") && m2.equals(">") && z.equals("or")) {
                 if(x1.equals("%") && x2.equals("")) {
                    if((age > (n1 * .01 * max)) || (age > n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age > n1) || ((age > n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age > n1 * .01 * max) || (age > n2 * .01 * max))
                            {
                                addit = true;
                            }
                    } else {
                            if((age > n1) || (age > n2)) {
                                addit = true;
                            }
                        }
                    }
                }               
            }            
            if(m1.equals(">") && m2.equals(">") && z.equals("and")) {
                 if(x1.equals("%") && x2.equals("")) {
                    if((age > (n1 * .01 * max)) && (age > n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age > n1) && ((age > n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age > n1 * .01 * max) && (age > n2 * .01 * max))
                            {
                                addit = true;
                            }
                    } else {
                            if((age > n1) && (age > n2)) {
                                addit = true;
                            }
                        }
                    }
                }               
            }
            if(m1.equals(">") && m2.equals("=") && z.equals("or")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age > (n1 * .01 * max)) || (age == n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age > n1) || ((age == n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age > n1 * .01 * max) || (age == n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age > n1) || (age == n2)) {
                                addit = true;
                            }
                        }
                    }
                }                     
            }
            if(m1.equals(">") && m2.equals("=") && z.equals("and")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age > (n1 * .01 * max)) && (age == n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age > n1) && ((age == n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age > n1 * .01 * max) && (age == n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age > n1) && (age == n2)) {
                                addit = true;
                            }
                        }
                    }
                }                    
            }
            if(m1.equals(">") && m2.equals("<=") && z.equals("or")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age > (n1 * .01 * max)) || (age <= n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age > n1) || ((age <= n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age > n1 * .01 * max) || (age <= n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age > n1) || (age <= n2)) {
                                addit = true;
                            }
                        }
                    }
                }                      
            }
            if(m1.equals(">") && m2.equals("<=") && z.equals("and")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age > (n1 * .01 * max)) && (age <= n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age > n1) && ((age <= n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age > n1 * .01 * max) && (age <= n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age > n1) && (age <= n2)) {
                                addit = true;
                            }
                        }
                    }
                }                    
            }
            if(m1.equals(">") && m2.equals(">=") && z.equals("or")) {
                   if(x1.equals("%") && x2.equals("")) {
                    if((age > (n1 * .01 * max)) || (age >= n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age > n1) || ((age >= n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age > n1 * .01 * max) || (age >= n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age > n1) || (age >= n2)) {
                                addit = true;
                            }
                        }
                    }
                }                   
            }
            if(m1.equals(">") && m2.equals(">=") && z.equals("and")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age > (n1 * .01 * max)) && (age >= n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age > n1) && ((age >= n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age > n1 * .01 * max) && (age >= n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age > n1) && (age >= n2)) {
                                addit = true;
                            }
                        }
                    }
                }                    
            }

            if(m1.equals("=") && m2.equals("<") && z.equals("or")) {
                if(x1.equals("%") && x2.equals("")) {
                    if((age == (n1 * .01 * max)) || (age < n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age == n1) || ((age < n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age == n1 * .01 * max) || (age < n2 * .01)) {
                                addit = true;
                            }
                    } else {
                            if((age == n1) || (age < n2)) {
                                addit = true;
                            }
                        }
                    }
                }
            }
            if(m1.equals("=") && m2.equals("<") && z.equals("and")) {
                if(x1.equals("%") && x2.equals("")) {
                    if((age == (n1 * .01 * max)) && (age < n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age == n1) && ((age < n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age == n1 * .01 * max) && (age < n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age == n1) && (age < n2)) {
                                addit = true;
                            }
                        }
                    }
                }
            }
            if(m1.equals("=") && m2.equals(">") && z.equals("or")) {
                 if(x1.equals("%") && x2.equals("")) {
                    if((age == (n1 * .01 * max)) || (age > n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age == n1) || ((age > n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age == n1 * .01 * max) || (age > n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age == n1) || (age > n2)) {
                                addit = true;
                            }
                        }
                    }
                }               
            }            
            if(m1.equals("=") && m2.equals(">") && z.equals("and")) {
                 if(x1.equals("%") && x2.equals("")) {
                    if((age == (n1 * .01 * max)) && (age > n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age == n1) && ((age > n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age == n1 * .01 * max) && (age > n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age == n1) && (age > n2)) {
                                addit = true;
                            }
                        }
                    }
                }               
            }
            if(m1.equals("=") && m2.equals("=") && z.equals("or")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age == (n1 * .01 * max)) || (age == n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age == n1) || ((age == n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age == n1 * .01 * max) || (age == n2 * .01 * max
                                )) {
                                addit = true;
                            }
                    } else {
                            if((age == n1) || (age == n2)) {
                                addit = true;
                            }
                        }
                    }
                }                     
            }
            if(m1.equals("=") && m2.equals("=") && z.equals("and")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age == (n1 * .01 * max)) && (age == n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age == n1) && ((age == n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age ==n1 * .01 * max) && (age == n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age == n1) && (age == n2)) {
                                addit = true;
                            }
                        }
                    }
                }                    
            }
            if(m1.equals("=") && m2.equals("<=") && z.equals("or")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age == (n1 * .01 * max)) || (age <= n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age == n1) || ((age <= n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age == n1 * .01 * max) || (age <= n2 * .01 * max
                                )) {
                                addit = true;
                            }
                    } else {
                            if((age == n1) || (age <= n2)) {
                                addit = true;
                            }
                        }
                    }
                }                      
            }
            if(m1.equals("=") && m2.equals("<=") && z.equals("and")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age ==(n1 * .01 * max)) && (age <= n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age == n1) && ((age <= n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age == n1 * .01 * max) && (age <= n2 * .01 * max
                                )) {
                                addit = true;
                            }
                    } else {
                            if((age == n1) && (age <= n2)) {
                                addit = true;
                            }
                        }
                    }
                }                    
            }
            if(m1.equals("=") && m2.equals(">=") && z.equals("or")) {
                   if(x1.equals("%") && x2.equals("")) {
                    if((age == (n1 * .01 * max)) || (age >= n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age == n1) || ((age >= n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age == n1 * .01 * max) || (age >= n2 * .01 * max
                                )) {
                                addit = true;
                            }
                    } else {
                            if((age == n1) || (age >= n2)) {
                                addit = true;
                            }
                        }
                    }
                }                   
            }
            if(m1.equals("=") && m2.equals(">=") && z.equals("and")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age == (n1 * .01 * max)) && (age >= n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age == n1) && ((age >= n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age == n1 * .01 * max) && (age >= n2 * .01 * max
                                )) {
                                addit = true;
                            }
                    } else {
                            if((age == n1) && (age >= n2)) {
                                addit = true;
                            }
                        }
                    }
                }                    
            }

            if(m1.equals("<=") && m2.equals("<") && z.equals("or")) {
                if(x1.equals("%") && x2.equals("")) {
                    if((age <= (n1 * .01 * max)) || (age < n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age <= n1) || ((age < n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age <= n1 * .01 * max) || (age < n2 * .01)) {
                                addit = true;
                            }
                    } else {
                            if((age <= n1) || (age < n2)) {
                                addit = true;
                            }
                        }
                    }
                }
            }
            if(m1.equals("<=") && m2.equals("<") && z.equals("and")) {
                if(x1.equals("%") && x2.equals("")) {
                    if((age <= (n1 * .01 * max)) && (age < n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age <= n1) && ((age < n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age <= n1 * .01 * max) && (age < n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age <= n1) && (age < n2)) {
                                addit = true;
                            }
                        }
                    }
                }
            }
            if(m1.equals("<=") && m2.equals(">") && z.equals("or")) {
                 if(x1.equals("%") && x2.equals("")) {
                    if((age <= (n1 * .01 * max)) || (age > n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age <= n1) || ((age > n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age <= n1 * .01 * max) || (age > n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age <= n1) || (age > n2)) {
                                addit = true;
                            }
                        }
                    }
                }               
            }            
            if(m1.equals("<=") && m2.equals(">") && z.equals("and")) {
                 if(x1.equals("%") && x2.equals("")) {
                    if((age <= (n1 * .01 * max)) && (age > n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age <= n1) && ((age > n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age <= n1 * .01 * max) && (age > n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age <= n1) && (age > n2)) {
                                addit = true;
                            }
                        }
                    }
                }               
            }
            if(m1.equals("<=") && m2.equals("=") && z.equals("or")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age <= (n1 * .01 * max)) || (age == n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age <= n1) || ((age == n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age <= n1 * .01 * max) || (age == n2 * .01 * max
                                )) {
                                addit = true;
                            }
                    } else {
                            if((age <= n1) || (age == n2)) {
                                addit = true;
                            }
                        }
                    }
                }                     
            }
            if(m1.equals("<=") && m2.equals("=") && z.equals("and")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age <= (n1 * .01 * max)) && (age == n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age <= n1) && ((age == n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age <= n1 * .01 * max) && (age == n2 * .01 * max
                                )) {
                                addit = true;
                            }
                    } else {
                            if((age <= n1) && (age == n2)) {
                                addit = true;
                            }
                        }
                    }
                }                    
            }
            if(m1.equals("<=") && m2.equals("<=") && z.equals("or")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age <= (n1 * .01 * max)) || (age <= n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age <= n1) || ((age <= n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age <= n1 * .01 * max) || (age <= n2 * .01 * max
                                )) {
                                addit = true;
                            }
                    } else {
                            if((age <= n1) || (age <= n2)) {
                                addit = true;
                            }
                        }
                    }
                }                      
            }
            if(m1.equals("<=") && m2.equals("<=") && z.equals("and")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age <= (n1 * .01 * max)) && (age <= n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age <= n1) && ((age <= n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age <= n1 * .01 * max) && (age <= n2 * .01 * max
                                )) {
                                addit = true;
                            }
                    } else {
                            if((age <= n1) && (age <= n2)) {
                                addit = true;
                            }
                        }
                    }
                }                    
            }
            if(m1.equals("<=") && m2.equals(">=") && z.equals("or")) {
                   if(x1.equals("%") && x2.equals("")) {
                    if((age <= (n1 * .01 * max)) || (age >= n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age <= n1) || ((age >= n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age <= n1 * .01 * max) || (age >= n2 * .01 * max
                                )) {
                                addit = true;
                            }
                    } else {
                            if((age <= n1) || (age >= n2)) {
                                addit = true;
                            }
                        }
                    }
                }                   
            }
            if(m1.equals("<=") && m2.equals(">=") && z.equals("and")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age <= (n1 * .01 * max)) && (age >= n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age <= n1) && ((age >= n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age <= n1 * .01 * max) && (age >= n2 * .01 * max
                                )) {
                                addit = true;
                            }
                    } else {
                            if((age <= n1) && (age >= n2)) {
                                addit = true;
                            }
                        }
                    }
                }                    
            }

            if(m1.equals(">=") && m2.equals("<") && z.equals("or")) {
                if(x1.equals("%") && x2.equals("")) {
                    if((age >= (n1 * .01 * max)) || (age < n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age >= n1) || ((age < n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age >= n1 * .01 * max) || (age < n2 * .01)) {
                                addit = true;
                            }
                    } else {
                            if((age >= n1) || (age < n2)) {
                                addit = true;
                            }
                        }
                    }
                }
            }
            if(m1.equals(">=") && m2.equals("<") && z.equals("and")) {
                if(x1.equals("%") && x2.equals("")) {
                    if((age >= (n1 * .01 * max)) && (age < n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age >= n1) && ((age < n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age >= n1 * .01 * max) && (age < n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age >= n1) && (age < n2)) {
                                addit = true;
                            }
                        }
                    }
                }
            }
            if(m1.equals(">=") && m2.equals(">") && z.equals("or")) {
                 if(x1.equals("%") && x2.equals("")) {
                    if((age >= (n1 * .01 * max)) || (age > n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age >= n1) || ((age > n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age >= n1 * .01 * max) || (age > n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age >= n1) || (age > n2)) {
                                addit = true;
                            }
                        }
                    }
                }               
            }            
            if(m1.equals(">=") && m2.equals(">") && z.equals("and")) {
                 if(x1.equals("%") && x2.equals("")) {
                    if((age >= (n1 * .01 * max)) && (age > n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age >= n1) && ((age > n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age >= n1 * .01 * max) && (age > n2 * .01 * max)
                                ) {
                                addit = true;
                            }
                    } else {
                            if((age >= n1) && (age > n2)) {
                                addit = true;
                            }
                        }
                    }
                }               
            }
            if(m1.equals(">=") && m2.equals("=") && z.equals("or")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age >= (n1 * .01 * max)) || (age == n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age >= n1) || ((age == n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age >= n1 * .01 * max) || (age == n2 * .01 * max
                                )) {
                                addit = true;
                            }
                    } else {
                            if((age >= n1) || (age == n2)) {
                                addit = true;
                            }
                        }
                    }
                }                     
            }
            if(m1.equals(">=") && m2.equals("=") && z.equals("and")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age >= (n1 * .01 * max)) && (age == n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age >= n1) && ((age == n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age >= n1 * .01 * max) && (age == n2 * .01 * max
                                )) {
                                addit = true;
                            }
                    } else {
                            if((age >= n1) && (age == n2)) {
                                addit = true;
                            }
                        }
                    }
                }                    
            }
            if(m1.equals(">=") && m2.equals("<=") && z.equals("or")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age >= (n1 * .01 * max)) || (age <= n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age >= n1) || ((age <= n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age >= n1 * .01 * max) || (age <= n2 * .01 * max
                                )) {
                                addit = true;
                            }
                    } else {
                            if((age >= n1) || (age <= n2)) {
                                addit = true;
                            }
                        }
                    }
                }                      
            }
            if(m1.equals(">=") && m2.equals("<=") && z.equals("and")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age >= (n1 * .01 * max)) && (age <= n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age >= n1) && ((age <= n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age >= n1 * .01 * max) && (age <= n2 * .01 * max
                                )) {
                                addit = true;
                            }
                    } else {
                            if((age >= n1) && (age <= n2)) {
                                addit = true;
                            }
                        }
                    }
                }                    
            }
            if(m1.equals(">=") && m2.equals(">=") && z.equals("or")) {
                   if(x1.equals("%") && x2.equals("")) {
                    if((age >= (n1 * .01 * max)) || (age >= n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age >= n1) || ((age >= n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age >= n1 * .01 * max) || (age >= n2 * .01 * max
                                )) {
                                addit = true;
                            }
                    } else {
                            if((age >= n1) || (age >= n2)) {
                                addit = true;
                            }
                        }
                    }
                }                   
            }
            if(m1.equals(">=") && m2.equals(">=") && z.equals("and")) {
                  if(x1.equals("%") && x2.equals("")) {
                    if((age >= (n1 * .01 * max)) && (age >= n2)) {
                        addit = true;
                    }
                } else {
                    if(x1.equals("") && x2.equals("%")) {
                        if((age >= n1) && ((age >= n2 * .01 * max))) {
                            addit = true;
                        }
                } else {
                        if(x1.equals("%") && x2.equals("%")) {
                            if((age >= n1 * .01 * max) && (age >= n2 * .01 * max
                                )) {
                                addit = true;
                            }
                    } else {
                            if((age >= n1) && (age >= n2)) {
                                addit = true;
                            }
                        }
                    }
                }                    
            }
            if(addit) {
               results.add(i);
            }
        }
        return Converters.fetchfromTable(MemoryBank.dbAge,results.get(0).
            toString(),0,1);
//                (GetData.dataQuery("*","dbAge","ageID",((
//            results.get(0)).toString()), false,false,null,null).get(1));
    }
    
    public static String getAlign(int alignCode) throws SQLException {
        return findAlign(alignCode);
    }
    
    private static String findAlign(int code) throws SQLException {
        //String save = savenameCheck();
        List<String> alignname = new ArrayList<>();
        List<Integer> alignval = new ArrayList<>();
        for(int i=0;i<MemoryBank.dbAlign.size();i++) {
            alignname.add(Converters.expListtoArray(MemoryBank.dbAlign.get(i))
                [0]);
            alignval.add(Integer.parseInt(Converters.expListtoArray(MemoryBank.
                dbAlign.get(i))[3]));
        }
//                GetData.dataQuery("*","dbAlign","alignID",
//            "*",true,false,null,null);
//        List<Integer> alignval = new ArrayList<>();
//        for (String s : (GetData.dataQuery("*","dbAlign","alignRank","*",true
//            ,false,null,null))) {
//            alignval.add(Integer.valueOf(s));
//        }
        if(code > alignval.get(1)) {
            return alignname.get(0);
        } else {
            if((code <= alignval.get(1)) && (code > alignval.get(2))) {
                return alignname.get(1);
            } else {
                if((code <= alignval.get(2)) && (code > alignval.get(3))) {
                    return alignname.get(2);
                } else {
                    if((code <= alignval.get(3)) && (code > alignval.get(4))) {
                        return alignname.get(3);
                    } else {
                        if((code == alignval.get(4))) {
                            return alignname.get(4);
                        } else {
                            if((code < alignval.get(4)) && (code > alignval.get
                                (5))) {
                                return alignname.get(5);
                            } else {
                                if((code <= alignval.get(5)) && (code > alignval
                                    .get(6))) {
                                    return alignname.get(6);
                                } else {
                                    if((code <= alignval.get(6)) && (code > 
                                        alignval.get(7))) {
                                        return alignname.get(7);
                                    } else {
                                        if(code <= alignval.get(7)) {
                                            return alignname.get(8);
                                        } else {
                                            return alignname.get(4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static String alignvaltoID(int alignVal) throws 
        SQLException {
        List<String> alignids = new ArrayList<>();
        for(int i=0;i<MemoryBank.dbAlign.size();i++) {
            alignids.add(Converters.expListtoArray(MemoryBank.dbAlign.get(i))[0]
                );
        }                
//                GetData.dataQuery("*","dbAlign","alignID",
//            "*",true,false,null,null);
        double alignvalue = (double) alignVal;
        if(alignvalue < 13) {
            return alignids.get(8);
        }
        if(alignvalue >= 13 && alignvalue < 25) {
            return alignids.get(7);
        }
        if(alignvalue >= 25 && alignvalue < 37) {
            return alignids.get(6);
        }
        if(alignvalue >= 37 && alignvalue < 50) {
            return alignids.get(5);
        }
        if(alignvalue == 50) {
            return alignids.get(4);
        }
        if(alignvalue > 50 && alignvalue <= 63) {
            return alignids.get(3);
        }
        if(alignvalue >= 63 && alignvalue < 75) {
            return alignids.get(2);
        }
        if(alignvalue >= 75 && alignvalue < 87) {
            return alignids.get(1);
        }
        if(alignvalue >= 87) {
            return alignids.get(0);
        }
        return alignids.get(4);
    }
    
    public static String getSize(String raceName, String ageName) throws 
        SQLException {
        return findSize (raceName, ageName);
    }
    
    private static String findSize(String race,String age) throws SQLException {
//        String save = savenameCheck();
        int racesize = Integer.parseInt(Converters.fetchfromTable(MemoryBank.
            dbRace,race,1,3));
//                GetData.dataQuery("*","dbRace","race"
//            + "Name",race,false,false,null,null).get(3));
        int ageid = Integer.parseInt(Converters.fetchfromTable(MemoryBank.dbAge,
            age,1,0));
//            GetData.dataQuery("*","dbAge","ageName",
//            age,false,false,null,null).get(0));
        String sizeid = "0";
        if(racesize > 0) {
            if(racesize == 1 && ageid <= 1) {
                sizeid = "0";
            }
            if(racesize == 1 && ageid >= 2) {
                sizeid = "1";
            }
            if(racesize == 2 && ageid <= 1) {
                sizeid = "1";
            } 
            if(racesize == 2 && ageid >= 2) {
                sizeid = "2";
            }
            if(racesize == 3 && ageid == 0) {
                sizeid = "1";
            }
            if(racesize == 3 && ageid == 1) {
                sizeid = "2";
            }
            if(racesize == 3 && ageid >= 2) {
                sizeid = "3";
            }
            if(racesize == 4 && ageid == 0) {
                sizeid = "1";
            }
            if(racesize == 4 && ageid == 1) {
                sizeid = "2";
            }
            if(racesize == 4 && ageid >= 2) {
                sizeid = "4";
            }
            if(racesize == 5 && ageid == 0) {
                sizeid = "2";
            }
            if(racesize == 5 && ageid == 1) {
                sizeid = "3";
            }
            if(racesize == 5 && ageid >= 2) {
                sizeid = "5";
            }
            if(racesize == 6 && ageid == 0) {
                sizeid = "3";
            }
            if(racesize == 6 && ageid == 1) {
                sizeid = "5";
            }
            if(racesize == 6 && ageid >= 2) {
                sizeid = "6";
            }
            if(racesize == 7 && ageid == 0) {
                sizeid = "4";
            }
            if(racesize == 7 && ageid == 1) {
                sizeid = "6";
            }
            if(racesize == 7 && ageid >= 2) {
                sizeid = "7";
            }
            if(racesize == 8 && ageid == 0) {
                sizeid = "5";
            }
            if(racesize == 8 && ageid == 1) {
                sizeid = "6";
            }
            if(racesize == 8 && ageid >= 2) {
                sizeid = "8";
            }
        }
        return Converters.fetchfromTable(MemoryBank.dbSize,sizeid,0,1);
//                GetData.dataQuery("*","dbSize","sizeID",sizeid,false,false,null,null).get(1);
    }
    
    private static String savenameCheck() {
//        if(MainControls.selectedSave.contains("." + MainControls.saveExt)) {
//            System.out.println("DOES: " + MainControls.selectedSave);
//            return Converters.capFirstLetter((MainControls.selectedSave)
//        .substring(0,(MainControls.selectedSave).indexOf("." + 
//            MainControls.saveExt)));
//        } else {
//            System.out.println("DOES NOT: " + MainControls.selectedSave);
            return MainControls.selectedSave;
//        }
    }
        
    
//<editor-fold defaultstate="collapsed" desc="Log File Method">
    private static void logFile (String type, String log) throws IOException {
        try {
            new LogWriter().writeLog(type,log);
        } catch(IOException ioex) {
            logFile("severe","logFile Method error:  Cannot fine log file (infi"
                    + "nite loop)!\nException:  " + ioex);
        }
    }
//</editor-fold>        
    
}

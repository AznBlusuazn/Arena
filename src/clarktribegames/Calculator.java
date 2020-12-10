package clarktribegames;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String save = Converters.capFirstLetter((MainControls.selectedSave)
        .substring(0,(MainControls.selectedSave).indexOf("." + 
            MainControls.saveExt)));
        List<String> racelist = GetData.dbQuery(save,"*","dbRace","raceID",race,
            false);
        return Integer.parseInt(racelist.get(27));
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
        if(ratio >= .20 && ratio < .40) {
            ageadjustVal = 1.25;
        }
        if(ratio >= .40 && ratio < .60) {
            ageadjustVal = 2.25;
        }
        if(ratio >= .60 && ratio < .80) {
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
        String save = Converters.capFirstLetter((MainControls.selectedSave)
        .substring(0,(MainControls.selectedSave).indexOf("." + 
            MainControls.saveExt)));
        List<String> agelist = GetData.dbQuery(save, "*","dbAge","ageCriteria",
            null, true);
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
                            if((age < n1 * .01 * max) || (age > n2 * .01 * max)) {
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
                            if((age < n1 * .01 * max) && (age > n2 * .01 * max)) {
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
                            if((age < n1 * .01 * max) || (age == n2 * .01 * max)) {
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
                            if((age < n1 * .01 * max) && (age == n2 * .01 * max)) {
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
                            if((age < n1 * .01 * max) || (age <= n2 * .01 * max)) {
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
                            if((age < n1 * .01 * max) && (age <= n2 * .01 * max)) {
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
                            if((age < n1 * .01 * max) || (age >= n2 * .01 * max)) {
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
                            if((age < n1 * .01 * max) && (age >= n2 * .01 * max)) {
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
                            if((age > n1 * .01 * max) && (age < n2 * .01 * max)) {
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
                            if((age > n1 * .01 * max) || (age > n2 * .01 * max)) {
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
                            if((age > n1 * .01 * max) && (age > n2 * .01 * max)) {
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
                            if((age > n1 * .01 * max) || (age == n2 * .01 * max)) {
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
                            if((age > n1 * .01 * max) && (age == n2 * .01 * max)) {
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
                            if((age > n1 * .01 * max) || (age <= n2 * .01 * max)) {
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
                            if((age > n1 * .01 * max) && (age <= n2 * .01 * max)) {
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
                            if((age > n1 * .01 * max) || (age >= n2 * .01 * max)) {
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
                            if((age > n1 * .01 * max) && (age >= n2 * .01 * max)) {
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
                            if((age == n1 * .01 * max) && (age < n2 * .01 * max)) {
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
                            if((age == n1 * .01 * max) || (age > n2 * .01 * max)) {
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
                            if((age == n1 * .01 * max) && (age > n2 * .01 * max)) {
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
                            if((age == n1 * .01 * max) || (age == n2 * .01 * max)) {
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
                            if((age ==n1 * .01 * max) && (age == n2 * .01 * max)) {
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
                            if((age == n1 * .01 * max) || (age <= n2 * .01 * max)) {
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
                            if((age == n1 * .01 * max) && (age <= n2 * .01 * max)) {
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
                            if((age == n1 * .01 * max) || (age >= n2 * .01 * max)) {
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
                            if((age == n1 * .01 * max) && (age >= n2 * .01 * max)) {
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
                            if((age <= n1 * .01 * max) && (age < n2 * .01 * max)) {
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
                            if((age <= n1 * .01 * max) || (age > n2 * .01 * max)) {
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
                            if((age <= n1 * .01 * max) && (age > n2 * .01 * max)) {
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
                            if((age <= n1 * .01 * max) || (age == n2 * .01 * max)) {
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
                            if((age <= n1 * .01 * max) && (age == n2 * .01 * max)) {
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
                            if((age <= n1 * .01 * max) || (age <= n2 * .01 * max)) {
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
                            if((age <= n1 * .01 * max) && (age <= n2 * .01 * max)) {
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
                            if((age <= n1 * .01 * max) || (age >= n2 * .01 * max)) {
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
                            if((age <= n1 * .01 * max) && (age >= n2 * .01 * max)) {
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
                            if((age >= n1 * .01 * max) && (age < n2 * .01 * max)) {
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
                            if((age >= n1 * .01 * max) || (age > n2 * .01 * max)) {
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
                            if((age >= n1 * .01 * max) && (age > n2 * .01 * max)) {
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
                            if((age >= n1 * .01 * max) || (age == n2 * .01 * max)) {
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
                            if((age >= n1 * .01 * max) && (age == n2 * .01 * max)) {
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
                            if((age >= n1 * .01 * max) || (age <= n2 * .01 * max)) {
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
                            if((age >= n1 * .01 * max) && (age <= n2 * .01 * max)) {
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
                            if((age >= n1 * .01 * max) || (age >= n2 * .01 * max)) {
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
                            if((age >= n1 * .01 * max) && (age >= n2 * .01 * max)) {
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
               results.add(i+1);
            }
        }
        List<String> finalResult = GetData.dbQuery(save, "*","dbAge","ageID",((results.get(0)).toString()), false);
        return (finalResult.get(1));
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

package clarktribegames;

// <editor-fold defaultstate="collapsed" desc="credits">

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    
    private static String lvformula(double number) {
        return (String.valueOf((long) (250 * (Math.pow(number,1.806392)) - (250 * number))));
    }
    
    private static double curlevel (String exp) {
        long xp = Long.parseLong(exp);
        for (int i = 1; i > 0 ; i++ ) {
            if((long) (Long.parseLong(lvformula(i))) > xp) {
                return i - 1;
            }
        }
        return 0;
    }
    
    private static double nextlevel(double level) {
        return Long.parseLong(lvformula(level));
    }
    
    public static String getAge(int age, String race) throws SQLException {
        return analyzeAgemath(age,getMaxAge(race));
    }
    
    private static int getMaxAge(String race) throws SQLException {
        String save = Converters.capFirstLetter((MainControls.selectedSave)
        .substring(0,(MainControls.selectedSave).indexOf("." + 
            MainControls.saveExt)));
        List<String> racelist = GetData.dbQuery(save, "*","dbRace","raceID",race, false);
        return Integer.parseInt(racelist.get(25));
    }
    
    private static String analyzeAgemath(int age, int max) throws SQLException {
        String save = Converters.capFirstLetter((MainControls.selectedSave)
        .substring(0,(MainControls.selectedSave).indexOf("." + 
            MainControls.saveExt)));
        List<String> agelist = GetData.dbQuery(save, "*","dbAge","ageCriteria",null, true);
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
            String s2 = (master.substring(master.indexOf((" "),master.indexOf(" ") +1),master.length())).replace(" ","");
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
            int n1 = Integer.parseInt((s1.replaceAll("[^0-9]", " ")).replaceAll(" ", "")); // number1
            int n2 = Integer.parseInt((s2.replaceAll("[^0-9]", " ")).replaceAll(" ", "")); // number2
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
    
    
}

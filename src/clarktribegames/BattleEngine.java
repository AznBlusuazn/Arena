package clarktribegames;

// <editor-fold defaultstate="collapsed" desc="credits">

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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

public class BattleEngine {
    
    static String[] team0;
    static String[] team1;
    static String saveName;
    static String saveToons;
    static String saveMax;
    
    public static void battleEngine(String save,String savetoons,String savemax)
        throws SQLException, IOException, InterruptedException{
        saveName = save;
        saveToons = savetoons;
        saveMax = savemax;
        battleTime(save, savetoons, savemax);
    }
    
    private static void battleTime(String save, String savetoons, String savemax
        ) throws SQLException, IOException, InterruptedException {
        int opponent = 0;
        int totalToons = GetData.dbQuery(save, "*", savetoons, "toonID", "*", 
            true).size();
        opponent = randomOpponent(Integer.parseInt(MainControls.selectedToon), 
            totalToons);
        if(String.valueOf(opponent).equals(MainControls.selectedToon)) {
            battleTime(save,savetoons,savemax);
        }
        team0 = new String[] {MainControls.selectedToon};
        team1 = new String[] {String.valueOf(opponent)};
        GetData.buildBattle(save, Converters.capFirstLetter(saveToons.substring(
            3,saveToons.length()).replace("Toons", "")));
        VersusGUI.main(null);
    }
        
    private static int randomOpponent(int toonid, int max) {
        Random rand = new Random();
        List<Integer> exclude = new ArrayList<>();
        exclude.add(toonid);
        int random = rand.nextInt(max) ;
        
        for(int i = 0; i < exclude.size(); i++) { 
            if(!exclude.contains(random)) {
                return random;
            }
            random ++;
        }
        return random;
    }
}

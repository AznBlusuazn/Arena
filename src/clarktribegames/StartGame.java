package clarktribegames;

import java.io.IOException;
import java.sql.SQLException;
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

public class StartGame {
    
    static List<String> savToons;
    static List<String> genToons;
    static List<String> altToons;
    
    
    public static void startGame(String save, String savetoons, String savemax) 
        throws SQLException, IOException, InterruptedException {
        startTime();
    }
    
    private static void startTime() 
        throws SQLException, IOException, InterruptedException{
        Popups.infoPopup("ALPHA TESTING IN PROGRESS", "This is where the game "
            + "would start, but the game is still in ALPHA.\n\nThank you for " +
            "testing!\n\nGeoff @ ClarkTribeGames");
        String tempfile = MainControls.currentgamePath.replaceAll(
            MainControls.saveExt,"temp");
        if(tempfile.length() > 0) {
            ChecksBalances.ifexistDelete(tempfile);
        }
        MainControls.clearTemp();
        System.gc();
        System.exit(0);
        //revamp Battle Engine
        //BattleEngine.battleEngine(save, savetoons, savemax);
    }
    
}

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
    
    
    public static void startGame() 
        throws SQLException, IOException, InterruptedException {
        startTime();
    }
    
    private static void startTime() 
        throws SQLException, IOException, InterruptedException{
        Popups.infoPopup("ALPHA TESTING IN PROGRESS", "This is where the game "
            + "would start, but the game is still in ALPHA.\n\nThank you for " +
            "testing!\n\nGeoff @ ClarkTribeGames");
        MemoryBank.dbTime+=(int) (Math.random() * (60*60));  //for testing time
        updateSave();
        System.gc();
        System.exit(0);
        //revamp Battle Engine
        //BattleEngine.battleEngine(save, savetoons, savemax);
    }
    
    private static void updateSave() throws SQLException {
        GetData.dataUpdateSingle("saveSettings","savesetConfig",MainControls.
            selectedToon,"savesetID","2");
        GetData.dataUpdateSingle("saveSettings","savesetConfig",String.
            valueOf(MemoryBank.dbTime),"savesetID","3");        
    }
    
}

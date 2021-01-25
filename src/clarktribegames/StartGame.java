package clarktribegames;

import java.io.IOException;
import java.sql.SQLException;

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
    
    public static void startGame(String save, String savetoons, String savemax) 
        throws SQLException, IOException, InterruptedException {
        startTime(save,savetoons,savemax);
    }
    
    private static void startTime(String save, String savetoons, String savemax) 
        throws SQLException, IOException, InterruptedException{
        String tempstartMsg = "This is normally where the game would start, but"
            + " for now, it's just battle mode.\n\n" + save + "\n" + savetoons;
        Popups.infoPopup("Starting " + Converters.capFirstLetter(savetoons.
            substring(3,savetoons.length()-5)) + " Game!",GetData.dataQuery("*",
            savetoons,"toonID",MainControls.selectedToon,false,false,null,null).
            get(1)+"\n"+"\n Week "+MainControls.gameWeek+", Month "+MainControls
            .gameMonth+", Day "+MainControls.gameDay+", Year "+MainControls.
            gameYear+"\n\n"+tempstartMsg);
        ChecksBalances.ifexistDelete(MainControls.currentgamePath.replaceAll(
            MainControls.saveExt,"temp"));

        //revamp Battle Engine
        BattleEngine.battleEngine(save, savetoons, savemax);
    }
    
}

package clarktribegames;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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
            substring(3,savetoons.length()-5)) + " Game!", GetData.dbQuery(save,
            "*",savetoons,"toonID",MainControls.selectedToon, false).get(1)+"\n"
            + "\n Week "+ MainControls.gameWeek + ", Month " + MainControls.gameMonth + ", Day " + MainControls.gameDay + ", Year "
            + MainControls.gameYear + "\n\n" + tempstartMsg);
        ChecksBalances.ifexistDelete(MainControls.currentgamePath.replaceAll(MainControls.saveExt, "temp"));
//        cleanupTempDB((MainControls.savesDir+save+"."+MainControls.saveExt)
//            .replaceAll(MainControls.saveExt + "." + MainControls.saveExt, 
//            MainControls.saveExt),savetoons);
        BattleEngine.battleEngine(save, savetoons, savemax);
    }
    
    private static void cleanupTempDB(String sp, String st) throws IOException {
        Database db = DatabaseBuilder.open(new File(sp));
        Map<String,Object> findCriteria = new HashMap<>();
        findCriteria.put("Name",st.replaceAll("Toons", "Temp"));
        findCriteria.put("Type",(short)1);
        if(db.getSystemTable("MSysObjects").getDefaultCursor().findFirstRow(
            findCriteria)){
            db.getSystemTable("MSysObjects").deleteRow(db.getSystemTable("MSysO"
            + "bjects").getDefaultCursor().getCurrentRow());
        }
        db.close();
    }
}

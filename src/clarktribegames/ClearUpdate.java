package clarktribegames;

import java.io.IOException;

// <editor-fold defaultstate="collapsed" desc="credits">

/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

public class ClearUpdate {
    
    public static void cleanUpdate() throws IOException, InterruptedException  {
        String performPopTitle="Prepare for Update?";
        String performPopMessage="Since this is an ALPHA release, you will need"
            + " to remove some of the default files,\nincluding the default "
            + "database, in order to properly update "+MainControls.appName+"."+
            "\n\nAre you sure you would like to proceed?";
        boolean performYN=Popups.yesnoPopup(performPopTitle,performPopMessage);
        if(performYN) {
            deleteforUpdate();
            String contTitle="Cleanup Complete - Update?";
            String contMessage="Cleanup is complete.  Proceed with Update?";
            boolean contYN=Popups.yesnoPopup(contTitle, contMessage);
            if(contYN) {
                Updater.updateProcess();
            }
            System.gc();
            System.exit(0);
        } else {
            String notnowTitle="";
            String notnowMessage="Okay.  When you are ready to proceed with the"
                +" older file removal, restart the game and attempt the update "
                +" again.  Thank you.";
            Popups.infoPopup(notnowTitle, notnowMessage);
        }
    }
    
    private static void deleteforUpdate() throws IOException {
        try {
            ChecksBalances.ifexistDelete(MainControls.imageDir + "_empty_.png");
            ChecksBalances.iffolderexistsDelete("sounds");
            ChecksBalances.iffolderexistsDelete("lib");
            ChecksBalances.iffolderexistsDelete(MainControls.savesDir);
        } catch (IOException | InterruptedException ex) {
            LogWriter.logFile("severe","Del4Update Error.  Exception: " + ex);
        }
    }

}
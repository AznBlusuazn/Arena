package clarktribegames;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 *
 * @author admingec
 */

public class Avatars {
       
    public static void setAvatar(JLabel box, String toon, String path) {
        String avatarPath = (avatarCheck(toon,path));
        box.setIcon(new ImageIcon(avatarPath));
        box.setText("");
    }
    
    private static String avatarCheck(String toon, String path) {
        String newPath = (MainControls.imageDir) + path;
        File customfile = new File(newPath);
        File toonfile = new File((MainControls.imageDir) + toon.toLowerCase() + 
            ".png");
        if(path.equals("") || ChecksBalances.isNullOrEmpty(path) || 
            !customfile.exists()) {
            if(toonfile.exists()) {
                newPath = (MainControls.imageDir) + toon.toLowerCase() + ".png";
            } else {
                newPath = (MainControls.imageDir + "_empty_.png");
            }
        }        
        return newPath;
    }
    
    public static List<Path> startmenuAvatars() throws IOException {
        try {
            List<Path> avatarList=Converters.foldertoList(MainControls.imageDir,
                "png");
            List<Path> pickedAvatars = new ArrayList<>();
            int avatardirSize = avatarList.size() -1;
            int avatarsNeeded;
            if(avatardirSize > 0) {
                if(avatardirSize < 6) {
                    avatarsNeeded = avatardirSize;
                } else {
                    avatarsNeeded = 6;
                }
                if(avatardirSize < avatarsNeeded ) {
                    throw new IllegalArgumentException("Can't ask for more "
                        + "numbers than are available");
                }
                List<Integer> generatedList = new ArrayList<>();
                for(int i = 0; i < avatarsNeeded; i++) {
                     generatedList = Randomizer.randomInt(avatarsNeeded);
                }
                for(int x = 0; x < generatedList.size(); x++) {
                    pickedAvatars.add(avatarList.get(generatedList.get(x)));
                }
                return pickedAvatars;
            } else {
                return null;
            }
        } catch (IOException ex) {
            LogWriter.logFile("severe", "Start Get Avatars Error.  Ex: " + ex);
        }
        return null;
    }
}
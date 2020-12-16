package clarktribegames;

import java.io.File;
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
        File toonfile = new File((MainControls.imageDir) + toon.toLowerCase() + ".png");
        if(path.equals("") || ChecksBalances.isNullOrEmpty(path) || !customfile.exists()) {
            if(toonfile.exists()) {
                newPath = (MainControls.imageDir) + toon.toLowerCase() + ".png";
            } else {
                newPath = (MainControls.imageDir + "_empty_.png");
            }
        }        
        return newPath;
    }
    
}
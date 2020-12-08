package clarktribegames;

import javax.swing.JLabel;

// <editor-fold defaultstate="collapsed" desc="credits">
/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

class ToonImage {
    void setImage(JLabel box, String path) {
        String newpath = ("/" + MainControls.imageDir + path);
        box.setIcon(new javax.swing.ImageIcon(getClass().getResource(newpath)));
        box.setText("");
    }
    
}

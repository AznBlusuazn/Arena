package com.clarktribe.arena;

import javax.swing.JLabel;

// <editor-fold defaultstate="collapsed" desc="credits">
/**
 * 
 * @author  Geoff Clark
 * @e-mail  gclark82@gmail.com
 * @game    Arena Game
 * 
 */
// </editor-fold>

class ToonImage {
    void setImage(JLabel box, String path) {
        String newpath = ("/avatars/" + path);
        box.setIcon(new javax.swing.ImageIcon(getClass().getResource(newpath)));
        box.setText("");
    }
    
}

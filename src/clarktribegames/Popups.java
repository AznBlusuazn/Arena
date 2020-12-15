package clarktribegames;

import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

// <editor-fold defaultstate="collapsed" desc="credits">
/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

public class Popups {
    
    public static int optPopup(String[] options, String title, String message) {
        int optResponse = JOptionPane.showOptionDialog(null, message, title, 
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options,
            options[0]);
        return optResponse;
    }
    
    public static void checkboxPopup(String title, String msg, Object[] popup) {
        JOptionPane.showMessageDialog(null, popup, title,JOptionPane
            .PLAIN_MESSAGE);
    }
    
    public static String comboboxPopup(String ttl,String msg,JComboBox box){
        Object[] opts = {msg, box, "\n"};
        JOptionPane.showMessageDialog(null,opts,ttl,JOptionPane.PLAIN_MESSAGE);
        return box.getSelectedItem().toString();
    }
    
    public static boolean yesnoPopup(String title, String message) {
        boolean yesnoAnswer = true;
        int answer = JOptionPane.showConfirmDialog(null,message,title,
            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(answer == JOptionPane.NO_OPTION) {
            yesnoAnswer = false;
            }
        return yesnoAnswer;
    }
    
    public static void plainPopup(String title, String msg) {
        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.PLAIN_MESSAGE);
    }
    
    public static void errorPopup(String title, String msg) {
        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.ERROR_MESSAGE);
    }
        
    public static void warnPopup(String ttl, String msg) {
        JOptionPane.showMessageDialog(null,msg,ttl,JOptionPane.WARNING_MESSAGE);
    }
    
    public static void infoPopup(String t, String m) {
        JOptionPane.showMessageDialog(null,m,t,JOptionPane.INFORMATION_MESSAGE);
    }

    public static void inputPopup(String t, String m) {
        JOptionPane.showInputDialog(null,m,t,JOptionPane.PLAIN_MESSAGE);
    }    
    
//<editor-fold defaultstate="collapsed" desc="Log File Method">
    private static void logFile (String type, String loginfo) throws IOException {
        try {
            new LogWriter().writeLog(type,loginfo);
        } catch(IOException ioex) {
            logFile("severe","logFile Method error:  Cannot fine log file (infi"
                    + "nite loop)!\nException:  " + ioex);
        }
    }
    //</editor-fold>
}

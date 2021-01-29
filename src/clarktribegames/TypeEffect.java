package clarktribegames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;

// <editor-fold defaultstate="collapsed" desc="credits">
/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Limitless
 * 
 */
// </editor-fold>

public class TypeEffect {
    
    private final Timer timer;
    private int index = 0;
    private volatile String in;
    private final JTextArea out;
    
        public TypeEffect(JTextArea out, String in, int rate, boolean battle, 
            JTextField input, JButton confirm) {
            if(battle) {
                input.setEnabled(false);
                confirm.setEnabled(false);
            }
            this.out = out;
            this.in = in;
            timer = new Timer(rate, new ActionListener() {
                @Override
                public synchronized void actionPerformed(ActionEvent e) {
                    if (index < in.length()) {
                        out.append(Character.toString(in.charAt(index)));
                        index++;
                    } else {
                        if(battle) {
                            input.setEnabled(true);
                            confirm.setEnabled(true);
                            if(!BattleEngine.battleDone) {
                                try {
                                    Thread.sleep(250);
                                    BattleGUI.pressConfirm();
                                } catch (InterruptedException | 
                                    BadLocationException | SQLException ex) {
                                    //
                                } catch (Exception ex) {
                                    //
                                }
                            }
                        }
                        stop();
                    }
                }
            });
        }

    public void start() {
        //out.setText(null);
        index = 0;
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
}
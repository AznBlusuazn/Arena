package clarktribegames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.Timer;

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
    private final String in;
    private final JTextArea out;
    private int rate;
    
        public TypeEffect(JTextArea out, String in) {
            this.rate = 25;
            this.out = out;
            this.in = in;
            timer = new Timer(rate, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (index < in.length()) {
                        out.append(Character.toString(in.charAt(index)));
                        index++;
                    } else {
                        stop();
                    }
                }
            });
        }

    public void start() {
        out.setText(null);
        index = 0;
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
}
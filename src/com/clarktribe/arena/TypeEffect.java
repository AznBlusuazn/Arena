package com.clarktribe.arena;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 *
 * @author  Geoff Clark
 * @e-mail  gclark82@gmail.com
 * @game    Arena Game
 * 
 */

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
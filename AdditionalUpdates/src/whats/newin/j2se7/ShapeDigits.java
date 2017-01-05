package whats.newin.j2se7;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.io.Serializable;
import java.util.HashMap;

public class ShapeDigits extends Applet {
    ThaiDigitsPanel panel;

    public ShapeDigits() {
        panel = new ThaiDigitsPanel();
    }

    static class ThaiDigitsPanel extends Panel {
    	private static final String digits = "Latin Digits: 0 1 2 3 4 5 6 7 8 9";
    	private TextLayout  layout;
 
         ThaiDigitsPanel() {
        	HashMap<TextAttribute, Serializable> map = new HashMap<TextAttribute, Serializable>();
        	Font font   = new Font("Lucida Sans", Font.PLAIN, 30);
		    FontRenderContext frc = new FontRenderContext(null, false, false);
		    map.put(TextAttribute.FONT, font);
		    
		    NumericShaper shaper = NumericShaper.getShaper(NumericShaper.Range.THAI);
		    map.put(TextAttribute.NUMERIC_SHAPING, shaper);
		    
		    layout = new TextLayout(digits, map, frc);
        }

        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D)g;

            layout.draw(g2d, 10, 50);
        }
    }
    public void init() {
        setLayout(new BorderLayout());
        add(panel, "Center");
    }

    public void destroy() {
        remove(panel);
    }

    public static void main(String args[]) {
        ShapeDigits thaiDigits = new ShapeDigits();
        thaiDigits.init();
        thaiDigits.start();

        Frame f = new Frame("ThaiDigits");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.add("Center", thaiDigits);
        f.setSize(400, 800);
        f.setVisible(true);
    }

    public String getAppletInfo() {
        return "Thai Digits Example";
    }
}
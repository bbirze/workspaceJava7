package whats.newin.j2se7;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.text.*;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Set;

public class DigitShaper  extends Applet {
	    ShaperPanel panel;

	    public DigitShaper() {
	        panel = new ShaperPanel();
	    }

	    static class ShaperPanel extends Panel {

	        private static final String text =
	           "-123 (Latin) 456.00 (Arabic) \u0641\u0642\u0643 789 (Thai) \u0e01\u0e33 01.23";

	        ShaperPanel() {
	            HashMap map = new HashMap();
	            Font textfont = new Font("Monospaced", Font.BOLD, 16);
	            Font font = new Font("Lucida Sans", Font.PLAIN, 15);
	            setFont(textfont);
	            map.put(TextAttribute.FONT, font);	

	            FontRenderContext frctx = new FontRenderContext(null, false, false);
	            layouts = new TextLayout[5][2];
	            
	            // no NumericShaper used
	            //
	            layouts[0][0] = new TextLayout(text, map, frctx);
	            AttributedCharacterIterator iter = new AttributedString(text, map).getIterator();
	            layouts[0][1] = new LineBreakMeasurer(iter, frctx).nextLayout(Float.MAX_VALUE);

	            // Single Range NumericShaper
	            //
	            NumericShaper shaper = NumericShaper.getShaper(NumericShaper.Range.ARABIC);
	            
	            map.put(TextAttribute.NUMERIC_SHAPING, shaper);
	            layouts[1][0] = new TextLayout(text, map, frctx);
	            iter = new AttributedString(text, map).getIterator();
	            layouts[1][1] = new LineBreakMeasurer(iter, frctx).nextLayout(Float.MAX_VALUE);

	            // Contextual Arabic NumericShaper, no context
	            //
	            Set<NumericShaper.Range> rangeSet = EnumSet.of(NumericShaper.Range.ARABIC);
	            shaper = NumericShaper.getContextualShaper(rangeSet);

	            map.put(TextAttribute.NUMERIC_SHAPING, shaper);
	            layouts[2][0] = new TextLayout(text, map, frctx);
	            iter = new AttributedString(text, map).getIterator();
	            layouts[2][1] = new LineBreakMeasurer(iter, frctx).nextLayout(Float.MAX_VALUE);

	            // Contextual Arabic NumericShaper, Arabic context
	            //
	            shaper = NumericShaper.getContextualShaper(rangeSet, 
	            										   NumericShaper.Range.ARABIC);

	            map.put(TextAttribute.NUMERIC_SHAPING, shaper);
	            layouts[3][0] = new TextLayout(text, map, frctx);
	            iter = new AttributedString(text, map).getIterator();
	            layouts[3][1] = new LineBreakMeasurer(iter, frctx).nextLayout(Float.MAX_VALUE);


	            // Contextual All Ranges NumericShaper, default Latin context
	            //            
	            rangeSet = EnumSet.of(NumericShaper.Range.ARABIC, NumericShaper.Range.THAI,
	            					  NumericShaper.Range.EUROPEAN);
	            shaper   = NumericShaper.getContextualShaper(rangeSet);

	            map.put(TextAttribute.NUMERIC_SHAPING, shaper);
	            layouts[4][0] = new TextLayout(text, map, frctx);
	            iter = new AttributedString(text, map).getIterator();
	            layouts[4][1] = new LineBreakMeasurer(iter, frctx).nextLayout(Float.MAX_VALUE);

	            setBackground(Color.white);
	            setForeground(Color.blue);
	        }
	        
	        private TextLayout[][] layouts;
	        private String[] descriptions = {
	                "No NumericShaper Used",
	                "NumericShaper.getShaper(NumericShaper.Range.ARABIC)",
	                "NumericShaper.getContextualShaper(EnumSet.of(Range.ARABIC))",
	                "NumericShaper.getContextualShaper(EnumSet.of(Range.ARABIC), Range.ARABIC)",
	                "NumericShaper.getContextualShaper(EnumSet.of(ARABIC, THAI, EUROPEAN))"
	             };

	        public void paint(Graphics g) {
	            Graphics2D g2d = (Graphics2D)g;

	            float x = 5;
	            float y = 5;

	            for (int i = 0; i < layouts.length; ++i) {
	                y += 18;
	                g2d.drawString(descriptions[i], x, y);
	                y += 4;

	                for (int j = 0; j < 2; ++j) {
	                    y += layouts[i][j].getAscent();
	                    layouts[i][j].draw(g2d, x, y);
	                    y += layouts[i][j].getDescent() + layouts[i][j].getLeading();
	                }
	            }
	        }
	    }
	    public static void main(String args[]) {
	    	DigitShaper shaper = new DigitShaper();
	        shaper.init();
	        shaper.start();

	        Frame f = new Frame("ShapedDigits");
	        f.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	                System.exit(0);
	            }
	        });

	        f.add(shaper, "Center");
	        f.setSize(800, 350);
	        f.setVisible(true);
	    }

	    public String getAppletInfo() {
	        return "Shaped Digits Sample";
	    }

	    public void init() {
	        setLayout(new BorderLayout());
	        add(panel, "Center");
	    }

	    public void destroy() {
	        remove(panel);
	    }
	}
package com.jongsul.sr.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class EdgePanel extends JPanel {
	int x1,y1,x2,y2;
	public EdgePanel(int x1, int y1, int x2, int y2) {
		if(x1<x2){
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		}else{
			this.x1 = x2;
			this.x2 = x1;
			this.y1 = y2;
			this.y2 = y1;
		}
        setBackground(new Color(0, 0, 0, 0));
        
        
    }

	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(y1<y2){
        	setBounds(x1,y1,Math.abs(x1-x2), Math.abs(y1-y2));
        }else{
        	setBounds(x1,y2,Math.abs(x1-x2), Math.abs(y1-y2));
        }
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(2,
            BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
        if(y1<y2){
        	g.drawLine(0, 0, x2-x1, y2-y1);
        }else{
        	g.drawLine(0, y1-y2, x2-x1, 0);
        }
    }

}

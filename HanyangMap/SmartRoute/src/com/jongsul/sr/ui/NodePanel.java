package com.jongsul.sr.ui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.JPanel;

/**
 * Created by sunghyo.jung on 2016. 5. 29..
 */
public class NodePanel extends JPanel {
	int x,y;
	public NodePanel(int x, int y) {
		this.x = x;
		this.y = y;
        setBackground(new Color(0, 0, 0, 0));
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//    if(getBounds().height != Math.abs(fy - sy) || getBounds().width != Math.abs(fx - sx)){
        setBounds(x-10, y-10, 20, 20);
//    }
        g.setColor(Color.red);
        g.fillOval(0, 0, 20, 20);

    }

}

package com.jongsul.sr.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PathPanel extends JPanel {
	
	private BufferedImage biDrawPad, biOrig;
	private Graphics2D g2dBiTemp;
	private int sx, sy, fx, fy;
	private Dimension drawPadSize;
	
	public PathPanel() {
        setBackground(new Color(0, 0, 0, 0));
        addListeners();
        
    }
	public void setPreferredSize(Dimension preferredSize) {
        super.setPreferredSize(preferredSize);
        drawPadSize = preferredSize;
        
    }
	
	private void addListeners() {
		this.addMouseListener(
				 new MouseAdapter()
	                {
	                    public void mousePressed(MouseEvent e)
	                    {
	                    	sx = e.getX();
	                    	sy = e.getY();
	                    	mousePressedLineCode();
	                    }
	                    
	                    public void mouseReleased(MouseEvent e)
	                    {
	                    	mouseReleasedLineCode();
	                    }
	                }
				 );
		this.addMouseMotionListener(
				new MouseMotionAdapter()
				{
					public void mouseDragged(MouseEvent e)
                    {
                        fx = e.getX();
                        fy = e.getY();
                        mouseDraggedLineCode();
                    }
				}
				);
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//    if(getBounds().height != Math.abs(fy - sy) || getBounds().width != Math.abs(fx - sx)){
        setBounds(0, 0, 900, 1500);
//    }
    }
	
	private void mouseDraggedLineCode()
    {
        g2dBiTemp.drawImage(biOrig, 0, 0, null);
        g2dBiTemp.drawLine(sx, sy, fx, fy);
        repaint();
    }

    private void mouseReleasedLineCode()
    {
        biOrig = null;
        g2dBiTemp.dispose();
        g2dBiTemp = null;
    }

    private void mousePressedLineCode()
    {
        biOrig = new BufferedImage(drawPadSize.width, drawPadSize.height, biDrawPad.getType());

        Graphics2D g2dBiOrig = biOrig.createGraphics();
        g2dBiOrig.drawImage(biDrawPad, 0, 0, null);
        g2dBiOrig.dispose();
        g2dBiOrig = null;
        g2dBiTemp = biDrawPad.createGraphics();
        g2dBiTemp.setColor(Color.red);
    }
}

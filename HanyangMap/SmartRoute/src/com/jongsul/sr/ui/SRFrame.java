package com.jongsul.sr.ui;


import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SRFrame extends JFrame{
	JPanel startNode, destinationNode, interNode;
	Image mapImg;
	
	public SRFrame(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Component abb;
		
		MapPanel abc = new MapPanel();
		JScrollPane jsp = new JScrollPane(abc);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		NodePanel a = new NodePanel(500,500,20,20);
		EdgePanel b = new EdgePanel(200,200,100,100);
//		abb =a;
//		abc.add(abb);
//		abc.setComponentZOrder(abb, 0);
		abb =b;
		abc.add(abb);
		abc.setComponentZOrder(abb, 0);
		this.add(abb);
//		PathPanel a = new PathPanel();
//		abb = a;
//		abc.add(abb);
//		abc.setComponentZOrder(abb, 0);
		this.setBounds(50,50,970,820);
		this.add(jsp);
		this.setVisible(true);
		
		
		
	}
	
	
//		 public static void main(String[] args) {
//			 javax.swing.SwingUtilities.invokeLater(new Runnable() {
//		            public void run() {
//		            	new SRFrame();
//		            	
//		            }
//		        });
//			  
//			 }




	
	
}

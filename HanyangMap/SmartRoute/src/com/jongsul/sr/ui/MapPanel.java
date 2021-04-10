package com.jongsul.sr.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jongsul.sr.dijkstra.Dijkstra;


public class MapPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	Dijkstra testDijkstra;
	int[] coordinatexy = {96,97,
			116,105,
			123,155,
			106,172,
			148,214,
			121,296,
			174,298,
			125,323,
			157,314,
			183,309,
			174,381,
			249,169,
			248,96,
			264,171,
			264,96,
			280,50,
			328,53,
			349,147,
			335,174,
			247,402,
			275,524,
			306,517,
			295,467,
			365,496,
			311,421,
			288,310,
			269,281,
			282,287,
			298,244,
			338,290,
			345,311,
			367,387,
			368,447,
			375,373,
			385,354,
			379,304,
			404,339,
			430,313,
			450,427,
			482,400,
			499,432,
			369,513,
			341,586,
			448,546,
			379,597,
			471,559,
			405,599,
			486,574,
			454,620,
			479,615,
			353,657,
			448,657,
			478,662,
			575,687,
			433,682,
			320,707,
			305,747,
			470,507,
			491,504,
			541,483,
			476,460,
			486,443,
			514,434,
			559,419,
			632,437,
			671,494,
			677,526,
			603,591,
			708,594,
			742,540,
			661,661,
			671,424,
			707,414,
			615,298,
			678,360,
			665,315,
			747,396,
			746,376,
			1000,1000,
			777,386,
			771,430,
			780,358,
			748,248,
			698,255,
			615,271,
			547,225,
			596,155};
	JButton sb,db,ib;
	int startpo,destinationpo,intermediatepo;
	float distance;
	
	
	private int sx, sy;
	private Component comp;
    private Image image1;
    public MapPanel() {
    	int numberOfNode;
		 
		 String[] distanceSet;
		 Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream("input.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 numberOfNode = sc.nextInt();
		 
		 distanceSet = new String[numberOfNode];
		 distanceSet[0] = sc.nextLine();
		 for(int w = 0; w< numberOfNode ; w++){
			 distanceSet[w] = sc.nextLine();
		 }
		 
		 testDijkstra = new Dijkstra(numberOfNode,distanceSet);
		 
		 
    	sb = new JButton("start");
    	db = new JButton("destination");
    	ib = new JButton("intermediate");
    	sb.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			startpo = coordiToNode(sx,sy)+1;
    			
    		}
    	});
    	db.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			destinationpo = coordiToNode(sx,sy)+1;
    			if(intermediatepo!=0){
    			distance = testDijkstra.dijkstraAlgo(startpo, destinationpo, intermediatepo);
    			int[] instPath;
    			 instPath = testDijkstra.getPath(startpo, destinationpo, intermediatepo);
    			 drawEdge(instPath);
    			 JFrame newjf = new JFrame();
       			 JLabel newjl = new JLabel();
       			 newjl.setText("거리 : "+distance+"m");
       			 newjf.add(newjl);
       			 newjf.setBounds(150,150,100,100);
       			 newjf.setVisible(true);
    			}else{
    				distance = testDijkstra.dijkstraAlgo(startpo, destinationpo);
    				int[] instPath;
    				instPath = testDijkstra.getPath(startpo, destinationpo);
       			 drawEdge(instPath);
       			 JFrame newjf = new JFrame();
       			 JLabel newjl = new JLabel();
       			 newjl.setText("거리 : "+distance+"m");
       			 newjf.add(newjl);
       			 newjf.setBounds(150,150,100,100);
       			 newjf.setVisible(true);
    			}
    			 
    		}
    	});
    	ib.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			intermediatepo = coordiToNode(sx,sy)+1;
    		}
    	});
        try {
			image1 = ImageIO.read(new File("map.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setFocusable(true);
        setIgnoreRepaint(true);
        addListeners();
    }

    public Dimension getPreferredSize() {
        return image1 == null ? super.getPreferredSize() : new Dimension(image1.getWidth(this), image1.getHeight(this));
    }

    public void paintComponent(Graphics g){ 
        super.paintComponent(g);

        if (image1 != null) {
            g.drawImage(image1,0,0,this);
        }
    }
    
    private void addListeners(){
    	this.addMouseListener( 
    			new MouseAdapter()
                {
                    public void mouseClicked(MouseEvent e)
                    {
                    	sx = e.getX();
                    	sy = e.getY();
                    	createNewNode(sx,sy);
                    	JFrame jj = new JFrame("출발도착경유");
                    	jj.setBounds(200,200,300,100);
                    	FlowLayout lay = new FlowLayout();
                    	jj.setLayout(lay);
                    	jj.add(sb);
                    	jj.add(db);
                    	jj.add(ib);
                    	jj.setVisible(true);
                    }
                }
    	);
    	
//    	
//    	this.addMouseMotionListener(
//                new MouseMotionAdapter()
//                {
//                	@Override
//	                public void mouseMoved(MouseEvent e) {
//	                	System.out.println(e.getX()+" "+e.getY());
//	                }
//                }
//    			);

}
    
    public void createNewNode(int sx, int sy) {
    	int index = coordiToNode(sx,sy);
        comp = new NodePanel(coordinatexy[index*2], coordinatexy[index*2+1]);
        this.add(comp);
        this.setComponentZOrder(comp, 0);
        validate();
    }
    
    public void createNewEdge(int x1, int y1, int x2, int y2) {
        comp = new EdgePanel(x1,y1,x2,y2);
        this.add(comp);
        this.setComponentZOrder(comp, 0);
        validate();
    }
    
    public void drawEdge(int[] path){
    	int[] inst1, inst2;
    	inst1 = new int[2];
    	inst2 = new int[2];
    	for(int i = 0; i < path.length-1; i++){
    		inst1 = nodeToCoordi(path[i]-1);
    		inst2 = nodeToCoordi(path[i+1]-1);
    		createNewEdge(inst1[0],inst1[1],inst2[0],inst2[1]);
    	}
    }
    
    public int coordiToNode(int x, int y){
    	int constant = 0;
    	int constant2 = 0;
    	int constant3 =Integer.MAX_VALUE;
    	for(int i = 0; i<87;i++){
    		constant2 = (int) (Math.pow((coordinatexy[i*2]-x), 2)+Math.pow((coordinatexy[i*2+1]-y), 2));
    		if(constant2<=constant3){
    			constant = i;
    			constant3 = constant2;
    		}
    	}
    	return constant;
    }
    
    public int[] nodeToCoordi(int index){
    	int[] inst = {coordinatexy[index*2],coordinatexy[index*2+1]};
    	return inst;
    }
    
    
//    public int findNode(int x, int y){
//    	int indexOfNode;
//    	for(int i = 0; i < 87; i++){
//    		
//    	}
//    }

}

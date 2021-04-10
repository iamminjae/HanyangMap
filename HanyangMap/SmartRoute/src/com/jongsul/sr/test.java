package com.jongsul.sr;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.jongsul.sr.dijkstra.Dijkstra;
import com.jongsul.sr.ui.SRFrame;

public class test {
	public static void main(String[] args) {
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	new SRFrame();
	            	
	            }
	        });
		  
		 }

//	 public static void main( String [] arg ) throws Exception {
//		 int numberOfNode;
//		 int start,destination, intermediate;
//		 float distance;
//		 String[] distanceSet;
//		 Scanner sc = new Scanner(new FileInputStream("input.txt"));
//		 numberOfNode = sc.nextInt();
//		 
//		 distanceSet = new String[numberOfNode];
//		 distanceSet[0] = sc.nextLine();
//		 for(int w = 0; w< numberOfNode ; w++){
//			 distanceSet[w] = sc.nextLine();
//		 }
//		 
//		 Dijkstra test = new Dijkstra(numberOfNode,distanceSet);
//		 
//		 
//		 BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
//		 System.out.print("\n출발점을 입력하시오 : ");
//		 start = Integer.parseInt(br.readLine());
//		 System.out.print("\n도착점을 입력하시오 : ");
//		 destination = Integer.parseInt(br.readLine());
//		 System.out.print("\n경유점을 입력하시오 : ");
//		 intermediate = Integer.parseInt(br.readLine());
//		 
//		 distance = test.dijkstraAlgo(start, destination, intermediate);
//		 
//		 
//		 System.out.printf("\n %d에서 출발하여, %d로 가는 최단 거리는 %f입니다.\n", start, destination, distance);
//		 
//		 int[] instPath;
//		 instPath = test.getPath(start, destination, intermediate);
//		 
//		 System.out.print(" 경로는 : ");
//		  
//		  for(int u=0;u<instPath.length-1;u++) {
//		   System.out.printf("%d -> ",instPath[u]);
//		  }
//		  System.out.printf("%d입니다",instPath[instPath.length-1]);
//		 
//		 
//	 		}

}

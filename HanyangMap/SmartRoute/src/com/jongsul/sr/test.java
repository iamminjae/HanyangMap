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
//		 System.out.print("\n������� �Է��Ͻÿ� : ");
//		 start = Integer.parseInt(br.readLine());
//		 System.out.print("\n�������� �Է��Ͻÿ� : ");
//		 destination = Integer.parseInt(br.readLine());
//		 System.out.print("\n�������� �Է��Ͻÿ� : ");
//		 intermediate = Integer.parseInt(br.readLine());
//		 
//		 distance = test.dijkstraAlgo(start, destination, intermediate);
//		 
//		 
//		 System.out.printf("\n %d���� ����Ͽ�, %d�� ���� �ִ� �Ÿ��� %f�Դϴ�.\n", start, destination, distance);
//		 
//		 int[] instPath;
//		 instPath = test.getPath(start, destination, intermediate);
//		 
//		 System.out.print(" ��δ� : ");
//		  
//		  for(int u=0;u<instPath.length-1;u++) {
//		   System.out.printf("%d -> ",instPath[u]);
//		  }
//		  System.out.printf("%d�Դϴ�",instPath[instPath.length-1]);
//		 
//		 
//	 		}

}

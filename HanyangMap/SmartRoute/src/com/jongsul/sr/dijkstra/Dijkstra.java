package com.jongsul.sr.dijkstra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Dijkstra {
	int numberOfNode;
	String[] distanceSet;
	int[] via1,via2;
	
	public Dijkstra(int numberOfNode, String[] distanceSet) {
		this.numberOfNode = numberOfNode;
		this.distanceSet = distanceSet;
	}
	
	public float getNode(String[] inst, int row, int column){
		String a = inst[row];
		int secondIndex, firstIndex=0;
		float abc3 = 0;
		secondIndex = a.indexOf(",");
		if(row!=column){
			for(int i = 0; i< column; i++){
				firstIndex= secondIndex;
				secondIndex = a.indexOf(",", firstIndex+1);
			}
			if(secondIndex==-1)
				secondIndex = a.length();
			if(column==0){
				a=a.substring(0,secondIndex);
			}else{
				a = a.substring(firstIndex+1, secondIndex);
			}
			abc3 = Float.parseFloat(a);
			if(abc3==0)
				abc3 = 5000;
		} else {
			abc3 = 0;
			}
		
		return abc3;
	}
	
	public float dijkstraAlgo(int start, int destination, int intermediate){
		float distance;
		distance = dijkstraAlgo(start,intermediate)+dijkstraAlgo(intermediate,destination);
		return distance;
	}
	
	public float dijkstraAlgo(int start, int destination) {
		int[] v,via;
		v = new int[numberOfNode];
		via = new int[numberOfNode];
		float[] distance;
		distance = new float[numberOfNode];
		int n = numberOfNode;
		int m = 5000;
		int s=start,k=0;
		float min;
		for(int i = 0; i < n; i++ ){
			 v[i] = 0;
			 distance[i] = m;
		 }
		 distance[s-1] = 0;
		 
		 for(int i = 0; i < n; i++){
			 min = m;
			 for(int j = 0; j < n; j++){
				 if(v[j] == 0 && distance[j] < min){
					 k = j;
					 min = distance[j];
				 }
			 }
			 v[k] = 1;
			 if(min==m) break;
			 for(int j = 0; j < n; j++){
				 if(distance[j] > distance[k] + getNode(distanceSet,k,j)) {
					 distance[j] = distance[k] + getNode(distanceSet,k,j);
					 via[j]=k;
				 }
			 }
		 }
		 if(via1==null){
			 via1 = via;
		 }else{
			 via2 = via;
		 }
		 return distance[destination-1];
	}
	
	
	public int[] getPath(int start, int destination, int intermediate){
		int[] instPath, instPath1, instPath2;
		int instLength;
		instPath1 = getPath(start, intermediate, via1);
		instLength = instPath1.length;
		instPath2 = getPath(intermediate, destination, via2);
		instLength += instPath2.length-1;
		instPath = new int[instLength];
		for(int i = 0; i < instLength; i++){
			if(i<instPath1.length){
				instPath[i] = instPath1[i];
			}else{
				instPath[i] = instPath2[i-instPath1.length+1];
			}
		}
		return instPath;
	}
	
	public int[] getPath(int start, int destination){
		int[] path = new int[numberOfNode];
		int path_cnt=0;
		int[] instPath;
		int[] viaPath = via1;
		
		int k = destination-1;
		int s = start;
		
		while(true) {
			path[path_cnt++]=k;
			if(k==s-1) break;
			k=viaPath[k];
		}
		
		instPath = new int[path_cnt];
		  
		  for(int i=path_cnt-1;i>=1;i--) {
		    instPath[path_cnt-i-1] = path[i]+1;
		  }
		  instPath[path_cnt-1] = path[0]+1;
		
		  return instPath;
	}
	
	public int[] getPath(int start, int destination, int[] instVia){
		int[] path = new int[numberOfNode];
		int path_cnt=0;
		int[] instPath;
		int[] viaPath = instVia;
		
		int k = destination-1;
		int s = start;
		
		while(true) {
			path[path_cnt++]=k;
			if(k==s-1) break;
			k=viaPath[k];
		}
		
		instPath = new int[path_cnt];
		  
		  for(int i=path_cnt-1;i>=1;i--) {
		    instPath[path_cnt-i-1] = path[i]+1;
		  }
		  instPath[path_cnt-1] = path[0]+1;
		
		  return instPath;
	}
}
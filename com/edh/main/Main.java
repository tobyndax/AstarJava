package com.edh.main;
import com.edh.utility.*;
class Main{

	public static void main(String[] args){	
		
        Map mappy = new Map();
        Node noddy = new Node(1,1,19,39,20,40,mappy);
        long startTime = System.nanoTime();
		noddy.branch();
        long finishTime = System.nanoTime();
        long elapsedTime = (finishTime - startTime)/(1000*1000);
		mappy.printMap();
        System.out.println("Time for execution: " + elapsedTime + " ms");
		System.out.println("Number of open nodes at end: " + noddy.getOpenSize());
		
		System.out.println("Number of closed nodes at end: " + noddy.getClosedSize());
		System.out.println("Total number of nodes: " + 20*40);
    }
}
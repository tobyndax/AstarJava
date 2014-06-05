package com.edh.main;
import com.edh.utility.*;
import com.edh.graphics.*;

import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;

class Main{
    
	public static void main(String[] args){
		
        
        
        
        Map mappy = new Map();
        Map mapGraph = new Map();
        
        System.out.println("Yo");
        DrawPanel panel = new DrawPanel(600,300,mapGraph);
        mapGraph.setPanel(panel);
        Node noddy = new Node(1,1,19,39,20,40,mappy,mapGraph);
        noddy.branch();
        
        
        
        long startTime = System.nanoTime();
        
        long finishTime = System.nanoTime();
        long elapsedTime = (finishTime - startTime)/(1000*1000);
        mappy.printMap();
        System.out.println("Time for execution: " + elapsedTime + " ms");
        System.out.println("Number of open nodes at end: " + noddy.getOpenSize());
        
        System.out.println("Number of closed nodes at end: " + noddy.getClosedSize());
        System.out.println("Total number of nodes: " + mappy.getSize());
        
        
    }
}
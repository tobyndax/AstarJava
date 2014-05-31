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
		
        DrawPanel panel = new DrawPanel();                            // window for drawing
        JFrame application = new JFrame();                            // the program itself
        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // set frame to exit
        // when it is closed
        application.add(panel);
        
        
        application.setSize(500, 400);         // window is 500 pixels wide, 400 high
        application.setVisible(true);
        
        
        
        
        /*
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
         System.out.println("Total number of nodes: " + mappy.getSize());
         
         */
    }
}
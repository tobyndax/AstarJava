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
        DrawPanel panel = new DrawPanel(600,600,mapGraph);
        mapGraph.setPanel(panel);
        Node noddy = new Node(1,1,39,39,40,40,mappy,mapGraph);
        noddy.branch();
        
        System.out.println("Number of open nodes at end: " + noddy.getOpenSize());
        
        System.out.println("Number of closed nodes at end: " + noddy.getClosedSize());
        System.out.println("Total number of nodes: " + mappy.getSize());
        
        
    }
}
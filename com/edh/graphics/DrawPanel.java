package com.edh.graphics;

import com.edh.utility.*;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;



public class DrawPanel extends JPanel{
    
    static private Map map;
    private JFrame application = new JFrame();
    
    public DrawPanel(int xSize, int ySize,Map inMap){
        super();
        setBackground(Color.GRAY);
        // window for drawing
        // the program itself
        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // set frame to exit
        // when it is closed
        application.add(this);
        
        map = inMap;
        
        application.setSize(xSize,ySize);
        System.out.println("Drawing");// window is x pixels wide, y high
        application.setVisible(true);
    }
    
    public void repaint(){
        if(application != null){
            application.repaint();
        }
    }
    
    public void paintComponent(Graphics g)  // draw graphics in the panel
    {
        int width = getWidth();             // width of window in pixels
        int height = getHeight();           // height of window in pixels
        
        
        super.paintComponent(g);            // call superclass to make panel display correctly
        
        
        int extraWidth = width - map.ySize*10;
        int extraHeight = height - map.xSize*10;
        
        
        for(int x = 0; x < map.xSize+1; x++){
            for(int y = 0; y < map.ySize+1; y++){
                if(map.getSection(x,y) == 3){
                    g.setColor(Color.magenta);
                    g.fillRect(y*10 + extraWidth/2,x*10 +extraHeight/2,10,10);
                }
                if(map.getSection(x,y) == 6){
                    g.setColor(Color.yellow);
                    g.fillRect(y*10 + extraWidth/2,x*10 +extraHeight/2,10,10);
                }
                if(map.getSection(x,y) == 7){
                    g.setColor(Color.yellow.darker());
                    g.fillRect(y*10 + extraWidth/2,x*10 +extraHeight/2,10,10);
                }
                if(map.getSection(x,y) == 8){
                    g.setColor(Color.blue);
                    g.fillRect(y*10 + extraWidth/2,x*10 +extraHeight/2,10,10);
                }
                if(map.getSection(x,y) == 4){
                    g.setColor(Color.magenta.darker());
                    g.fillRect(y*10 + extraWidth/2,x*10 +extraHeight/2,10,10);
                }
                if(map.getSection(x,y) == 12){
                    g.setColor(Color.green.darker());
                    g.fillRect(y*10 + extraWidth/2,x*10 +extraHeight/2,10,10);
                }
                if(map.getSection(x,y) == 2 ||map.getSection(x,y) == 9 ){
                    g.setColor(Color.blue);
                    g.fillRect(y*10 + extraWidth/2,x*10 +extraHeight/2,10,10);
                }
                if(map.getSection(x,y) == 1){
                    g.setColor(Color.green);
                    g.fillRect(y*10 + extraWidth/2,x*10 +extraHeight/2,10,10);
                }
                g.setColor(Color.black);
                g.drawRect(y*10 + extraWidth/2,x*10 +extraHeight/2,10,10);
            }
        }
        
    }
    
}
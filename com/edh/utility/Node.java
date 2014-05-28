package com.edh.utility;
import java.util.*;
import com.edh.utility.*;

public class Node implements Comparable<Node>{
	private int xPos;
    private int yPos;
	static private int xStart;
	static private int yStart;
	static private int xStop;
	static private int yStop; 
    private int cost;
	private int gCost;
	private int hCost;
    private Node parent;
    static private OpenList open;
    
    
//----------------------------------------------
    
    public Node(Node inNode,int inX,int inY){
        xPos = inX;
        yPos = inY;
        parent = inNode;
		
		calculateFCost();
    }

    
//----------------------------------------------
    
    //this is pretty cool. implements and overrides a compare so it can be used in
    //standard sorting algorithms of java.Collections
    //what does this do in null case?
    
    
    public int compareTo(Node node) {
        if (cost == node.cost){
            return 0;
        }
        else if(cost > node.cost){
            return 1;
        }
        else{
            return -1;
        }
    }
    
//----------------------------------------------
    
    public Node(int xStart, int yStart, int inxStop, int inyStop){
        xPos = xStart;
        yPos = yStart;
		xStart = xStart; 
		yStart = yStart;
		xStop = inxStop;
		yStop = inyStop;
        
        OpenList open = new OpenList(6*6);
        
    }

//----------------------------------------------
    
	private void calculateFCost(){
        calculateGCost();
        calculateHCost();
        cost = gCost + hCost;
        
    }
    
//----------------------------------------------
	
	private void calculateGCost(){
		if(parent != null){
			if(parent.getX() == xStart && parent.getY() == yStart){
				if(diagonal()){
					gCost = 14;
                }else{
					gCost = 10;
                }
			}else{
				if(diagonal()){
					gCost = 14 + parent.gCost;
                }else{
					gCost = 10 + parent.gCost;
				}
			}
		}
	}
    
//----------------------------------------------
    
	private void calculateHCost(){
		int dx = Math.abs(xPos-xStop);
		int dy = Math.abs(yPos-yStop);
		hCost = (dx+dy)*10;
	}
	
//----------------------------------------------
    
	private boolean diagonal(){
        
		int dx = Math.abs(xPos-parent.xPos);
		int dy = Math.abs(yPos-parent.yPos); 
		
		if(dx == 1 && dy == 1){
			return true; 
		}
		return false;
	}
    
//----------------------------------------------
	
    public void setCost(int inCost){
        cost = inCost;
    }
    
//----------------------------------------------
    
    public int getCost(){
        return cost;
    }
    
//----------------------------------------------
    
    public int getX(){
        return xPos;
    }
    
//----------------------------------------------
    
    public int getY(){
        return yPos;
    }
    
//----------------------------------------------
    
}
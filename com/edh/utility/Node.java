package com.edh.utility;

public class Node{
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
    
    public Node(Node inNode,int inX,int inY){
        xPos = inX;
        yPos = inY;
		
		calculateCost();
    }
    
    public Node(int xStart, int yStart, int xStop, int yStop){
        xPos = xStart;
        yPos = yStart;
		xStart = xStart; 
		yStart = yStart;
		xStop = xStop;
		yStop = yStop;
		calculateCost();
    }

	private void calculateFCost(){
	cost = calculateGCost() + calculateHCost();
	}
	
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
		gCost = 0;
	}
	private void calculateHCost(){
		int dx = Math.abs(xPos-parent.xPos);
		int dy = Math.abs(yPos-parent.yPos); 
		int hCost = (dx+dy)*10;
	}
	
	private boolean diagonal(){
		int dx = Math.abs(xPos-parent.xPos);
		int dy = Math.abs(yPos-parent.yPos); 
		
		if(dx == 1 && dy == 1){
			return true; 
		}
		return false;
	}
	
    public void setCost(int inCost){
        cost = inCost;
    }
    
    public int getCost(){
        return cost;
    }
    
    public int getX(){
        return xPos;
    }
    
    public int getY(){
        return yPos;
    }
}
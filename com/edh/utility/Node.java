package com.edh.utility;

public class Node{
	private int xPos;
    private int yPos;
    private int cost;
    private Node parent;
    
    public Node(int inX,int inY,int inCost){
        xPos = inX;
        yPos = inY;
        cost = inCost;
    }
    
    public Node(int inX,int inY,int inCost,Node inNode){
        xPos = inX;
        yPos = inY;
        cost = inCost;
        parent = inNode;
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
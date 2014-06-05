package com.edh.utility;
import java.util.*;
import com.edh.utility.*;

public class Node{// implements Comparable<Node>{
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
    
    static private MyMap map;
    static private MyMap mapGraph;
    static private OpenList open = new OpenList();
    static private ClosedList closed = new ClosedList();
    
    
    //----------------------------------------------
    
    //this is pretty cool. implements and overrides a compare so it can be used in
    //standard sorting algorithms of java.Collections
    //what does this do in null case?
    
    /*
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
     */
    //----------------------------------------------
    //Constructor for first node.
    public Node(int inxStart, int inyStart, int inxStop, int inyStop,int xSize,int ySize,MyMap inMap, MyMap inGraphMap){
        xPos = inxStart;
        yPos = inyStart;
		xStart = inxStart;
		yStart = inyStart;
		xStop = inxStop;
		yStop = inyStop;
        map = inMap;
        mapGraph = inGraphMap;
        open.setMap(inGraphMap);
        closed.setMap(inGraphMap);
        
        map.setSection(inxStart,inyStart,2);
        map.setSection(inxStop,inyStop,8);
        mapGraph.setSection(inxStart,inyStart,2);
        mapGraph.setSection(inxStop,inyStop,8);
        
        open.addToList(this);
        
    }
    //----------------------------------------------
    
	public int getOpenSize(){
		return open.size();
	}
    
    //----------------------------------------------
	
	public int getClosedSize(){
		return closed.size();
	}
	
    //----------------------------------------------
    //constructor for all consecutive nodes.
    public Node(Node inNode,int inX,int inY){
        xPos = inX;
        yPos = inY;
        parent = inNode;
		
		calculateFCost();
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
		int xDistance = Math.abs(xPos-xStop);
        int yDistance = Math.abs(yPos-yStop);
        if(xDistance > yDistance){
            hCost = 14*yDistance + 10*(xDistance-yDistance);
            
        }else{
            hCost = 14*xDistance + 10*(yDistance-xDistance);
        }
	}
    
    //----------------------------------------------
    
	private boolean vertical(){
        
		int dx = Math.abs(xPos-parent.xPos);
		int dy = Math.abs(yPos-parent.yPos);
		
		if(dx == 0 && dy == 1){
			return true;
		}
		return false;
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
    public void chooseBranchPoint(){
        if(open.getBestNode() == null){
			map.printMap();
			return;
		}
		open.getBestNode().branch();
    }
    
    
    //----------------------------------------------
    public void getPath(){
        if(xPos == xStart && yPos == yStart){
            return;
        }
        map.setSection(xPos,yPos,6);
        mapGraph.setSection(xPos,yPos,6);
        mapGraph.panel.path.add(this);
        parent.getPath();
    }
    
    
    
    
    //----------------------------------------------
    public void branch(){
        for(int dx = -1; dx < 2; dx++){
            for(int dy = -1; dy < 2; dy++){
                
                if(dx == 0 && dy == 0){
                    continue;
				}
				
				if(!map.withinBounds(xPos+dx,yPos+dy)){
                    continue;
                }
                //if we can reach stop from here return the path.
                if(xPos+dx == xStop && yPos+dy == yStop){
                    open.addToList(new Node(this,xPos+dx,yPos+dy));
                    mapGraph.panel.path.add(open.getNode(xStop,yStop));
                    getPath();
                    return;
                    
                }
                //if inpassable terrain add node to closedlist if it is not already there.
                if(map.getSection(xPos+dx,yPos+dy) == 1 && closed.getNode(xPos+dx,yPos+dy) == null){
                    closed.addToList(new Node(this,xPos+dx,yPos+dy));//add to closed list if non-walkable
                    continue;
                }
                //if node is open but cheaper to reach from here update it's parent to this.
                //and update it's cost
                
                if(open.getNode(xPos+dx,yPos+dy) != null && open.getNode(xPos+dx,yPos+dy).parent.gCost > gCost){
                    open.getNode(xPos+dx,yPos+dy).setParent(this);
                }
                //if node does not exist on open or closed list. add it to the open list.
                if(open.getNode(xPos+dx,yPos+dy) == null && closed.getNode(xPos+dx,yPos+dy) == null){
                    open.addToList(new Node(this,xPos+dx,yPos+dy));
                }
            }
        }
        //move this node to closed list.
        open.removeNode(this);
        closed.addToList(this);
        chooseBranchPoint();
    }
    
    
    //----------------------------------------------
    //  Accessors
    //----------------------------------------------
    
    public void setParent(Node inNode){
        parent = inNode;
        open.removeNode(this);
        calculateFCost();
        
        open.addToList(this);
    }
    
    public Node getParent(){
        return parent;
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
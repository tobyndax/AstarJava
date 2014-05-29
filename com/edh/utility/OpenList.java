package com.edh.utility;
import com.edh.utility.Node;
import java.util.*;

public class OpenList{
    private PriorityQueue<Node> theList = new PriorityQueue<Node>(10,new Comparator<Node>(){
        public int compare(Node a, Node b){
            if(a.getCost() > b.getCost()){
                return 1;
            }
            if(b.getCost() > a.getCost()){
                return -1;
            }
            return 0;
        }
    });
    
    
//----------------------------------------------
    
    public OpenList(){
    }
    
//----------------------------------------------
    
    public void addToList(Node inNode){
        theList.add(inNode);
    }
    
//----------------------------------------------

    public void removeNode(Node inNode){
        theList.remove(inNode);
    }
    
//----------------------------------------------
    public Node getBestNode(){
        if(theList.size() == 0 ){
			System.out.println("No more open nodes, no way to finish found.");
			return null;
		}
        //Collections.sort(theList);
        return theList.peek();
    }
	
//----------------------------------------------
    public void resort(){
        //Collections.sort(theList);
    }
	
//----------------------------------------------
	public int size(){
		return theList.size();
	}
    
//----------------------------------------------

    
    public Node getNode(int xPos,int yPos){
        
        Iterator<Node> it = theList.iterator();
        while(it.hasNext()){
            Node element = it.next();
            if(element.getX() == xPos && element.getY() == yPos){
                return element;
            }
        }
        return null;
    }

    
//----------------------------------------------
    
    
    public void printList(){
        Iterator<Node> it = theList.iterator();
        while(it.hasNext()){
            Node element = it.next();
            System.out.println(element.getCost());
        }
    }
//----------------------------------------------
    
}

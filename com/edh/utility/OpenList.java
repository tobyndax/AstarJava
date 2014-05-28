package com.edh.utility;
import com.edh.utility.Node;
import java.util.*;

public class OpenList{
    private List<Node> theList = new ArrayList<Node>();
    
    
//----------------------------------------------
    
    public OpenList(){
    }
    
//----------------------------------------------
    
    public void addToList(Node inNode){
        theList.add(inNode);
        Collections.sort(theList);
    }
    
//----------------------------------------------

    public void removeNode(Node inNode){
        theList.remove(inNode);
        Collections.sort(theList);
    }
    
//----------------------------------------------
    public Node getBestNode(){
        if(theList.size() == 0 ){
			System.out.println("No more open nodes");
			return null;
		}
		return theList.get(0);
    }
	
//----------------------------------------------
    public void resort(){
        Collections.sort(theList);
    }
    

    
//----------------------------------------------

    
    public Node getNode(int xPos,int yPos){
        if(theList.size() == 0){
            return null;
        }
        for(int i = 0; i< theList.size();i++ ){
            if(theList.get(i).getX() == xPos && theList.get(i).getY() == yPos){
                return theList.get(i);
            }
        }
        return null;
    }
    
//----------------------------------------------
    
    
    public void printList(){
        for(int i = 0; i < theList.size(); i++){
            if (theList.get(i) == null){
                break;
            }else{
                System.out.println(theList.get(i).getCost());
            }
        }
    }
    
//----------------------------------------------
    
}

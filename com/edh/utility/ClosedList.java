package com.edh.utility;
import com.edh.utility.Node;
import java.util.*;

public class OpenList{
    static int MAXSIZE;
    private List<Node> openList = new ArrayList<Node>();
    
    
//----------------------------------------------
    
    public OpenList(int size){
        MAXSIZE = size;
    }
    
//----------------------------------------------
    
    public void addToList(Node inNode){
        openList.add(inNode);
        Collections.sort(openList);
    }
    
//----------------------------------------------

    public void removeNode(Node inNode){
        openList.remove(inNode);
        Collections.sort(openList);
    }
    
//----------------------------------------------

    
    public Node getNode(int xPos,int yPos){
        for(int i = 0; i< openList.size();i++ ){
            if(openList.get(i).getX() == xPos && openList.get(i).getY() == yPos){
                return openList.get(i);
            }
        }
        return null;
    }
    
//----------------------------------------------
    
    
    public void printList(){
        for(int i = 0; i < openList.size(); i++){
            if (openList.get(i) == null){
                break;
            }else{
                System.out.println(openList.get(i).getCost());
            }
        }
    }
    
//----------------------------------------------
    
}

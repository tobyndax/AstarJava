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

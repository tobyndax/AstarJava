package com.edh.utility;
import com.edh.utility.Node;
import java.util.*;

public class ClosedList extends OpenList{
    
    private SortedSet<Node> theList = new TreeSet<Node>(new Comparator<Node>(){
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
    public ClosedList(){
        super();
    }
    
@Override
    public void addToList(Node inNode){
        theList.add(inNode);
        map.setSection(inNode.getX(),inNode.getY(),4);
    }
}

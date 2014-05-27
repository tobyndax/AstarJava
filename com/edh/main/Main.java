package com.edh.main;
import com.edh.utility.*;
class Main{

	public static void main(String[] args){	
		Map mappy = new Map();
        Node noddy = new Node(5,5,10);
        Node noddy2 = new Node(5,4,10,noddy);
		mappy.printMap();
	}	
}
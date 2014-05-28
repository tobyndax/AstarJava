package com.edh.main;
import com.edh.utility.*;
class Main{

	public static void main(String[] args){	
		Map mappy = new Map();
        Node noddy = new Node(1,1,19,19,20,20,mappy);
        noddy.branch();
    }
}
package Lab4;

import java.io.Serializable;

public class Node<E> implements Serializable{
	
	//Class variable declaration: leftNode, rightNode, and data
	protected Node<E> leftNode;
	protected Node<E> rightNode;
	protected E data;
	
	//Constructor
	public Node(E data){
		//Initialization of a node
		leftNode = rightNode = null;
		this.data = data;
	}
	
	//Method: toString
	public String toString(){
		return data.toString();
	}
	
	//Method: insert. Insert a node into a tree
	public void insert(E insertValue){
		if((Integer) insertValue < (Integer) this.data){
			//add this node to the of the current node
			if(this.leftNode == null){
				this.leftNode = new Node<E>(insertValue);
			}
			else{
				this.leftNode.insert(insertValue);
			}
		}
		else if((Integer) insertValue > (Integer) this.data){
	        if (this.rightNode == null)
	        	this.rightNode = new Node<E>(insertValue);
	        else
	        	this.rightNode.insert(insertValue);
	    }
	}
}

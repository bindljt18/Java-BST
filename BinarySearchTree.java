package Lab4;

import java.io.Serializable;

public class BinarySearchTree<E> implements Serializable{
	
private Node<E> root;
	
	//Constructor 1: create an empty BST tree
	public BinarySearchTree(){
		root = null;
	}
	//Constructor 2: create a BST given a root
	public BinarySearchTree(Node<E> root){
		this.root = root;
	}
	//Constructor 3: create a BST given data root, left tree, and right tree
	public BinarySearchTree(E data, BinarySearchTree<E> leftTree, BinarySearchTree<E> rightTree){
		//create a root node for this tree
		this.root = new Node<E>(data);
		//connect the leftnode of the root with leftTree
		if(leftTree != null)
			this.root.leftNode = leftTree.root;
		//connect the rightNode of the root with rightTree
		if(rightTree != null)
			this.root.rightNode = rightTree.root;
	}
	
	//Method: insertNode (insert a value into a BST)
	public void insertNode(E insertValue){
		
		if(this.root == null)
			this.root = new Node<E>(insertValue);
		else
			this.root.insert(insertValue);
	}
	
	public BinarySearchTree<E> getLeftTree(){
		
		if(root != null && root.leftNode != null){
			return (new BinarySearchTree<E>(root.leftNode));
		}
		else
			return null;
	}
	
	public BinarySearchTree<E> getRightTree(){
		
		if(root != null && root.rightNode != null){
			return (new BinarySearchTree<E>(root.rightNode));
		}
		else
			return null;
	}
	
	public String getInorderTraversal(BinarySearchTree<E> tree){
		
		if(tree == null)
			return "";
		else
			return (getInorderTraversal(tree.getLeftTree()) + tree.root.toString() + " "
			+ getInorderTraversal(tree.getRightTree()));
	}
	
	public String getPreorderTraversal(BinarySearchTree<E> tree){
		
		if(tree == null)
			return "";
		else
			return (tree.root.toString() + " " + getPreorderTraversal(tree.getLeftTree())
			+ getPreorderTraversal(tree.getRightTree()));
	}
	
	public String getPostorderTraversal(BinarySearchTree<E> tree){
		
		if(tree == null)
			return "";
		else
			return (getPostorderTraversal(tree.getLeftTree()) + getPostorderTraversal(tree.getRightTree())
			+ tree.root.toString() + " ");
	}
}

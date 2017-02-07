package Lab4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class Main {
	
	public void writeTree(BinarySearchTree tree, String filename){
		
		try {
			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
			oos.writeObject(tree);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public <E> BinarySearchTree<E> readTree(String fileName){
		
		try{
			
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			BinarySearchTree<E> aTree = (BinarySearchTree<E>) ois.readObject();
			return aTree;
		} catch (IOException | ClassNotFoundException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String [] args){
		
		final int COUNT = 10;
		final int MAXVALUE = 100;
		
		Random rd = new Random();
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		
		for(int i = 0; i < COUNT; i++){
			int label = rd.nextInt(MAXVALUE);
			System.out.print(label + " ");
			tree.insertNode(label);
		}
		
		Main obj = new Main();
		obj.writeTree(tree, "bst.out");
		BinarySearchTree<Integer> testTree = new BinarySearchTree<Integer>();
		testTree = obj.readTree("bst.out");
		
		System.out.println("\n In-order traversal:");
		System.out.println(tree.getInorderTraversal(tree));
		System.out.println("Pre-order traversal:");
		System.out.println(tree.getPreorderTraversal(tree));
		System.out.println("Post-order traversal:");
		System.out.println(tree.getPostorderTraversal(tree));
		
		System.out.println();
		System.out.println("In-order traversal after writing and reading: ");
		System.out.println(testTree.getInorderTraversal(testTree));
		
	}
}

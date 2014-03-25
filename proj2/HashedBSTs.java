package proj2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class uses a creates and uses a hashed generic Binary Search Tree to hold
 * generic objects that are manipulated.
 * 
 * @version 03/21/14
 * @author Megan Straub <mstraub1@umbc.edu>
 * CMSC 341 - Spring 2014 - Project 2
 * Section 4
 *
 */
public class HashedBSTs <AnyType extends Comparable<? super AnyType>>{
	
	/**
	 * The ArrayList that holds the Binary Search Tree objects.
	 */
	private ArrayList<BinarySearchTree<Node>> table;
	
	/**
	 * A constructor method for the HashedBSTs class.
	 * 
	 * @param size the size of the index
	 */
	public HashedBSTs(int size){
		
		table = new ArrayList<BinarySearchTree<Node>>(size);
		
		for(int i = 0; i < size; i++){
			BinarySearchTree<Node> tree = new BinarySearchTree<Node>();
			table.add(i,tree);
		}			
	}
	
	/**
	 * This prints the results of the hashed binary search tree.
	 */
	public void printHashCountResults(){

		for (int index = 0; index < table.size(); index++){
			
			if (table.get(index).isEmpty()){
				
				System.out.print("This tree starts with ");
				System.out.println("and has " + table.get(index).count() + " nodes");
				
			}else{
				
				System.out.print("This tree starts with ");
				table.get(index).printRoot();	
				System.out.println("and has " + table.get(index).count() + " nodes");
			}			
		}	
	}
	
	/**
	 * This reads the file, removes any unwanted characters from the file, and inserts
	 * the Nodes into the specific binary search tree.
	 * 
	 * @param fileName the name of the file to be manipulated
	 */
	public void fileReader(String fileName){	
		
		File textFile = new File(fileName);
		
		String str = " ";
		char letter = 'z';
		int index;
		Node n; 
		
		try {
			Scanner scanFile = new Scanner(textFile); // reads the input file
			
			while (scanFile.hasNext()){
				str = scanFile.next();
	
				str = str.replaceAll("\\W|[0-9]", "");	//removes any unwanted characters
				
				if (str.length() > 0){
					letter = str.charAt(0);
					
					/**
					 * 90 and 65 are the ASCII characters of the upper case letters
					 * 90 minus 65 is 25 the letter Z
					 * 65 minus 65 is 0 the letter A
					 */
					char letterUpper = Character.toUpperCase(letter);					
					
					if(letterUpper - 65 >= 0 && letterUpper - 65 <= 25){	
						
						index = letterUpper - 65;
						n = new Node(str);
						table.get(index).insert(n);
					}	
				}				
			}
			scanFile.close();		
		}// end try
		catch (FileNotFoundException e){			
			System.out.println("File not found.");
			e.printStackTrace();
		}// end catch
	}
	
	/**
	 * This method finds all nodes in a tree that begin with the sample node parameter.
	 * 
	 * @param retrieved the binary search tree being searched
	 * @param sample the node that is to be matched with the other nodes in the binary search tree
	 */
	public void findAll(BinarySearchTree<Node> retrieved, Node sample){
		
		System.out.println("Finding all words that START WITH '" + sample.getWord() + "'");

		retrieved.findAll(sample);
	}
	
	/**
	 * This methods retrieves a specific tree from a certain index in the
	 * array list.
	 *
	 * @param index
	 * @return the tree at the specific index in the array list
	 */
	public BinarySearchTree<Node> retrieveHashedBSTat(int index){
		return table.get(index);
	}
}
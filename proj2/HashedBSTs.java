/**
 *TO DO:
 *
 *1. figure out frequency
 *2. finish find all
 *3. finish common ancestor
 *4. document the shit out of this thing
 */
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
	}//end HashedBSTs()
	
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
	}//end printHashCountResults()	
	
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
				/*
				 * this deliminates the words and replace the parts removed with no space. 
				 * i did this because when printing the root of the tree i was getting the wrong root.
				 * it also appears to fix our node problem with how many are in the tree (only checked A though)
				 * 
				 */
				str = str.replaceAll("\\W|[0-9]", "");
				
				if (str.length() > 0){
					letter = str.charAt(0);
					
					/**
					 * 90 and 65 are the ASCII characters of the upper case letters
					 * 90 minus 65 is 25 the Z letter
					 * 65 minus 65 is 0 the A letter
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
		/*
		for (int i = 0; i < 26; i++){
			table.get(i).printTree();
		}
		*/
		//printHashCountsResults();		
	}//end fileReader()
	
	/**
	 * will collect all codes that START with the letters in the sample Node and print that list of nodes
	 * 
	 * should run O(lgn) time
	 */
	
	/**
	 * 
	 */
	public void findAll(BinarySearchTree<Node> retrieved, Node sample){
		/*
		 * collect all codes that start with the letters in the sample Node and print that list of nodes
		 * will run at O(logn) time
		 */
		
		System.out.println("Finding all words that START with '" + sample.getWord() + "'");
		// if all words are greater than the sample they are a partial match
		// must traverse the entire tree given to find matches
		// use compare to function?
		
		
		
	}//end findAll()
	
	/**
	 * allows you to get a specific tree at a certain index in the array list
	 * @param index
	 * @return
	 */
	public BinarySearchTree<Node> retreiveHashedBSTat(int index){
		return table.get(index);
	}//end retreiveHashedBSTat()
}//end HashedBSTs class

/**
 * will open a file, filter it to the distinct words, remove ALL punctuation, and numbers
 * then place those words into the appropriate BST in the arraylist table
 * 
 * should run in O(n) time
 */
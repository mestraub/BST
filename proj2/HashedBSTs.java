/**
 * not building tree correctly
 * httpexamplecom should be together and not seperate
 * 
 * 
 * 3.20.14-fixed teh building of the trees, put stuff in if statement
 * made it so the arraylist does a Node
 * 
 * make nodes in the BST class and compare when inserting
 */
package proj2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Megan
 *
 */
public class HashedBSTs <AnyType extends Comparable<? super AnyType>>{

	private ArrayList<BinarySearchTree<Node>> table;
	private BinarySearchTree<Node> tree;
	
	//private ArrayList<BinarySearchTree<AnyType>> table;
	//private BinarySearchTree<AnyType> tree;
	
	/**
	 * a constructor that will accept the size of the hashed table
	 */
	public HashedBSTs(int size){
		// create array list called table
		//table = new ArrayList
		//table = new ArrayList<BinarySearchTree<AnyType>>(size);	
		table = new ArrayList<BinarySearchTree<Node>>(size);
		for(int i = 0; i < size; i++){
			//tree = new BinarySearchTree<AnyType>();
			tree = new BinarySearchTree<Node>();
			table.add(i,tree);
		}			
	}//end HashedBSTs()
	
	/**
	 * this is a grading and debugging tool
	 * should run in O(n) time
	 */
	public void printHashCountResults(){
		// loop through the entire array list
		
		/*
		 * a test printing schema for the output
		 */
		for (int index = 0; index < table.size(); index++)
		{
			if (table.get(index).isEmpty()){
				System.out.println("This tree has no nodes");
			}else{
				System.out.print("This tree starts with ");
				table.get(index).printRoot();
				
				//IMPORTANT: find out how to get tree size
				//System.out.print(" and has GET TREE SIZE HERE nodes.\n");
			}
		}	
	}//end printHashCountResults()
	
	/**
	 * will open a file, filter it to the distinct words, remove ALL punctuation, and numbers
	 * then place those words into the appropriate BST in the arraylist table
	 * 
	 * should run in O(n) time
	 */
	
	public void fileReader(String fileName){
		
		
		File textFile = new File(fileName);
		
		String str = " ";
		char letter = 'z';
		int index;
		Node n; 
		
		try {
			// reads in the text file
			Scanner scanFile = new Scanner(textFile);
			
			//uses a regular expression to deliminate the text file
			//scanFile.useDelimiter("\\W|[0-9]");
			
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
						//table.get(index).insert((AnyType)str);
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
	
	public void findAll(BinarySearchTree<Node> retrieved, Node sample){
		
	}
	
	
	
	/**
	 * letters 'A' and 'a' will be at index 0
	 * letters 'B' and 'b' will be at index 1
	 * there will be 26 spots in the table
	 * 
	 * use an array list to hold the BST called table, the size will be 26
	 */
	
}
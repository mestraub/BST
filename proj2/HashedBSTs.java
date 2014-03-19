/**
 * 
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
public class HashedBSTs <AnyType>{

	private ArrayList<BinarySearchTree<String>> table;
	
	/**
	 * a constructor that will accept the size of the hashed table
	 */
	public HashedBSTs(int size){
		// create array list called table
		//table = new ArrayList
		table = new ArrayList<BinarySearchTree<String>>(size);
		
		
	}
	
	/**
	 * this is a grading and debugging tool
	 * should run in O(n) time
	 */
	public void printHashCountsResults(){
		
	}
	
	/**
	 * will open a file, filter it to the distinct words, remove ALL punction, and numbers
	 * then place those words into the apprpriate BST in the arraylist table
	 * 
	 * should run in O(n) time
	 */
	
	public void fileReader(String fileName){
		
		
		File textFile = new File(fileName);
		
		String str = " ";
		char letter = 'z';
		
		try {
			// reads in the text file
			Scanner scanFile = new Scanner(textFile);
			
			scanFile.useDelimiter("\\W|[0-9]");
			
			while (scanFile.hasNext()){
				str = scanFile.next();

				if (str.length() > 0){
					letter = str.charAt(0);
				//	System.out.println(letter);
				}
				
				switch(letter){
					case'A':
					case'a': 
							BinarySearchTree<String> treeA = new BinarySearchTree<String>();					
							table.add(0, treeA);
							treeA.insert(str);
							treeA.printTree();
							break;
					/**case 'B':
					case 'b': 
							BinarySearchTree<String> treeB = new BinarySearchTree<String>();
							table.add(1, treeB);
							treeB.insert(str);
							treeB.printTree();
							break; */
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
	 * will collect all codes that START with the letters in teh sample Node and print that list of nodes
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
	 * use an array list to hold the BST called table, teh size will be 26
	 */
	
}

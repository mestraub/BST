/**
 * not building tree correctly
 * httpexamplecom should be together and not seperate
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

	private ArrayList<BinarySearchTree<AnyType>> table;
	private BinarySearchTree<AnyType> tree;
	
	/**
	 * a constructor that will accept the size of the hashed table
	 */
	public HashedBSTs(int size){
		// create array list called table
		//table = new ArrayList
		table = new ArrayList<BinarySearchTree<AnyType>>(size);	
		
		for(int i = 0; i < size; i++){
			tree = new BinarySearchTree<AnyType>();
			table.add(i,tree);
		}			
	}
	
	/**
	 * this is a grading and debugging tool
	 * should run in O(n) time
	 */
	public void printHashCountsResults(){
		// loop through the entire array list
		for (int index = 0; index < table.size(); index++)
		{
			if (table.get(index).isEmpty()){
				System.out.println("This tree has no nodes");
			}else{
				System.out.print("This tree starts with Node ");
				table.get(index).printRoot();
				//System.out.print(" and has GET TREE SIZE HERE nodes.\n");
			}
		}
		
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
		int index;
		
		try {
			// reads in the text file
			Scanner scanFile = new Scanner(textFile);
			
			//uses a regular expression to deliminate the text file
			//scanFile.useDelimiter("\\W|[0-9]");
			
			while (scanFile.hasNext()){
				str = scanFile.next();
				str = str.replaceAll("\\W|[0-9]", "");
				
				if (str.length() > 0){
					letter = str.charAt(0);
				}
				
				/**
				 * 90 and 65 are the ASCII characters of the upper case letters
				 * 90 minus 65 is 25 the Z letter
				 * 65 minus 65 is 0 the A letter
				 */
				char letterUpper = Character.toUpperCase(letter);
				
				
				if(letterUpper - 65 >= 0 && letterUpper - 65 <= 25){
					index = letterUpper - 65;
					table.get(index).insert((AnyType)str);
				}						
			}

			scanFile.close();
			
		}// end try
		catch (FileNotFoundException e){	
			
			System.out.println("File not found.");
			e.printStackTrace();
		}// end catch
		
		for (int i = 0; i < 26; i++){
			table.get(i).printTree();
		}
		
		printHashCountsResults();
		
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

/**
switch(letter){
	case'A':
	case'a': 
			table.get(0).insert(str);							
			break;
	case 'B':
	case 'b': 
			table.get(1).insert(str);				
			break;
	case 'C':
	case 'c': 
			table.get(2).insert(str);				
			break;
	case 'D':
	case 'd': 
			table.get(3).insert(str);				
			break;
	case 'E':
	case 'e': 
			table.get(4).insert(str);				
			break;
	case 'F':
	case 'f': 
			table.get(5).insert(str);				
			break;
	case 'G':
	case 'g': 
			table.get(6).insert(str);				
			break;
	case 'H':
	case 'h': 
			table.get(7).insert(str);				
			break;
	case 'I':
	case 'i': 
			table.get(8).insert(str);				
			break;
	case 'J':
	case 'j': 
			table.get(9).insert(str);				
			break;
	case 'K':
	case 'k': 
			table.get(10).insert(str);				
			break;
	case 'L':
	case 'l': 
			table.get(11).insert(str);				
			break;
	case 'M':
	case 'm': 
			table.get(12).insert(str);				
			break;
	case 'N':
	case 'n': 
			table.get(13).insert(str);				
			break;
	case 'O':
	case 'o': 
			table.get(14).insert(str);				
			break;
	case 'P':
	case 'p': 
			table.get(15).insert(str);				
			break;
	case 'Q':
	case 'q': 
			table.get(16).insert(str);				
			break;
	case 'R':
	case 'r': 
			table.get(17).insert(str);				
			break;
	case 'S':
	case 's': 
			table.get(18).insert(str);				
			break;
	case 'T':
	case 't': 
			table.get(19).insert(str);				
			break;
	case 'U':
	case 'u': 
			table.get(20).insert(str);				
			break;
	case 'V':
	case 'v': 
			table.get(21).insert(str);				
			break;
	case 'W':
	case 'w': 
			table.get(22).insert(str);				
			break;
	case 'X':
	case 'x': 
			table.get(23).insert(str);				
			break;
	case 'Y':
	case 'y': 
			table.get(24).insert(str);				
			break;
	case 'Z':
	case 'z': 
			table.get(25).insert(str);				
			break;
}//end switch 
**/
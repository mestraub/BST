package proj2;


public class BinarySearchTree<AnyType extends Comparable <? super AnyType>> {

	/**
	 * need these functions:
	 * 	insert
	 * 	printRoot
	 * 	printTree
	 * 
	 * 	void findCommonAncestor(AnyType x, AnyType y)
	 */
	
	private BinaryNode<AnyType> root;
	// used to count nodes as they are inserted into a tree
	private int count;
	
	/**
	 * A constructor method for the BinarySearchTree class that sets
	 * the root to null, and count to 0.
	 */
	public BinarySearchTree(){		
		root = null;
		count = 0; // if there are no nodes there is nothing to count
	}//end BinarySearchTree()
	
	/**
	 * This creates an empty BinarySearchTree.
	 */
	public void createEmpty(){
		root = null;
		count = 0;
	}//end createEmpty()
	
	/**
	 * This determines whether the BinarySearchTree is empty or not.
	 * 
	 * @return if root is null the tree is empty, otherwise it is full
	 */
	public boolean isEmpty(){
		return root == null;
	}//end isEmpty()
	
	/**
	 * Inserts an item into the BinarySearchTree.
	 * 
	 * @param x the item to insert
	 */
	public void insert(AnyType x){
		root = insert(x,root);
		
		/*
		if (contains(x)){
			;
		}	
		else{
			root = insert (x, root);
			count++;
		}*/
	}
	
	/**
	 * An internal method that inserts an item into a subtree.
	 * 
	 * @param x the item to insert
	 * @param t the node that roots the subtree
	 * @return the new root of the subtree
	 */
	private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t){
		if ( t == null){
			count++;
			return new BinaryNode<AnyType>(x, null, null);
		}			
		
		int compareResult = x.compareTo(t.getData());
		
		if (compareResult < 0)
			t.left = insert(x, t.getLeft());
		else if (compareResult > 0)
			t.right = insert(x,t.getRight());
		else if (contains(x)){
			;
		}
			 // duplicate find out what to do		
		return t;		
	}//end insert()
	
	/**
	 * Prints the root.
	 */
	public void printRoot(){
		System.out.print(root.getData());
	}//end printRoot()
	
	/**
	 * Prints the BinarySearchTree.
	 */
	public void printTree(){
		if (isEmpty())
				System.out.println("Empty Tree");
		else
			printTree(root);
	}//end printTree()
	
	/**
	 * An internal method that prints the tree in inorder traversal.
	 * 
	 * @param t the node that roots the subtree
	 */
	private void printTree(BinaryNode<AnyType> t){
		if( t != null){
			
			printTree(t.getLeft());
			System.out.println(t.getData());
			printTree(t.getRight());
		}
	}//end printTree()
	
	public boolean contains (AnyType x){
		return contains(x, root);
	}
	
	private boolean contains (AnyType x, BinaryNode<AnyType> t){
		if (t == null)
			return false;
		
		int compareResult = x.compareTo(t.getData());
		
		if(compareResult < 0)
			return contains(x, t.getLeft());
		else if (compareResult > 0)
			return contains (x, t.getRight());
		else
			return true; // Match
	}
	
	
	/**
	 * This gets the counter for the number of items in the BinarySearchTree.
	 * 
	 * @return the number of items in the BinarySearchTree
	 */
	public int count(){
		return count;
	}//end count()
	
	/**
	 * 
	 * @param data
	 */
	public void findCommonAncestor(AnyType x, AnyType y){
		System.out.println("The results of the common ancestor is:");
		
		if ( root == null){
			System.out.println("Empty tree");
		}
		
		int compareResult = x.compareTo(y);	
	}
	
	
	private static class BinaryNode<AnyType>{
		// page 113
		AnyType data; // the data in the node
		BinaryNode<AnyType> left; // left child
		BinaryNode<AnyType> right; // right child
		
		/**
		 * The constructor for the BinaryNode class.
		 */
		public BinaryNode(AnyType theNode){
			this(theNode,null,null);
		}//end BinaryNode()
		
		/**
		 * A second constructor for the BinaryNode class.
		 * 
		 * @param theNode the data in the node
		 * @param leftNode the left child
		 * @param rightNode the right child
		 */
		public BinaryNode(AnyType theNode, BinaryNode<AnyType> leftNode, BinaryNode<AnyType> rightNode){
			data = theNode;
			left = leftNode;
			right = rightNode;
		}//end BinaryNode()
		
		public AnyType getData(){
			return data;
		}
		
		/**
		 * 
		 */
		public BinaryNode<AnyType> getLeft(){
			return left;
		}
		
		/**
		 * 
		 */
		public BinaryNode<AnyType> getRight(){
			return right;
		}
		
		/**
		 * 
		 */
	    public void setLeft(AnyType data){
	        left.data = data;
	    }
	    
	    /**
	     * 
	     */
	    public void setRight(AnyType data){
	        right.data = data;
	    }
		
	}//end BinaryNode class
}//end BinarySearchTree class

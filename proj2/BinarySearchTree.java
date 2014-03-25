package proj2;

/**
 * This class is the generic BinarySearchTree class used in HashedBSTs. 
 * BinarySearchTree contains a private class called BinaryNode which is the nodes of the 
 * binary search tree. 
 * 
 * @version 03/21/14
 * @author Megan Straub <mstraub1@umbc.edu>
 * CMSC 341 - Spring 2014 - Project 2
 * Section 4
 *
 */

public class BinarySearchTree<AnyType extends Comparable <? super AnyType>> {
	
	/**
	 * The root node of a binary search tree.
	 */
	private BinaryNode<AnyType> root;
	
	/**
	 * The counter for number of nodes in a binary search tree.
	 */
	private int count;
	
	/**
	 * A constructor method for the BinarySearchTree class that sets
	 * the root to null, and count to 0 (there are no nodes).
	 */
	public BinarySearchTree(){		
		root = null;
		count = 0; 
	}
	
	/**
	 * This creates an empty BinarySearchTree.
	 */
	public void createEmpty(){
		root = null;
		count = 0;
	}
	
	/**
	 * This determines whether the BinarySearchTree is empty or not.
	 * 
	 * @return if root is null the tree is empty, otherwise it is full
	 */
	public boolean isEmpty(){
		return root == null;
	}
	
	/**
	 * Inserts an item into the BinarySearchTree.
	 * 
	 * @param x the item to insert
	 */
	public void insert(AnyType x){
		root = insert(x,root);
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
		else{
			Node n = (Node)t.getData();
			n.incrementFrequency();
			t.setData((AnyType)n);
		}	
		return t;		
	}
	
	/**
	 * Prints the root.
	 */
	public void printRoot(){
		System.out.print(root.getData());
	}
	
	/**
	 * Prints the binary search tree.
	 */
	public void printTree(){
		if (isEmpty())
				System.out.println("Empty Tree");
		else
			printTree(root);
	}
	
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
	}
	
	/**
	 * This gets the counter for the number of nodes in a binary search tree.
	 * 
	 * @return the number of nodes in a binary search tree
	 */
	public int count(){
		return count;
	}
	
	/**
	 * This finds the lowest common ancestor of two items in a binary search tree.
	 * 
	 * @param x the first item being compared
	 * @param y the second item being compared
	 */
	public void findCommonAncestor(AnyType x, AnyType y){
		System.out.println("The results of the common ancestor is: \n" + findNode(x) + " and " + findNode(y));
		System.out.println("is: " + findCommonAncestor(root, x, y).getData());
	}
	
	/**
	 * An internal method to find the lowest common ancestor between two items.
	 * 
	 * @param t the root of a node
	 * @param x the first item being compared
	 * @param y the second item being compared
	 * @return the new root of a subtree
	 */
	private BinaryNode<AnyType> findCommonAncestor(BinaryNode<AnyType> t, AnyType x, AnyType y){
		if (t == null)
			return null;
		if(t.getData().compareTo(x) > 0 && t.getData().compareTo(y) > 0)
			return findCommonAncestor(t.left, x, y);
		else if (t.getData().compareTo(x) < 0 && t.getData().compareTo(y) < 0)
			return findCommonAncestor(t.right, x, y);
		else
			return t;	
	}
	
	/**
	 * This finds a specific node within the binary search tree.
	 * 
	 * @param x the node being found
	 * @return the actual node that was found
	 */
	public AnyType findNode(AnyType x){
		return findNode(x, root);
	}
	
	/**
	 * An internal method that finds a node within a binary search tree.
	 * 
	 * @param x
	 * @param t
	 * @return 
	 */
	private AnyType findNode(AnyType x, BinaryNode<AnyType> t){
		if (t ==  null)
			return null;
		else if (t.getData().compareTo(x) > 0)
			return findNode(x, t.left);
		else if (t.getData().compareTo(x) < 0)
			return findNode(x, t.right);
		else
			return t.getData();
	}
	
	/**
	 * This method finds all items that are similar to the parameter x.
	 * 
	 * @param x the item being compared with nodes in a tree
	 */
	public void findAll(AnyType x){
		findAll(x, root);
	}
	
	/**
	 * An internal method that compares x to the node t and sees
	 * if the two are similar. If the two items are similar the method
	 * will print the information of that node.
	 * 
	 * @param x the item nodes are compared to
	 * @param t the node being compared
	 */
	private void findAll(AnyType x, BinaryNode<AnyType> t){
		
		if (t == null){
			System.out.print("");
		}else if (((Node)t.getData()).startsWith(x)){	
			
			System.out.println(t.getData());

			findAll(x, t.left);
			findAll(x, t.right);
	
		}else if (t.getData().compareTo(x) > 0){
			findAll(x, t.left);		 
		}else if (t.getData().compareTo(x) < 0){
			findAll(x, t.right);
		}
	}

	/**
	 * A private class that deals with the nodes in the
	 * binary search tree.
	 */
	private static class BinaryNode<AnyType>{
		/**
		 * The data in the node.
		 */
		private AnyType data; 
		
		/**
		 * The left child of a node.
		 */
		private BinaryNode<AnyType> left;
		
		/**
		 * The right child of a node.
		 */
		private BinaryNode<AnyType> right;
		
		/**
		 * The constructor for the BinaryNode class.
		 * 
		 * @param theNode the node being created
		 */
		public BinaryNode(AnyType theNode){
			this(theNode,null,null);
		}
		
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
		}
		
		/**
		 * Retrieves data of the root.
		 * 
		 * @return the data of the root
		 */
		private AnyType getData(){
			return data;
		}
		
		/**
		 * This sets the data in the Node.
		 * 
		 * @param data the information being set
		 */
		private void setData(AnyType data){
			this.data = data;
		}
		
		/**
		 * Retrieves the left child.
		 * 
		 * @return the child being retrieved
		 */
		private BinaryNode<AnyType> getLeft(){
			return left;
		}
		
		/**
		 * Retrieves the right child.
		 * 
		 * @return the child being retrieved
		 */
		private BinaryNode<AnyType> getRight(){
			return right;
		}
		
		/**
		 * This sets the left child data.
		 * 
		 * @param data the data being set
		 */
	    private void setLeft(AnyType data){
	        left.data = data;
	    }
	    
	    /**
	     * This sets the right child data.
	     * 
	     * @param data the data being set
	     */
	    private void setRight(AnyType data){
	        right.data = data;
	    }
		
	}
}
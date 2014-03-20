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
	
	/**
	 * 
	 */
	public BinarySearchTree(){
		root = null;
	}
	
	public void createEmpty(){
		root = null;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	
	
	/**
	 * 
	 */
	public void insert(AnyType x){
		root = insert (x, root);
	}
	
	public BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t){
		if ( t == null)
			return new BinaryNode<AnyType>(x, null, null);
		
		int compareResult = x.compareTo(t.getData());
		
		if (compareResult < 0)
			t.left = insert(x, t.getLeft());
		else if (compareResult > 0)
			t.right = insert(x,t.getRight());
		else
			; // duplicate find out what to do
		
		return t;
		
	}
	
	/**
	 * 
	 */
	public void printRoot(){
		System.out.println(root.getData());
	}
	
	/**
	 * 
	 */
	public void printTree(){
		if (isEmpty())
				System.out.println("Empty Tree");
		else
			printTree(root);
	}
	
	public void printTree(BinaryNode<AnyType> t){
		if( t != null){
			printTree(t.left);
			System.out.println(t.data);
			printTree(t.right);
		}
	}
	
	private static class BinaryNode<AnyType>{
		// page 113
		AnyType data; // the data in the node
		BinaryNode<AnyType> left; // left child
		BinaryNode<AnyType> right; // right child
		//int frequency;
		
		/**
		 * 
		 */
		public BinaryNode(AnyType theNode){
			this(theNode,null,null);
		}
		
		/**
		 * 
		 */
		public BinaryNode(AnyType theNode, BinaryNode<AnyType> leftNode, BinaryNode<AnyType> rightNode){
			data = theNode;
			left = leftNode;
			right = rightNode;
		}
		
		public AnyType getData(){
			return data;
		}
		
		public BinaryNode<AnyType> getLeft(){
			return left;
		}
		
		public BinaryNode<AnyType> getRight(){
			return right;
		}
		
	    public void setLeft(AnyType data)
	    {
	        left.data = data;
	    }

	    public void setRight(AnyType data)
	    {
	        right.data = data;
	    }
		
	}// end binarynode class
	
}

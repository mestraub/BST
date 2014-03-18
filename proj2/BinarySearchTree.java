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
	
	public BinaryNode<AnyType> (AnyType x, BinaryNode<AnyType> t){
		if ( t == null)
			return new BinaryNode<>(x, null, null);
		
		int compareResult = x.compareTo(t.data);
		
		if (compareResult < 0)
			t.left = insert (x, t.left);
		else if (compareResult > 0)
			t.right = insert (x, t.right);
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
		
	}
	
	private static class BinaryNode<AnyType>{
		// page 113
		AnyType data; // the data in the node
		BinaryNode<AnyType> left; // left child
		BinaryNode<AnyType> right; // right child
		
		/**
		 * 
		 */
		BinaryNode(AnyType theNode){
			this(theNode,null,null);
		}
		
		/**
		 * 
		 */
		BinaryNode(AnyType theNode, BinaryNode<AnyType> leftNode, BinaryNode<AnyType> rightNode){
			data = theNode;
			left = leftNode;
			right = rightNode;
		}
		
		AnyType getData(){
			return data;
		}
		
	}// end binarynode class
	
}

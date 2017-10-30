package trees;

public class BSTNode<T extends Comparable<T>> {

	private T info;				//Node content
	private BSTNode<T> left;	//Left child node
	private BSTNode<T> right;	//Right child node
	
	
	public BSTNode(T info){
		if(info!=null) {
			this.info=info;
			this.left=null;
			this.right=null;
		}	
	}
	
	
	/**
	 * @return  info, Node content
	 */
	public T getInfo() {
		return info;
	}


	/**
	 * @param info, Set the node information
	 */
	public void setInfo(T info) {
		this.info = info;
	}

	/**
	 * @return Left child node
	 */
	public BSTNode<T> getLeft() {
		return left;
	}

	/**
	 * @param left, Set the left child node
	 */
	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}

	/**
	 * @return Right child node
	 */
	public BSTNode<T> getRight() {
		return right;
	}

	/**
	 * @param right, Set the right child node 
	 */
	public void setRight(BSTNode<T> right) {
		this.right = right;
	}

	/**
	 * @return Node content string
	 */
	public String toString() {
		return info.toString();
		
	}
	

}

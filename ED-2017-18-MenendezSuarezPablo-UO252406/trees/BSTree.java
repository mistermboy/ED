package trees;

public class BSTree<T extends Comparable<T>>{

	private BSTNode<T> raiz;
	
	
	public BSTree() {
		raiz = null;
	}
	
	
	
	//################# C O M E N T A R     T O D O ################################
	
	
	public boolean addNode(T element) {
		if (element != null) {
			if (raiz == null) {
				raiz = new BSTNode<T>(element);
				return true;
			} else {
				return addNodeRec(raiz, element);
			}
		}
		return false;

	}
	
	
	public boolean addNodeRec(BSTNode<T> theRoot, T element) {

		if (theRoot.getInfo().compareTo(element) == 0) {
			return false;
		} else if (theRoot.getInfo().compareTo(element) > 0) {
			if (theRoot.getLeft() == null) {
				theRoot.setLeft(new BSTNode<T>(element));
				return true;
			} else {
				return addNodeRec(theRoot.getLeft(), element);
			}
		} else if (theRoot.getInfo().compareTo(element) < 0) {
			if (theRoot.getRight() == null) {
				theRoot.setRight(new BSTNode<T>(element));
				return true;
			} else {
				return addNodeRec(theRoot.getRight(), element);
			}
		}
		return false;

	}
	
	
	
	public BSTNode<T> findNode(T element) {
		if(element!=null) {
			if(raiz == element) {
				return raiz;
			}else {
				return findNodeRec(raiz, element);
			}
			
		}		
		return null;
	}
	
	
	private BSTNode<T> findNodeRec(BSTNode<T> theRoot, T element){
		if(theRoot == null) {
			return null;
		}else if(theRoot.getInfo().compareTo(element) > 0) {
			return findNodeRec(theRoot.getLeft(),element);
		}else if(theRoot.getInfo().compareTo(element) < 0) {
			return findNodeRec(theRoot.getRight(),element);
		}else if(theRoot.getInfo().compareTo(element) == 0) {
			return theRoot;
		}
		return null;
	}
	
	
	
	
	public String preOrder() {
		return preOrderRec(raiz).substring(0,preOrderRec(raiz).length()-1);
	}

	private String preOrderRec(BSTNode<T> theRoot) {
		String pre = "";
		if (theRoot != null) {
			pre += theRoot.toString() + "\t";
			pre += preOrderRec(theRoot.getLeft());
			pre += preOrderRec(theRoot.getRight());

		}
		return pre;
	}

	public String postOrder() {
		return postOrderRec(raiz).substring(0,postOrderRec(raiz).length()-1);
	}

	private String postOrderRec(BSTNode<T> theRoot) {
		String post = "";
		if (theRoot != null) {
			post += postOrderRec(theRoot.getLeft());
			post += postOrderRec(theRoot.getRight());
			post += theRoot.toString() + "\t";

		}
		return post;
	}

	public String inOrder() {
		return inOrderRec(raiz).substring(0,inOrderRec(raiz).length()-1);
	}

	private String inOrderRec(BSTNode<T> theRoot) {
		String in = "";
		if (theRoot != null) {
			in += inOrderRec(theRoot.getLeft());
			in += theRoot.toString() + "\t";
			in += inOrderRec(theRoot.getRight());

		}
		return in;
	}
	
	
}

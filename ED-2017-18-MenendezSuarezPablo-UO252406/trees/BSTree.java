package trees;

public class BSTree<T extends Comparable<T>> {

	private BSTNode<T> raiz;

	private boolean remove;

	public BSTree() {
		raiz = null;
	}

	/**
	 * Add a node into the binary tree
	 * 
	 * @param element,
	 *            node to add
	 * @return true if it was added correctly, false otherwise
	 */
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

	/**
	 * Looks for the node that is indicated
	 * 
	 * @param element,
	 *            searched node
	 * @return searched node if it find it, null otherwise
	 */
	public BSTNode<T> findNode(T element) {
		if (element != null) {
			if (raiz == element) {
				return raiz;
			} else {
				return findNodeRec(raiz, element);
			}

		}
		return null;
	}

	private BSTNode<T> findNodeRec(BSTNode<T> theRoot, T element) {
		if (theRoot == null) {
			return null;
		} else if (theRoot.getInfo().compareTo(element) > 0) {
			return findNodeRec(theRoot.getLeft(), element);
		} else if (theRoot.getInfo().compareTo(element) < 0) {
			return findNodeRec(theRoot.getRight(), element);
		} else if (theRoot.getInfo().compareTo(element) == 0) {
			return theRoot;
		}
		return null;
	}

	/**
	 * @return the route in pre-order
	 */
	public String preOrder() {
		return preOrderRec(raiz).substring(0, preOrderRec(raiz).length() - 1);

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

	/**
	 * @return the route in post-order
	 */
	public String postOrder() {
		return postOrderRec(raiz).substring(0, postOrderRec(raiz).length() - 1);
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

	/**
	 * @return the route in in-order
	 */
	public String inOrder() {
		return inOrderRec(raiz).substring(0, inOrderRec(raiz).length() - 1);
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

	/**
	 * Remove the node that is indicated
	 * 
	 * @param element,
	 *            node to add
	 * @return true if it was removed correctly, false otherwise
	 */
	public boolean removeNode(T x) {
		if (x != null) {
			if (findNode(x) != null) {
				remove = false;
				raiz = removeNodeRec(raiz, x);
				return remove;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private BSTNode<T> removeNodeRec(BSTNode<T> theRoot, T element) {
		if (theRoot == null)
			throw new RuntimeException("element does not exist!");
		else if (element.compareTo(theRoot.getInfo()) < 0)
			theRoot.setLeft(removeNodeRec(theRoot.getLeft(), element));
		else if (element.compareTo(theRoot.getInfo()) > 0)
			theRoot.setRight(removeNodeRec(theRoot.getRight(), element));
		else {
			if (theRoot.getLeft() == null) {
				remove = true;
				return theRoot.getRight();
			} else if (theRoot.getRight() == null) {
				remove = true;
				return theRoot.getLeft();
			}

			else {
				theRoot.setInfo(getMax(theRoot.getLeft()));
				theRoot.setLeft(removeNodeRec(theRoot.getLeft(), theRoot.getInfo()));
				remove = true;
			}
		}
		return theRoot;
	}

	private T getMax(BSTNode<T> theRoot) {
		if (theRoot == null)
			return null;
		else if (theRoot.getRight() == null)
			return theRoot.getInfo();
		else
			return getMax(theRoot.getRight());
	}

}

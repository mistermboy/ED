package trees;

public class AVLTree<T extends Comparable<T>> {
	
	private AVLNode<T> raiz;
	
	
	public AVLTree() {
		raiz = null;
	}
	
	public AVLNode<T> getRaiz(){
		return raiz;
	}
	
	public T getInfoRaiz() {
		return raiz.getInfo();
	}
	
	
	/**
	 * Add a node into the AVL tree
	 * @param element, node to add 
	 * @return the root if it was added correctly, false otherwise
	 */
	public AVLNode<T> add(T element){
		if (element != null) {
			if (raiz == null) {
				raiz = new AVLNode<T>(element);
				return raiz; 
			} else {
				return addRec(raiz, element);
			}
		}
		return null;
	}
	
	
	private AVLNode<T> addRec(AVLNode<T> theRoot, T element) {
		if (theRoot == null)
			return new AVLNode<T>(element);
		else {
			if (theRoot.getInfo().compareTo(element) > 0) {

				theRoot.setLeft(addRec(theRoot.getLeft(), element));
			} else if (theRoot.getInfo().compareTo(element) < 0) {

				theRoot.setRight(addRec(theRoot.getRight(), element));
			} else {
				theRoot.setInfo(element);
			}

			return (updateAndBalanceIfNecesary(theRoot));
		}
	}
	
	/**
	 * Perform the necessary rotations in the tree
	 * @param theRoot
	 * @return the new root
	 */
	private AVLNode<T> updateAndBalanceIfNecesary(AVLNode<T> theRoot) {
		theRoot.setFactorBalanceAltura();
		if (theRoot.getBF() == -2) {
			if (theRoot.getLeft().getBF() == -1)
				theRoot = singleLeftRotation(theRoot);
			else if (theRoot.getLeft().getBF() == 0) {
				theRoot = singleLeftRotation(theRoot);
			} else
				theRoot = doubleLeftRotation(theRoot);
		} else if (theRoot.getBF() == 2) {
			if (theRoot.getRight().getBF() == 1)
				theRoot = (singleRightRotation(theRoot));
			else if (theRoot.getRight().getBF() == 0) {
				theRoot = singleRightRotation(theRoot);
			} else
				theRoot = (doubleRightRotation(theRoot));
		}
		theRoot.setFactorBalanceAltura();
		return (theRoot);
	}
	
	
	/**
	 *	Method that performs a simple rotation to the left
	 * 
	 * @param node
	 * @return the new root
	 */
	private AVLNode<T> singleLeftRotation(AVLNode<T> node) {
		AVLNode<T> aux = node.getLeft();
		node.setLeft(aux.getRight());
		aux.setRight(node);
		node = aux;
		node.getRight().setFactorBalanceAltura();
		return node;
	}

	/**
	 *	Method that performs a double rotation to the left
	 * 
	 * @param node
	 * @return the new root
	 */
	private AVLNode<T> doubleLeftRotation(AVLNode<T> node) {
		AVLNode<T> aux = node.getLeft();
		AVLNode<T> aux1 = aux.getRight();
		aux.setRight(aux1.getLeft());
		aux1.setLeft(aux);
		node.setLeft(aux1.getRight());
		aux1.setRight(node);
		node = aux1;

		updateAndBalanceIfNecesary(node.getRight());
		updateAndBalanceIfNecesary(node.getLeft());

		return node;

	}

	/**
	 *	Method that performs a simple rotation to the right
	 * 
	 * @param node
	 * @return the new root
	 */
	private AVLNode<T> singleRightRotation(AVLNode<T> node) {
		AVLNode<T> aux = node.getRight();
		node.setRight(aux.getLeft());
		aux.setLeft(node);
		node = aux;
		node.getLeft().setFactorBalanceAltura();
		return node;
	}

	/**
	 *	Method that performs a double rotation to the right
	 * 
	 * @param node
	 * @return the new root
	 */
	private AVLNode<T> doubleRightRotation(AVLNode<T> node) {
		AVLNode<T> aux = node.getRight();
		AVLNode<T> aux1 = aux.getLeft();
		aux.setLeft(aux1.getRight());
		aux1.setRight(aux);
		node.setRight(aux1.getLeft());
		aux1.setLeft(node);
		node = aux1;

		updateAndBalanceIfNecesary(node.getRight());
		updateAndBalanceIfNecesary(node.getLeft());

		return node;
	}
	
	
}

package trees;

import java.util.ArrayList;
import java.util.List;

public class AVLTree<T extends Comparable<T>> {

	private AVLNode<T> raiz;

	private AVLNode<T> ascendiente;
	private int numAristas;
	private String camino;

	public AVLTree() {
		raiz = null;
	}

	/**
	 * Add a node into the AVL tree
	 * 
	 * @param element,
	 *            node to add
	 * @return the root if it was added correctly, false otherwise
	 */
	public AVLNode<T> add(T element) {
		if (element != null) {
			if (findNode(element) != null) {
				return null;
			}
			if (raiz == null) {
				raiz = new AVLNode<T>(element);
			} else {
				raiz = addRec(raiz, element);
			}
			return raiz;
		}
		return null;
	}

	private AVLNode<T> addRec(AVLNode<T> theRoot, T element) {
		if (theRoot == null)
			return new AVLNode<T>(element);
		else if (theRoot.getInfo().compareTo(element) == 0) {
			theRoot.setInfo(element);
		} else if (theRoot.getInfo().compareTo(element) > 0) {
			theRoot.setLeft(addRec(theRoot.getLeft(), element));
		} else if (theRoot.getInfo().compareTo(element) < 0) {
			theRoot.setRight(addRec(theRoot.getRight(), element));
		}
		return (updateTree(theRoot));
	}

	/**
	 * Perform the necessary rotations in the tree
	 * 
	 * @param theRoot
	 * @return the new root
	 */
	private AVLNode<T> updateTree(AVLNode<T> theRoot) {
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
	 * Looks for the node that is indicated
	 * 
	 * @param element,
	 *            searched node
	 * @return searched node if it find it, null otherwise
	 */
	public AVLNode<T> findNode(T element) {
		ascendiente = null;
		if (element != null) {
			if (raiz == element) {
				return raiz;
			} else {
				return findNodeRec(raiz, element);
			}

		}
		return null;
	}

	/**
	 * Looks for the node that is indicated from a origin node
	 * 
	 * @param source,
	 *            origin node
	 * @param element,
	 *            searched node
	 * @return searched node if it find it, null otherwise
	 */
	public AVLNode<T> findNodeFromOtherNode(T source, T element) {
		if (element != null && source != null) {
			AVLNode<T> theRoot = findNode(source);
			numAristas = 0;
			camino = "";
			if (theRoot != null) {
				if (theRoot == element) {
					return raiz;
				} else {
					return findNodeRec(theRoot, element);
				}
			}
		}
		return null;
	}

	private AVLNode<T> findNodeRec(AVLNode<T> theRoot, T element) {
		if (theRoot == null) {
			return null;
		} else if (theRoot.getInfo().compareTo(element) > 0) {
			numAristas++;
			camino += theRoot.toString() + "\t";
			ascendiente = theRoot;
			return findNodeRec(theRoot.getLeft(), element);
		} else if (theRoot.getInfo().compareTo(element) < 0) {
			numAristas++;
			camino += theRoot.toString() + "\t";
			ascendiente = theRoot;
			return findNodeRec(theRoot.getRight(), element);
		} else if (theRoot.getInfo().compareTo(element) == 0) {
			camino += theRoot.toString() + "\t";
			return theRoot;
		}
		return null;
	}

	/**
	 * Removes a node from the tree
	 * 
	 * @param info,
	 *            the node that you want to remove
	 * @return the node that is erased
	 */
	public AVLNode<T> removeNode(T info) {
		if (info == null)
			return null;
		else
			try {
				raiz = removeNodeRec(raiz, info);
			} catch (RuntimeException e) {
				return null;
			}
		return raiz;
	}

	private AVLNode<T> removeNodeRec(AVLNode<T> theRoot, T info) {
		if (theRoot == null)
			throw new RuntimeException("El elemento no existe");
		else if (info.compareTo(theRoot.getInfo()) < 0)
			theRoot.setLeft(removeNodeRec(theRoot.getLeft(), info));
		else if (info.compareTo(theRoot.getInfo()) > 0)
			theRoot.setRight(removeNodeRec(theRoot.getRight(), info));
		else {
			if (theRoot.getLeft() == null)
				return theRoot.getRight();
			else {
				if (theRoot.getRight() == null)
					return theRoot.getLeft();
				else
					theRoot.setInfo(getMax(theRoot.getLeft()));
				theRoot.setLeft(removeNodeRec(theRoot.getLeft(), theRoot.getInfo()));
			}
		}
		return (updateTree(theRoot));
	}

	/**
	 * Returns if one node is direct ancestor of another
	 * 
	 * @param padre
	 * @param hijo
	 * @return true if it´s direct ancestor, false otherwise
	 */
	public boolean esAscendienteDirecto(T padre, T hijo) {
		if (padre != null && hijo != null) {
			findNode(hijo);
			return ascendiente.getInfo() == padre;
		}
		return false;
	}

	/**
	 * Returns the number of edges between one node and another. The origin node
	 * must always be over the destination node
	 * 
	 * @param a
	 * @param b
	 * @return number of edges between one node and another, 0 if the origin node
	 *         it´s not over the destination node or if the parameters are incorrect
	 */
	public int nunAristas(T a, T b) {
		if (a != null && b != null) {
			if (findNodeFromOtherNode(a, b) != null) {
				return numAristas;
			} else {
				return 0;
			}
		}
		return 0;
	}

	/**
	 * Returns the path from one node to another.The origin node must always be over
	 * the destination node
	 * 
	 * @param a,
	 *            origin node
	 * @param b,
	 *            destination node
	 * @return the path if it exist, "No existe camino" otherwise
	 */
	public String camino(T a, T b) {
		if (a != null && b != null) {
			if (findNodeFromOtherNode(a, b) != null) {
				return camino;
			} else {
				return "No existe camino";
			}
		}
		return "No existe camino";
	}

	/**
	 * Method that performs a simple rotation to the left
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
	 * Method that performs a double rotation to the left
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

		updateTree(node.getRight());
		updateTree(node.getLeft());

		return node;

	}

	/**
	 * Method that performs a simple rotation to the right
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
	 * Method that performs a double rotation to the right
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

		updateTree(node.getRight());
		updateTree(node.getLeft());

		return node;
	}

	/**
	 * @return the root
	 */
	public AVLNode<T> getRaiz() {
		return raiz;
	}

	/**
	 * @return info of the root
	 */
	public T getInfoRaiz() {
		return raiz.getInfo();
	}

	private T getMax(AVLNode<T> theRoot) {
		if (theRoot == null)
			return null;
		else if (theRoot.getRight() == null)
			return theRoot.getInfo();
		else
			return getMax(theRoot.getRight());
	}

	/**
	 * @return the route in pre-order
	 */
	public String preOrder() {
		return preOrderRec(raiz).substring(0, preOrderRec(raiz).length() - 1);

	}

	private String preOrderRec(AVLNode<T> theRoot) {
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

	private String postOrderRec(AVLNode<T> theRoot) {
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

	private String inOrderRec(AVLNode<T> theRoot) {
		String in = "";
		if (theRoot != null) {
			in += inOrderRec(theRoot.getLeft());
			in += theRoot.toString() + "\t";
			in += inOrderRec(theRoot.getRight());

		}
		return in;
	}

	
	// ~################################################  Posibles métodos de examen   ##################################################
	
	public AVLTree<T> clone() {
		AVLTree<T> copy = new AVLTree<T>();
		return clone(copy, this.getRaiz());
	}

	private AVLTree<T> clone(AVLTree<T> tree, AVLNode<T> root) {
		if (root != null) {
			tree.add(root.getInfo());
			clone(tree, root.getLeft());
			clone(tree, root.getRight());
		}
		return tree;
	}

	public AVLNode<T> join(AVLNode<T> tree) {
		if (tree != null) {
			AVLTree<T> joinTree = this.clone();
			return join(joinTree.getRaiz(), tree);
		}
		return null;

	}

	private AVLNode<T> join(AVLNode<T> theRoot1, AVLNode<T> theRoot2) {
		if (theRoot2 != null) {
			add(theRoot2.getInfo());
			join(theRoot1, theRoot2.getLeft());
			join(theRoot1, theRoot2.getRight());
		}
		return theRoot1;

	}

	public List<T> toList(AVLNode<T> tree) {
		List<T> list = new ArrayList<T>();
		return toList(tree, list);
	}

	private List<T> toList(AVLNode<T> root, List<T> list) {
		if (root != null) {
			list.add(root.getInfo());
			toList(root.getLeft(), list);
			toList(root.getRight(), list);
		}
		return list;
	}

	private boolean isInList(List<T> list, T element) {
		for (T t : list) {
			if (t == element) {
				return true;
			}
		}
		return false;
	}

	public AVLNode<T> difference(AVLNode<T> secondTree) {
		List<T> list1 = toList(this.raiz);
		List<T> list2 = toList(secondTree);
		AVLTree<T> diferent = new AVLTree<T>();
		for (T t : list1) {
			if (!isInList(list2, t)) {
				diferent.add(t);
			}
		}
		for (T t : list2) {
			if (!isInList(list1, t)) {
				diferent.add(t);
			}

		}
		return diferent.getRaiz();
	}

}

package arbolesUO252406;

import arbolesUO252406.AVLNode;

/**
 * Clase derivada de BSTree a�adiendo funcionalidad de AVL
 * 
 * @author UO252406
 * @version 2016-17
 */
public class AVLTree<T extends Comparable<T>> extends BSTree<T> {
	private int rotacionesSimplesIzquierda;
	private int rotacionesSimplesDerecha;
	private int rotacionesDoblesIzquierda;
	private int rotacionesDoblesDerecha;

	/**
	 * Constructor
	 */
	public AVLTree() {
		super();
	}

	/**
	 * M�todo add que a�ade un nodo al �rbol
	 * 
	 * @param info
	 *            , Nodo que se desea a�adir
	 * @return true si lo a�ade, false en caso contrario
	 */
	public boolean add(T info) {
		if (info == null)
			return false;
		else
			raiz = addRec((AVLNode<T>) raiz, info);

		return true;
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
	 * M�todo que actualiza los factores de balance de los mnodos
	 * 
	 * @param nodo
	 *            el �rbol que se quiere actualizar Height, BF y balancear
	 * @return ra�z del �rbol
	 */
	private AVLNode<T> updateAndBalanceIfNecesary(AVLNode<T> theRoot) {
		theRoot.updateHeight();
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
		theRoot.updateHeight();
		return (theRoot);
	}

	/**
	 * M�todo que realiza una rotaci�n simple hacia la izquierda
	 * 
	 * @param nodo
	 * @return ra�z del nuevo �rbol
	 */
	private AVLNode<T> singleLeftRotation(AVLNode<T> nodo) {
		rotacionesSimplesIzquierda += 1;
		AVLNode<T> aux = nodo.getLeft();
		nodo.setLeft(aux.getRight());
		aux.setRight(nodo);
		nodo = aux;
		nodo.getRight().updateHeight();
		return nodo;
	}

	/**
	 * M�todo que realiza una rotaci�n doble hacia la izquierda
	 * 
	 * @param nodo
	 * @return ra�z del nuevo �rbol
	 */
	private AVLNode<T> doubleLeftRotation(AVLNode<T> nodo) {
		rotacionesDoblesIzquierda += 1;
		AVLNode<T> aux = nodo.getLeft();
		AVLNode<T> aux1 = aux.getRight();
		aux.setRight(aux1.getLeft());
		aux1.setLeft(aux);
		nodo.setLeft(aux1.getRight());
		aux1.setRight(nodo);
		nodo = aux1;

		updateAndBalanceIfNecesary(nodo.getRight());
		updateAndBalanceIfNecesary(nodo.getLeft());

		return nodo;

	}

	/**
	 * M�todo que realiza una rotaci�n simple hacia la derecha
	 * 
	 * @param nodo
	 * @return ra�z del nuevo �rbol
	 */
	private AVLNode<T> singleRightRotation(AVLNode<T> nodo) {
		rotacionesSimplesDerecha += 1;
		AVLNode<T> aux = nodo.getRight();
		nodo.setRight(aux.getLeft());
		aux.setLeft(nodo);
		nodo = aux;
		nodo.getLeft().updateHeight();
		return nodo;
	}

	/**
	 * M�todo que realiza una rotaci�n doble hacia la derecha
	 * 
	 * @param nodo
	 * @return ra�z del nuevo �rbol
	 */
	private AVLNode<T> doubleRightRotation(AVLNode<T> nodo) {
		rotacionesDoblesDerecha += 1;
		AVLNode<T> aux = nodo.getRight();
		AVLNode<T> aux1 = aux.getLeft();
		aux.setLeft(aux1.getRight());
		aux1.setRight(aux);
		nodo.setRight(aux1.getLeft());
		aux1.setLeft(nodo);
		nodo = aux1;

		updateAndBalanceIfNecesary(nodo.getRight());
		updateAndBalanceIfNecesary(nodo.getLeft());

		return nodo;
	}

	/**
	 * M�todo remove que elimina un nodo del �rbol
	 * 
	 * @param nodo
	 *            que se desea eliminar
	 * @return true si lo elimina,false en caso contrario Si el elemento es null
	 *         o no existe devuelve false
	 */
	public boolean remove(T info) {
		if (info == null)
			return false;
		else
			try {
				raiz = removeRec((AVLNode<T>) raiz, info);
			} catch (RuntimeException e) {
				return false;
			}

		return true;
	}

	private BSTNode<T> removeRec(arbolesUO252406.AVLNode<T> theRoot, T element) {
		if (theRoot == null)
			throw new RuntimeException("El elemento no existe");
		else if (element.compareTo(theRoot.getInfo()) < 0)
			theRoot.setLeft(removeRec(theRoot.getLeft(), element));
		else if (element.compareTo(theRoot.getInfo()) > 0)
			theRoot.setRight(removeRec(theRoot.getRight(), element));
		else {
			if (theRoot.getLeft() == null)
				return theRoot.getRight();
			else {
				if (theRoot.getRight() == null)
					return theRoot.getLeft();
				else
					theRoot.setInfo(getMax(theRoot.getLeft()));
				theRoot.setLeft(removeRec(theRoot.getLeft(), theRoot.getInfo()));
			}
		}
		return (updateAndBalanceIfNecesary(theRoot));
	}

	/**
	 * @return n�mero de rotaciones simples hacia la izquierda que se realizan
	 */
	public int getRotacionesSimplesIzquierda() {
		return rotacionesSimplesIzquierda;
	}

	/**
	 * @return n�mero de rotaciones simples hacia la derecha que se realizan
	 */
	public int getRotacionesSimplesDerecha() {
		return rotacionesSimplesDerecha;
	}

	/**
	 * @return n�mero de rotaciones dobles hacia la izquierda que se realizan
	 */
	public int getRotacionesDoblesIzquierda() {
		return rotacionesDoblesIzquierda;
	}

	/**
	 * @return n�mero de rotaciones dobles hacia la derecha que se realizan
	 */
	public int getRotacionesDoblesDerecha() {
		return rotacionesDoblesDerecha;
	}

}

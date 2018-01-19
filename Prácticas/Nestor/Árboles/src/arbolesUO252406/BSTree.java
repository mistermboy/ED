package arbolesUO252406;

/**
 * @author Néstor
 * @version 2016-17
*/
public class BSTree <T extends Comparable<T>>{


	protected BSTNode<T> raiz;
	private boolean eliminar;
	private T search;

	
	/**
	 * @param x
	 *            El objeto comparable que tiene que insertar
	 * 
	 * @return verdadero cuando lo inserta o modifica (si existe sustituye la
	 *         información) falso cuando no lo hace
	 */
	public boolean add(T x) {
		if (x == null)
			return false;
		else
				this.addRecBST(raiz, x);
		return true;

	}

	protected BSTNode<T> addRecBST(BSTNode<T> theRoot, T element) {
		// Si la raiz es null lo inserta( CASO BASE )
		// O que sea igual que el nodo que quieres insertar (compareTo = 0)
		// Que sea mayor, recursividad por la derecha ( CASO GENERAL1 )
		// Que sea menor, recursividad por la izquierda ( CASO GENERAL2 )
		// Si el nodo existe se sustituye uno por otro
		if (raiz == null)
			raiz = new BSTNode<T>(element);
		else if (theRoot == null)
			return new BSTNode<T>(element);
		else if (theRoot.getInfo().compareTo(element) == 0) {
			theRoot.setInfo(element);
		} else if (theRoot.getInfo().compareTo(element) >0) {
			theRoot.setLeft(addRecBST(theRoot.getLeft(), element));
		} else
			theRoot.setRight(addRecBST(theRoot.getRight(), element));
		return theRoot;
	}
		 
		
	/**
	 * @param x
	 *            El objeto comparable que se busca
	 * @return El objeto que se busca (completo) si lo encuentra. (null) si no
	 *         lo encuentra
	 */
	public T search(T x) {
		if (x != null) {
			search = null;
			if (search(raiz, x)) {
				return search;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	private boolean search(BSTNode<T> theRoot, T element) {
		if (theRoot == null) {
			return false;
		} else if (element.compareTo(theRoot.getInfo()) == 0) {
			search = theRoot.getInfo();
			return true;
		} else if (element.compareTo(theRoot.getInfo()) < 0) {
			return search(theRoot.getLeft(), element);
		} else if (element.compareTo(theRoot.getInfo()) > 0) {
			return search(theRoot.getRight(), element);
		}
		return false;
	}

	/**
	 * Muestra por pantalla el recorrido en pre-orden (izquierda-derecha) y lo
	 * devuelve en un String (separados por tabuladores)
	 */
	public String preOrder() {
		return preOrder(raiz);
	}

	private String preOrder(BSTNode<T> theRoot) {
		String pre = "";
		if (theRoot != null) {
			pre += theRoot.toString() + "\t";
			pre += preOrder(theRoot.getLeft());
			pre += preOrder(theRoot.getRight());

		}
		return pre;
	}

	/**
	 * Muestra por pantalla el recorrido en post-orden (izquierda-derecha) y lo
	 * devuelve en un String (separados por tabuladores)
	 */
	public String postOrder() {
		return postOrder(raiz);
	}

	private String postOrder(BSTNode<T> theRoot) {
		String post = "";
		if (theRoot != null) {
			post += postOrder(theRoot.getLeft());
			post += postOrder(theRoot.getRight());
			post += theRoot.toString() + "\t";

		}
		return post;
	}

	/**
	 * Muestra por pantalla el recorrido en in-orden (izquierda-derecha) y lo
	 * devuelve en un String (separados por tabuladores)
	 */
	public String inOrder() {
		return inOrder(raiz);
	}

	private String inOrder(BSTNode<T> theRoot) {
		String in = "";
		if (theRoot != null) {
			in += inOrder(theRoot.getLeft());
			in += theRoot.toString() + "\t";
			in += inOrder(theRoot.getRight());

		}
		return in;
	}

	/**
	 * @param x
	 *            El objeto que se quiere borrar
	 * @return true si lo ha borrado, false en caso contrario (no existía)
	 */
	public boolean remove(T x) {
		if (x != null) {
			if (search(raiz, x)) {
				eliminar = false;
				raiz = remove(raiz, x);
				return eliminar;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private BSTNode<T> remove(BSTNode<T> theRoot, T element) {
		if (theRoot == null)
			throw new RuntimeException("element does not exist!");
		else if (element.compareTo(theRoot.getInfo()) < 0)
			theRoot.setLeft(remove(theRoot.getLeft(), element));
		else if (element.compareTo(theRoot.getInfo()) > 0)
			theRoot.setRight(remove(theRoot.getRight(), element));
		else {
			if (theRoot.getLeft() == null) {
				eliminar = true;
				return theRoot.getRight();
			} else if (theRoot.getRight() == null) {
				eliminar = true;
				return theRoot.getLeft();
			}

			else {
				theRoot.setInfo(getMax(theRoot.getLeft()));
				theRoot.setLeft(remove(theRoot.getLeft(), theRoot.getInfo()));
				eliminar = true;
			}
		}
		return theRoot;
	}

	protected T getMax(BSTNode<T> theRoot) {
		if (theRoot == null)
			return null;
		else if (theRoot.getRight() == null)
			return theRoot.getInfo();
		else
			return getMax(theRoot.getRight());
	}

	public String toString() {
		return tumbarArbol(raiz, 0);
	}

	/**
	 * Genera un String con el árbol "tumbado" (la raíz a la izquierda y las
	 * ramas hacia la derecha) Es un recorrido InOrden-derecha-izquierda,
	 * tabulando para mostrar los distintos niveles Utiliza el toString de la
	 * información almacenada
	 * 
	 * @param p
	 *            La raíz del árbol a mostrar tumbado
	 * @param esp
	 *            El espaciado en número de tabulaciones para indicar la
	 *            profundidad
	 * @return El String generado
	 */
	protected String tumbarArbol(BSTNode<T> p, int esp) {
		StringBuilder cadena = new StringBuilder();

		if (p != null) {
			cadena.append(tumbarArbol(p.getRight(), esp + 1));
			for (int i = 0; i < esp; i++)
				cadena.append("\t");
			cadena.append(p + "\n");
			cadena.append(tumbarArbol(p.getLeft(), esp + 1));
		}
		return cadena.toString();
	}
}


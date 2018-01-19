package arbolesUO252406;
/**
 * Clase derivada de BSTNode añadiendo funcionalidad de AVL
 * @author UO252406
 * @version 2016-17
 * 
 */
public class AVLNode<T extends Comparable<T>> extends BSTNode<T>  {
	/**
	 * Para almacenar al Factor de balance. Puede no existir y calcularse cada vez a partir de la altura de los hijos.
	 */
	public byte balanceFactor;
	/**
	 * Para almacenar la altura del árbol
	 */
	public int height;

	
	/**
	 * Llama al padre y añade la información propia
	 * @param info la información que se mete en el nuevo nodo
	 */
	public AVLNode(T info){
		super(info);
	}




	/**
	 * @return devuelve la altura del árbol del cual es raíz el nodo en cuestión
	 */
	public int getHeight() {
		return height;
	}




	/**
	 * @return Devuelve el factor de balance según equilibrio del árbol del cual es raíz
	 */
	public byte getBF() {
		return balanceFactor;
	}




	/**
	 * Actualiza la altura del nodo en el árbol utilizando la altura de los hijos
	 */
	protected void updateHeight() {
		// Si ambos hijos son null, la altura es 0
		if (getRight() == null && getLeft() == null) {
			height = 0;
			balanceFactor = 0;
			
			// Si el hijo de la izquierda es != null y el derecho es null
			// la altura se pone a 1 y se calcula la altura del hijo izquierdo
		} else if (getRight() != null && getLeft() == null) {
			height = getRight().getHeight() + 1;
			balanceFactor = (byte) height;
			// Idem solo que con el derecho
		} else if (getLeft() != null && getRight() == null) {
			height = getLeft().getHeight() + 1;
			balanceFactor = (byte) -height;
			// Se queda con el hijo que mayor altura tenga
		} else {
			if (getRight().getHeight() < getLeft().getHeight()) {
				height = getLeft().getHeight() + 1;

			} else {
				height = getRight().getHeight() + 1;

			}
			balanceFactor = (byte) (getRight().getHeight() - getLeft()
					.getHeight());
		}
	}
	

	
	/* (non-Javadoc)
	 * @see BSTNode#getLeft()
	 */
	public AVLNode<T> getLeft(){
		return (AVLNode<T>) super.getLeft();
	}
	
	private void setBalanceFactor(byte balanceFactor) {
		this.balanceFactor = balanceFactor;
	}




	/* (non-Javadoc)
	 * @see BSTNode#getRight()
	 */
	public AVLNode<T> getRight() {
		return (AVLNode<T>) super.getRight();
	}
	
// No se necesitan los setters, valen los heredados


	/* (non-Javadoc)
	 * @see BSTNode#toString()
	 * Añade factor de balance
	 */
	public String toString() {
		return super.toString()+":FB="+ getBF();
	}




	/**
	 * SetHeight
	 * @param height
	 */
	private void setHeight(int height) {
		this.height = height;
	}
	
	
	
}

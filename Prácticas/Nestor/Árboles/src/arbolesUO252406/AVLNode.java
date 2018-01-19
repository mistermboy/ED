package arbolesUO252406;
/**
 * Clase derivada de BSTNode a�adiendo funcionalidad de AVL
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
	 * Para almacenar la altura del �rbol
	 */
	public int height;

	
	/**
	 * Llama al padre y a�ade la informaci�n propia
	 * @param info la informaci�n que se mete en el nuevo nodo
	 */
	public AVLNode(T info){
		super(info);
	}




	/**
	 * @return devuelve la altura del �rbol del cual es ra�z el nodo en cuesti�n
	 */
	public int getHeight() {
		return height;
	}




	/**
	 * @return Devuelve el factor de balance seg�n equilibrio del �rbol del cual es ra�z
	 */
	public byte getBF() {
		return balanceFactor;
	}




	/**
	 * Actualiza la altura del nodo en el �rbol utilizando la altura de los hijos
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
	 * A�ade factor de balance
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

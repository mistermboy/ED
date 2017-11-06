package trees;

public class AVLNode<T extends Comparable<T>> {

	private T info;
	private AVLNode<T> left;
	private AVLNode<T> right;

	public int height; // Altura
	public int bF; // BalanceFactor

	public AVLNode(T info) {
		if (info != null) {
			this.info = info;
			this.left = null;
			this.right = null;
		}
	}

	/**
	 * Update the height of the node in the tree using the height of it´s children
	 */
	public void setFactorBalanceAltura() {
		// Si ambos hijos son null, la altura es 0
		if (getRight() == null && getLeft() == null) {
			height = 0;
			bF = 0;
			// Si el hijo de la izquierda es != null y el derecho es null
			// se actualiza la altura con la del hijo izquierdo + 1
		} else if (getRight() != null && getLeft() == null) {
			height = getRight().getHeight() + 1;
			bF = height;
			// Idem solo que con el derecho
		} else if (getLeft() != null && getRight() == null) {
			height = getLeft().getHeight() + 1;
			bF = -height;
			// Se queda con el hijo que mayor altura tenga
		} else {
			if (getRight().getHeight() < getLeft().getHeight()) {
				height = getLeft().getHeight() + 1;

			} else {
				height = getRight().getHeight() + 1;

			}
			bF = getRight().getHeight() - getLeft().getHeight();
		}

	}

	/**
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height,
	 *            height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return balanceFactor
	 */
	public int getBF() {
		return bF;
	}

	/**
	 * @param bf,
	 *            the balanceFactor to set
	 */
	public void setBF(int bF) {
		this.bF = bF;
	}

	/**
	 * @return info of the node
	 */
	public T getInfo() {
		return info;
	}

	/**
	 * @param info,
	 *            info to set
	 */
	public void setInfo(T info) {
		this.info = info;
	}

	/**
	 * @return the left soon
	 */
	public AVLNode<T> getLeft() {
		return left;
	}

	/**
	 * @param left
	 *            , the left soon to set
	 */
	public void setLeft(AVLNode<T> left) {
		this.left = left;
	}

	/**
	 * @return the right soon
	 */
	public AVLNode<T> getRight() {
		return right;
	}

	/**
	 * @param right
	 *            , the right soon to set
	 */
	public void setRight(AVLNode<T> right) {
		this.right = right;
	}

	/**
	 * @return toString
	 */
	public String toString() {
		return info.toString() + ":FB=" + getBF();
	}

}

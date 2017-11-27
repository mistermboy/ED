package hash;

public class HashNode<T> {

	private T info;
	private int estado;

	final static int BORRADO = -1;
	final static int VACIO = 0;
	final static int LLENO = 1;

	/**
	 * Constructor por defecto
	 */
	public HashNode() {
		this.info = null;
		this.estado = VACIO;
	}

	/**
	 * Incializar info y poner estado a lleno
	 * 
	 * @param info
	 */
	public HashNode(T info) {
		if (info != null) {
			this.info = info;
			this.estado = LLENO;
		}
	}

	/**
	 * Devuelve la info
	 * 
	 * @return
	 */
	public T getInfo() {
		return info;
	}

	/**
	 * Cambia la info por la que se le pasa
	 * 
	 * @param info
	 */
	public void setInfo(T info) {
		this.info = info;
		this.estado= LLENO;
	}

	/**
	 * Pone el estado a borrado
	 */
	public void borrar() {
		this.estado = BORRADO;
	}

	/**
	 * Devuelve el estado
	 * 
	 * @return
	 */
	public int getEstado() {
		return estado;
	}

}

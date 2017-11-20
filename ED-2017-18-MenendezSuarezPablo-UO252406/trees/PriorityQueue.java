package trees;

public interface PriorityQueue <T extends Comparable<T>>{

	/**
	 * Add an element to the priority queue and return true if you insert it and
	 * false otherwise
	 * @param elemento
	 * @return true if it insert it, false otherwise
	 */
	public boolean add(T elemento); //true si lo inserta, false si no cabe o ya existe
	
	/**
	 * Elimina el elemento con mayor prioridad de la cola de prioridad y
	 *	devuelve el elemento borrado si lo borrar o null en otro caso
	 * @return
	 */
	public T poll(); //Saca el primer elemento
	
	/**
	 * Elimina el elemento de la cola de prioridad y devuelve true si lo elimina y
	 *	false en otro caso
	 * @param elemento
	 * @return
	 */
	public boolean remove(T elemento); //true si lo borra, false si no existe o el monticulo está vacío...
	
	/**
	 * Devuleve true si la cola de prioridad está vacía y false el otro caso
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * Borrar todos los elementos de la cola de prioridad
	 */
	public void clear();
	
	/**
	 * Returns a string with the information of the heap
	 * @return String
	 */
	public String toString();
	
	
}

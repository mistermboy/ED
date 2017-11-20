package trees;

public class BinaryHeap<T extends Comparable<T>> implements PriorityQueue<T> {

	protected T[] monticulo;

	private int numElements;

	@SuppressWarnings("unchecked")
	public BinaryHeap(int n) {
		if (n > 0) {
			monticulo = (T[]) new Comparable[n];
			numElements = 0;
		}
	}

	@Override
	public boolean add(T elemento) {
		if (elemento == null || numElements == monticulo.length) {
			return false;
		}

		this.monticulo[numElements] = elemento;
		filtradoAscendente(this.numElements);
		this.numElements++;
		return true;
	}

	@Override
	public T poll() {
		T aux = null;
		if (!isEmpty()) {
			aux = monticulo[0];
			monticulo[0] = monticulo[numElements - 1];
			monticulo[numElements - 1] = null;
			numElements--;
			filtradoDescendente(0);
		}
		return aux;
	}

	@Override
	public boolean remove(T elemento) {
		if (elemento == null) {
			return false;
		}
		int index = find1(elemento);
		if (index >= 0) {
			monticulo[index] = monticulo[numElements - 1];
			// monticulo[numElements - 1] = null; Me parece que no es necesario
			numElements--;
			int posicionPadre = (index - 1) / 2;

			if (monticulo[index] != null) {

				if ((index - 1) / 2 >= 0 && monticulo[index].compareTo(monticulo[posicionPadre]) < 0) {
					filtradoAscendente(index);
					return true;
				}

				else {
					filtradoDescendente(index);
					return true;
				}

			} else
				return true;
		}
		return false;
	}

	private void filtradoAscendente(int i) {

		if (i != 0) {
			int pos = (i - 1) / 2;
			if (pos >= 0 && monticulo[i].compareTo(monticulo[pos]) < 0) {
				T aux = monticulo[i];
				monticulo[i] = monticulo[pos];
				monticulo[pos] = aux;
				filtradoAscendente(pos);
			}
		}

	}

	private void filtradoDescendente(int i) {
		if (i >= numElements) {
			return;
		}

		int hIzquierdo = (i * 2) + 1;
		int hDerecho = (i * 2) + 2;

		if (hDerecho < numElements) {
			if (monticulo[i].compareTo(monticulo[hIzquierdo]) <= 0
					&& monticulo[i].compareTo(monticulo[hDerecho]) <= 0) {
				return;
			}
			int hijoPequeño = monticulo[hIzquierdo].compareTo(monticulo[hDerecho]);

			if (hijoPequeño <= 0) {

				if (monticulo[i].compareTo(monticulo[hIzquierdo]) > 0) {
					T aux = monticulo[i];
					monticulo[i] = monticulo[hIzquierdo];
					monticulo[hIzquierdo] = aux;
					filtradoDescendente(hIzquierdo);
				}

			} else {

				if (monticulo[i].compareTo(monticulo[hDerecho]) > 0) {
					T aux = monticulo[i];
					monticulo[i] = monticulo[hDerecho];
					monticulo[hDerecho] = aux;
					filtradoDescendente(hDerecho);
				}
			}

		} else if (hIzquierdo < numElements) {
			if (monticulo[i].compareTo(monticulo[hIzquierdo]) < 0) {
				return;
			} else {
				T aux = monticulo[i];
				monticulo[i] = monticulo[hIzquierdo];
				monticulo[hIzquierdo] = aux;
				filtradoDescendente(hIzquierdo);

			}

		}

	}

	@Override
	public boolean isEmpty() {
		return numElements == 0;
	}

	@Override
	public void clear() {
		this.numElements = 0;
	}

	// @Override
	// public String toString() {
	// String cad = "";
	// for (int i = 0; i < numElements - 1; i++) {
	// cad += monticulo[i] + ",";
	// }
	// cad += monticulo[numElements - 1];
	// return cad;
	// }

	public String toString() {
		// Por ejemplo el árbol tumbado...
		StringBuilder cadena = new StringBuilder();
		cadena.append(inOrdenDerechaTabulado(0, 0));
		return cadena.toString();
	}

	// el árbol tumbado...
	private String inOrdenDerechaTabulado(int p, int esp) {
		String cadena = "";
		if (p < numElements) {
			int izq = Math.abs(2 * p + 1);
			int der = Math.abs(2 * p + 2);
			cadena += inOrdenDerechaTabulado(der, esp + 1);
			for (int i = 0; i < esp; i++)
				cadena += "\t";
			cadena += monticulo[p] + "\n";
			cadena += inOrdenDerechaTabulado(izq, esp + 1);
		}
		return cadena;
	}

	/**
	 * Devuelve la posición dentro del montículo del hijo menor del elemento que
	 * está en pos
	 * 
	 * @param pos
	 * @return
	 */
	public int hijomenor(int pos) {
		if (pos >= 0 && pos < numElements) {

			int hIzquierdo = (pos * 2) + 1;
			int hDerecho = (pos * 2) + 2;

			if (hIzquierdo <= numElements && hDerecho <= numElements) {

//				if (monticulo[hIzquierdo] == null && monticulo[hDerecho] == null) {
//					return -1;
//				} else if (monticulo[hIzquierdo] == null) {
//					return hDerecho;
//				} else if (monticulo[hDerecho] == null) {
//					return hIzquierdo;
//				} else if (monticulo[hIzquierdo].compareTo(monticulo[hDerecho]) < 0) {
//					return hIzquierdo;
//				} else {
//					return hDerecho;
//				}
				
				if(monticulo[hIzquierdo] == null) {
					return -1;
				}else {
					if (monticulo[hIzquierdo].compareTo(monticulo[hDerecho]) < 0) {
						return hIzquierdo;
					} else {
						return hDerecho;
					}
				}
				
				
			}
		}
		return -1;
	}

	/**
	 * Intercambia el contenido de las posiciones que se pasan como parámetro
	 * 
	 * @param pos1
	 * @param pos2
	 */
	private void intercambia(int pos1, int pos2) {

	}

	/**
	 * Devuelve la posición dentro del montículo donde se encuentra info
	 * 
	 * @param info
	 * @return posición en el montículo,en el caso de que encuentre el elemento, -1
	 *         si es null o no lo encuentra
	 */
	private int find1(T info) {
		if (info != null) {
			for (int i = 0; i < numElements; i++)
				if (monticulo[i].equals(info))
					return i;
		}
		return -1;
	}

	/**
	 * Devuelve la posición dentro del montículo donde se encuentra info pero a
	 * partir de una posición dada
	 * 
	 * @param info
	 * @param pos
	 * @return
	 */
	private int find2(T info, int pos) {
		for (int i = 0; i < numElements; i++)
			if (monticulo[i].equals(info))
				return i;
		return -1;
	}

}

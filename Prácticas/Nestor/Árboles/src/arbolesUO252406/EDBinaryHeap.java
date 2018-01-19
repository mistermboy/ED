package arbolesUO252406;

/**
 * @author UO252406
 * @version 2016-17
 * 
 */
public class EDBinaryHeap<T extends Comparable<T>> implements EDPriorityQueue<T>{
   protected T[] elementos;
	protected int numElementos;

	public EDBinaryHeap(int numMaxElementos) {

		elementos = (T[]) new Comparable[numMaxElementos];
		numElementos = 0;

	}

	@Override
	public boolean add(T info) {
		if (info == null || numElementos == elementos.length)
			return false;

		this.elementos[numElementos] = info;
		filtradoAscendente(this.numElementos);
		this.numElementos++;
		return true;

	}

	private void filtradoAscendente(int i) {

		if (i == 0)
			return;
		int pos = (i - 1) / 2;
		if (pos >= 0 && elementos[i].compareTo(elementos[pos]) < 0) {
			T aux = elementos[i];
			elementos[i] = elementos[pos];
			elementos[pos] = aux;

			filtradoAscendente(pos);
		}

	}

	/**
	 * devuelves la raiz, coges el último elemento, lo colocas en la raiz y le
	 * haces un filtrado descendente
	 */
	@Override
	public T poll() {
		T aux = null;
		if (!isEmpty()) {
			aux = elementos[0];
			elementos[0] = elementos[numElementos - 1];
			elementos[numElementos - 1] = null;
			numElementos--;
			filtradoDescendente(0);
		}
		return aux;

	}

	private void filtradoDescendente(int i) {
		if (i >= numElementos) {
			return;
		}

		int hIzquierdo = (i * 2) + 1;
		int hDerecho = (i * 2) + 2;

		if (hDerecho < numElementos) {
			if (elementos[i].compareTo(elementos[hIzquierdo]) <= 0
					&& elementos[i].compareTo(elementos[hDerecho]) <= 0) {
				return;
			}
			int hijoPequeño = elementos[hIzquierdo]
					.compareTo(elementos[hDerecho]);

			if (hijoPequeño <= 0) {

				if (elementos[i].compareTo(elementos[hIzquierdo]) > 0) {
					T aux = elementos[i];
					elementos[i] = elementos[hIzquierdo];
					elementos[hIzquierdo] = aux;
					filtradoDescendente(hIzquierdo);
				}

			} else {

				if (elementos[i].compareTo(elementos[hDerecho]) > 0) {
					T aux = elementos[i];
					elementos[i] = elementos[hDerecho];
					elementos[hDerecho] = aux;
					filtradoDescendente(hDerecho);
				}
			}

		} else if (hIzquierdo < numElementos) {
			if (elementos[i].compareTo(elementos[hIzquierdo]) < 0) {
				return;
			} else {
				T aux = elementos[i];
				elementos[i] = elementos[hIzquierdo];
				elementos[hIzquierdo] = aux;
				filtradoDescendente(hIzquierdo);

			}

		}
		

	}

	@Override
	public boolean remove(T info) {
		if (info == null) {
			return false;
		}
		int index = find(info);
		if (index >= 0) {
			elementos[index] = elementos[numElementos - 1];
			elementos[numElementos - 1] = null;
			numElementos--;
			int posicionPadre = (index - 1) / 2;

			if (elementos[index] != null) {

				if ((index - 1) / 2 >= 0
						&& elementos[index].compareTo(elementos[posicionPadre]) < 0) {
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

	private int find(T info) {
		for (int i = 0; i < numElementos; i++)
			if (elementos[i].equals(info))
				return i;
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return this.numElementos == 0;
	}

	@Override
	public void clear() {
		numElementos = 0;
		elementos = (T[]) new Comparable[elementos.length];

	}

	/**
	 * Devuelve una cadena con la información de los elementos que contiene el
	 * montículo en forma visible (recomendado inorden-derecha-izquierda
	 * tabulado)
	 */

	public String toString() {
		// Por ejemplo el árbol tumbado...
		StringBuilder cadena = new StringBuilder();
		cadena.append(inOrdenDerechaTabulado(0, 0));
		return cadena.toString();
	}

	// el árbol tumbado...
	private String inOrdenDerechaTabulado(int p, int esp) {
		String cadena = "";
		if (p < numElementos) {
			int izq = Math.abs(2 * p + 1);
			int der = Math.abs(2 * p + 2);
			cadena += inOrdenDerechaTabulado(der, esp + 1);
			for (int i = 0; i < esp; i++)
				cadena += "\t";
			cadena += elementos[p] + "\n";
			cadena += inOrdenDerechaTabulado(izq, esp + 1);
		}
		return cadena;
	}
	
}

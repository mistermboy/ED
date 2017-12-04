package hash;

import java.lang.reflect.Array;

import sun.security.action.GetBooleanAction;

public class ClosedHashTable<T extends Comparable<T>> extends AbstractHash<T> {

	private int numElementos;
	private HashNode<T>[] tabla; // Tabla hash
	private int tipoExploracion;

	private double minlf; // Factor de carga mínimo
	private double maxlf; // Factor de carga máximo

	public static final int B = 5;
	public static final double MINIMUN_LF = 0.16;
	public static final double MAXIMUN_LF = 0.5;
	public static final int TIPO_EXPLORACION = 2;

	@SuppressWarnings("unchecked")
	/**
	 * Constructor por defecto
	 */
	public ClosedHashTable() {
		this.numElementos = 0;
		this.tipoExploracion = TIPO_EXPLORACION;
		this.minlf = MINIMUN_LF;
		this.maxlf = MAXIMUN_LF;
		this.tabla = (HashNode<T>[]) Array.newInstance(HashNode.class, B);

		for (int i = 0; i < getB(); i++) {
			tabla[i] = new HashNode<T>();
		}
	}

	@SuppressWarnings("unchecked")
	/**
	 * Constructor con parámetros
	 * 
	 * @param tam
	 *            tamaño
	 * @param minlf
	 *            límite inferior
	 * @param maxlf
	 *            límite superior
	 * @param tipoExploracion
	 */
	public ClosedHashTable(int tam, int tipoExploracion, double minlf, double maxlf) {
		this.numElementos = 0;
		this.tipoExploracion = tipoExploracion;
		this.minlf = minlf;
		this.maxlf = maxlf;
		if (!esPrimo(tam))
			tam = numPrimoMayor(tam);
		this.tabla = (HashNode<T>[]) Array.newInstance(HashNode.class, tam);

		for (int i = 0; i < getB(); i++) {
			tabla[i] = new HashNode<T>();
		}

	}

	@Override
	protected int fHash(T info, int intentos) {
		if (tipoExploracion == 1) {
			return (obtenerClave(info) + intentos) % getB();
		} else if (tipoExploracion == 2) {
			return (obtenerClave(info) + intentos * intentos) % getB();
		} else if (tipoExploracion == 3) {
			return (obtenerClave(info) + intentos * ((numPrimoMenor(getB()) - obtenerClave(info)) % getB())) % getB();
		}
		return 0;
	}

	private int getB() {
		return tabla.length;
	}

	@Override
	public boolean add(T elem) {

		if (elem != null) {

			if (find(elem) == null) {

				// 1º Buscar el sitio --> usar fHash
				int aux = 0; // iteración
				int posicion = fHash(elem, 0);

				while (tabla[posicion].getEstado() == HashNode.LLENO && aux <= getB()) {
					posicion = fHash(elem, aux);
					aux++;
				}
				tabla[posicion].setInfo(elem);
				numElementos++;

				if (loadFactor() > maxlf) {
					reDispersion();
					// numRedis++;
				}

				return true;
			}
		}
		return false;
	}

	@Override
	public T find(T elem) {
		// Comprobación de que sea un null
		if (elem != null) {

			int aux = 0; // Iteración
			int posicion = fHash(elem, aux);
			int contador = 0;

			while (tabla[posicion].getEstado() != HashNode.VACIO && contador <= getB() && posicion >= 0) {
				if (tabla[posicion].getEstado() == HashNode.LLENO) {
					if (tabla[posicion].getInfo().equals(elem)) {
						return tabla[posicion].getInfo();
					}
				}
				posicion = fHash(elem, aux);
				aux++;
				contador++;
			}
		}
		return null;
	}

	@Override
	public boolean remove(T elem) {
		// Comprobación de que sea un null
		if (elem != null) { // (MONO)

			int aux = 0; // Iteración
			int posicion = fHash(elem, aux);
			int contador = 0;

			while (contador <= getB() && posicion >= 0 && tabla[posicion].getEstado() != HashNode.VACIO) {
				if (tabla[posicion].getEstado() == HashNode.LLENO) {
					if (tabla[posicion].getInfo().equals(elem)) {
						tabla[posicion].borrar();
						numElementos--;
						if (numElementos != 0) {
							if (loadFactor() < minlf) {
								inverseReDispersion();
								// numInvers++;
							}
						}
						return true;
					}
				}
				posicion = fHash(elem, aux);
				aux++;
				contador++;
			}

		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected boolean reDispersion() {
		// Se establece un número B para la nueva tabla buscando el número primo
		// inmediatamente superior al doble del original (TEORÍA)
		int newSize = numPrimoMayor(getB() * 2); // Next ptrimo

		// Copiamos la tabla a una auxiliar y copiamos a una variable el tamaño
		// original
		HashNode<T> newTable[] = tabla;
		int originalSize = getB();

		// Creamos la tabla original con el nuevo tamaño
		tabla = (HashNode<T>[]) Array.newInstance(HashNode.class, newSize);
		numElementos = 0;

		// Rellenamos la tabla con nodos
		for (int i = 0; i < newSize; i++) {
			tabla[i] = new HashNode<T>();
		}

		// Añadimos los elementos viejos a la nueva tabla
		for (int i = 0; i < originalSize; i++) {
			if (newTable[i].getEstado() == HashNode.LLENO)
				add(newTable[i].getInfo());
		}
		return true; // No hace falta que devuelva nada (Podemos utilizarlo para
						// saber si ha realizado la redispersión)
	}

	@Override
	protected boolean inverseReDispersion() {
		// Se establece un número B para la nueva tabla buscando el número primo
		// inferior a la mitad del original (TEORÍA)

		// SI B/2 ES PRIMO ME QUEDO CON EL
		int newSize; // Previous primo
		if (esPrimo(getB() / 2)) {
			newSize = getB() / 2;
		} else {
			newSize = numPrimoMenor(getB() / 2);
		}

		// Copiamos la tabla a una auxiliar y copiamos a una variable el tamaño
		// original
		HashNode<T> newTable[] = tabla;
		int originalSize = getB();

		// Creamos la tabla original con el nuevo tamaño
		tabla = (HashNode<T>[]) Array.newInstance(HashNode.class, newSize);
		numElementos = 0;

		// Rellenamos la tabla con nodos
		for (int i = 0; i < newSize; i++) {
			tabla[i] = new HashNode<T>();
		}

		// Añadimos los elementos viejos a la nueva tabla
		for (int i = 0; i < originalSize; i++) {
			if (newTable[i].getEstado() == HashNode.LLENO)
				add(newTable[i].getInfo());
		}
		return true; // No hace falta que devuelva nada (Podemos utilizarlo para
						// saber si ha realizado la redispersión)
	}

	@Override
	public String toString() {
		String cad = "";
		for (HashNode<T> node : tabla) {
			if (node == null || node.getEstado() == node.VACIO) {
				cad += "[_E_]-";
			} else if (node.getEstado() == node.BORRADO) {
				cad += "[_D_]-";
			} else if (node.getEstado() == node.LLENO) {
				cad += "[" + node.getInfo() + "]-";
			}

		}
		cad += "[Tam:" + getB() + " NElem:" + this.numElementos + "]";
		return cad;
	}

	/**
	 * Método para calcular el factor de carga
	 */
	public float loadFactor() {
		float fc = (float) numElementos / (float) getB();
		return fc;
	}

	public HashNode<T>[] getTable() {
		return tabla;
	}

	public int getNumElementos() {
		return numElementos;
	}

	public int getSize() {
		return tabla.length;
	}

}

package hashUO252406;

/**
 * @author UO252406
 * @version 2016-17
 *
 */
public class ClosedHashTable<T> extends AbstractHash<T> {
// IMPORTANTE
// No cambiar el nombre ni visibilidad de los atributos protected




	protected HashNode<T> associativeArray[];


	private int hashSize;	// Tamaño de la tabla, debe ser un número primo (B de teoría)
	private int numElementos;	// Número de elementos en la tabla en cada momento.


	static final byte LINEAL = 0;	// Tipo de exploración en caso de colisión, por defecto será LINEAL
	static final byte CUADRATICA = 1;

	
	private double fcUP;		
	private double fcDOWN;
	private byte expl;
	
	
	private int numRedis;
	private int numInvers;

	/**
	 * Constructor para fijar el tamaño, los factores de carga límite para redispersión y redispersión inversa
 *     y el tipo de exploración en las colisiones
	 * @param tam tamaño del Hash, si no es un número primo lo ajusta al primo superior
	 * @param fcUP Factor de carga límite, por encima del cual hay que redispersar (directa)
	 * @param fcDOWN Factor de carga límite, por debajo del cual hay que redispersar (inversa)
	 * @param expl tipo de exploración (LINEAL=0, CUADRATICA=1, ...), si inválido LINEAL
	 */
	@SuppressWarnings("unchecked")
	public ClosedHashTable(int tam, double fcUP, double fcDOWN, byte expl) {
		hashSize=isPrime(tam) ? tam : nextLargestPrimeNumber(tam); // Establece un tamaño válido
		
		associativeArray = (HashNode<T>[]) new HashNode[hashSize]; // Crea el array de HashNode's...Completar lo que falta…...
		//Array de referencias a HashNodes que están creados en añgún sitio
		for(int i = 0; i < hashSize; i++)
		{
			associativeArray[i] = new HashNode<T>();
		}

		this.fcUP=fcUP;
		this.fcDOWN=fcDOWN;
		if(expl==CUADRATICA){
			this.expl=CUADRATICA;
		}else{
			this.expl=LINEAL;
		}
		
		numElementos = 0;
				
	}


	/**
	 * Realiza la función de exploración en la tabla hash cuando hay colisión
	 * Dependiendo del caso, hará exploración lineal, cuadrática,...
	 *
	 * @param iter
	 *            iteración de la colisión
	 * @param elem
	 *            Elemento que causa la exploración
	 * @return Nueva posición según la exploración actual de la tabla
	 */
	protected int fExploracion(int iter, T elem) {
		// Devuelve solamente el índice
		// Todos los cálculos dentro del método

		// Cuadrática
		if (expl == CUADRATICA) { // REVISAR (MONO) POR SI CAMBIA LAS CONTANTES
			return (fHash(elem) + iter * iter) % hashSize;
		}
		// Si no, se hace la lineal por defecto
		else {
			return (fHash(elem) + iter) % hashSize;
		}

	}

	/**
	 * Método que devuelve el número de elementos de la tabla
	 * 
	 * @return int, número de elementos
	 */
	@Override
	public int getNumOfElems() {
		return numElementos;
	}

	/**
	 * Método que devuelve el tamaño de la tabla
	 * 
	 * @return int, tamaño de la tabla
	 */
	@Override
	public int getSize() {
		return hashSize;
	}
	
	/**
	 * Realiza una redispersión (aumentando el tamaño) al número primo mayor que el doble del tamaño actual, 
	 * y recolocando los elementos
	 * @return true al realizarla
	 */
	@Override
	protected boolean reDispersion() {

		// Se establece un número B para la nueva tabla buscando el número primo
		// inmediatamente superior al doble del original (TEORÍA)
		int newSize = nextLargestPrimeNumber(hashSize * 2); // Next ptrimo

		// Copiamos la tabla a una auxiliar y copiamos a una variable el tamaño
		// original
		HashNode<T> newTable[] = associativeArray;
		int originalSize = hashSize;

		// Creamos la tabla original con el nuevo tamaño
		associativeArray = new HashNode[newSize];
		numElementos = 0;
		hashSize = newSize;

		// Rellenamos la tabla con nodos
		for (int i = 0; i < newSize; i++) {
			associativeArray[i] = new HashNode<T>();
		}

		// Añadimos los elementos viejos a la nueva tabla
		for (int i = 0; i < originalSize; i++) {
			if (newTable[i].getEstado() == HashNode.LLENO)
				add(newTable[i].getInfo());
		}
		return true; // No hace falta que devuelva nada (Podemos utilizarlo para
						// saber si ha realizado la redispersión)
	}

	/**
	 * Realiza una redispersión inversa (disminuyendo el tamaño) al número primo menor que la mitad del tamaño actual, 
	 * y recolocando los elementos
	 * @return true al realizarla
	 */
	@Override
	protected boolean inverseReDispersion() {
		// Se establece un número B para la nueva tabla buscando el número primo
		// inferior a la mitad del original (TEORÍA)
		int newSize = previousSmallerPrimeNumber(hashSize / 2); // Next ptrimo

		// Copiamos la tabla a una auxiliar y copiamos a una variable el tamaño
		// original
		HashNode<T> newTable[] = associativeArray;
		int originalSize = hashSize;

		// Creamos la tabla original con el nuevo tamaño
		associativeArray = new HashNode[newSize];
		numElementos = 0;
		hashSize = newSize;

		// Rellenamos la tabla con nodos
		for (int i = 0; i < newSize; i++) {
			associativeArray[i] = new HashNode<T>();
		}

		// Añadimos los elementos viejos a la nueva tabla
		for (int i = 0; i < originalSize; i++) {
			if (newTable[i].getEstado() == HashNode.LLENO)
				add(newTable[i].getInfo());
		}
		return true; // No hace falta que devuelva nada (Podemos utilizarlo para
						// saber si ha realizado la redispersión)
	}

	/**
	 * Convierte la tabla a una String que se pueda mostrar de forma "visible"
	 *
	 * @return el String con la información de la tabla hash
	 */
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		for (int i = 0; i < getSize(); i++) {
			cadena.append(associativeArray[i]);
			cadena.append(";");
		}
		cadena.append("[Size: ");
		cadena.append(getSize());
		cadena.append(" Num.Elems.: ");
		cadena.append(getNumOfElems());
		cadena.append("]");
		return cadena.toString();
	}


	/**
	 * Inserta un nuevo elemento en la tabla hash 
	 *  
	 * @param elem Elemento que se inserta
	 * @return true si lo ha insertado o false en caso contrario
	 */
	@Override
	public boolean add(T elem) {
		// Comprobación de que sea un null
		if (elem != null) { 
			// 1º Buscar el sitio --> usar fExploracion 
			int posicion = fHash(elem);
			int aux = 0; // iteración


			while (associativeArray[posicion].getEstado() == HashNode.LLENO) {
				posicion = fExploracion(aux, elem);
				aux++;
			}
			associativeArray[posicion].setInfo(elem);
			numElementos++;

			if (getFC() > fcUP) {
				reDispersion();
				numRedis++;
			}
			
			return true;
		}
		return false;
	}



	/**
	 * Busca y devuelve un elemento de la tabla hash 
	 * 
	 * @param elem La clave que se busca,  
	 * @return El elemento encontrado si lo encuentra o null en caso contrario 
	 */
	@Override
	public T find(T elem) {
		// Comprobación de que sea un null
		if (elem != null) { 

			int posicion = fHash(elem);
			int aux = 0; // Iteración
			int contador = 0;

			while (associativeArray[posicion].getEstado() != HashNode.VACIO && contador <= getSize() && posicion >= 0) {
				if (associativeArray[posicion].getEstado() == HashNode.LLENO) {
					if (associativeArray[posicion].getInfo().equals(elem)) {
						return associativeArray[posicion].getInfo();
					}
				}
				posicion = fExploracion(aux, elem);
				aux++;
				contador++;
			}
		}
		return null;
	}


	/**
	 * Borra un elemento que se encuentra en la tabla hash
	 * 
	 * @param elem elemento para borrar
	 * @return true si lo ha borrado o false en caso contrario
	 */
	@Override
	public boolean remove(T elem) {
		// Comprobación de que sea un null
		if (elem != null) { // (MONO)

			int posicion = fHash(elem);
			int aux = 0; // Iteración
			int contador = 0;

			while (contador <= getSize() && posicion >= 0
					&& associativeArray[posicion].getEstado() != HashNode.VACIO) {
				if (associativeArray[posicion].getEstado() == HashNode.LLENO) {
					if (associativeArray[posicion].getInfo().equals(elem)) {
						associativeArray[posicion].borrar();
						numElementos--;
						if (numElementos != 0) {
							if (getFC() < fcDOWN) {
								inverseReDispersion();
								numInvers++;
							}
						}
						return true;
					}
				}
				posicion = fExploracion(aux, elem);
				aux++;
				contador++;
			}

		}
		return false;
	}

	/**
	 * Método para calcular el factor de carga
	 */
	public float getFC(){
		float fc=(float) numElementos / (float) hashSize;
		return fc;
	}
	
	/**
	 * Devuelve el valor fHash del elemento que se le pasa
	 */
	public int FH(T elem){
		return fHash(elem);
	}
	
	public int getNumInvers() {
		return numInvers;
	}
	
	public int getNumRedis() {
		return numRedis;
	}
}



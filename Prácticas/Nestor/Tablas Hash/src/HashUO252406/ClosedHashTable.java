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


	private int hashSize;	// Tama�o de la tabla, debe ser un n�mero primo (B de teor�a)
	private int numElementos;	// N�mero de elementos en la tabla en cada momento.


	static final byte LINEAL = 0;	// Tipo de exploraci�n en caso de colisi�n, por defecto ser� LINEAL
	static final byte CUADRATICA = 1;

	
	private double fcUP;		
	private double fcDOWN;
	private byte expl;
	
	
	private int numRedis;
	private int numInvers;

	/**
	 * Constructor para fijar el tama�o, los factores de carga l�mite para redispersi�n y redispersi�n inversa
 *     y el tipo de exploraci�n en las colisiones
	 * @param tam tama�o del Hash, si no es un n�mero primo lo ajusta al primo superior
	 * @param fcUP Factor de carga l�mite, por encima del cual hay que redispersar (directa)
	 * @param fcDOWN Factor de carga l�mite, por debajo del cual hay que redispersar (inversa)
	 * @param expl tipo de exploraci�n (LINEAL=0, CUADRATICA=1, ...), si inv�lido LINEAL
	 */
	@SuppressWarnings("unchecked")
	public ClosedHashTable(int tam, double fcUP, double fcDOWN, byte expl) {
		hashSize=isPrime(tam) ? tam : nextLargestPrimeNumber(tam); // Establece un tama�o v�lido
		
		associativeArray = (HashNode<T>[]) new HashNode[hashSize]; // Crea el array de HashNode's...Completar lo que falta�...
		//Array de referencias a HashNodes que est�n creados en a�g�n sitio
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
	 * Realiza la funci�n de exploraci�n en la tabla hash cuando hay colisi�n
	 * Dependiendo del caso, har� exploraci�n lineal, cuadr�tica,...
	 *
	 * @param iter
	 *            iteraci�n de la colisi�n
	 * @param elem
	 *            Elemento que causa la exploraci�n
	 * @return Nueva posici�n seg�n la exploraci�n actual de la tabla
	 */
	protected int fExploracion(int iter, T elem) {
		// Devuelve solamente el �ndice
		// Todos los c�lculos dentro del m�todo

		// Cuadr�tica
		if (expl == CUADRATICA) { // REVISAR (MONO) POR SI CAMBIA LAS CONTANTES
			return (fHash(elem) + iter * iter) % hashSize;
		}
		// Si no, se hace la lineal por defecto
		else {
			return (fHash(elem) + iter) % hashSize;
		}

	}

	/**
	 * M�todo que devuelve el n�mero de elementos de la tabla
	 * 
	 * @return int, n�mero de elementos
	 */
	@Override
	public int getNumOfElems() {
		return numElementos;
	}

	/**
	 * M�todo que devuelve el tama�o de la tabla
	 * 
	 * @return int, tama�o de la tabla
	 */
	@Override
	public int getSize() {
		return hashSize;
	}
	
	/**
	 * Realiza una redispersi�n (aumentando el tama�o) al n�mero primo mayor que el doble del tama�o actual, 
	 * y recolocando los elementos
	 * @return true al realizarla
	 */
	@Override
	protected boolean reDispersion() {

		// Se establece un n�mero B para la nueva tabla buscando el n�mero primo
		// inmediatamente superior al doble del original (TEOR�A)
		int newSize = nextLargestPrimeNumber(hashSize * 2); // Next ptrimo

		// Copiamos la tabla a una auxiliar y copiamos a una variable el tama�o
		// original
		HashNode<T> newTable[] = associativeArray;
		int originalSize = hashSize;

		// Creamos la tabla original con el nuevo tama�o
		associativeArray = new HashNode[newSize];
		numElementos = 0;
		hashSize = newSize;

		// Rellenamos la tabla con nodos
		for (int i = 0; i < newSize; i++) {
			associativeArray[i] = new HashNode<T>();
		}

		// A�adimos los elementos viejos a la nueva tabla
		for (int i = 0; i < originalSize; i++) {
			if (newTable[i].getEstado() == HashNode.LLENO)
				add(newTable[i].getInfo());
		}
		return true; // No hace falta que devuelva nada (Podemos utilizarlo para
						// saber si ha realizado la redispersi�n)
	}

	/**
	 * Realiza una redispersi�n inversa (disminuyendo el tama�o) al n�mero primo menor que la mitad del tama�o actual, 
	 * y recolocando los elementos
	 * @return true al realizarla
	 */
	@Override
	protected boolean inverseReDispersion() {
		// Se establece un n�mero B para la nueva tabla buscando el n�mero primo
		// inferior a la mitad del original (TEOR�A)
		int newSize = previousSmallerPrimeNumber(hashSize / 2); // Next ptrimo

		// Copiamos la tabla a una auxiliar y copiamos a una variable el tama�o
		// original
		HashNode<T> newTable[] = associativeArray;
		int originalSize = hashSize;

		// Creamos la tabla original con el nuevo tama�o
		associativeArray = new HashNode[newSize];
		numElementos = 0;
		hashSize = newSize;

		// Rellenamos la tabla con nodos
		for (int i = 0; i < newSize; i++) {
			associativeArray[i] = new HashNode<T>();
		}

		// A�adimos los elementos viejos a la nueva tabla
		for (int i = 0; i < originalSize; i++) {
			if (newTable[i].getEstado() == HashNode.LLENO)
				add(newTable[i].getInfo());
		}
		return true; // No hace falta que devuelva nada (Podemos utilizarlo para
						// saber si ha realizado la redispersi�n)
	}

	/**
	 * Convierte la tabla a una String que se pueda mostrar de forma "visible"
	 *
	 * @return el String con la informaci�n de la tabla hash
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
		// Comprobaci�n de que sea un null
		if (elem != null) { 
			// 1� Buscar el sitio --> usar fExploracion 
			int posicion = fHash(elem);
			int aux = 0; // iteraci�n


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
		// Comprobaci�n de que sea un null
		if (elem != null) { 

			int posicion = fHash(elem);
			int aux = 0; // Iteraci�n
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
		// Comprobaci�n de que sea un null
		if (elem != null) { // (MONO)

			int posicion = fHash(elem);
			int aux = 0; // Iteraci�n
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
	 * M�todo para calcular el factor de carga
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



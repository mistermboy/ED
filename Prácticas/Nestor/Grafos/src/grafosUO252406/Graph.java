/**
 * 
 */
package grafosUO252406;

import java.text.DecimalFormat;

/**
* @author UO252406
* 
*/
public class Graph <T>{
	private T[] nodes; // Vector de nodos
	private boolean[][] edges; // matriz de aristas
	private double[][] weights; // matriz de pesos
	private int numNodes; // número de elementos en un momento dado
//	private double distanciaTotal=0;

	//Matrices para floyd
	double[][] A;
	int[][] P;
	
	/**
	 * 
	 * @param tam
	 *            Número máximo de nodos del grafo
	 */
	public Graph(int tam) {
		nodes = (T[]) new Object[tam];
		edges = new boolean[tam][tam];
		weights = new double[tam][tam];
		numNodes = 0;
	}
	
	public Graph(int tam, T initialNodes[], boolean[][] initialEdges,
			double[][] initialWeights, double[][] initialAfloyd,
			int[][] initialPfloyd) {
		// Llama al constructor original
		this(tam);

		// Pero modifica los atributos con los parámetros para hacer pruebas...
		numNodes = initialNodes.length;

		for (int i = 0; i < numNodes; i++) {
			nodes[i] = initialNodes[i];
			for (int j = 0; j < numNodes; j++) {
				edges[i][j] = initialEdges[i][j];
				weights[i][j] = initialWeights[i][j];
			}
		}
		if (initialAfloyd != null) {
			A = initialAfloyd;
			P = initialPfloyd;
		}

	}
	

	/**
	 * Inserta un nuevo nodo que se le pasa como parámetro, en el vector de
	 * nodos, si existe no lo inserta
	 * 
	 * @param node1
	 *            el nodo que se quiere insertar
	 * @return 0 si lo inserta, -1 si no puede insertarlo
	 */
	public int addNode(T node) {
		if (node == null) {
			return -1;
		}
		if (getNode(node) == -1 && numNodes < nodes.length) {
			nodes[numNodes] = node;
			numNodes++;
			return 0;
		} else {
			return -1;
		}
	}

	
	
	/**
	 * Obtiene el índice de un nodo en el vector de nodos
	 *
	 * ¡¡¡ OJO que es privado porque depende de la implementación !!!
	 * 
	 * @param node
	 *            el nodo que se busca
	 * @return la posición del nodo en el vector ó -1 si no lo encuentra
	 */
	private int getNode(T node) {
		int indice = -1;
		for (int i = 0; i < numNodes; i++) {
			if (node.equals(nodes[i])) {
				indice = i;
			}
		}
		return indice;
	}


	/**
	 * Devuelve un String con la informacion del grafo
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		String cadena = "";

		cadena += "VECTOR NODOS\n";
		for (int i = 0; i < numNodes; i++) {
			cadena += nodes[i].toString() + "\t";
		}
		cadena += "\n\nMATRIZ ARISTAS\n";
		for (int i = 0; i < numNodes; i++) {
			for (int j = 0; j < numNodes; j++) {
				cadena += (edges[i][j] ? "T" : "F") + "\t";
			}
			cadena += "\n";
		}
		cadena += "\nMATRIZ PESOS\n";
		for (int i = 0; i < numNodes; i++) {
			for (int j = 0; j < numNodes; j++) {
				cadena += (edges[i][j] ? df.format(weights[i][j]) : "-") + "\t";
			}
			cadena += "\n";
		}

		if (A != null) {
			cadena += "\nMATRIZ AFloyd\n";
			for (int i = 0; i < numNodes; i++) {
				for (int j = 0; j < numNodes; j++) {
					cadena += df.format(A[i][j]) + "\t";
				}
				cadena += "\n";
			}
			cadena += "\nMATRIZ PFloyd\n";
			for (int i = 0; i < numNodes; i++) {
				for (int j = 0; j < numNodes; j++) {
					cadena += (P[i][j] >= 0 ? df.format(P[i][j]) : "-") + "\t";
				}
				cadena += "\n";
			}
		}
		return cadena;
	}

	
	/**
	 * Inserta una arista con el peso indicado (> 0) entre dos nodos, uno origen y
	 * otro destino. 
	 * Si la arista existe, le cambia el peso.
	 * Devuelve 0 si la inserta (o cambia el peso) y -1 si no lo hace
	 * 
	 * @param source
	 *            nodo origen
	 * @param target
	 *            nodo destino
	 * @param edgeWeight
	 *            peso de la arista, debe ser > 0
	 * @return 0 si lo hace y -1 si no lo hace (también si el peso es < 0)
	 */
	public int addEdge(T source, T target, double edgeWeight) {
		if (source == null || target == null) {
			return -1;
		}
		if (edgeWeight >= 0) {
			int nodeOrigen = getNode(source);
			int nodeDestino = getNode(target);
			if (nodeOrigen != -1 && nodeDestino != -1) {
				weights[nodeOrigen][nodeDestino] = edgeWeight;
				edges[nodeOrigen][nodeDestino] = true;
				return 0;
			} else {
				return -1;
			}
		} else {
			return -1;
		}

	}
	

	/**
	 * @param node  Nodo que se quiere consultar
	 * @return si existe o no el nodo
	 */
	public boolean existNode(T node) {
		if(node==null){
			return false;
		}
		boolean exist = false;
		for (int i = 0; i < numNodes; i++) {
			if (node.equals(nodes[i])) {
				exist = true;
			}
		}
		return exist;
	}

	/**
	 * Borra el nodo deseado del vector de nodos así como las aristas de las que
	 * forma parte
	 * 
	 * @param node
	 *            que se quiere borrar
	 * @return 0 si lo borra o -1 si no lo hace
	 */
	public int removeNode(T node) {
		if (node == null) {
			return -1;
		}
		int remove = -1;
		int index = getNode(node);
		if (!isEmpty()) {
			if (index != -1) {
				--numNodes;
				if (index != numNodes + 1) {
					nodes[index] = nodes[numNodes];
					for (int j = 0; j <= numNodes; j++) {
						edges[j][index] = edges[j][numNodes];
						edges[index][j] = edges[numNodes][j];
						weights[index][j] = weights[numNodes][j];
						weights[j][index] = weights[j][numNodes];
					}
					edges[index][index] = edges[numNodes][numNodes];
					weights[index][index] = weights[numNodes][numNodes];
					remove = 0;
				}
			}
		}
		return remove;
	}
	
	/**
	 * Comprueba si existe una arista entre dos nodos que se pasan como
	 * parámetro
	 * 
	 * @param source
	 *            nodo origen
	 * @param target
	 *            nodo destino
	 * @return verdadero o falso si existe o no, si alguno de los nodos no
	 *         existe también falso
	 */
	public boolean existEdge(T source, T target) {
		if (source == null || target == null) {
			return false;
		}
		boolean exist = false;
		int nodeOrigen = getNode(source);
		int nodeDestino = getNode(target);
		if (nodeOrigen != -1 && nodeDestino != -1) {
			exist = edges[nodeOrigen][nodeDestino];
		}
		return exist;
	}

	/**
	 * Borra una arista del grafo que conecta dos nodos
	 * 
	 * @param source
	 *            nodo origen
	 * @param target
	 *            nodo destino
	 * @return 0 si la borra o -1 si no lo hace (también si no existe alguno de
	 *         sus nodos)
	 */
	public int removeEdge(T source, T target) {
		if (source == null || target == null) {
			return -1;
		}
		int remove = -1;
		int nodeOrigen = getNode(source);
		int nodeDestino = getNode(target);
		if (nodeOrigen != -1 && nodeDestino != -1) {
			edges[nodeOrigen][nodeDestino] = false;
			weights[nodeOrigen][nodeDestino] = 0.0;
			remove = 0;
		}
		return remove;
	}

	/**
	 * Devuelve el peso de la arista que conecta dos nodos, si no existe la
	 * arista, devuelve -1 (también si no existe alguno de los nodos)
	 * 
	 * @param source
	 * @param target
	 * @return El peso de la arista o -1 si no existe
	 */
	public double getEdge(T source, T target) {
		if (source == null || target == null) {
			return -1;
		}
		double weight = -1;
		int nodeOrigen = getNode(source);
		int nodeDestino = getNode(target);
		if (nodeOrigen != -1 && nodeDestino != -1 && existEdge(source, target)) {
			weight = weights[nodeOrigen][nodeDestino];
		}
		return weight;
	}

	/**
	 * trata el nodo que se le pasa por parámetro, en este caso lo muestra por
	 * pantalla con un tabulador detrás
	 * 
	 * @param nodo
	 */
	private void tratarNodo(T nodo) {
		System.out.print(nodo.toString() + "\t"); // toString para aclarar...
	}
	
	/**
	 * Devuelve el número de nodos 
	 */
	public int getNumberOfNodes(){
		return numNodes;
	}

	/**
	 *  Indica si la lista contiene o no nodos
	 * @return Devuelve true si la lista no contiene elementos false en caso contrario
	 */
	public boolean isEmpty() {
		return numNodes==0 ? true:false;
	}
	
	/**
	 *  Algoritmo de Dijkstra para encontrar el camino de coste mínimo desde nodoOrigen 
	 *  hasta el resto de nodos
	 *  
	 * @param nodoOrigen
	 * @return vector D de dijkstra para comprobar funcionamiento
	 */
	public double[] dijkstra(T nodoOrigen) {
		double[] D = new double[numNodes];
		double[] P = new double[numNodes];
		boolean[] V = new boolean[numNodes];

		//CORREGIDO
		int inicio = getNode(nodoOrigen);
		if (nodoOrigen == null || inicio==-1) {
			return null;
		}
		
		for (int i = 0; i < numNodes; i++) {
			V[i] = false;
			if (inicio == i) {
				D[i] = 0.0;
				P[i] = -1;
				V[i] = true;
			} else if (existEdge(nodoOrigen, nodes[i])) {
				D[i] = getEdge(nodoOrigen, nodes[i]);
				P[i] = inicio;
			} else {
				D[i] = Double.POSITIVE_INFINITY;
				P[i] = -1;
			}
		}

		for (int i = 0; i < numNodes; i++) {

			int w = minCost(D, V);
			if (w != -1) {
				V[w] = true;
				for (int m = 0; m < numNodes; m++) {
					//if (weights[w][m] != 0) {
					//Mejor esta comprobacion
					if(edges[w][m]){
						if (D[w] + weights[w][m] < D[m]) {
							D[m] = D[w] + weights[w][m];
							P[m] = w;
						}
					}
				}
			}
		}

		return D;
	}

	/**
	 * Busca el nodo con distancia mínima en D al resto de nodos
	 * @param dist  vector d
	 * @param v  	vector con visitados (conjunto S)
	 * @return índice del nodo buscado o -1 si el grafo es no conexo o no quedan nodos sin visitar
	 */
	private int minCost(double[] dist, boolean[] v) { 
		double first =Double.POSITIVE_INFINITY;
		int index = -1 ;
		for(int i=0;i<numNodes;i++){
			if(dist[i]<first && v[i]==false){
				first=dist[i];
				index=i;
				
			}
		}
		return index;
	}


	/**
	 * Aplica el algoritmo de Floyd al grafo actual
	 * 
	 * @return la matriz A de Floyd
	 */
	public double[][] floyd() {
		A = new double[numNodes][numNodes];
		P = new int[numNodes][numNodes];
		for (int i = 0; i < numNodes; i++) {
			for (int j = 0; j < numNodes; j++) {
				P[i][j] = -1;
				if (weights[i][j] == 0.0 && i != j) {
					A[i][j] = Double.POSITIVE_INFINITY;
				} else {
					A[i][j] = weights[i][j];
				}
			}
		}

		for (int k = 0; k < numNodes; k++)
			for (int i = 0; i < numNodes; i++)
				for (int j = 0; j < numNodes; j++)
					if (A[i][k] + A[k][j] < A[i][j]) {
						A[i][j] = A[i][k] + A[k][j];
						P[i][j] = k;
					}

		return A;

	}

	/**
	 * Indica el camino entre los nodos que se le pasan como parámetros de esta forma:
	 * Origen<tab>(coste0)<tab>Intermedio1<tab>(coste1)….IntermedioN<tab>(costeN) Destino
	 * 
	 * @param origen
	 * @param destino
	 * @return Distancia entre los nodos origen y destino según Floyd
	 */
	public double path(T origen, T destino) {
		if (origen == null || destino == null) {
			return -1;
		}
		floyd();
		int nodeOrigen = getNode(origen);
		int nodeDestino = getNode(destino);
		double distanciaTotal = 0;
		String cad = "";
		boolean condicion = true;
		int k = P[nodeOrigen][nodeDestino];
		if (k > 0) {
			distanciaTotal += A[nodeOrigen][k];
			cad += "\t( " + A[nodeOrigen][k] + " )\t"  + nodes[k];
			while (condicion) {
				int newOrigen = k;
				if (newOrigen > 0) {
					k = P[newOrigen][nodeDestino];
					if (k > 0) {
						distanciaTotal += A[newOrigen][k];
						cad += "\t( " + A[newOrigen][k]+ " ) ";
						cad += "\t" + nodes[k];
						newOrigen = k;
						k = P[k][nodeDestino];
					}

					if (k > 0) {
						distanciaTotal += A[newOrigen][k];
						 cad += " ( " + A[newOrigen][k] + " ) ";
					}
					distanciaTotal += A[newOrigen][nodeDestino];
					 cad+="\t( " + A[newOrigen][nodeDestino] + " )\t";
				}
				condicion = false;
			}
			System.out.print(origen + "");
			System.out.print(cad);
			System.out.print( destino);
			System.out.print("\n");

		} else {
			System.out.print(origen + " ");
			distanciaTotal += A[nodeOrigen][nodeDestino];
			System.out.print("\t( " + A[nodeOrigen][nodeDestino] + " )\t");
			System.out.print("\t" + destino);
			System.out.print("\n");
		}
		return distanciaTotal;
	}
		
//		if (origen == null || destino == null) {
//			return -1;
//		}
//		floyd();
//		int nodeOrigen = getNode(origen);
//		int nodeDestino = getNode(destino);
//		int k = P[nodeOrigen][nodeDestino];
//		if(k>0){
//			System.out.print(origen + " ");
//			distanciaTotal+=printPath(nodeOrigen, nodeDestino);
//			int newOrigen = P[k][nodeDestino];
//			if(newOrigen>0){
//			System.out.print("\t( " + A[newOrigen][nodeDestino] + " )\t");
//			distanciaTotal += A[newOrigen][nodeDestino];
//			System.out.print("\t" + destino);
//			System.out.print("\n");
//			}else{
//				System.out.print("\t( " + A[k][nodeDestino] + " )\t");
//				distanciaTotal += A[k][nodeDestino];
//				System.out.print("\t" + destino);
//				System.out.print("\n");
//			}
//		
//		}else{
//		System.out.print(origen + " ");
//		System.out.print("\t( " + A[nodeOrigen][nodeDestino] + " )\t");
//		distanciaTotal += A[nodeOrigen][nodeDestino];
//		System.out.print("\t" + destino);
//		System.out.print("\n");
//		}
//		return distanciaTotal;
//		
//	}
//	
//	private double printPath(int i, int j){
//		int k = P[i][j]; 
//		if (k>0) { 
//			printPath (i, k); 
//			System.out.print ("\t( " + A[i][k] + " )\t" + nodes[k]); 
//			distanciaTotal += A[i][k];
//			printPath (k, j); 
//			} 
//		return distanciaTotal;
//		}


//	/**
//	 * Lanza el recorrido en profundidad de un grafo desde un nodo determinado,
//	 * No necesariamente recorre todos los nodos.
//	 * Al recorrer cada nodo hace un tratamiento del mismo programado en
//	 * otro método privado: tratarNodo(...) 
//	 * Usa un método privado recursivo
//	 * 
//	 * @param nodo
//	 *            El nodo por el que se quiere empezar el recorrido en
//	 *            profundidad
//	 * @return si se llega a todos devuelve 0, si no devuelve -1
//	 */
//	public int recorridoProfundidad(T nodoOrigen) { 
	
	
//	/**
//	 * Se devuelven el número de nodos n tal que es posible pasar de la
//	 * source y volver con un coste no mayor que el previsto.
//	 *
//	 * @param source
//	 * El nodo en el que se inicia el algoritmo y, por tanto, el camino
//	 * @param Coste
//	 *. El coste máximo posible de alcanzar y devolver los nodos de
//	 * la fuente.
//	 * @return El número de nodos alcanzables dentro de la gama de coste.
//	 * Excepción @throws
//	 * Si el coste previsto es negativo. El coste debe ser siempre
//	 * Positivo.
//	 */
//	 public int getNumberOfReturnNodesWithinCost(T source, double coste)
//	   throws Exception {
//	  if (coste < 0)
//	   throw new RuntimeException("El coste no puede ser negativo.");
//	  int index = getNode(source);
//	  floyd();
//	  int result = 1;
//	  for (int i = 0; i < numNodes; i++) {
//	   if ((A[index][i] + A[i][index]) <= coste && index != i)
//	    result++;
//	  }
//	  return result;
//	 }


//	 /**
//	 * Comprueba si un nodo es fuertemente conexo, es decir, hay un camino desde
//	 * el nodo a todos los demás nodos en el grafo y al mismo tiempo desde todos
//	 * los demás nodos a el mismo;
//	 * 
//	 * @param node
//	 *            , nodo a comprobar
//	 * 
//	 * @return si el nodo es fuertemente conexo
//	 */
//	    public boolean isStronglyConnected(T node) {
//		int index = getNode(node);
//		floyd();
//		boolean result = true;
//
//		for (int i = 0; i < numNodes; i++) {
//		    if (A[index][i] == Double.POSITIVE_INFINITY && index != i)
//			result = false;
//		    if (A[i][index] == Double.POSITIVE_INFINITY && index != i)
//			result = false;
//		}
//
//		return result;
//	    }
	
//	/**
//	 * Sacar la arista con mayor peso
//	 */
//	public double sacarAristaDeMayorPeso(T origen, T destino) {
//		if (origen == null || destino == null) {
//			return -1;
//		}
//		int nodeOrigen = getNode(origen);
//		int nodeDestino = getNode(destino);
//		floyd();
//		double pesos = 0;
//		double contador = pesos;
//		boolean condicion = true;
//		int k = P[nodeOrigen][nodeDestino];
//		if (k > 0) {
//			pesos = weights[nodeOrigen][k];
//			if(contador<pesos){
//				contador=pesos;
//			}
////			pesos = weights[k][nodeDestino];
////			if(contador<pesos){
////				contador=pesos;
////			}
//			while (condicion) {
//				int newOrigen = k;
//				if (newOrigen > 0) {
//					k = P[newOrigen][nodeDestino];
//					pesos = weights[newOrigen][nodeDestino];
//					if(contador<pesos){
//						contador=pesos;
//					}
//					if (k > 0) {
//						newOrigen = k;
//						k = P[k][nodeDestino];
//						pesos = weights[newOrigen][nodeDestino];
//						if(contador<pesos){
//							contador=pesos;
//						}
//					}
//				}
//				condicion = false;
//			}
//	}
//		return contador;
//		
//	}
//	
//	/**
//     *Calcula la excenticidad de un nodo
//     * 
//     * @param nodo al que se le quiere calcular la excentricidad
//     * 
//     * @return excentricidad del nodo
//     */
//    public double excentricidad(T node) {
//	int index = getNode(node);
//	floyd();
//	double result = 0.0;
//
//	for (int i = 0; i < numNodes; i++) {
//	    if (A[index][i] > result && index != i && A[index][i] != Double.POSITIVE_INFINITY)
//		result = A[index][i];
//	}
//
//	return result;
//    }
//    
//    /**
//     * Devuelve el diámetro del grafo
//     * 
//     * @return diámetro
//     */
//    public double diametro() {
//	double result = 0.0;
//	for (T node : nodes) {
//	    double ex = excentricidad(nodes[getNode(node)]);
//	    if (ex > result) {
//		result = ex;
//	    }
//	}
//
//	return result;
//    }
//    
//	  /**
//     * Devuelve el grado del nodo(Numero de aristas incidentes en el vertice)
//     * 
//     * @param node
//     * @return numero de aristas
//     */
//    public int gradoNodo(T node) {
//	int index = getNode(node);
//	int result = 0;
//	for (int i = 0; i < numNodes; i++) {
//	    if (edges[i][index]==true){
//		result++;
//	    }
//	}
//	return result;
//    }
//	
//	  /**
//     * Nuumero minimo de aristas incidentes en un vertice de entre todos los
//     * vertices existentes en el grafo
//     * 
//     * @return integer. Numero minimo de aristas incidentes
//     */
//    public int minGradoNodo() {
//	int result = Integer.MAX_VALUE;
//	for (T node : nodes) {
//	    int gn = gradoNodo(nodes[getNode(node)]);
//	    if (gn < result)
//		result = gn;
//	}
//	return result;
//    }
//	
//	 /**
//     * Numero maximo de aristas que inciden en un vertice de entre todos los
//     * vertices del grafo.
//     * 
//     * @return integer. Numero maximo de aristas que incide
//     */
//	public int maxGradoNodo() {
//		int result = 0;
//		for (T node : nodes) {
//			int gn = gradoNodo(nodes[getNode(node)]);
//			if (gn > result){
//				result = gn;
//			}
//		}
//		return result;
//	}
}
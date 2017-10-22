package graphs;

import java.text.DecimalFormat;

public class preraringExam<T> {

	private T[] nodes;  //Array de nodos
	private boolean [][] edges;  //Matriz de ejes
	private double[][] weights;		//Matriz de pesos
	int numNodes;
	
	//Matrices para floyd
	private double[][] A;
	private T[][] P;
	
	
	
	@SuppressWarnings("unchecked")
	public preraringExam(int tam) {
		nodes =  (T[]) new Object[tam];
		edges = new boolean[tam][tam];
		weights = new double[tam][tam];
		numNodes=0;
		
		//Floyd
		A = new double[tam][tam];
		P = (T[][]) new Object[tam][tam];
	}
	
	
	/**
	 * Método que verifica la existencia del nodo
	 * @param node nodo que se quiere verificar
	 * @return true si existe, false en caso contrario
	 */
	public boolean existNode(T node) {
		if(node!=null) {
			for(int i=0;i<numNodes;i++) {
				if(nodes[i].equals(node)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 *  Método que devuelve el índice del nodo dentro del grafo
	 * @param node 
	 * @return indíce del nodo, -1 si no existe
	 */
	private int getNode(T node) {
		if(node!=null) {
			for(int i=0;i<numNodes;i++) {
				if(nodes[i].equals(node)) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * Inserta un nuevo nodo que se le pasa como parámetro, en el vector de
	 * nodos, si existe no lo inserta
	 * @param node, nodo que se quiere insertar
	 * @return 0 si lo inserta, -1 si no puede insertarlo
	 */
	public int addNode(T node) {
		if (node != null) {
			if (getNode(node) == -1 && numNodes < nodes.length) {
				nodes[numNodes] = node;
				for(int i=0; i<numNodes ; i++){
	    			edges[i][numNodes]=false;
	    			edges[numNodes][i]=false;
	    			weights[numNodes][i]=Double.POSITIVE_INFINITY;
	    			weights[i][numNodes]=Double.POSITIVE_INFINITY;
	    		}
				numNodes++;
				inicializaFloyd();
				return 0;
			}
		}
		return -1;

	}
	
	/**
	 * Borra el nodo deseado del vector de nodos así como las aristas de las que
	 * forma parte
	 * @param node, nodo que se quiere borrar
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
				if (index != numNodes + 1) {	//Creo que sobra
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
					inicializaFloyd();
				}
			}
		}
		return remove;
	}
	

	/**
	 * Comprueba si existe una arista entre dos nodos que se pasan como
	 * parámetro
	 * @param source, nodo origen
	 * @param target, nodo destino
	 * @return verdadero o falso si existe o no, si alguno de los nodos no existe también falso
	 */
	public boolean existEdge(T source, T target) {
		if (source != null && target != null) {
			int sourceNode = getNode(source);
			int targetNode = getNode(target);
			if (sourceNode != -1 && targetNode != -1) {
				return edges[sourceNode][targetNode];
			}
		}
		return false;
	}
	
	/**
	 * Devuelve el peso de la arista que conecta dos nodos, si no existe la
	 * arista, devuelve -1 (también si no existe alguno de los nodos)
	 * @param sourcenodo origen
	 * @param target, nodo destino
	 * @return El peso de la arista o -1 si no existe
	 */
	public double getEdge(T source, T target) {
		if (source != null && target != null) {
			int sourceNode = getNode(source);
			int targetNode = getNode(target);
			if (sourceNode != -1 && targetNode != -1 && existEdge(source, target)) {
				return weights[sourceNode][targetNode];
			}
		}
		return -1;
	}
	
	/**
	 * Inserta una arista con el peso indicado (> 0) entre dos nodos, uno origen y
	 * otro destino. 
	 * Si la arista existe, no se le cambia el valor
	 * Devuelve 0 si la inserta (o cambia el peso) y -1 si no lo hace
	 * @param source, nodo origen
	 * @param target, nodo destino
	 * @param edgeWeight peso de la arista, debe ser > 0
	 * @return 0 si lo hace y -1 si no lo hace (también si el peso es < 0)
	 */
	public int addEdge(T source, T target,double edgeWeight) {
		if (source != null && target != null) {
			if(edgeWeight > 0) {
				int sourceNode = getNode(source);
				int targetNode = getNode(target);
				if (sourceNode != -1 && targetNode != -1 && !existEdge(source, target) && sourceNode!=targetNode) {
					weights[sourceNode][targetNode]=edgeWeight;
					edges[sourceNode][targetNode]=true;
					inicializaFloyd();
					return 0;
				}
			}
		}
		return -1;
	}
	
	/**
	 * Borra una arista del grafo que conecta dos nodos.
	 * @param source nodo origen
	 * @param target nodo destino
	 * @return 0 si la borra o -1 si no lo hace (también si no existe alguno de sus nodos)
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
			inicializaFloyd();
		}
		return remove;
	}
	
	
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
		 if (edges[i][j])
		 cadena += "T\t";
		 else
		 cadena += "F\t";
		 }
		 cadena += "\n";
		 }
		 cadena += "\nMATRIZ PESOS\n";
		 for (int i = 0; i < numNodes; i++) {
		 for (int j = 0; j < numNodes; j++) {
		 cadena += df.format(weights[i][j]) + "\t";
		 }
		 cadena += "\n";
		 }
		 return cadena;
		}

	
	/**
	 * Algoritmo de Dijkstra, cuya función es encontrar 
	 * el camino de coste mínimo desde un nodo que se pasa como parámetro hasta 
	 * el resto de los nodos
	 * @param nodoOrigen
	 * @return vector D de dijkstra para comprobar funcionamiento
	 */
	public double[] dijkstra(T nodoOrigen) {
		double[] D = new double[numNodes];
		double[] P = new double[numNodes];
		boolean[] V = new boolean[numNodes];

		int inicio = getNode(nodoOrigen);
		if (nodoOrigen == null || inicio == -1) {
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
					if (edges[w][m]) {
						if (D[w] + weights[w][m] < D[m]) {
							D[m] = D[w] + weights[w][m];
							P[m] = w;
						}
					}
				}
			}
		}

		D[getNode(nodoOrigen)] = Double.POSITIVE_INFINITY;

		return D;
	}
	
	
	
	
	private int minCost(double[] d, boolean[] v) {
		double min = Double.POSITIVE_INFINITY;
		int index=-1;
		for(int i=0;i<numNodes;i++) {
			if(!v[i] && d[i]<min) {
				min = d[i];
				index=i;
			}
		}
		return index;
	}

	/**
	 * Genera A y P Devuelve 0 si genera las dos matrices y -1 si el tamaño del
	 * grafo es menor o igual a 1
	 * 
	 * @return
	 */
	public int floyd() {
		if (nodes.length <= 1) {
			return -1;
		}

		A = weights;

		for (int k = 0; k < numNodes; k++) {
			for (int i = 0; i < numNodes; i++) {
				for (int j = 0; j < numNodes; j++) {
					if (weights[i][k] + weights[k][j] < A[i][j]) {
						A[i][j] = weights[i][k] + weights[k][j];
						P[i][j] = nodes[k];
					}
				}
			}
		}
		return 0;
	}
	
	
	
	/**
	 *  Devuelve el coste mínimo del camino entre dos nodos que se pasan como parámetros, 
	 *  usando la matriz de floyd, o -1 si no existen los nodos o no hay camino entre ellos.
	 * @param nodoOrigen
	 * @param nodoDestino
	 * @return
	 */
	public double minCostPath(T nodoOrigen,T nodoDestino) {
		if(nodoOrigen==null || nodoDestino==null) {
			return -1;
		}
		int source = getNode(nodoOrigen);
		int target = getNode(nodoDestino);
		if(source != -1 && target !=-1) { 
			floyd();
			if(A[source][target]!=Double.POSITIVE_INFINITY) {
				return A[source][target];
			}
			
		}
		return -1;
	}
	
	
	/**
	 * Devuelve el camino de coste mínimo entre 2 nodos que se pasan como
	 * parámetro usando la matriz de floyd, o -1 si no existen los nodos o no
	 * hay camino entre ellos.
	 * 
	 * @param nodoOrigen
	 * @param nodoDestino
	 * @return camino de coste mínimo
	 */
	public String path(T nodoOrigen, T nodoDestino) {
		if (nodoOrigen == null || nodoDestino == null) {
			return null;
		}

		floyd();
		int source = getNode(nodoOrigen);
		int target = getNode(nodoDestino);
		if (source == -1 || target == -1) {
			return null;
		}

		// Si el nodo origen es igual al nodoDestino
		// nodoOrigen

		if (nodoOrigen.equals(nodoDestino)) {
			return nodoOrigen.toString();
		}

		// Si no hay camino entre los nodos
		// nodoOrigen(Infinito)nodoDestino
		if (P[source][target] == null && !existEdge(nodoOrigen, nodoDestino)) {
			return nodoOrigen.toString() + "(Infinito)"
					+ nodoDestino.toString();
		}

		// Si hay camino
		// nodoOrigen<tab>(cost0)<tab>Intermedio1<tab>(coste1)<tab>...
		// Intermedio1<tab>(coste1)<tab>nodoDestino
		return printPaht(nodoOrigen, nodoDestino);

	}
	
	
	private String printPaht(T nodoOrigen, T nodoDestino) {
		if (nodoOrigen.equals(nodoDestino)) {
			return nodoOrigen.toString();
		}

		int start = getNode(nodoOrigen);
		int end = getNode(nodoDestino);
		T step = P[start][end];
		if (step == null && edges[start][end])
			step = nodes[start];
		return printPaht(nodoOrigen, step) + "\t("
				+ weights[getNode(step)][getNode(nodoDestino)] + ")\t"
				+ nodes[end].toString();
	}
	
	
	/**
	 * Inicializa las matrices A y P de floyd
	 */
	private void inicializaFloyd() {
		for(int i=0;i<numNodes;i++) {
			for(int j=0;j<numNodes;j++) {
				A[i][j] = Double.POSITIVE_INFINITY;
				P[i][j] =null;
			}
		}
	}


	/**
	 * Método que verifica que el grafo esté vacío
	 * @return true si lo está, false en caso contrario
	 */
	private boolean isEmpty() {
		return numNodes==0?true:false;
	}
	
	/**
	 * Método que devuelve el número de nodos del grafo
	 * @return numNodes, de tipo int
	 */
	public int getNumberOfNodes(){
		return numNodes;
	}
	
	
	/**
	 * Método que borra todos los datos del grafo
	 */
	@SuppressWarnings("unchecked")
	public void removeAll() {
		nodes =  (T[]) new Object[nodes.length];
		edges = new boolean[edges.length][edges.length];
		weights = new double[weights.length][weights.length];
		numNodes=0;
	}

	
	/**
	 * @return Devuelve la matriz A de floyd
	 */
	public double[][] getFloydA() {
		return A;
	}
	
	/**
	 * @return Devuelve la matriz P de floyd
	 */
	public T[][] getFloydP() {
		return P;
	}
	
	/**
	 * Metodo que indica si el grafo es fuertemente conexo(conexion de todos los
	 * nodos con todos)
	 * 
	 * @return true si el grafo es fuertemente conexo y false en caso contrario
	 */
	public boolean isStronglyConnected() {
		floyd();
		for (int source = 0; source < numNodes; source++) {
			for (int target = 0; target < numNodes; target++) {

				if (P[source][target] == null
						&& !existEdge(nodes[source], nodes[target])) {
					return false;
				}

			}
		}
		return true;

	}
	
	/**
	 * Metodo que calcula el grado total de un nodo
	 * 
	 * @param nodo
	 *            para calcular su grado
	 * @return grado de dicho nodo
	 */
	public int gradoDeUnNodo(T nodo) {
		if (nodo == null || !existNode(nodo)) {
			return -1;
		}

		int grado = 0;
		floyd();
		for (int i = 0; i < numNodes; i++) {
			if (edges[getNode(nodo)][i]) {
				grado++;
			} else if (edges[i][getNode(nodo)]) {
				grado++;
			}
		}
		return grado;
	}
	
	/** 
	 * Método que devuelve si un nodo es fuertemente conexo. Es decir, si desde este nodo
	 * podemos llegar o no hasta todos los demás.
	 * Para ello usamos la matriz que nos devuelve floyd.
	 * @param sourcenode el nodo que queremos analizar 
	 * @return true si lo es, false en caso contrario.
	 */
	public boolean nodoFuertementeConexo(T source) {
		if (source == null || !existNode(source)) {
			return false;
		}
		floyd();
		int nodo = getNode(source);
		for (int i = 0; i < numNodes; i++) {
			if(A[nodo][i]==Double.POSITIVE_INFINITY){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Calcula la excentricidad de un nodo. El valor máximo de las longitudes mínimas de los caminos 
	 * desde todos los nodos hasta el nodo source. 
	 * @param source nodo a calcular la excentricidad
	 * @return la excentricidad
	 */
	public double excentricidad (T source) {
		double excentricity=-1;
		floyd();
		if(source!=null && existNode(source)){
			for(int i=0;i<numNodes;i++){
				if(A[i][getNode(source)]>excentricity){
					excentricity=A[i][getNode(source)];
				}
			}
		}
		return excentricity;
	}
	
	/**
	 * Calcula el centro del grafo. 
	 * Será el nodo más cercano al nodo más distante. Para saber el nodo más distante buscamos
	 * la menor excentricidad.
	 * @return el identificador dentro del vector de nodos que es el centro del grafo.
	 */
	public int centro () {
		floyd();
		int masDistante=-1;
		double minExcentricity=Double.POSITIVE_INFINITY;
		for(int i=0;i<numNodes;i++){
			if(excentricidad(nodes[i])<minExcentricity){
				minExcentricity=excentricidad(nodes[i]);
				masDistante=i;
			}
		}
		int centro=0;
		double distance=Double.POSITIVE_INFINITY;
		for(int i=0;i<numNodes;i++){
			if(A[i][masDistante]<distance){
				distance=A[i][masDistante];
				centro = i;
			}
		}
		return centro;
	}
	
	/**
	 * Número de aristas que tienen al nodo como destino
	 * @param sourcenode nodo para calcular su grado de entrada
	 * @return el grado de entrada (int)
	 */
	public int gradoEntrada (T source)
	{
		if(source==null || !existNode(source)){
			return -1;
		}
		int numAristas=0;
		for(int i=0;i<numNodes;i++){
			if(edges[i][getNode(source)]){
				numAristas++;
			}
		}
		return numAristas;
		
		
		
	}
	
	/**
	 * Número de aristas que tienen al nodo como destino
	 * @param sourcenode nodo para calcular su grado de entrada
	 * @return el grado de entrada (int)
	 */
	public int gradoSalida (T source)
	{
		if(source==null || !existNode(source)){
			return -1;
		}
		int numAristas=0;
		for(int i=0;i<numNodes;i++){
			if(edges[getNode(source)][i]){
				numAristas++;
			}
		}
		return numAristas;
		
		
	}
	
	/**
	 * Si su grado de salida es mayor que cero y el grado de entrada 0
	 * @param source el nodo a calcular
	 * @return true en caso de serlo, falso si no
	 */
	public boolean esNodoFuente (T source) {
		if(source==null || !existNode(source)){
			return false;
		}
		
		int gradoEntrada=0;
		for(int i=0;i<numNodes;i++){
			if(edges[i][getNode(source)]){
				gradoEntrada++;
			}
		}
		if(gradoEntrada==0){
			int gradoSalida=0;
			for(int i=0;i<numNodes;i++){
				if(edges[getNode(source)][i]){
					gradoSalida++;
				}
			}
			if(gradoSalida>0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Si su grado de entrada es mayor que cero y el grado de salida 0
	 * @param source el nodo a calcular
	 * @return true en caso de serlo, falso si no
	 */
	public boolean esNodoSumidero (T source) {
		if(source==null || !existNode(source)){
			return false;
		}
		
		int gradoEntrada=0;
		for(int i=0;i<numNodes;i++){
			if(edges[i][getNode(source)]){
				gradoEntrada++;
			}
		}
		if(gradoEntrada>0){
			int gradoSalida=0;
			for(int i=0;i<numNodes;i++){
				if(edges[getNode(source)][i]){
					gradoSalida++;
				}
			}
			if(gradoSalida==0){
				return true;
			}
		}
		return false;
	
	}
	
	/**
	 * Si su grado de entrada y salida son 0 ambos
	 * @param source el nodo a calcular
	 * @return true en caso de serlo, falso si no
	 */
	public boolean esNodoAislado (T source) {
		return gradoEntrada(source)==0 && gradoSalida(source)==0;
	}
	
	/**
	 * Método que calcula si un nodo es el inicial del grafo. Para ser el nodo inicial de él tiene que salir algún vértice y no llegar 
	 * ninguno.
	 * @param source el nodo que se quiere saber si es el inicial.
	 * @return true en caso de serlo false si no.
	 */
	public boolean esNodoInicial(T source) {
		if (source != null || existNode(source)) {

			for (int i = 0; i < numNodes; i++) {
				if (edges[i][getNode(source)]) {
					return false;
				}
			}
			for (int i = 0; i < numNodes; i++) {
				if (edges[getNode(source)][i]) {
					return true;
				}
			}
		}
		return false;

	}
		
}

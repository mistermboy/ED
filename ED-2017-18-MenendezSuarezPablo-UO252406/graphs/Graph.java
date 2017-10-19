package graphs;

import java.text.DecimalFormat;

public class Graph<T> {

	private T[] nodes;  //Array de nodos
	private boolean [][] edges;  //Matriz de ejes
	private double[][] weights;		//Matriz de pesos
	int numNodes;
	
	
	public Graph(int tam) {
		nodes =  (T[]) new Object[tam];
		edges = new boolean[tam][tam];
		weights = new double[tam][tam];
		numNodes=0;
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
		
		
		
		
		
		
		
		
		//FALTA EL FOR
		
		
		
		
		
		
		
		if (node != null) {
			if (getNode(node) == -1 && numNodes < nodes.length) {
				nodes[numNodes] = node;
				numNodes++;
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
				if (sourceNode != -1 && targetNode != -1 && !existEdge(source, target)) {
					weights[sourceNode][targetNode]=edgeWeight;
					edges[sourceNode][targetNode]=true;
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
	public void removeAll() {
		nodes =  (T[]) new Object[nodes.length];
		edges = new boolean[edges.length][edges.length];
		weights = new double[weights.length][weights.length];
		numNodes=0;
	}
	
}

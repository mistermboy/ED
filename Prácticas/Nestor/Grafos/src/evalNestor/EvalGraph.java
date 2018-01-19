//  NO MODIFICAR NOMBRE DE ESTE PAQUETE, crear un paquete nuevo en vuestro proyecto que se llame as�: "evalNestor"
//  y meted en �l esta clase
package evalNestor;

//SUSTITUIR el nombre del paquete donde est� Graph (import de debajo) por el paquete vuestro de grafos
import grafosUO252406.Graph;

public class EvalGraph<T> extends Graph<T> {

	public EvalGraph(int i) {
		super(i);
	}
	
	public EvalGraph(int i,T initialNodes[], boolean[][] initialEdges, double [][] initialWeights, double [][] initialAfloyd, int [][] initialPfloyd){
		super(i,initialNodes,initialEdges,initialWeights,initialAfloyd,initialPfloyd);
	}
	
	public String getNombreFicheroAlumno(){
		return "Ev-Intermedia-Grafos-MenendezSuarezPablo-UO252406";
	}
}

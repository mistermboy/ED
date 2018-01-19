//  NO MODIFICAR NOMBRE DE ESTE PAQUETE, crear un paquete nuevo (si no existe ya) en vuestro proyecto que se llame as�: "evalNestor"
//  y meted en �l esta clase
package evalNestor;

// SUSTITUIR el nombre del paquete donde est�n BSTree y AVLTree (import de debajo) por el paquete vuestro de �rboles
import arbolesUO252406.*;

public class EvalBSTree <T extends Comparable<T>> extends BSTree <T> {

	public String getNombreFicheroAlumno(){
		// Poned vuestros apellidos, nombre y UO; sustituyendolos en el return de debajo...
		return "Ev-Intermedia-Arboles-BST-MenendezSuarezPablo-UO252406";
	}

	public EvalBSTree() {
		super();
	}
	
	public EvalBSTree(T[] serie)  {
		super();
		setRoot(reconstruirArbolBST(0, serie));
	}

	
	private void setRoot(BSTNode<T> reconstruirArbolBST) {
			raiz=reconstruirArbolBST;
			
	}

	private BSTNode<T> reconstruirArbolBST(int i, T[] serie) {
		if (i<serie.length && serie[i]!=null) {
			BSTNode<T> r = new BSTNode<T>(serie[i]);
			r.setLeft(reconstruirArbolBST(i*2+1, serie));
			r.setRight(reconstruirArbolBST(i*2+2, serie));
			return r;
		}
		return null;
	}	
	
}

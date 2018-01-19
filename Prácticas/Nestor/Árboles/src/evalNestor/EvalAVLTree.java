//  NO MODIFICAR NOMBRE DE ESTE PAQUETE, crear un paquete nuevo (si no existe ya) en vuestro proyecto que se llame as�: "evalNestor"
//  y meted en �l esta clase
package evalNestor;

// SUSTITUIR el nombre del paquete donde est�n BSTree y AVLTree (import de debajo) por el paquete vuestro de �rboles
import arbolesUO252406.*;

public class EvalAVLTree <T extends Comparable<T>> extends AVLTree <T> {

	public String getNombreFicheroAlumno(){
		// Poned vuestros apellidos, nombre y UO; sustituyendolos en el return de debajo...
		return "Ev-Intermedia-Arboles-AVL-MenendezSuarezPablo-UO252406";
	}

	public EvalAVLTree() {
		super();
	}
	
	public EvalAVLTree(T[] serie)  {
		super();
		try {
			setRoot(reconstruirArbolAVL(0, serie));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	


	private void setRoot(AVLNode<T> reconstruirArbolAVL) {
		raiz=reconstruirArbolAVL;
		
	}

	// Necesita que se cambie la visibilidad del atributo height a public
	private AVLNode<T> reconstruirArbolAVL(int i, T[] serie) throws Exception {
		if (i<serie.length && serie[i]!=null) {
			AVLNode<T> r = new AVLNode<T>(serie[i]);
			r.setLeft(reconstruirArbolAVL(i*2+1, serie));
			r.setRight(reconstruirArbolAVL(i*2+2, serie));
			int altI=r.getLeft()!=null?r.getLeft().height:r.height;// Cojo la altura del nodo reci�n creado como se la hayas puesto si no tiene hijos por la rama
			int altR=r.getRight()!=null?r.getRight().height:r.height; // Idem y adem�s no depende del getHeight() vuestro
			r.height=(altI>altR?altI:altR)+1;
			r.balanceFactor=(byte) (altR-altI);// Comentar esto si no es un atributo el factor de balance y cambiarlo a public si lo es
			if (Math.abs(altR-altI)>1) throw new Exception("El �rbol que se intentaba crear NO es un AVL: "+serializar(serie));
			return r;
		}
		return null;
	}
	
	private String serializar(T[] serie){
		StringBuilder cad=new StringBuilder();
		for (T i:serie) {
			cad.append((i==null?"null":i.toString())+"\t");
		}
		return cad.toString();
	}
	
}

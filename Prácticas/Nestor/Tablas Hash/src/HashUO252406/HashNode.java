package hashUO252406;
/**
 * @author UO252406
 * @version 2016-17
 *
 * @param <T>
 */
public class HashNode<T> {
	private T info;
	private byte estado;


	
	static final byte BORRADO = -1;
	static final byte VACIO = 0;
	static final byte LLENO = 1;


	public HashNode () {
		info = null;
		estado=VACIO;
	}
	
	public T getInfo() {
		return info;
	}
	
	public void borrar (){
		estado=BORRADO;
	}
	
	public void setInfo(T elem){
		info=elem;
		estado=LLENO;
	}
	
	public byte getEstado() {
		return estado;
	}


	public String toString (){
		StringBuilder cadena=new StringBuilder("{");
		switch (getEstado()){
		case LLENO:
			cadena.append(info);
			break;
		case VACIO:
			cadena.append("_E_");
			break;
		case BORRADO:
			cadena.append("_D_");
		}
		cadena.append("}");
		return cadena.toString();
	}


}



package hash;

import java.util.LinkedList;

public class OpenHashTable<T extends Comparable<T>> extends AbstractHash<T> {

	private final static int B = 5;
	private int numElementos;
	@SuppressWarnings("rawtypes")
	private LinkedList[] tabla;
	private double minlf;
	private double maxlf;

	public static final double MINIMUN_LF = 0.33;
	public static final double MAXIMUN_LF = 1;

	@SuppressWarnings("rawtypes")
	public OpenHashTable() {
		this.numElementos = 0;
		this.minlf = MINIMUN_LF;
		this.maxlf = MAXIMUN_LF;
		tabla = new LinkedList[B];
		for (int i = 0; i < tabla.length; i++) {
			tabla[i] = new LinkedList();
		}
	}

	@SuppressWarnings("rawtypes")
	public OpenHashTable(int tam, double minlf, double maxlf) {
		this.numElementos = 0;
		this.minlf = minlf;
		this.maxlf = maxlf;
		if (!esPrimo(tam))
			tam = numPrimoMayor(tam);
		tabla = new LinkedList[tam];
		for (int i = 0; i < tabla.length; i++) {
			tabla[i] = new LinkedList();
		}
	}

	@Override
	public boolean add(T elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T find(T elem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean reDispersion() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean inverseReDispersion() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int fHash(T info, int intentos) {
		return obtenerClave(info) % getB();
	}

	public static int getB() {
		return B;
	}

	public double getMinlf() {
		return minlf;
	}

	public void setMinlf(double minlf) {
		this.minlf = minlf;
	}

	public double getMaxlf() {
		return maxlf;
	}

	public void setMaxlf(double maxlf) {
		this.maxlf = maxlf;
	}

	public int getNumElementos() {
		return numElementos;
	}

	public LinkedList[] getTabla() {
		return tabla;
	}

}

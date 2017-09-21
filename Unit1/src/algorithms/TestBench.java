package algorithms;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Locale;

import javax.swing.text.DefaultEditorKit.CutAction;

public class TestBench {
	
	static long SLEEP_TIME = 250;

	public static void main(String[] args) {
		TestBench t = new TestBench();
		t.testLinear("SalidaLinear.csv", 0, 10, 5);
		t.testQuadratic("SalidaQuadratic.csv", 0, 10, 5);
		t.testCubic("SalidaCubic.csv", 0, 5, 5);
		t.testLogaritmic("SalidaLogaritmic", 0, 20, 5);
	}

	
	/**
	 * Método que duerme el hilo durante el tiempo que se le pasa por constante	SLLEP_TIME
	 * 
	 */
	private static void doNothing() {
		try {
			Thread.sleep(SLEEP_TIME);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	/**
	 *  Método que realiza un algoritmo con complejidad O(n)
	 * @param n, número de veces que se repite el algoritmo, de tipo int
	 */
	public static void linear(int n) {
		
		for (int i = 0; i <= n; i++) {

			doNothing();
		}
	}
	 
	 /**
	  * Método que realiza un algoritmo con complejidad O(n^2)
	  * @param n, número de veces que se repite el algoritmo, de tipo int
	  */
	public static void quadratic(int n) {

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				doNothing();
			}
		}
	}
	 
	 /**
	  * Método que realiza un algoritmo  con complejidad O(n^3)
	  * @param n, número de veces que se repite el algoritmo, de tipo int
	  */
	public static void cubic(int n) {

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				for (int k = 0; k <= n; k++) {
					doNothing();
				}
			}
		}
	}

	 /**
	  * Método que realiza un algoritmo con complejidad O(log n)
	  * @param n, número de veces que se repite el algoritmo, de tipo int
	  */
	public static void logarithm(int n) {
		for (int i = 1; i <= n; i*=2) {
			doNothing();
		}

	}


	/**
	 * Método que relaiza un algoritmo que eleva 2 a el número que se le pasa por parï¿½metro.
	 * La complejidad es lineal, ya que solo tiene un bucle for.
	 * @param n, número al que se le quiere elevar el 2, de tipo int 
	 */		 
	public static long pow2iter(int n) {
		long total = 1;
		if (n > 0)
			for (int i = 0; i < n; i++) {
				doNothing();
				total = total * 2;
			}

		return total;
	}

	/**
	 * Método que estudia el comportamiento del algoritmo con complejidad
	 * lineal.
	 * 
	 * @param output
	 *            Nombre del fichero de salida, te tipo csv, de tipo String
	 * @param startN
	 *            Cota inferior, de tipo int
	 * @param endN
	 *            Cota superior, de tipo int
	 * @param times
	 *            Número de veces que se ejecuta el algotitmo por iteración, de tipo int
	 */
	public void testLinear(String output, int startN, int endN, int times) {

		FileWriter file = null;
		PrintWriter pw;
		double initTime, finalTime, time;

		try {
			file = new FileWriter(output);
			pw = new PrintWriter(file);
			for (int i = startN; i <= endN; i++) {
				initTime = System.currentTimeMillis();
				for (int nVeces = 1; nVeces < times; nVeces++) {
					linear(i);
				}
				finalTime = System.currentTimeMillis();
				time = finalTime - initTime;
				System.out.println("Executing " + i);
				pw.println(i + ";" + time);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (file != null)
					file.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * Método que todo que estudia el comportamiento del algoritmo con complejidad
	 * cuadrática.
	 * 
	  * @param output
	 *            Nombre del fichero de salida, te tipo csv, de tipo String
	 * @param startN
	 *            Cota inferior, de tipo int
	 * @param endN
	 *            Cota superior, de tipo int
	 * @param times
	 *            Número de veces que se ejecuta el algotitmo por iteración, de tipo int
	 */
	public void testQuadratic(String output, int startN, int endN, int times) {

		FileWriter file = null;
		PrintWriter pw;
		double initTime, finalTime, time;

		try {
			file = new FileWriter(output);
			pw = new PrintWriter(file);
			for (int i = startN; i <= endN; i++) {
				initTime = System.currentTimeMillis();
				for (int nVeces = 1; nVeces < times; nVeces++) {
					quadratic(i);
				}
				finalTime = System.currentTimeMillis();
				time = finalTime - initTime;
				System.out.println("Executing " + i);
				pw.println(i + ";" + time);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (file != null)
					file.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	

	/**
	 * Método que todo que estudia el comportamiento del algoritmo con complejidad
	 * cúbica.
	 * 
	  * @param output
	 *            Nombre del fichero de salida, te tipo csv, de tipo String
	 * @param startN
	 *            Cota inferior, de tipo int
	 * @param endN
	 *            Cota superior, de tipo int
	 * @param times
	 *            Número de veces que se ejecuta el algotitmo por iteración, de tipo int
	 */
	public void testCubic(String output, int startN, int endN, int times) {

		FileWriter file = null;
		PrintWriter pw;
		double initTime, finalTime, time;

		try {
			file = new FileWriter(output);
			pw = new PrintWriter(file);
			for (int i = startN; i <= endN; i++) {
				initTime = System.currentTimeMillis();
				for (int nVeces = 1; nVeces < times; nVeces++) {
					cubic(i);
				}
				finalTime = System.currentTimeMillis();
				time = finalTime - initTime;
				System.out.println("Executing " + i);
				pw.println(i + ";" + time);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (file != null)
					file.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	/**
	 * Método que todo que estudia el comportamiento del algoritmo con complejidad
	 * logarítmica.
	 * 
	  * @param output
	 *            Nombre del fichero de salida, te tipo csv, de tipo String
	 * @param startN
	 *            Cota inferior, de tipo int
	 * @param endN
	 *            Cota superior, de tipo int
	 * @param times
	 *            Número de veces que se ejecuta el algotitmo por iteración, de tipo int
	 */
	public void testLogaritmic(String output, int startN, int endN, int times) {

		FileWriter file = null;
		PrintWriter pw;
		double initTime, finalTime, time;

		try {
			file = new FileWriter(output);
			pw = new PrintWriter(file);
			for (int i = startN; i <= endN; i++) {
				initTime = System.currentTimeMillis();
				for (int nVeces = 1; nVeces < times; nVeces++) {
					logarithm(i);
				}
				finalTime = System.currentTimeMillis();
				time = finalTime - initTime;
				System.out.println("Executing " + i);
				pw.println(i + ";" + time);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (file != null)
					file.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
}

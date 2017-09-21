import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Locale;

import javax.swing.text.DefaultEditorKit.CutAction;

public class TestBench {
	
	static long SLEEP_TIME = 250;

	public static void main(String[] args) {
		TestBench t = new TestBench();
		//t.testLinear("SalidaLinear.csv",0,10,5);
		//t.testQuadratic("SalidaQuadratic.csv",0,10,5);
		//t.testCubic("SalidaCubic.csv", 0, 5, 5);
		t.testLogaritmic("SalidaLogaritmic", 0, 5, 5);
	}
	
	// TUS MUUUELAS

	
	/**
	 * M�todo que duerme el hilo durante el tiempo que se le pasa por constante	SLLEP_TIME
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
	 *  M�todo que realiza un algoritmo con complejidad O(n)
	 * @param n, n�mero de veces que se repite el algoritmo, de tipo int
	 */
	public static void linear(int n) {
		
		for (int i = 0; i <= n; i++) {

			doNothing();
		}
	}
	 
	 /**
	  * M�todo que realiza un algoritmo con complejidad O(n^2)
	  * @param n, n�mero de veces que se repite el algoritmo, de tipo int
	  */
	public static void quadratic(int n) {

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				doNothing();
			}
		}
	}
	 
	 /**
	  * M�todo que realiza un algoritmo  con complejidad O(n^3)
	  * @param n, n�mero de veces que se repite el algoritmo, de tipo int
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
	  * M�todo que realiza un algoritmo con complejidad O(log n)
	  * @param n, n�mero de veces que se repite el algoritmo, de tipo int
	  */
	public static void logarithm(int n) {

		for (long i = 0; i <= n; i = i *= 2) {
			doNothing();
		}

	}


	/**
	 * M�todo que relaiza un algoritmo que eleva 2 a el n�mero que se le pasa por par�metro.
	 * La complejidad es lineal, ya que solo tiene un bucle for.
	 * @param n, num�ro al que se le quiere elevar el 2, de tipo int 
	 */		 
	public static long pow2iter(int n) {
		long total = 1;
		if (n > 0)
			for (long i = 0; i < n; i++) {
				doNothing();
				total = total * 2;
			}

		return total;
	}

	/**
	 * M�todo que estudia el comportamiento del algoritmo con complejidad
	 * lineal.
	 * 
	 * @param output
	 *            Nombre del fichero de salida, te tipo csv, de tipo String
	 * @param startN
	 *            Cota inferior, de tipo int
	 * @param endN
	 *            Cota superior, de tipo int
	 * @param times
	 *            N�mero de veces que se ejecuta el algotitmo por iteraci�n, de tipo int
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
	 * M�todo que estudia el comportamiento del algoritmo con complejidad
	 * cuadr�tica.
	 * 
	  * @param output
	 *            Nombre del fichero de salida, te tipo csv, de tipo String
	 * @param startN
	 *            Cota inferior, de tipo int
	 * @param endN
	 *            Cota superior, de tipo int
	 * @param times
	 *            N�mero de veces que se ejecuta el algotitmo por iteraci�n, de tipo int
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
	 * M�todo que estudia el comportamiento del algoritmo con complejidad
	 * c�bica.
	 * 
	  * @param output
	 *            Nombre del fichero de salida, te tipo csv, de tipo String
	 * @param startN
	 *            Cota inferior, de tipo int
	 * @param endN
	 *            Cota superior, de tipo int
	 * @param times
	 *            N�mero de veces que se ejecuta el algotitmo por iteraci�n, de tipo int
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
	 * M�todo que estudia el comportamiento del algoritmo con complejidad
	 * logar�tmica.
	 * 
	  * @param output
	 *            Nombre del fichero de salida, te tipo csv, de tipo String
	 * @param startN
	 *            Cota inferior, de tipo int
	 * @param endN
	 *            Cota superior, de tipo int
	 * @param times
	 *            N�mero de veces que se ejecuta el algotitmo por iteraci�n, de tipo int
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
	
}

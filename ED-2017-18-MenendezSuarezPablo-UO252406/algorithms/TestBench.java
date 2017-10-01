package algorithms;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Locale;

import javax.swing.text.DefaultEditorKit.CutAction;

public class TestBench {
	
	

	public static void main(String[] args) {
		TestBench t = new TestBench();
		
		t.testLinear("SalidaLinear.csv", 0, 10, 5);
		t.testQuadratic("SalidaQuadratic.csv", 0, 10, 5);
		t.testCubic("SalidaCubic.csv", 0, 5, 5);
		t.testLogaritmic("SalidaLogaritmic", 0, 20, 5);
	
		
		t.test("SalidaPow2Iter", 1, 10, 3, "algorithms.Algorithms", "pow2iter");
		t.test("SalidaPow1Rec", 1, 10, 3, "algorithms.Algorithms", "pow1Rec");
		t.test("SalidaPow2Rec", 1, 10, 3, "algorithms.Algorithms", "pow2Rec");
		t.test("SalidaPow3Rec", 1, 10, 3, "algorithms.Algorithms", "pow3Rec");
		t.test("SalidaPow4Rec", 1, 10, 3, "algorithms.Algorithms", "pow4Rec");
		
		
		
		t.test("SalidaFactIter", 1, 10, 3, "algorithms.Algorithms", "factorialIterativo");
		t.test("SalidaFactRec", 1, 10, 3, "algorithms.Algorithms", "factorialRec");
		t.test("SalidaFibIter", 1, 10, 3, "algorithms.Algorithms", "fibonacciIterativo");
		t.test("SalidaFibRec", 1, 10, 3, "algorithms.Algorithms", "fibonacciRec");
		
	
	}

	

	
	/**
	 * M�todo que todo que estudia el comportamiento del algoritmo deseado
	 * 
	  * @param output
	 *            Nombre del fichero de salida, te tipo csv, de tipo String
	 * @param startN
	 *            Cota inferior, de tipo int
	 * @param endN
	 *            Cota superior, de tipo int
	 * @param times
	 *            N�mero de veces que se ejecuta el algotitmo por iteraci�n, de tipo int
	 *            
	 * @param className 
	 * 				Nombre de la clase donde se encuentra el m�todo
	 * 
	 * @param methodName
	 * 				Nombre del m�todo
	 */
	public void test(String output, int startN, int endN, int times,String className, String methodName) {

		FileWriter file = null;
		PrintWriter pw;
		double initTime, finalTime, time;

		try {
			file = new FileWriter(output);
			pw = new PrintWriter(file);
			for (int i = startN; i <= endN; i++) {
				initTime = System.currentTimeMillis();
				for (int nVeces = 1; nVeces < times; nVeces++) {
					testAlgorithm(className,methodName,i);
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
	 * Tiempo en milisegundos que tarda en ejecutarse el m�todo �nomMetodo� de la clase �nomClase� con un par�metro entero �n�
	 * @param className, nombre de la clase que se quiere utilizar, de tipo String
	 * @param methodName, nombre del m�todo que se quiere utilizar, de tipo String
	 * @param n,par�metro que se le pasa al m�todo, de tipo int
	 * @throws IOException
	 */
	public long testAlgorithm(String className, String methodName, int n) {
		long tInicial = 0, tFinal = 0;

		Class<?> cl;
		try {
			cl = Class.forName(className);
			Object o = cl.newInstance();
			Method m = cl.getMethod(methodName, int.class);

			tInicial = System.currentTimeMillis();
			m.invoke(o, n);
			tFinal = System.currentTimeMillis();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tFinal - tInicial;
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
					Algorithms.linear(i);
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
	 * M�todo que todo que estudia el comportamiento del algoritmo con complejidad
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
					Algorithms.quadratic(i);
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
	 * M�todo que todo que estudia el comportamiento del algoritmo con complejidad
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
					Algorithms.cubic(i);
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
	 * M�todo que todo que estudia el comportamiento del algoritmo con complejidad
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
					Algorithms.logarithm(i);
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

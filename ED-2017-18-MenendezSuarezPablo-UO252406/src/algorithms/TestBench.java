package algorithms;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Locale;

import javax.swing.text.DefaultEditorKit.CutAction;

public class TestBench {
	
	

	public static void main(String[] args) {
		TestBench t = new TestBench();
//		t.testLinear("SalidaLinear.csv", 0, 10, 5);
//		t.testQuadratic("SalidaQuadratic.csv", 0, 10, 5);
//		t.testCubic("SalidaCubic.csv", 0, 5, 5);
//		t.testLogaritmic("SalidaLogaritmic", 0, 20, 5);
	
//		System.out.println("Factorial Iterativo");
//		System.out.println();
//		
//		System.out.println(Algorithms.factorial(0));
//		System.out.println(Algorithms.factorial(1));
//		System.out.println(Algorithms.factorial(2));
//		System.out.println(Algorithms.factorial(3));
//		System.out.println(Algorithms.factorial(4));
//		System.out.println(Algorithms.factorial(5));
//		System.out.println(Algorithms.factorial(6));
//		System.out.println(Algorithms.factorial(7));
//		
//		System.out.println();
//		System.out.println("Factorial Recursivo");
//		System.out.println();
//		
//		System.out.println(Algorithms.factorialRec(0));
//		System.out.println(Algorithms.factorialRec(1));
//		System.out.println(Algorithms.factorialRec(2));
//		System.out.println(Algorithms.factorialRec(3));
//		System.out.println(Algorithms.factorialRec(4));
//		System.out.println(Algorithms.factorialRec(5));
//		System.out.println(Algorithms.factorialRec(6));
//		System.out.println(Algorithms.factorialRec(7));
		
		

		System.out.println();
		System.out.println("Fibonacci Iterativo");
		System.out.println();
		
		System.out.println(Algorithms.fibonacci(0));
		System.out.println(Algorithms.fibonacci(1));
		System.out.println(Algorithms.fibonacci(2));		
		System.out.println(Algorithms.fibonacci(3));
		System.out.println(Algorithms.fibonacci(4));
		System.out.println(Algorithms.fibonacci(5));
		System.out.println(Algorithms.fibonacci(6));
		System.out.println(Algorithms.fibonacci(7));
		
		
		System.out.println();
		System.out.println("Fibonacci Recursivo");
		System.out.println();
		
		System.out.println(Algorithms.fibonacciRec(0));
		System.out.println(Algorithms.fibonacciRec(1));
		System.out.println(Algorithms.fibonacciRec(2));		
		System.out.println(Algorithms.fibonacciRec(3));
		System.out.println(Algorithms.fibonacciRec(4));
		System.out.println(Algorithms.fibonacciRec(5));
		System.out.println(Algorithms.fibonacciRec(6));
		System.out.println(Algorithms.fibonacciRec(7));
	
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
	
	
	/**
	 * Método que todo que estudia el comportamiento del algoritmo deseado
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
	 *            
	 * @param className 
	 * 				Nombre de la clase donde se encuentra el método
	 * 
	 * @param methodName
	 * 				Nombre del método
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
	 * Tiempo en milisegundos que tarda en ejecutarse el método “nomMetodo” de la clase “nomClase” con un parámetro entero “n”
	 * @param className, nombre de la clase que se quiere utilizar, de tipo String
	 * @param methodName, nombre del método que se quiere utilizar, de tipo String
	 * @param n,parámetro que se le pasa al método, de tipo int
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
	
}
